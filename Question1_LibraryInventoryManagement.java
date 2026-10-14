/**
 * Problem M1: Library Inventory Management
 * 
 * Scenario:
 * The library currently tracks its book inventory using three parallel arrays —
 * titles, authors, copiesAvailable — and a recount last week already went out of sync.
 * Rebuild it the OOP way.
 * 
 * Task:
 * - Define a class BookInventory with fields String title, String author, and int copiesAvailable.
 * - Write a constructor that sets all three fields.
 * - Write an instance method printEntry() that prints one formatted line.
 * - Create four BookInventory objects for different books, store them in an array of BookInventory,
 *   and print each one in a loop.
 */

class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }
}

public class Question1_LibraryInventoryManagement {
    public static void main(String[] args) {
        // Create four BookInventory objects
        BookInventory[] books = new BookInventory[] {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        // Print each entry using a loop
        for (BookInventory book : books) {
            book.printEntry();
        }
    }
}
