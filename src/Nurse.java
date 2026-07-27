/**
 * Represents a nurse in the health service.
 */
public class Nurse extends HealthProfessional {

    private String nursingGrade;

    /**
     * Creates a nurse with common professional details
     * and a nursing grade.
     *
     * @param professionalId unique professional ID
     * @param name           nurse's name
     * @param availableDays  days the nurse is available
     * @param nursingGrade   nurse's professional grade
     */

    public Nurse(
            int professionalId,
            String name,
            String[] availableDays,
            String nursingGrade) {

        super(professionalId, name, availableDays);

        // Ensure a valid nursing grade is provided.

        if (nursingGrade == null || nursingGrade.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nursing grade cannot be empty.");
        }

        this.nursingGrade = nursingGrade;
    }

    /**
     * Returns the nurse's grade.
     *
     * @return nursing grade
     */

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

    /**
     * Returns the professional type.
     *
     * @return Nurse
     */

    @Override
    public String getProfessionalType() {
        return "Nurse";
    }

    /**
     * Returns the nurse's full details.
     *
     * @return formatted nurse details
     */

    @Override
    public String toString() {
        return super.toString()
                + "\nNursing Grade: " + nursingGrade;
    }
}