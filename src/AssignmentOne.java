/**
 * Main class.
 *
 * Demonstrates the complete health service
 * appointment system.
 */
public class AssignmentOne {

    /**
     * Runs the appointment system demonstration.
     *
     * @param args command-line arguments
     */

    public static void main(String[] args) {
        System.out.println("________Health Service Appointment System________");
        System.out.println();

        // Create three general practitioners.

        GeneralPractitioner gp1 = new GeneralPractitioner(
                101,
                "Dr Sarah Wilson",
                new String[] { "Monday", "Wednesday", "Friday" },
                "Room 1");

        GeneralPractitioner gp2 = new GeneralPractitioner(
                102,
                "Dr David Lee",
                new String[] { "Tuesday", "Thursday" },
                "Room 2");

        GeneralPractitioner gp3 = new GeneralPractitioner(
                103,
                "Dr Olivia Martinez",
                new String[] { "Monday", "Thursday" },
                "Room 3");

        // Create two specialists.

        Specialist specialist1 = new Specialist(
                201,
                "Dr John Smith",
                new String[] { "Monday", "Thursday" },
                "Cardiology");

        Specialist specialist2 = new Specialist(
                202,
                "Dr Emily Johnson",
                new String[] { "Tuesday", "Friday" },
                "Dermatology");

        // Create two nurses.

        Nurse nurse1 = new Nurse(
                301,
                "Nurse Emily Johnson",
                new String[] { "Tuesday", "Thursday" },
                "Senior Nurse");

        Nurse nurse2 = new Nurse(
                302,
                "Nurse Michael Brown",
                new String[] { "Monday", "Wednesday" },
                "Junior Nurse");

        // Create two dietitians.

        Dietitian dietitian1 = new Dietitian(
                401,
                "Michael Brown",
                new String[] { "Wednesday", "Friday", "Saturday" },
                "Clinical Nutrition");

        Dietitian dietitian2 = new Dietitian(
                402,
                "Sarah Lee",
                new String[] { "Tuesday", "Thursday" },
                "Sports Nutrition");

        /*
         * Store different subclasses using their common
         * HealthProfessional parent type. This demonstrates
         * polymorphism.
         */

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

        // Demonstrate behaviours unique to each professional type.

        System.out.println();
        System.out.println("_______Proffessional Specific Behaviours_______");

        gp1.prescribeMedicine();
        specialist1.provideSpecialistConsultation();
        nurse1.takeBloodSample();
        dietitian1.createDietPlan();

        // Create patients.

        System.out.println();
        System.out.println("_______Patient Details_______");

        Patient patient1 = new Patient(
                "Kavindu LAkshitha",
                "0712345678");
        Patient patient2 = new Patient(
                "Nadeesha Perera",
                "0776543210");

        System.out.println();
        System.out.println(patient1);
        System.out.println("__________________________________________");
        System.out.println();
        System.out.println(patient2);

        /*
         * Create appointments for the current day.
         * Only the appointment time is stored.
         */

        System.out.println();
        System.out.println("_______Appointment Details_______");

        Appointment appointment1 = new Appointment(
                patient1,
                gp1,
                "2024-06-15 10:00 AM");

        Appointment appointment2 = new Appointment(
                patient2,
                specialist1,
                "2024-06-16 02:00 PM");

        System.out.println();
        System.out.println(appointment1);

        System.out.println();
        System.out.println("__________________________________________");
        System.out.println();

        System.out.println(appointment2);

        /*
         * Professionals with the same unique ID are
         * considered equal.
         */

        System.out.println();
        System.out.println("_________Proffessional Equality test_________");

        GeneralPractitioner sameGp = new GeneralPractitioner(
                101,
                "Dr. John Doe",
                new String[] { "Monday", "Wednesday" },
                "General Practice");
        System.out.println("Does gp1 represent the same professional as sameGp? " + gp1.equals(sameGp));

        // Create the appointment manager.

        System.out.println();
        System.out.println("_________Appointment Management");

        AppointmentManager appointmentManager = new AppointmentManager();
        appointmentManager.addAppointment(appointment1);
        appointmentManager.addAppointment(appointment2);

        Patient patient3 = new Patient(
                "Amal Perera",
                "0771234567");

        Appointment appointment3 = new Appointment(
                patient3,
                nurse1,
                "2024-06-15 10:00 AM");

        /*
         * This appointment uses the same time as appointment1,
         * but a different professional, so it is valid.
         */

        appointmentManager.addAppointment(appointment3);
        appointmentManager.displayAppointments();

        Patient patient5 = new Patient(
                "Kamal Perera",
                "0779876543");

        Appointment appointment4 = new Appointment(
                patient5,
                gp1,
                "2024-06-16 11:00 AM");

        appointmentManager.addAppointment(appointment4);

        /*
         * Attempt to book gp1 at 10:00 again.
         * The manager should reject this double-booking.
         */

        System.out.println();
        System.out.println("_________Double Booking Test_________");

        Patient patient4 = new Patient(
                "Nimal Silva",
                "0719876543");

        Appointment duplicateAppointment = new Appointment(
                patient4,
                gp1,
                "2024-06-15 10:00 AM");

        appointmentManager.addAppointment(duplicateAppointment);

        /*
         * 09:15 is invalid because appointments are
         * available only in 30-minute intervals.
         */

        System.out.println();
        System.out.println("_________Invalid Time Test_________");

        Appointment invalidTimeAppointment = new Appointment(
                patient4,
                gp1,
                "2024-06-15 09:15 AM");

        appointmentManager.addAppointment(invalidTimeAppointment);

        // Demonstrate filtering using both required options.

        System.out.println();
        System.out.println("_________Filtering Tests_________");

        appointmentManager.displayAppointmentsByProfessionalId(101);

        appointmentManager.displayAppointmentsByPatientPhone(
                "0771234567");

        // Demonstrate unsuccessful filter operations.

        appointmentManager.displayAppointmentsByProfessionalId(999);

        appointmentManager.displayAppointmentsByPatientPhone(
                "0400 000 000");

        // Display all appointments and a filtered list in time order.

        System.out.println();
        System.out.println("_________Sorting Tests_________");

        appointmentManager.displayAppointmentsSortedByTime();
        appointmentManager.displaySortedAppointmentsByProfessionalId(101);

        /*
         * Cancel an appointment using professional ID
         * and appointment time.
         */

        System.out.println();
        System.out.println("_________Cancellation Tests_________");

        appointmentManager.cancelAppointment(101, "2024-06-15 10:00 AM");
        appointmentManager.displayAppointments();

        // Cancel an appointment using the patient phone number.

        appointmentManager.cancelAppointmentByPatientPhone("0771234567");

        // Display the collection after cancellation.

        appointmentManager.displayAllAppointments();

        // Demonstrate cancellation warning messages.

        System.out.println();
        System.out.println("_________Cancellation Test for Non-Existent Appointment_________");
        appointmentManager.cancelAppointment(999, "2024-06-15 10:00 AM");
        appointmentManager.cancelAppointmentByPatientPhone("0400 000 000");

    }

}
