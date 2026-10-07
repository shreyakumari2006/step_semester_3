import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 3: Library Late Fine Counter
 * 
 * Task:
 * A library charges a fine when borrowed items are returned late. Books, DVDs, and magazines each
 * follow a different fine rule. Every item has a title and a number of days late. The library needs
 * the fine for each item and the total fines collected.
 * 
 * Input / Output:
 * Input: The first line contains N. Each of the next N lines contains TYPE Title daysLate,
 * where TYPE is BOOK, DVD, or MAGAZINE and Title is one word.
 * 
 * Output: For each item, print Title: fine. Finally, print Total Fines: total, formatted to two decimal places.
 * 
 * Business Rules:
 * - Books: 2 per day late.
 * - DVDs: 5 per day late, up to a maximum of 50.
 * - Magazines: 1 per day late.
 * 
 * Sample Input:
 * 3
 * BOOK Algebra 4
 * DVD Inception 12
 * MAGAZINE Sports 3
 * 
 * Expected Output:
 * Algebra: 8.00
 * Inception: 50.00
 * Sports: 3.00
 * Total Fines: 61.00
 */

// Abstract base class demonstrating abstraction and fine calculation contract
abstract class LibraryItemFine {
    private final String itemType;
    private final String title;
    private final int daysLate;

    public LibraryItemFine(String itemType, String title, int daysLate) {
        this.itemType = itemType;
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getItemType() {
        return itemType;
    }

    public String getTitle() {
        return title;
    }

    public int getDaysLate() {
        return daysLate;
    }

    // Abstract method to calculate fine polymorphically
    public abstract double calculateFine();

    public void display() {
        System.out.printf("%s: %.2f%n", title, calculateFine());
    }
}

class BookFine extends LibraryItemFine {
    private static final double RATE_PER_DAY = 2.0;

    public BookFine(String title, int daysLate) {
        super("BOOK", title, daysLate);
    }

    @Override
    public double calculateFine() {
        return RATE_PER_DAY * getDaysLate();
    }
}

class DvdFine extends LibraryItemFine {
    private static final double RATE_PER_DAY = 5.0;
    private static final double MAX_FINE = 50.0;

    public DvdFine(String title, int daysLate) {
        super("DVD", title, daysLate);
    }

    @Override
    public double calculateFine() {
        double fine = RATE_PER_DAY * getDaysLate();
        return Math.min(MAX_FINE, fine);
    }
}

class MagazineFine extends LibraryItemFine {
    private static final double RATE_PER_DAY = 1.0;

    public MagazineFine(String title, int daysLate) {
        super("MAGAZINE", title, daysLate);
    }

    @Override
    public double calculateFine() {
        return RATE_PER_DAY * getDaysLate();
    }
}

public class Question3_LibraryLateFineCounter {
    public static void main(String[] args) {
        System.out.println("=== Problem 3: Library Late Fine Counter ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "BOOK Algebra 4\n"
                    + "DVD Inception 12\n"
                    + "MAGAZINE Sports 3";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<LibraryItemFine> items = new ArrayList<>();
        double totalFines = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            LibraryItemFine item;
            if (type.equalsIgnoreCase("BOOK")) {
                item = new BookFine(title, daysLate);
            } else if (type.equalsIgnoreCase("DVD")) {
                item = new DvdFine(title, daysLate);
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                item = new MagazineFine(title, daysLate);
            } else {
                throw new IllegalArgumentException("Unknown item type: " + type);
            }

            items.add(item);
            totalFines += item.calculateFine();
        }

        for (LibraryItemFine item : items) {
            item.display();
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
    }
}
