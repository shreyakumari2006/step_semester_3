import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 5: Public Transport Fare Calculator
 * 
 * Task:
 * A public transport system calculates fares based on the type of transport (e.g., Bus, Train, Metro)
 * and distance traveled. Each transport type has a different fare structure. The system needs to
 * calculate the fare for a list of journeys and display the individual and total fares.
 * 
 * Input Format:
 * The first line contains an integer N, the number of journeys.
 * Each of the next N lines contains TransportType Distance [AdditionalParam]:
 * - BUS Distance
 * - TRAIN Distance
 * - METRO Distance PeakHourFactor
 * 
 * Output Format:
 * For each journey, display TransportType: CalculatedFare, formatted to two decimal places.
 * Finally, display Total: GrandTotalFare, also formatted to two decimal places.
 * 
 * Business Rules:
 * - Bus: Base fare $2, plus $0.10 per km. Max fare $10.
 * - Train: Base fare $3, plus $0.15 per km.
 * - Metro: Base fare $1.50, plus $0.20 per km, multiplied by a PeakHourFactor.
 * 
 * Constraints:
 * - 1 <= N <= 100
 * - Distance is a positive number.
 * - PeakHourFactor is a float between 1.0 and 2.0 (inclusive).
 * 
 * Sample Input:
 * 3
 * BUS 15
 * TRAIN 50
 * METRO 10 1.5
 * 
 * Expected Output:
 * BUS: 3.50
 * TRAIN: 10.50
 * METRO: 5.25
 * Total: 19.25
 */

// Base class demonstrating inheritance and polymorphism
abstract class TransportJourney {
    private final String transportType;
    private final double distance;

    public TransportJourney(String transportType, double distance) {
        this.transportType = transportType;
        this.distance = distance;
    }

    public String getTransportType() {
        return transportType;
    }

    public double getDistance() {
        return distance;
    }

    // Abstract method to calculate fare polymorphically
    public abstract double calculateFare();

    public void display() {
        System.out.printf("%s: %.2f%n", transportType, calculateFare());
    }
}

class BusJourney extends TransportJourney {
    private static final double BASE_FARE = 2.00;
    private static final double RATE_PER_KM = 0.10;
    private static final double MAX_FARE = 10.00;

    public BusJourney(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateFare() {
        double calculated = BASE_FARE + (RATE_PER_KM * getDistance());
        return Math.min(MAX_FARE, calculated);
    }
}

class TrainJourney extends TransportJourney {
    private static final double BASE_FARE = 3.00;
    private static final double RATE_PER_KM = 0.15;

    public TrainJourney(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateFare() {
        return BASE_FARE + (RATE_PER_KM * getDistance());
    }
}

class MetroJourney extends TransportJourney {
    private static final double BASE_FARE = 1.50;
    private static final double RATE_PER_KM = 0.20;
    private final double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    public double getPeakHourFactor() {
        return peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (BASE_FARE + (RATE_PER_KM * getDistance())) * peakHourFactor;
    }
}

public class Question5_PublicTransportFareCalculator {
    public static void main(String[] args) {
        System.out.println("=== Problem 5: Public Transport Fare Calculator ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "BUS 15\n"
                    + "TRAIN 50\n"
                    + "METRO 10 1.5";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<TransportJourney> journeys = new ArrayList<>();
        double grandTotalFare = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            double distance = scanner.nextDouble();

            TransportJourney journey;
            if (type.equalsIgnoreCase("BUS")) {
                journey = new BusJourney(distance);
            } else if (type.equalsIgnoreCase("TRAIN")) {
                journey = new TrainJourney(distance);
            } else if (type.equalsIgnoreCase("METRO")) {
                double peakHourFactor = scanner.nextDouble();
                journey = new MetroJourney(distance, peakHourFactor);
            } else {
                throw new IllegalArgumentException("Unknown transport type: " + type);
            }

            journeys.add(journey);
            grandTotalFare += journey.calculateFare();
        }

        for (TransportJourney j : journeys) {
            j.display();
        }
        System.out.printf("Total: %.2f%n", grandTotalFare);
    }
}
