/**
 * Represents the common information shared by all
 * health professionals in the health service.
 */
public abstract class HealthProfessional {

    private int professionalId;
    private String name;
    private String[] availableDays;

    /**
     * Creates a health professional.
     *
     * @param professionalId unique professional ID
     * @param name           professional's name
     * @param availableDays  days the professional works
     */
    public HealthProfessional(
            int professionalId,
            String name,
            String[] availableDays) {

        if (professionalId <= 0) {
            throw new IllegalArgumentException(
                    "Professional ID must be greater than zero.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Professional name cannot be empty.");
        }

        if (availableDays == null || availableDays.length == 0) {
            throw new IllegalArgumentException(
                    "At least one available day is required.");
        }

        this.professionalId = professionalId;
        this.name = name;
        this.availableDays = availableDays;
    }

    public int getProfessionalId() {
        return professionalId;
    }

    public String getName() {
        return name;
    }

    public String[] getAvailableDays() {
        return availableDays;
    }

    /**
     * Returns the specific type of health professional.
     *
     * @return professional type
     */
    public abstract String getProfessionalType();

    @Override
    public String toString() {

        String days = "";

        for (int i = 0; i < availableDays.length; i++) {
            days += availableDays[i];

            if (i < availableDays.length - 1) {
                days += ", ";
            }
        }

        return "Professional Type: " + getProfessionalType()
                + "\nProfessional ID: " + professionalId
                + "\nName: " + name
                + "\nAvailable Days: " + days;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null
                || !(object instanceof HealthProfessional)) {
            return false;
        }

        HealthProfessional other = (HealthProfessional) object;

        return professionalId == other.professionalId;
    }

    @Override
    public int hashCode() {
        return professionalId;
    }
}