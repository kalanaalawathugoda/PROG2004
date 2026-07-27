/**
 * Represents a dietitian working in the health service.
 */

public class Dietitian extends HealthProfessional {

    private String nutritionSpecialty;

    /**
     * Creates a dietitian with professional details
     * and a nutrition specialty.
     *
     * @param professionalId     unique professional ID
     * @param name               dietitian's name
     * @param availableDays      days the dietitian is available
     * @param nutritionSpecialty area of nutrition expertise
     */

    public Dietitian(
            int professionalId,
            String name,
            String[] availableDays,
            String nutritionSpecialty) {

        super(professionalId, name, availableDays);

        // Ensure the dietitian has a valid specialty.

        if (nutritionSpecialty == null || nutritionSpecialty.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nutrition specialty cannot be empty.");
        }

        this.nutritionSpecialty = nutritionSpecialty;
    }

    /**
     * Returns the nutrition specialty.
     *
     * @return nutrition specialty
     */

    public String getNutritionSpecialty() {
        return nutritionSpecialty;
    }

    /**
     * Demonstrates behaviour specific to a dietitian.
     */

    public void createDietPlan() {
        System.out.println(getName() + " can create a personalized diet plan.");
    }

    /**
     * Returns the professional type.
     *
     * @return Dietitian
     */

    @Override
    public String getProfessionalType() {
        return "Dietitian";
    }

    /**
     * Returns the dietitian's full details.
     *
     * @return formatted dietitian details
     */

    @Override
    public String toString() {
        return super.toString() + "\nNutrition Specialty: " + nutritionSpecialty;
    }
}
