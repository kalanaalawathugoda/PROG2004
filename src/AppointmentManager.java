import java.util.ArrayList;
import java.util.Collections;

public class AppointmentManager {
    private ArrayList<Appointment> appointments;

    private static final String[] VALID_TIME_SLOTS = {
            "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
            "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM"
    };

    public AppointmentManager() {
        appointments = new ArrayList<Appointment>();
    }

    private boolean isValidTimeSlot(String appointmentTime) {
        for (String validTime : VALID_TIME_SLOTS) {
            if (appointmentTime.endsWith(validTime)) {
                return true;
            }
        }
        return false;
    }

    public boolean addAppointment(Appointment appointment) {

        if (appointment == null) {
            System.out.println(
                    "WARNING: Appointment information is required.");
            return false;
        }

        if (!isValidTimeSlot(appointment.getAppointmentTime())) {
            System.out.println(
                    "WARNING: " + appointment.getAppointmentTime()
                            + " is not a valid clinic time slot.");
            return false;
        }

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

    public void displayAppointmentsSortedByTime() {
        System.out.println();
        System.out.println("________All Scheduled Appointments (Sorted by Time)________");

        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }

        ArrayList<Appointment> sortedAppointments = new ArrayList<>(appointments);
        Collections.sort(sortedAppointments);

        for(Appointment appointment : sortedAppointments) {
            System.out.println();
            System.out.println(appointment);
            System.out.println("__________________________");
        }

    }

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

    public void displaySortedAppointmentsByProfessionalId(
        int professionalId){
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
        for(Appointment appointment : filteredAppointments) {
            System.out.println();
            System.out.println(appointment);
            System.out.println("__________________________");
        }
    }

    public boolean cancelAppointmentByPatientPhone(String mobileNumber) {

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

    public boolean cancelAppointment(
        int professionalId, 
        String appointmentTime) {

            for (int i = 0; i < appointments.size(); i++) {

                Appointment appointment = appointments.get(i);

                boolean sameProfessional = appointment.getHealthProfessional().getProfessionalId() == professionalId;
                boolean sameTime = appointment.getAppointmentTime().equals(appointmentTime);

                if (sameProfessional && sameTime) {
                    appointments.remove(i);
                    System.out.println("SUCCESS: Appointment for Professional ID: " + professionalId + " at " + appointmentTime + " has been canceled.");
                    return true;
                }
            }
            System.out.println("FAILURE: No appointment found for Professional ID: " + professionalId + " at " + appointmentTime);
            return false;
        }
        
    }

    
   

