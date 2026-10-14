import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 1: Payment System Fee Calculation
 * 
 * Task:
 * A payment processing system handles various transaction types. Each payment method applies
 * a different processing fee. For every transaction, calculate the final amount after applying
 * the applicable fee and display the adjusted amount for each transaction followed by the total
 * amount processed.
 * 
 * Input Format:
 * The first line contains an integer N, the number of transactions.
 * Each of the next N lines contains a payment type and transaction amount:
 * - CARD Amount
 * - WALLET Amount
 * - BANKTRANSFER Amount
 * 
 * Output Format:
 * For each transaction, display PaymentType: AdjustedAmount, formatted to two decimal places.
 * Finally, display Total: GrandTotal, also formatted to two decimal places.
 * 
 * Business Rules:
 * - Card transactions have a 2% processing fee.
 * - Wallet transactions have a 1% processing fee.
 * - Bank transfers have no processing fee.
 * 
 * Constraints:
 * - 1 <= N <= 1000
 * - 1 <= Amount <= 1000000
 * 
 * Sample Input:
 * 3
 * CARD 1000
 * WALLET 500
 * BANKTRANSFER 2000
 * 
 * Expected Output:
 * CARD: 1020.00
 * WALLET: 505.00
 * BANKTRANSFER: 2000.00
 * Total: 3525.00
 */

// Base class demonstrating inheritance and polymorphism
abstract class PaymentMethod {
    private final String type;

    public PaymentMethod(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    // Abstract method to be overridden by subclasses
    public abstract double calculateAdjustedAmount(double amount);
}

class CardPayment extends PaymentMethod {
    private static final double FEE_RATE = 0.02; // 2% fee

    public CardPayment() {
        super("CARD");
    }

    @Override
    public double calculateAdjustedAmount(double amount) {
        return amount + (amount * FEE_RATE);
    }
}

class WalletPayment extends PaymentMethod {
    private static final double FEE_RATE = 0.01; // 1% fee

    public WalletPayment() {
        super("WALLET");
    }

    @Override
    public double calculateAdjustedAmount(double amount) {
        return amount + (amount * FEE_RATE);
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment() {
        super("BANKTRANSFER");
    }

    @Override
    public double calculateAdjustedAmount(double amount) {
        return amount; // 0% fee
    }
}

class Transaction {
    private final PaymentMethod paymentMethod;
    private final double rawAmount;
    private final double adjustedAmount;

    public Transaction(PaymentMethod paymentMethod, double rawAmount) {
        this.paymentMethod = paymentMethod;
        this.rawAmount = rawAmount;
        this.adjustedAmount = paymentMethod.calculateAdjustedAmount(rawAmount);
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public double getRawAmount() {
        return rawAmount;
    }

    public double getAdjustedAmount() {
        return adjustedAmount;
    }

    public void display() {
        System.out.printf("%s: %.2f%n", paymentMethod.getType(), adjustedAmount);
    }
}

public class Question1_PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Payment System Fee Calculation ===");

        // If input is provided via standard input, parse dynamically; otherwise run sample test
        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            // Running Sample Test Case
            String sampleInput = "3\nCARD 1000\nWALLET 500\nBANKTRANSFER 2000";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Transaction> transactions = new ArrayList<>();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            double amount = scanner.nextDouble();

            PaymentMethod method;
            if (type.equalsIgnoreCase("CARD")) {
                method = new CardPayment();
            } else if (type.equalsIgnoreCase("WALLET")) {
                method = new WalletPayment();
            } else if (type.equalsIgnoreCase("BANKTRANSFER")) {
                method = new BankTransferPayment();
            } else {
                throw new IllegalArgumentException("Unknown payment type: " + type);
            }

            Transaction tx = new Transaction(method, amount);
            transactions.add(tx);
            grandTotal += tx.getAdjustedAmount();
        }

        for (Transaction tx : transactions) {
            tx.display();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
