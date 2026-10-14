import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 3: Delivery Fee Calculator
 * 
 * Task:
 * A delivery service offers different types of delivery (e.g., Standard, Express, International).
 * Each delivery type has unique rules for calculating its fee based on weight and distance.
 * The system needs to calculate the total fee for a list of delivery requests.
 * 
 * Input Format:
 * The first line contains an integer N, the number of delivery requests.
 * Each of the next N lines contains DeliveryType Weight Distance [AdditionalParam]:
 * - STANDARD Weight Distance
 * - EXPRESS Weight Distance
 * - INTERNATIONAL Weight Distance CustomsFee
 * 
 * Output Format:
 * For each delivery, display DeliveryType: CalculatedFee, formatted to two decimal places.
 * Finally, display Total: GrandTotalFee, also formatted to two decimal places.
 * 
 * Business Rules:
 * - Standard Delivery: Base fee $5, plus $0.50 per kg, plus $0.10 per km.
 * - Express Delivery: Base fee $15, plus $1.00 per kg, plus $0.20 per km.
 * - International Delivery: Base fee $25, plus $2.00 per kg, plus $0.50 per km, plus an additional CustomsFee.
 * 
 * Constraints:
 * - 1 <= N <= 100
 * - Weight, Distance, CustomsFee are positive numbers.
 * 
 * Sample Input:
 * 3
 * STANDARD 10 50
 * EXPRESS 5 20
 * INTERNATIONAL 20 100 30
 * 
 * Expected Output:
 * STANDARD: 15.00
 * EXPRESS: 24.00
 * INTERNATIONAL: 195.00
 * Total: 234.00
 */

// Base class demonstrating inheritance and runtime polymorphism
abstract class Delivery {
    private final String deliveryType;
    private final double weight;
    private final double distance;

    public Delivery(String deliveryType, double weight, double distance) {
        this.deliveryType = deliveryType;
        this.weight = weight;
        this.distance = distance;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public double getWeight() {
        return weight;
    }

    public double getDistance() {
        return distance;
    }

    // Abstract method to calculate fee polymorphically
    public abstract double calculateFee();

    public void display() {
        System.out.printf("%s: %.2f%n", deliveryType, calculateFee());
    }
}

class StandardDelivery extends Delivery {
    private static final double BASE_FEE = 5.00;
    private static final double RATE_PER_KG = 0.50;
    private static final double RATE_PER_KM = 0.10;

    public StandardDelivery(double weight, double distance) {
        super("STANDARD", weight, distance);
    }

    @Override
    public double calculateFee() {
        return BASE_FEE + (RATE_PER_KG * getWeight()) + (RATE_PER_KM * getDistance());
    }
}

class ExpressDelivery extends Delivery {
    private static final double BASE_FEE = 15.00;
    private static final double RATE_PER_KG = 1.00;
    private static final double RATE_PER_KM = 0.20;

    public ExpressDelivery(double weight, double distance) {
        super("EXPRESS", weight, distance);
    }

    @Override
    public double calculateFee() {
        return BASE_FEE + (RATE_PER_KG * getWeight()) + (RATE_PER_KM * getDistance());
    }
}

class InternationalDelivery extends Delivery {
    private static final double BASE_FEE = 25.00;
    private static final double RATE_PER_KG = 2.00;
    private static final double RATE_PER_KM = 0.50;
    private final double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    @Override
    public double calculateFee() {
        return BASE_FEE + (RATE_PER_KG * getWeight()) + (RATE_PER_KM * getDistance()) + customsFee;
    }
}

public class Question3_DeliveryFeeCalculator {
    public static void main(String[] args) {
        System.out.println("=== Problem 3: Delivery Fee Calculator ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "STANDARD 10 50\n"
                    + "EXPRESS 5 20\n"
                    + "INTERNATIONAL 20 100 30";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();

            Delivery delivery;
            if (type.equalsIgnoreCase("STANDARD")) {
                delivery = new StandardDelivery(weight, distance);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                delivery = new ExpressDelivery(weight, distance);
            } else if (type.equalsIgnoreCase("INTERNATIONAL")) {
                double customsFee = scanner.nextDouble();
                delivery = new InternationalDelivery(weight, distance, customsFee);
            } else {
                throw new IllegalArgumentException("Unknown delivery type: " + type);
            }

            deliveries.add(delivery);
            grandTotal += delivery.calculateFee();
        }

        for (Delivery d : deliveries) {
            d.display();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
