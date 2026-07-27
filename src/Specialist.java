/**
 * Represents a medical specialist working
 * in the health service.
 */

public class Specialist extends HealthProfessional {
    private String specialty;

    /**
     * Creates a specialist with common professional
     * details and a medical specialty.
     *
     * @param professionalId unique professional ID
     * @param name           specialist's name
     * @param availableDays  days the specialist is available
     * @param specialty      specialist's medical field
     */

    public Specialist(
            int professionalId,
            String name,
            String[] availableDays,
            String specialty) {

        super(professionalId, name, availableDays);

        // Ensure a valid specialty is provided.

        if (specialty == null || specialty.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Specialty cannot be empty.");
        }
        this.specialty = specialty;
    }

    /**
     * Returns the specialist's medical field.
     *
     * @return medical specialty
     */

    public String getSpecialty() {
        return specialty;
    }

    /**
     * Demonstrates behaviour specific to a specialist.
     */

    public void provideSpecialistConsultation() {
        System.out.println(getName() + " provides a " + specialty + " consultation.");
    }

    /**
     * Returns the professional type.
     *
     * @return Specialist
     */

    @Override
    public String getProfessionalType() {
        return "Specialist";
    }

    /**
     * Returns the specialist's full details.
     *
     * @return formatted specialist details
     */

    @Override
    public String toString() {
        return super.toString() + "\nSpecialty: " + specialty;
    }
}