import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 1: Movie Ticket Counter
 * 
 * Task:
 * A cinema sells three kinds of seats: regular, premium, and recliner. Each seat type has
 * its own ticket price, but every ticket — whatever the seat type — also carries the same
 * convenience fee of 20. The fee must be written in one place only.
 * The counter needs the amount for each booking and the total collected. A plain "ticket"
 * with no seat type must never be sold.
 * 
 * Input / Output:
 * Input: The first line contains N, the number of bookings. Each of the next N lines contains
 * SEAT count, where SEAT is REGULAR, PREMIUM, or RECLINER and count is the number of tickets.
 * 
 * Output: For each booking, print SEAT: amount. Finally, print Total: total.
 * All values are formatted to two decimal places.
 * 
 * Business Rules:
 * - Regular seat: 150 per ticket.
 * - Premium seat: 250 per ticket.
 * - Recliner seat: 400 per ticket.
 * - Every ticket adds a convenience fee of 20.
 * 
 * Sample Input:
 * 3
 * REGULAR 3
 * PREMIUM 2
 * RECLINER 1
 * 
 * Expected Output:
 * REGULAR: 510.00
 * PREMIUM: 540.00
 * RECLINER: 420.00
 * Total: 1470.00
 */

// Abstract base class preventing creation of a generic ticket with no seat type
abstract class MovieTicket {
    // Shared convenience fee defined in one place only
    public static final double CONVENIENCE_FEE = 20.0;

    private final String seatType;
    private final int count;

    public MovieTicket(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    public int getCount() {
        return count;
    }

    // Abstract method for seat-specific base price
    public abstract double getBasePrice();

    // Template method calculating total ticket price including convenience fee
    public double calculateTotalAmount() {
        return (getBasePrice() + CONVENIENCE_FEE) * count;
    }

    public void display() {
        System.out.printf("%s: %.2f%n", seatType, calculateTotalAmount());
    }
}

class RegularTicket extends MovieTicket {
    private static final double BASE_PRICE = 150.0;

    public RegularTicket(int count) {
        super("REGULAR", count);
    }

    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }
}

class PremiumTicket extends MovieTicket {
    private static final double BASE_PRICE = 250.0;

    public PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }
}

class ReclinerTicket extends MovieTicket {
    private static final double BASE_PRICE = 400.0;

    public ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }
}

public class Question1_MovieTicketCounter {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Movie Ticket Counter ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "REGULAR 3\n"
                    + "PREMIUM 2\n"
                    + "RECLINER 1";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<MovieTicket> bookings = new ArrayList<>();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            int count = scanner.nextInt();

            MovieTicket ticket;
            if (type.equalsIgnoreCase("REGULAR")) {
                ticket = new RegularTicket(count);
            } else if (type.equalsIgnoreCase("PREMIUM")) {
                ticket = new PremiumTicket(count);
            } else if (type.equalsIgnoreCase("RECLINER")) {
                ticket = new ReclinerTicket(count);
            } else {
                throw new IllegalArgumentException("Unknown seat type: " + type);
            }

            bookings.add(ticket);
            totalCollected += ticket.calculateTotalAmount();
        }

        for (MovieTicket ticket : bookings) {
            ticket.display();
        }
        System.out.printf("Total: %.2f%n", totalCollected);
    }
}
