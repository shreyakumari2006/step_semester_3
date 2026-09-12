/**
 * Problem M4 (Practice): Library ID Card Management
 * 
 * Scenario:
 * Two "different" variables in a script both claim to represent Ravi's library card,
 * but only one of them is actually real. Prove it with code.
 * 
 * Task:
 * - Define a class IdCard with fields String name and int booksIssued, both set through a constructor.
 * - Create one IdCard object for Ravi. Assign a second variable to point at that same object
 *   (do not create a new one).
 * - Through the second variable, change booksIssued.
 * - Print the field's value as seen through the first variable, and print whether the two
 *   variables are == to each other.
 * - Create a third, separate IdCard object with identical field values, and print whether it is == to the first.
 */

class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class Question4_LibraryIdCardManagement {
    public static void main(String[] args) {
        // Create one IdCard object for Ravi
        IdCard ravi = new IdCard("Ravi", 0);

        // Assign a second variable to point at the same object (reference copy)
        IdCard duplicate = ravi;

        // Change booksIssued through the second variable
        duplicate.booksIssued = 3;

        // Create a third, separate IdCard object with identical field values
        IdCard separate = new IdCard("Ravi", 3);

        // Print field's value through the first variable
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);

        // Print whether duplicate and ravi are ==
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Print whether separate and ravi are ==
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
