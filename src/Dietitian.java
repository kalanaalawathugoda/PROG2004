public class Dietitian extends HealthProfessional {

    private String nutritionSpecialty;

    public Dietitian(
            int professionalId,
            String name,
            String[] availableDays,
            String nutritionSpecialty) {

        super(professionalId, name, availableDays);

        if (nutritionSpecialty == null || nutritionSpecialty.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nutrition specialty cannot be empty.");
        }

        this.nutritionSpecialty = nutritionSpecialty;
    }

    public String getNutritionSpecialty() {
        return nutritionSpecialty;
    }

    public void createDietPlan() {
        System.out.println(getName() + " can create a personalized diet plan.");
    }

    @Override
    public String getProfessionalType() {
        return "Dietitian";
    }

    @Override
    public String toString() {
        return super.toString() + "\nNutrition Specialty: " + nutritionSpecialty;
    }
}
