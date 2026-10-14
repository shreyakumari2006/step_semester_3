/**
 * Problem 1: The Piggy Bank
 * 
 * Scenario:
 * A savings app tracks how much money a kid has put away.
 * 
 * Problem Statement:
 * Create a PiggyBank class where money can only be added or removed through specific actions — never set directly to any amount.
 * 
 * Requirements:
 * - The savings amount must be private, changed only by deposit and withdraw methods.
 * - A withdrawal larger than the current savings must be rejected, not applied.
 * - Give the piggy bank a final ID that's fixed the moment it's created.
 * - Provide a way to check the current savings, but no way to set it directly.
 * 
 * Expected Behavior:
 * - A new piggy bank starts at 0 savings.
 * - Depositing adds exactly that amount.
 * - Withdrawing more than what's saved leaves the amount unchanged.
 * - There's no method anywhere that lets you set the savings to a specific number directly.
 * 
 * Sample Input/Output:
 * PiggyBank pb = new PiggyBank("PB-1");
 * pb.deposit(100) -> savings = 100
 * pb.withdraw(30) -> savings = 70
 * pb.withdraw(500) -> rejected, savings stays 70
 */

class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: Amount must be positive.");
            return;
        }
        this.savings += amount;
        System.out.println("Deposited: " + (amount == (long) amount ? String.format("%d", (long) amount) : amount) + " -> savings = " + getFormattedSavings());
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be positive.");
            return;
        }
        if (amount > this.savings) {
            System.out.println("Withdrawal rejected: Amount (" + (amount == (long) amount ? String.format("%d", (long) amount) : amount) + ") exceeds current savings (" + getFormattedSavings() + ").");
            return;
        }
        this.savings -= amount;
        System.out.println("Withdrew: " + (amount == (long) amount ? String.format("%d", (long) amount) : amount) + " -> savings = " + getFormattedSavings());
    }

    public double getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }

    private String getFormattedSavings() {
        if (this.savings == (long) this.savings) {
            return String.format("%d", (long) this.savings);
        }
        return String.valueOf(this.savings);
    }
}

public class Question1_ThePiggyBank {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Piggy Bank ===");
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("PiggyBank created with ID: " + pb.getId());
        System.out.println("Initial savings: " + pb.getSavings());

        // Test sample operations
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500); // Should be rejected

        System.out.println("Final savings: " + pb.getSavings());
    }
}
