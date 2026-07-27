/**
 * Represents an appointment between a patient and a health professional.
 */

public class Appointment implements Comparable<Appointment> {
    private Patient patient;
    private HealthProfessional healthProfessional;
    private String appointmentTime;

    /**
     * Creates a new appointment.
     *
     * @param patient            patient attending the appointment
     * @param healthProfessional selected health professional
     * @param appointmentTime    appointment time in HH:mm format
     */

    public Appointment(
            Patient patient,
            HealthProfessional healthProfessional,
            String appointmentTime) {

        // Ensure all required appointment details are provided.

        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
        if (healthProfessional == null) {
            throw new IllegalArgumentException("Health professional cannot be null.");
        }
        if (appointmentTime == null || appointmentTime.trim().isEmpty()) {
            throw new IllegalArgumentException("Appointment time cannot be empty.");
        }
        this.patient = patient;
        this.healthProfessional = healthProfessional;
        this.appointmentTime = appointmentTime;
    }

    /**
     * Returns the patient.
     *
     * @return patient object
     */

    public Patient getPatient() {
        return patient;
    }

    /**
     * Returns the selected health professional.
     *
     * @return health professional object
     */

    public HealthProfessional getHealthProfessional() {
        return healthProfessional;
    }

    /**
     * Returns the appointment time.
     *
     * @return appointment time
     */

    public String getAppointmentTime() {
        return appointmentTime;
    }

    /**
     * Compares appointments by time for sorting.
     *
     * @param other appointment being compared
     * @return comparison result
     */

    @Override
    public int compareTo(Appointment other) {
        return this.appointmentTime.compareTo(other.appointmentTime);
    }

    /**
     * Returns all appointment details in a readable format.
     *
     * @return formatted appointment details
     */

    @Override
    public String toString() {
        return "Appointment Time: " + appointmentTime + "\n" + patient + "\nHealth Professional:\n"
                + healthProfessional;
    }

}
