public class Specialist extends HealthProfessional {
    private String specialty;

    public Specialist(
            int professionalId,
            String name,
            String[] availableDays,
            String specialty) {

        super(professionalId, name, availableDays);

        if (specialty == null || specialty.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Specialty cannot be empty.");
        }
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void provideSpecialistConsultation() {
        System.out.println(getName() + " provides a " + specialty + " consultation.");
    }

    @Override
    public String getProfessionalType() {
        return "Specialist";
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpecialty: " + specialty;
    }
}