import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 5: Home Appliance Energy Report
 * 
 * Task:
 * An energy app estimates the monthly electricity cost of four home appliances: a fridge, an air
 * conditioner, a TV, and a washing machine. Every appliance has a fixed power rating and a number
 * of hours used. The air conditioner and the washing machine also have a saver mode that reduces their
 * energy use by 25%; the fridge and the TV do not.
 * The app must show the units used and the cost for each appliance, and the total cost. If saver mode
 * is requested for an appliance that does not support it, the app must report it instead of calculating a cost.
 * 
 * Input / Output:
 * Input: The first line contains N. Each of the next N lines contains APPLIANCE hours or APPLIANCE hours SAVER,
 * where APPLIANCE is FRIDGE, AC, TV, or WASHER.
 * 
 * Output: For each appliance, print APPLIANCE: Units=u Cost=c, or APPLIANCE: saver mode not supported.
 * Finally, print Total Cost: total. All values are formatted to two decimal places.
 * 
 * Business Rules:
 * - Power ratings: Fridge 150 W, AC 1500 W, TV 100 W, Washer 500 W.
 * - Units (kWh) = power * hours / 1000. In saver mode, units are reduced by 25%.
 * - Cost = units * 8.
 * 
 * Sample Input:
 * 4
 * FRIDGE 24
 * AC 8 SAVER
 * TV 5
 * WASHER 2 SAVER
 * 
 * Expected Output:
 * FRIDGE: Units=3.60 Cost=28.80
 * AC: Units=9.00 Cost=72.00
 * TV: Units=0.50 Cost=4.00
 * WASHER: Units=0.75 Cost=6.00
 * Total Cost: 110.80
 */

// Interface defining the capability to operate in energy saver mode
interface SaverModeCapable {
    double SAVER_DISCOUNT_FACTOR = 0.75; // 25% energy reduction

    default double applySaverReduction(double baseUnits) {
        return baseUnits * SAVER_DISCOUNT_FACTOR;
    }
}

// Abstract base class representing any household appliance
abstract class Appliance {
    public static final double COST_PER_UNIT = 8.0;

    private final String applianceName;
    private final double powerWatts;
    private final double hoursUsed;
    private final boolean saverModeRequested;

    public Appliance(String applianceName, double powerWatts, double hoursUsed, boolean saverModeRequested) {
        this.applianceName = applianceName;
        this.powerWatts = powerWatts;
        this.hoursUsed = hoursUsed;
        this.saverModeRequested = saverModeRequested;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public double getPowerWatts() {
        return powerWatts;
    }

    public double getHoursUsed() {
        return hoursUsed;
    }

    public boolean isSaverModeRequested() {
        return saverModeRequested;
    }

    public boolean isOperationSupported() {
        if (saverModeRequested && !(this instanceof SaverModeCapable)) {
            return false;
        }
        return true;
    }

    public double calculateUnits() {
        if (!isOperationSupported()) {
            return 0.0;
        }

        double baseUnits = (powerWatts * hoursUsed) / 1000.0;
        if (saverModeRequested && this instanceof SaverModeCapable) {
            return ((SaverModeCapable) this).applySaverReduction(baseUnits);
        }
        return baseUnits;
    }

    public double calculateCost() {
        if (!isOperationSupported()) {
            return 0.0;
        }
        return calculateUnits() * COST_PER_UNIT;
    }

    public void display() {
        if (!isOperationSupported()) {
            System.out.println(applianceName + ": saver mode not supported");
        } else {
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", applianceName, calculateUnits(), calculateCost());
        }
    }
}

class FridgeAppliance extends Appliance {
    private static final double POWER_RATING = 150.0;

    public FridgeAppliance(double hoursUsed, boolean saverModeRequested) {
        super("FRIDGE", POWER_RATING, hoursUsed, saverModeRequested);
    }
}

class AcAppliance extends Appliance implements SaverModeCapable {
    private static final double POWER_RATING = 1500.0;

    public AcAppliance(double hoursUsed, boolean saverModeRequested) {
        super("AC", POWER_RATING, hoursUsed, saverModeRequested);
    }
}

class TvAppliance extends Appliance {
    private static final double POWER_RATING = 100.0;

    public TvAppliance(double hoursUsed, boolean saverModeRequested) {
        super("TV", POWER_RATING, hoursUsed, saverModeRequested);
    }
}

class WasherAppliance extends Appliance implements SaverModeCapable {
    private static final double POWER_RATING = 500.0;

    public WasherAppliance(double hoursUsed, boolean saverModeRequested) {
        super("WASHER", POWER_RATING, hoursUsed, saverModeRequested);
    }
}

public class Question5_HomeApplianceEnergyReport {
    public static void main(String[] args) {
        System.out.println("=== Problem 5: Home Appliance Energy Report ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "4\n"
                    + "FRIDGE 24\n"
                    + "AC 8 SAVER\n"
                    + "TV 5\n"
                    + "WASHER 2 SAVER";
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
        List<Appliance> appliances = new ArrayList<>();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length >= 3 && parts[2].equalsIgnoreCase("SAVER");

            Appliance appliance;
            if (type.equalsIgnoreCase("FRIDGE")) {
                appliance = new FridgeAppliance(hours, saver);
            } else if (type.equalsIgnoreCase("AC")) {
                appliance = new AcAppliance(hours, saver);
            } else if (type.equalsIgnoreCase("TV")) {
                appliance = new TvAppliance(hours, saver);
            } else if (type.equalsIgnoreCase("WASHER")) {
                appliance = new WasherAppliance(hours, saver);
            } else {
                throw new IllegalArgumentException("Unknown appliance type: " + type);
            }

            appliances.add(appliance);
            if (appliance.isOperationSupported()) {
                totalCost += appliance.calculateCost();
            }
        }

        for (Appliance a : appliances) {
            a.display();
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
