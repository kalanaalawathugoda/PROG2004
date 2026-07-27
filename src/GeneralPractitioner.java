/**
 * Represents a general practitioner working
 * in the health service.
 */

public class GeneralPractitioner extends HealthProfessional {
    private String clinicRoom;

    /**
     * Creates a general practitioner with common
     * professional details and a clinic room.
     *
     * @param professionalId unique professional ID
     * @param name           general practitioner's name
     * @param availableDays  days the GP is available
     * @param clinicRoom     room assigned to the GP
     */

    public GeneralPractitioner(int professionalId, String name, String[] availableDays, String clinicRoom) {

        super(professionalId, name, availableDays);

        // Ensure a valid clinic room is provided.

        if (clinicRoom == null || clinicRoom.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Clinic room cannot be empty.");
        }
        this.clinicRoom = clinicRoom;
    }

    /**
     * Returns the assigned clinic room.
     *
     * @return clinic room
     */

    public String getClinicRoom() {
        return clinicRoom;
    }

    /**
     * Demonstrates behaviour specific to
     * a general practitioner.
     */

    public void prescribeMedicine() {
        System.out.println(getName() + " can prescribe general medication.");
    }

    /**
     * Returns the professional type.
     *
     * @return General Practitioner
     */

    @Override
    public String getProfessionalType() {
        return "General Practitioner";
    }

    /**
     * Returns the GP's full details.
     *
     * @return formatted general practitioner details
     */

    @Override
    public String toString() {
        return super.toString() + "\nClinic Room: " + clinicRoom;
    }

}
