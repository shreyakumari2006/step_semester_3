import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Problem 2: Library Item Due Date Calculator
 * 
 * Task:
 * A library manages different types of items (e.g., Books, DVDs, Magazines). Each item type has
 * a specific borrowing duration. The system needs to process a list of borrowed items and
 * calculate their respective due dates from the current date.
 * 
 * Input Format:
 * The first line contains an integer N, the number of borrowed items.
 * Each of the next N lines contains ItemType ItemTitle:
 * - BOOK "The Great Gatsby"
 * - DVD "Inception"
 * - MAGAZINE "National Geographic: Jan 2023"
 * 
 * Output Format:
 * For each borrowed item, display ItemTitle: DueDate.
 * The DueDate should be formatted as YYYY-MM-DD.
 * 
 * Business Rules:
 * - Books have a standard borrowing period of 14 days.
 * - DVDs have a standard borrowing period of 7 days.
 * - Magazines have a standard borrowing period of 3 days.
 * - The due date is calculated relative to the "current date". For simplicity, assume the current date is 2023-10-26.
 * 
 * Constraints:
 * - 1 <= N <= 100
 * - ItemTitle is a string
 * 
 * Sample Input:
 * 3
 * BOOK "1984"
 * DVD "The Matrix"
 * MAGAZINE "Forbes Issue 500"
 * 
 * Expected Output:
 * 1984: 2023-11-09
 * The Matrix: 2023-11-02
 * Forbes Issue 500: 2023-10-29
 */

// Base class demonstrating inheritance and polymorphism
abstract class LibraryItem {
    private final String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    // Subclasses override to return specific borrowing duration
    public abstract int getBorrowingDays();

    public LocalDate calculateDueDate(LocalDate baseDate) {
        return baseDate.plusDays(getBorrowingDays());
    }

    public void displayDueDate(LocalDate baseDate) {
        LocalDate dueDate = calculateDueDate(baseDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(this.title + ": " + dueDate.format(formatter));
    }
}

class BookItem extends LibraryItem {
    private static final int BORROWING_DAYS = 14;

    public BookItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return BORROWING_DAYS;
    }
}

class DvdItem extends LibraryItem {
    private static final int BORROWING_DAYS = 7;

    public DvdItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return BORROWING_DAYS;
    }
}

class MagazineItem extends LibraryItem {
    private static final int BORROWING_DAYS = 3;

    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return BORROWING_DAYS;
    }
}

public class Question2_LibraryItemDueDateCalculator {
    public static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Library Item Due Date Calculator ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "BOOK \"1984\"\n"
                    + "DVD \"The Matrix\"\n"
                    + "MAGAZINE \"Forbes Issue 500\"";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextLine()) return;

        String firstLine = scanner.nextLine().trim();
        while (firstLine.isEmpty() && scanner.hasNextLine()) {
            firstLine = scanner.nextLine().trim();
        }
        if (firstLine.isEmpty()) return;

        int n = Integer.parseInt(firstLine);
        List<LibraryItem> items = new ArrayList<>();

        Pattern pattern = Pattern.compile("^([A-Z]+)\\s+\"?([^\"]+)\"?$");

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            Matcher matcher = pattern.matcher(line);
            String itemType;
            String itemTitle;

            if (matcher.find()) {
                itemType = matcher.group(1);
                itemTitle = matcher.group(2);
            } else {
                int spaceIdx = line.indexOf(' ');
                itemType = line.substring(0, spaceIdx).trim();
                itemTitle = line.substring(spaceIdx + 1).replace("\"", "").trim();
            }

            LibraryItem item;
            if (itemType.equalsIgnoreCase("BOOK")) {
                item = new BookItem(itemTitle);
            } else if (itemType.equalsIgnoreCase("DVD")) {
                item = new DvdItem(itemTitle);
            } else if (itemType.equalsIgnoreCase("MAGAZINE")) {
                item = new MagazineItem(itemTitle);
            } else {
                throw new IllegalArgumentException("Unknown library item type: " + itemType);
            }

            items.add(item);
        }

        for (LibraryItem item : items) {
            item.displayDueDate(CURRENT_DATE);
        }
    }
}
