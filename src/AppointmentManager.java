import java.util.ArrayList;
import java.util.Collections;

/**
 * Manages all appointments for the health service.
 *
 * This class supports adding, displaying, filtering,
 * sorting and cancelling appointments.
 */

public class AppointmentManager {
    private ArrayList<Appointment> appointments;

    // Fixed clinic schedule from 09:00 to 16:00
    // using 30-minute appointment intervals.

    private static final String[] VALID_TIME_SLOTS = {
            "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
            "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM"
    };

    /**
     * Creates an empty appointment collection.
     */

    public AppointmentManager() {
        appointments = new ArrayList<Appointment>();
    }

    /**
     * Checks whether an appointment time is part
     * of the clinic's fixed schedule.
     *
     * @param appointmentTime time being checked
     * @return true if the time is valid
     */

    private boolean isValidTimeSlot(String appointmentTime) {
        for (String validTime : VALID_TIME_SLOTS) {
            if (appointmentTime.endsWith(validTime)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds an appointment when the time is valid and the professional is not
     * already booked.
     *
     * @param appointment appointment being added
     * @return true if the appointment is added
     */

    public boolean addAppointment(Appointment appointment) {

        if (appointment == null) {
            System.out.println(
                    "WARNING: Appointment information is required.");
            return false;
        }

        // Reject appointments outside the clinic schedule.

        if (!isValidTimeSlot(appointment.getAppointmentTime())) {
            System.out.println(
                    "WARNING: " + appointment.getAppointmentTime()
                            + " is not a valid clinic time slot.");
            return false;
        }

        // Check whether the same professional is already
        // booked at the requested appointment time.

        for (Appointment existingAppointment : appointments) {

            boolean sameProfessional = existingAppointment
                    .getHealthProfessional()
                    .equals(
                            appointment
                                    .getHealthProfessional());

            boolean sameTime = existingAppointment
                    .getAppointmentTime()
                    .equals(
                            appointment
                                    .getAppointmentTime());

            if (sameProfessional && sameTime) {
                System.out.println(
                        "WARNING: "
                                + appointment
                                        .getHealthProfessional()
                                        .getName()
                                + " is already booked at "
                                + appointment.getAppointmentTime()
                                + ".");
                return false;
            }
        }

        appointments.add(appointment);

        System.out.println(
                "SUCCESS: Appointment added for "
                        + appointment.getPatient().getName()
                        + " at "
                        + appointment.getAppointmentTime()
                        + ".");

        return true;
    }

    /**
     * Displays all scheduled appointments.
     */

    public void displayAppointments() {

        System.out.println();
        System.out.println("________All Scheduled Appointments________");

        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }

        System.out.println("Scheduled Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
            System.out.println("-------------------------");
        }
    }

    /**
     * Displays appointments for a selected health professional ID.
     *
     * @param professionalId professional ID used for filtering
     */

    public void displayAppointmentsByProfessionalId(
            int professionalId) {
        System.out.println();
        System.out.println("_____________Appointments for Professional ID: " + professionalId + "______");

        boolean found = false;

        for (Appointment appointment : appointments) {
            if (appointment.getHealthProfessional().getProfessionalId() == professionalId) {

                System.out.println();
                System.out.println(appointment);

                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found for Professional ID: " + professionalId);
        }

    }

    /**
     * Displays appointments for a selected patient phone number.
     *
     * @param mobileNumber patient phone number used for filtering
     */

    public void displayAppointmentsByPatientPhone(
            String mobileNumber) {
        System.out.println();
        System.out.println("_____________Appointments for Patient Mobile Number: " + mobileNumber + "______");

        boolean found = false;

        for (Appointment appointment : appointments) {
            if (appointment.getPatient().getMobileNumber().equals(mobileNumber)) {

                System.out.println();
                System.out.println(appointment);

                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found for Patient Mobile Number: " + mobileNumber);
        }

    }

    /**
     * Displays all appointments sorted from earliest to latest.
     */

    public void displayAppointmentsSortedByTime() {
        System.out.println();
        System.out.println("________All Scheduled Appointments (Sorted by Time)________");

        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }

        // Copy the list before sorting so the original appointment collection is not
        // rearranged.

        ArrayList<Appointment> sortedAppointments = new ArrayList<>(appointments);
        Collections.sort(sortedAppointments);

        for (Appointment appointment : sortedAppointments) {
            System.out.println();
            System.out.println(appointment);
            System.out.println("__________________________");
        }

    }

    /**
     * Displays all appointments currently stored.
     */

    public void displayAllAppointments() {

        System.out.println();
        System.out.println("____________ALL APPOINTMENTS____________");

        if (appointments.isEmpty()) {
            System.out.println(
                    "WARNING: There are no appointments to display.");
            return;
        }

        for (Appointment appointment : appointments) {
            System.out.println();
            System.out.println(appointment);
            System.out.println("________________________________");
        }
    }

    /**
     * Displays appointments for one professional,
     * sorted from earliest to latest.
     *
     * @param professionalId professional ID used for filtering
     */

    public void displaySortedAppointmentsByProfessionalId(
            int professionalId) {
        System.out.println();
        System.out.println("_____________Appointments for Professional ID: " + professionalId);

        ArrayList<Appointment> filteredAppointments = new ArrayList<Appointment>();

        for (Appointment appointment : appointments) {
            if (appointment.getHealthProfessional().getProfessionalId() == professionalId) {
                filteredAppointments.add(appointment);
            }
        }

        if (filteredAppointments.isEmpty()) {
            System.out.println("No appointments found for Professional ID: " + professionalId);
            return;
        }

        Collections.sort(filteredAppointments);
        for (Appointment appointment : filteredAppointments) {
            System.out.println();
            System.out.println(appointment);
            System.out.println("__________________________");
        }
    }

    /**
     * Cancels an appointment using a patient's
     * phone number.
     *
     * @param mobileNumber patient phone number
     * @return true if an appointment is cancelled
     */

    public boolean cancelAppointmentByPatientPhone(String mobileNumber) {

        // Loop backwards to safely remove matching items.

        for (int i = appointments.size() - 1; i >= 0; i--) {

            Appointment appointment = appointments.get(i);

            if (appointment.getPatient()
                    .getMobileNumber()
                    .equals(mobileNumber)) {

                appointments.remove(i);

                System.out.println(
                        "SUCCESS: Appointment for patient phone "
                                + mobileNumber
                                + " was cancelled.");

                return true;
            }
        }

        System.out.println(
                "WARNING: No appointment found for patient phone "
                        + mobileNumber + ".");

        return false;
    }

    /**
     * Cancels an appointment using a professional ID
     * and appointment time.
     *
     * @param professionalId  health professional ID
     * @param appointmentTime appointment time
     * @return true if an appointment is cancelled
     */

    public boolean cancelAppointment(
            int professionalId,
            String appointmentTime) {

        for (int i = 0; i < appointments.size(); i++) {

            Appointment appointment = appointments.get(i);

            boolean sameProfessional = appointment.getHealthProfessional().getProfessionalId() == professionalId;
            boolean sameTime = appointment.getAppointmentTime().equals(appointmentTime);

            if (sameProfessional && sameTime) {
                appointments.remove(i);
                System.out.println("SUCCESS: Appointment for Professional ID: " + professionalId + " at "
                        + appointmentTime + " has been canceled.");
                return true;
            }
        }
        System.out.println(
                "FAILURE: No appointment found for Professional ID: " + professionalId + " at " + appointmentTime);
        return false;
    }

}
