public class Patient {
    private String name;
    private String mobileNumber;

    public Patient(String name, String mobileNumber) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        if (mobileNumber == null || mobileNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient mobile number cannot be empty.");
        }
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public String toString() {
        return "Patient Name: " + name + "\nMobile Number: " + mobileNumber;
    }

}
