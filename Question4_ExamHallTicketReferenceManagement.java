/**
 * Problem M4: Exam Hall Ticket Reference Management
 * 
 * Scenario:
 * Two "different" variables in a script both claim to represent Priya's exam hall ticket,
 * but only one of them is actually real. Prove it with code.
 * 
 * Task:
 * - Define a class HallTicket with fields String studentName and int seatNumber,
 *   both set through a constructor.
 * - Create one HallTicket object for Priya. Assign a second variable to point at that same object
 *   (do not create a new one).
 * - Through the second variable, change seatNumber.
 * - Print the field's value as seen through the first variable, and print whether the two
 *   variables are == to each other.
 * - Create a third, separate HallTicket object with identical field values, and print whether
 *   it is == to the first.
 */

class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class Question4_ExamHallTicketReferenceManagement {
    public static void main(String[] args) {
        // Create one HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);

        // Assign a second variable to point at the same object (reference copy)
        HallTicket copy = priya;

        // Change seatNumber through the second variable
        copy.seatNumber = 45;

        // Create a third, separate HallTicket object with identical field values
        HallTicket separate = new HallTicket("Priya", 45);

        // Print field's value through the first variable
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);

        // Print whether copy and priya are ==
        System.out.println("copy == priya: " + (copy == priya));

        // Print whether separate and priya are ==
        System.out.println("separate == priya: " + (separate == priya));
    }
}
