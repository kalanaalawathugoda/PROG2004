public class GeneralPractitioner extends HealthProfessional {
    private String clinicRoom;
    public GeneralPractitioner(int professionalId, String name, String[] availableDays, String clinicRoom) {

        super(professionalId, name, availableDays);
        if (clinicRoom == null || clinicRoom.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Clinic room cannot be empty.");
        }
        this.clinicRoom = clinicRoom;
    }
    public String getClinicRoom() {
        return clinicRoom;
    }

    public void prescribeMedicine() {
        System.out.println(getName() + " can prescribe general medication.");
    }

   @Override
    public String getProfessionalType() {
        return "General Practitioner";
    }

    @Override
    public String toString() {
        return super.toString() + "\nClinic Room: " + clinicRoom;
    }

}
