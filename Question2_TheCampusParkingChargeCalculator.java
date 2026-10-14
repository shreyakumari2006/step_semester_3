import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Coding Assignment for Category C
 * Problem 2: The Campus Parking Charge Calculator
 * 
 * Task:
 * The campus parking lot allows bikes, cars, and trucks. Each vehicle type is charged differently
 * based on the number of hours it was parked. For every parked vehicle, calculate the parking
 * charge, display it, and then display the total charge collected.
 * 
 * Input:
 * The first line contains an integer N, the number of parked vehicles. Each of the next N lines
 * contains a vehicle type and the number of hours parked:
 * - BIKE Hours
 * - CAR Hours
 * - TRUCK Hours
 * 
 * Output:
 * For each vehicle, display VehicleType: Charge, formatted to two decimal places.
 * Finally, display Total: GrandTotal, also formatted to two decimal places.
 * 
 * Business Rules:
 * - Bike: ₹10 per hour.
 * - Car: ₹30 for the first hour, plus ₹20 for each additional hour.
 * - Truck: ₹50 per hour, with a minimum charge of ₹100.
 * 
 * Constraints:
 * - 1 <= N <= 500
 * - Hours is a whole number, 1 <= Hours <= 24
 * 
 * Sample Input:
 * 4
 * BIKE 3
 * CAR 4
 * TRUCK 1
 * CAR 1
 * 
 * Expected Output:
 * BIKE: 30.00
 * CAR: 90.00
 * TRUCK: 100.00
 * CAR: 30.00
 * Total: 250.00
 */

// Base class demonstrating inheritance and polymorphism
abstract class ParkedVehicle {
    private final String vehicleType;
    private final int hours;

    public ParkedVehicle(String vehicleType, int hours) {
        this.vehicleType = vehicleType;
        this.hours = hours;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getHours() {
        return hours;
    }

    // Abstract method to calculate parking charge polymorphically
    public abstract double calculateCharge();

    public void display() {
        System.out.printf("%s: %.2f%n", vehicleType, calculateCharge());
    }
}

class BikeVehicle extends ParkedVehicle {
    private static final double HOURLY_RATE = 10.0;

    public BikeVehicle(int hours) {
        super("BIKE", hours);
    }

    @Override
    public double calculateCharge() {
        return getHours() * HOURLY_RATE;
    }
}

class CarVehicle extends ParkedVehicle {
    private static final double FIRST_HOUR_RATE = 30.0;
    private static final double ADDITIONAL_HOURLY_RATE = 20.0;

    public CarVehicle(int hours) {
        super("CAR", hours);
    }

    @Override
    public double calculateCharge() {
        int hours = getHours();
        if (hours <= 1) {
            return FIRST_HOUR_RATE;
        }
        return FIRST_HOUR_RATE + ((hours - 1) * ADDITIONAL_HOURLY_RATE);
    }
}

class TruckVehicle extends ParkedVehicle {
    private static final double HOURLY_RATE = 50.0;
    private static final double MINIMUM_CHARGE = 100.0;

    public TruckVehicle(int hours) {
        super("TRUCK", hours);
    }

    @Override
    public double calculateCharge() {
        double total = getHours() * HOURLY_RATE;
        return Math.max(MINIMUM_CHARGE, total);
    }
}

public class Question2_TheCampusParkingChargeCalculator {
    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Campus Parking Charge Calculator ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "4\n"
                    + "BIKE 3\n"
                    + "CAR 4\n"
                    + "TRUCK 1\n"
                    + "CAR 1";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<ParkedVehicle> vehicles = new ArrayList<>();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            int hours = scanner.nextInt();

            ParkedVehicle vehicle;
            if (type.equalsIgnoreCase("BIKE")) {
                vehicle = new BikeVehicle(hours);
            } else if (type.equalsIgnoreCase("CAR")) {
                vehicle = new CarVehicle(hours);
            } else if (type.equalsIgnoreCase("TRUCK")) {
                vehicle = new TruckVehicle(hours);
            } else {
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
            }

            vehicles.add(vehicle);
            grandTotal += vehicle.calculateCharge();
        }

        for (ParkedVehicle v : vehicles) {
            v.display();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
