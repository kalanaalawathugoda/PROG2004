/**
 * Represents a patient who books an appointment
 * with a health professional.
 */

public class Patient {
    private String name;
    private String mobileNumber;

    /**
     * Creates a patient with a name and mobile number.
     *
     * @param name         patient's full name
     * @param mobileNumber patient's contact number
     */

    public Patient(String name, String mobileNumber) {

        // Ensure a valid patient name is provided.

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        // Ensure a valid mobile number is provided.

        if (mobileNumber == null || mobileNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient mobile number cannot be empty.");
        }
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    /**
     * Returns the patient's name.
     *
     * @return patient name
     */

    public String getName() {
        return name;
    }

    /**
     * Returns the patient's mobile number.
     *
     * @return patient mobile number
     */

    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Returns the patient's details in a readable format.
     *
     * @return formatted patient details
     */

    @Override
    public String toString() {
        return "Patient Name: " + name + "\nMobile Number: " + mobileNumber;
    }

}
