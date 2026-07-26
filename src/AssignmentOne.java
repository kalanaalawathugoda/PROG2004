public class AssignmentOne {

    public static void main(String[] args) {
        System.out.println("________Health Service Appointment System________");
        System.out.println();

        GeneralPractitioner gp1 = new GeneralPractitioner(
            101,
                "Dr Sarah Wilson",
                new String[]{"Monday", "Wednesday", "Friday"},
                "Room 1");

        System.out.println(gp1);
        System.out.println();
        
        gp1.prescribeMedicine();

            Specialist specialist1 = new Specialist(
            201,
            "Dr John Smith",
            new String[]{"Monday", "Thursday"},
            "Cardiology");
        
        System.out.println();    
        System.out.println(specialist1);
        System.out.println();
        
        specialist1.provideSpecialistConsultation();

        Nurse nurse1 = new Nurse(
            301,
            "Nurse Emily Johnson",
            new String[]{"Tuesday", "Thursday"},
            "Senior Nurse");

        System.out.println();
        System.out.println(nurse1);
        System.out.println();
        
        nurse1.takeBloodSample();

            Dietitian dietitian1 = new Dietitian(
            401,
            "Michael Brown",
            new String[]{"Wednesday", "Friday", "Saturday"},
            "Clinical Nutrition"
        );

        System.out.println();
        System.out.println(dietitian1);
        System.out.println();
        
        dietitian1.createDietPlan();
    }
}
