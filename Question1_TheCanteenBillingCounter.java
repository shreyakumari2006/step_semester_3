import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Coding Assignment for Category C
 * Problem 1: The Canteen Billing Counter
 * 
 * Task:
 * A college canteen serves three kinds of customers: students, staff, and guests. Each kind of
 * customer pays a different final amount for the same bill. For every bill, calculate the final amount
 * to be paid, display it, and then display the total amount collected.
 * 
 * Input:
 * The first line contains an integer N, the number of bills. Each of the next N lines contains
 * a customer type and the bill amount:
 * - STUDENT Amount
 * - STAFF Amount
 * - GUEST Amount
 * 
 * Output:
 * For each bill, display CustomerType: FinalAmount, formatted to two decimal places.
 * Finally, display Total: GrandTotal, also formatted to two decimal places.
 * 
 * Business Rules:
 * - Students get a 10% discount.
 * - Staff get a 5% discount.
 * - Guests pay the full amount plus a ₹10 service charge.
 * 
 * Constraints:
 * - 1 <= N <= 1000
 * - 1 <= Amount <= 100000
 * 
 * Sample Input:
 * 3
 * STUDENT 200
 * STAFF 300
 * GUEST 150
 * 
 * Expected Output:
 * STUDENT: 180.00
 * STAFF: 285.00
 * GUEST: 160.00
 * Total: 625.00
 */

// Base class demonstrating inheritance and polymorphism
abstract class CanteenCustomer {
    private final String customerType;
    private final double billAmount;

    public CanteenCustomer(String customerType, double billAmount) {
        this.customerType = customerType;
        this.billAmount = billAmount;
    }

    public String getCustomerType() {
        return customerType;
    }

    public double getBillAmount() {
        return billAmount;
    }

    // Abstract method to calculate final bill amount polymorphically
    public abstract double calculateFinalAmount();

    public void display() {
        System.out.printf("%s: %.2f%n", customerType, calculateFinalAmount());
    }
}

class StudentCustomer extends CanteenCustomer {
    private static final double DISCOUNT_RATE = 0.10; // 10% discount

    public StudentCustomer(double billAmount) {
        super("STUDENT", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return getBillAmount() - (getBillAmount() * DISCOUNT_RATE);
    }
}

class StaffCustomer extends CanteenCustomer {
    private static final double DISCOUNT_RATE = 0.05; // 5% discount

    public StaffCustomer(double billAmount) {
        super("STAFF", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return getBillAmount() - (getBillAmount() * DISCOUNT_RATE);
    }
}

class GuestCustomer extends CanteenCustomer {
    private static final double SERVICE_CHARGE = 10.0; // ₹10 service charge

    public GuestCustomer(double billAmount) {
        super("GUEST", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return getBillAmount() + SERVICE_CHARGE;
    }
}

public class Question1_TheCanteenBillingCounter {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Canteen Billing Counter ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "STUDENT 200\n"
                    + "STAFF 300\n"
                    + "GUEST 150";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<CanteenCustomer> bills = new ArrayList<>();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            double amount = scanner.nextDouble();

            CanteenCustomer customer;
            if (type.equalsIgnoreCase("STUDENT")) {
                customer = new StudentCustomer(amount);
            } else if (type.equalsIgnoreCase("STAFF")) {
                customer = new StaffCustomer(amount);
            } else if (type.equalsIgnoreCase("GUEST")) {
                customer = new GuestCustomer(amount);
            } else {
                throw new IllegalArgumentException("Unknown customer type: " + type);
            }

            bills.add(customer);
            grandTotal += customer.calculateFinalAmount();
        }

        for (CanteenCustomer c : bills) {
            c.display();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
