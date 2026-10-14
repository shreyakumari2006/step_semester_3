import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 2: Parcel Shipping Desk
 * 
 * Task:
 * A courier office ships standard, express, and fragile parcels. Every parcel has a weight and
 * a declared value, and each parcel type calculates its shipping charge differently. Express and
 * fragile parcels can also be insured; standard parcels cannot.
 * The office needs the charge, the insurance, and the total for each parcel, followed by the grand total.
 * Making another parcel type insurable later should not change the parcel types that are not insured.
 * 
 * Input / Output:
 * Input: The first line contains N. Each of the next N lines contains TYPE weightKg declaredValue,
 * where TYPE is STANDARD, EXPRESS, or FRAGILE.
 * 
 * Output: For each parcel, print TYPE: Charge=c Insurance=i Total=t. Finally, print Grand Total: g.
 * All values are formatted to two decimal places.
 * 
 * Business Rules:
 * - Standard: 40 plus 10 per kg.
 * - Express: 80 plus 15 per kg.
 * - Fragile: the standard charge plus a handling fee of 50.
 * - Insurance for express and fragile parcels is 2% of the declared value. Standard parcels show Insurance=0.00.
 * 
 * Sample Input:
 * 3
 * STANDARD 3 500
 * EXPRESS 2 1000
 * FRAGILE 4 2000
 * 
 * Expected Output:
 * STANDARD: Charge=70.00 Insurance=0.00 Total=70.00
 * EXPRESS: Charge=110.00 Insurance=20.00 Total=130.00
 * FRAGILE: Charge=130.00 Insurance=40.00 Total=170.00
 * Grand Total: 370.00
 */

// Interface defining the insurable capability for parcels that support insurance
interface Insurable {
    double calculateInsurance();
}

// Abstract base class representing any parcel
abstract class Parcel {
    private final String type;
    private final double weightKg;
    private final double declaredValue;

    public Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public String getType() {
        return type;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double getDeclaredValue() {
        return declaredValue;
    }

    // Abstract method for parcel-specific shipping charge
    public abstract double calculateShippingCharge();

    public double getInsuranceAmount() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance();
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateShippingCharge() + getInsuranceAmount();
    }

    public void display() {
        System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, calculateShippingCharge(), getInsuranceAmount(), calculateTotal());
    }
}

class StandardParcel extends Parcel {
    private static final double BASE_CHARGE = 40.0;
    private static final double RATE_PER_KG = 10.0;

    public StandardParcel(double weightKg, double declaredValue) {
        super("STANDARD", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return BASE_CHARGE + (RATE_PER_KG * getWeightKg());
    }
}

class ExpressParcel extends Parcel implements Insurable {
    private static final double BASE_CHARGE = 80.0;
    private static final double RATE_PER_KG = 15.0;
    private static final double INSURANCE_RATE = 0.02; // 2% of declared value

    public ExpressParcel(double weightKg, double declaredValue) {
        super("EXPRESS", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return BASE_CHARGE + (RATE_PER_KG * getWeightKg());
    }

    @Override
    public double calculateInsurance() {
        return INSURANCE_RATE * getDeclaredValue();
    }
}

class FragileParcel extends Parcel implements Insurable {
    private static final double BASE_CHARGE = 40.0;
    private static final double RATE_PER_KG = 10.0;
    private static final double HANDLING_FEE = 50.0;
    private static final double INSURANCE_RATE = 0.02; // 2% of declared value

    public FragileParcel(double weightKg, double declaredValue) {
        super("FRAGILE", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return BASE_CHARGE + (RATE_PER_KG * getWeightKg()) + HANDLING_FEE;
    }

    @Override
    public double calculateInsurance() {
        return INSURANCE_RATE * getDeclaredValue();
    }
}

public class Question2_ParcelShippingDesk {
    public static void main(String[] args) {
        System.out.println("=== Problem 2: Parcel Shipping Desk ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "STANDARD 3 500\n"
                    + "EXPRESS 2 1000\n"
                    + "FRAGILE 4 2000";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            Parcel parcel;
            if (type.equalsIgnoreCase("STANDARD")) {
                parcel = new StandardParcel(weight, declaredValue);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                parcel = new ExpressParcel(weight, declaredValue);
            } else if (type.equalsIgnoreCase("FRAGILE")) {
                parcel = new FragileParcel(weight, declaredValue);
            } else {
                throw new IllegalArgumentException("Unknown parcel type: " + type);
            }

            parcels.add(parcel);
            grandTotal += parcel.calculateTotal();
        }

        for (Parcel p : parcels) {
            p.display();
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
