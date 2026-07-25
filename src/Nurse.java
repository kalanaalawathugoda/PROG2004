/**
 * Represents a nurse in the health service.
 */
public class Nurse extends HealthProfessional {

    private String nursingGrade;

    public Nurse(
            int professionalId,
            String name,
            String[] availableDays,
            String nursingGrade) {

        super(professionalId, name, availableDays);

        if (nursingGrade == null || nursingGrade.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nursing grade cannot be empty.");
        }

        this.nursingGrade = nursingGrade;
    }

    public String getNursingGrade() {
        return nursingGrade;
    }

    /**
     * Demonstrates behaviour specific to a nurse.
     */
    public void takeBloodSample() {
        System.out.println(
                getName() + " can take a blood sample.");
    }

    @Override
    public String getProfessionalType() {
        return "Nurse";
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nNursing Grade: " + nursingGrade;
    }
}