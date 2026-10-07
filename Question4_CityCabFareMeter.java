import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 4: City Cab Fare Meter
 * 
 * Task:
 * A cab company runs three kinds of cabs: mini, sedan, and SUV. Each cab type charges a different
 * rate per kilometre, but the company has one rule for all cabs: no trip costs less than 100.
 * Only sedans and SUVs offer night service, which adds 20% to the fare. A night trip requested
 * in a mini must be rejected.
 * The company needs the fare for every completed trip and the total of all completed trips.
 * 
 * Input / Output:
 * Input: The first line contains N. Each of the next N lines contains CAB km TIME,
 * where CAB is MINI, SEDAN, or SUV and TIME is DAY or NIGHT.
 * 
 * Output: For each completed trip, print CAB: fare. For a rejected trip, print CAB: night service not available.
 * Finally, print Total: total. All values are formatted to two decimal places.
 * 
 * Business Rules:
 * - Mini: 10 per km. Sedan: 14 per km. SUV: 18 per km.
 * - Fare = distance * rate, but never less than 100.
 * - A night trip adds 20% to the fare (after the minimum is applied).
 * 
 * Sample Input:
 * 4
 * MINI 8 DAY
 * SEDAN 10 NIGHT
 * SUV 20 DAY
 * MINI 5 NIGHT
 * 
 * Expected Output:
 * MINI: 100.00
 * SEDAN: 168.00
 * SUV: 360.00
 * MINI: night service not available
 * Total: 628.00
 */

// Interface defining the capability to offer night service
interface NightServiceSupport {
    double NIGHT_SURCHARGE_MULTIPLIER = 1.20; // 20% extra

    default double applyNightSurcharge(double baseFare) {
        return baseFare * NIGHT_SURCHARGE_MULTIPLIER;
    }
}

// Abstract base class encapsulating common cab attributes and minimum fare logic
abstract class Cab {
    public static final double MINIMUM_FARE = 100.0;

    private final String cabType;
    private final double distanceKm;
    private final String timeOfDay;

    public Cab(String cabType, double distanceKm, String timeOfDay) {
        this.cabType = cabType;
        this.distanceKm = distanceKm;
        this.timeOfDay = timeOfDay;
    }

    public String getCabType() {
        return cabType;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public boolean isNightTrip() {
        return "NIGHT".equalsIgnoreCase(timeOfDay);
    }

    // Abstract method returning rate per km
    public abstract double getRatePerKm();

    // Check whether the requested trip is valid/available
    public boolean isTripValid() {
        if (isNightTrip() && !(this instanceof NightServiceSupport)) {
            return false;
        }
        return true;
    }

    // Calculates fare for valid trip; returns -1.0 if rejected
    public double calculateFare() {
        if (!isTripValid()) {
            return -1.0;
        }

        double rawFare = distanceKm * getRatePerKm();
        double baseFareWithMinimum = Math.max(MINIMUM_FARE, rawFare);

        if (isNightTrip() && this instanceof NightServiceSupport) {
            return ((NightServiceSupport) this).applyNightSurcharge(baseFareWithMinimum);
        }

        return baseFareWithMinimum;
    }

    public void display() {
        if (!isTripValid()) {
            System.out.println(cabType + ": night service not available");
        } else {
            System.out.printf("%s: %.2f%n", cabType, calculateFare());
        }
    }
}

class MiniCab extends Cab {
    private static final double RATE = 10.0;

    public MiniCab(double distanceKm, String timeOfDay) {
        super("MINI", distanceKm, timeOfDay);
    }

    @Override
    public double getRatePerKm() {
        return RATE;
    }
}

class SedanCab extends Cab implements NightServiceSupport {
    private static final double RATE = 14.0;

    public SedanCab(double distanceKm, String timeOfDay) {
        super("SEDAN", distanceKm, timeOfDay);
    }

    @Override
    public double getRatePerKm() {
        return RATE;
    }
}

class SuvCab extends Cab implements NightServiceSupport {
    private static final double RATE = 18.0;

    public SuvCab(double distanceKm, String timeOfDay) {
        super("SUV", distanceKm, timeOfDay);
    }

    @Override
    public double getRatePerKm() {
        return RATE;
    }
}

public class Question4_CityCabFareMeter {
    public static void main(String[] args) {
        System.out.println("=== Problem 4: City Cab Fare Meter ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "4\n"
                    + "MINI 8 DAY\n"
                    + "SEDAN 10 NIGHT\n"
                    + "SUV 20 DAY\n"
                    + "MINI 5 NIGHT";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Cab> trips = new ArrayList<>();
        double totalCompletedFares = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            Cab cab;
            if (type.equalsIgnoreCase("MINI")) {
                cab = new MiniCab(km, time);
            } else if (type.equalsIgnoreCase("SEDAN")) {
                cab = new SedanCab(km, time);
            } else if (type.equalsIgnoreCase("SUV")) {
                cab = new SuvCab(km, time);
            } else {
                throw new IllegalArgumentException("Unknown cab type: " + type);
            }

            trips.add(cab);
            double fare = cab.calculateFare();
            if (fare > 0) {
                totalCompletedFares += fare;
            }
        }

        for (Cab trip : trips) {
            trip.display();
        }
        System.out.printf("Total: %.2f%n", totalCompletedFares);
    }
}
