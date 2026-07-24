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

    }
}