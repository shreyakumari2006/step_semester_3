import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 4: Electricity Connection Billing
 * 
 * Task:
 * The electricity board issues monthly bills to homes, shops, and factories. Every connection has
 * a number of units used, but each connection type calculates its bill differently. The board needs
 * each connection's bill and the total amount billed.
 * 
 * Input / Output:
 * Input: The first line contains N. Each of the next N lines contains TYPE units,
 * where TYPE is HOME, SHOP, or FACTORY.
 * 
 * Output: For each connection, print TYPE: bill. Finally, print Total: total, formatted to two decimal places.
 * 
 * Business Rules:
 * - Home: 5 per unit for the first 100 units and 7 per unit after that.
 * - Shop: 8 per unit plus a fixed charge of 100.
 * - Factory: 6 per unit, with a minimum bill of 1000.
 * 
 * Sample Input:
 * 3
 * HOME 150
 * SHOP 90
 * FACTORY 120
 * 
 * Expected Output:
 * HOME: 850.00
 * SHOP: 820.00
 * FACTORY: 1000.00
 * Total: 2670.00
 */

// Abstract base class representing an electricity connection
abstract class ElectricityConnection {
    private final String connectionType;
    private final double units;

    public ElectricityConnection(String connectionType, double units) {
        this.connectionType = connectionType;
        this.units = units;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public double getUnits() {
        return units;
    }

    // Abstract method to calculate monthly bill
    public abstract double calculateBill();

    public void display() {
        System.out.printf("%s: %.2f%n", connectionType, calculateBill());
    }
}

class HomeConnection extends ElectricityConnection {
    private static final double SLAB_LIMIT = 100.0;
    private static final double RATE_TIER_1 = 5.0;
    private static final double RATE_TIER_2 = 7.0;

    public HomeConnection(double units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (getUnits() <= SLAB_LIMIT) {
            return getUnits() * RATE_TIER_1;
        } else {
            return (SLAB_LIMIT * RATE_TIER_1) + ((getUnits() - SLAB_LIMIT) * RATE_TIER_2);
        }
    }
}

class ShopConnection extends ElectricityConnection {
    private static final double RATE_PER_UNIT = 8.0;
    private static final double FIXED_CHARGE = 100.0;

    public ShopConnection(double units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (getUnits() * RATE_PER_UNIT) + FIXED_CHARGE;
    }
}

class FactoryConnection extends ElectricityConnection {
    private static final double RATE_PER_UNIT = 6.0;
    private static final double MINIMUM_BILL = 1000.0;

    public FactoryConnection(double units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        double calculated = getUnits() * RATE_PER_UNIT;
        return Math.max(MINIMUM_BILL, calculated);
    }
}

public class Question4_ElectricityConnectionBilling {
    public static void main(String[] args) {
        System.out.println("=== Problem 4: Electricity Connection Billing ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "HOME 150\n"
                    + "SHOP 90\n"
                    + "FACTORY 120";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();
        double totalBill = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            double units = scanner.nextDouble();

            ElectricityConnection conn;
            if (type.equalsIgnoreCase("HOME")) {
                conn = new HomeConnection(units);
            } else if (type.equalsIgnoreCase("SHOP")) {
                conn = new ShopConnection(units);
            } else if (type.equalsIgnoreCase("FACTORY")) {
                conn = new FactoryConnection(units);
            } else {
                throw new IllegalArgumentException("Unknown connection type: " + type);
            }

            connections.add(conn);
            totalBill += conn.calculateBill();
        }

        for (ElectricityConnection conn : connections) {
            conn.display();
        }
        System.out.printf("Total: %.2f%n", totalBill);
    }
}
