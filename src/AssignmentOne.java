public class AssignmentOne {

    public static void main(String[] args) {
        System.out.println("________Health Service Appointment System________");
        System.out.println();

        GeneralPractitioner gp1 = new GeneralPractitioner(
            101,
                "Dr Sarah Wilson",
                new String[]{"Monday", "Wednesday", "Friday"},
                "Room 1"
        );

        GeneralPractitioner gp2 = new GeneralPractitioner(
            102,
                "Dr David Lee",
                new String[]{"Tuesday", "Thursday"},
                "Room 2"
        );
                
        GeneralPractitioner gp3 = new GeneralPractitioner(
            103,
                "Dr Olivia Martinez",
                new String[]{"Monday", "Thursday"},
                "Room 3"
        );

        Specialist specialist1 = new Specialist(
            201,
                "Dr John Smith",
                new String[]{"Monday", "Thursday"},
                "Cardiology"
        );

        Specialist specialist2 = new Specialist(
            202,
                "Dr Emily Johnson",
                new String[]{"Tuesday", "Friday"},
                "Dermatology"
        );

        Nurse nurse1 = new Nurse(
            301,
                "Nurse Emily Johnson",
                new String[]{"Tuesday", "Thursday"},
                "Senior Nurse"
        );

        Nurse nurse2 = new Nurse(
            302,
                "Nurse Michael Brown",
                new String[]{"Monday", "Wednesday"},
                "Junior Nurse"
        );

        Dietitian dietitian1 = new Dietitian(
            401,
                "Michael Brown",
                new String[]{"Wednesday", "Friday", "Saturday"},
                "Clinical Nutrition"
        );

        Dietitian dietitian2 = new Dietitian(
            402,
                "Sarah Lee",
                new String[]{"Tuesday", "Thursday"},
                "Sports Nutrition"
        );

        HealthProfessional[] professionals = {
            gp1, 
            gp2, 
            gp3,
            specialist1, 
            specialist2,
            nurse1, 
            nurse2,
            dietitian1, 
            dietitian2
        };

        System.out.println("_______List of Health Professionals_______");
        for (HealthProfessional professional : professionals) {
            System.out.println();
            System.out.println(professional);
            System.out.println("__________________________________________");
        }

        System.out.println();
        System.out.println("_______Proffessional Specific Behaviours_______");

        gp1.prescribeMedicine();
        specialist1.provideSpecialistConsultation();
        nurse1.takeBloodSample();
        dietitian1.createDietPlan();

            System.out.println();
    System.out.println("_______Patient Details_______");

     Patient patient1 = new Patient(
                "Kavindu LAkshitha",
                "0712345678"
            );
    Patient patient2 = new Patient(
                "Nadeesha Perera",
                "0776543210"
            );

        System.out.println();
        System.out.println(patient1);
        System.out.println("__________________________________________");
        System.out.println();
        System.out.println(patient2);
    
        System.out.println();
        System.out.println("_______Appointment Details_______");

        Appointment appointment1 = new Appointment(
            patient1,
            gp1,
            "2024-06-15 10:00 AM"
        );

        Appointment appointment2 = new Appointment(
            patient2,
            specialist1,
            "2024-06-16 02:30 PM"
        );

        System.out.println();
        System.out.println(appointment1);

        System.out.println();
        System.out.println("__________________________________________");
        System.out.println();

        System.out.println(appointment2);

    }

}






