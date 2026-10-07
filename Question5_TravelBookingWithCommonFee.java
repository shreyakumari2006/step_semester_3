import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 5: Travel Booking with a Common Fee
 * 
 * Task:
 * A travel website sells bus, train, and flight tickets. The fare depends on the travel mode
 * and the distance, but every booking — whatever the mode — also adds the same booking fee of 50.
 * The fee must be written in one place only.
 * 
 * If the booking fee changes, only one line of code should need to change.
 * 
 * Input / Output:
 * Input: The first line contains N. Each of the next N lines contains MODE distanceKm,
 * where MODE is BUS, TRAIN, or FLIGHT.
 * 
 * Output: For each booking, print MODE: total, formatted to two decimal places.
 * 
 * Business Rules:
 * - Bus fare: 2 per km.
 * - Train fare: 1.5 per km.
 * - Flight fare: 2500 plus 4 per km.
 * - Every booking adds a booking fee of 50 to the fare.
 * 
 * Sample Input:
 * 3
 * BUS 200
 * TRAIN 300
 * FLIGHT 500
 * 
 * Expected Output:
 * BUS: 450.00
 * TRAIN: 500.00
 * FLIGHT: 4550.00
 */

// Abstract base class managing common booking fee in one central place
abstract class TravelBooking {
    // Single point of modification for the common booking fee
    public static final double BOOKING_FEE = 50.0;

    private final String mode;
    private final double distanceKm;

    public TravelBooking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public String getMode() {
        return mode;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    // Abstract method to calculate base fare specific to each mode
    public abstract double calculateBaseFare();

    // Final total calculation combining mode-specific base fare with common booking fee
    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    public void display() {
        System.out.printf("%s: %.2f%n", mode, calculateTotalFare());
    }
}

class BusBooking extends TravelBooking {
    private static final double RATE_PER_KM = 2.0;

    public BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return RATE_PER_KM * getDistanceKm();
    }
}

class TrainBooking extends TravelBooking {
    private static final double RATE_PER_KM = 1.5;

    public TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return RATE_PER_KM * getDistanceKm();
    }
}

class FlightBooking extends TravelBooking {
    private static final double BASE_AIR_FARE = 2500.0;
    private static final double RATE_PER_KM = 4.0;

    public FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return BASE_AIR_FARE + (RATE_PER_KM * getDistanceKm());
    }
}

public class Question5_TravelBookingWithCommonFee {
    public static void main(String[] args) {
        System.out.println("=== Problem 5: Travel Booking with a Common Fee ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "BUS 200\n"
                    + "TRAIN 300\n"
                    + "FLIGHT 500";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String mode = scanner.next();
            double distanceKm = scanner.nextDouble();

            TravelBooking booking;
            if (mode.equalsIgnoreCase("BUS")) {
                booking = new BusBooking(distanceKm);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                booking = new TrainBooking(distanceKm);
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                booking = new FlightBooking(distanceKm);
            } else {
                throw new IllegalArgumentException("Unknown travel mode: " + mode);
            }

            bookings.add(booking);
        }

        for (TravelBooking b : bookings) {
            b.display();
        }
    }
}
