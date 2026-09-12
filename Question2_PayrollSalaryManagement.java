/**
 * Problem M2: Payroll Salary Management
 * 
 * Scenario:
 * A company's payroll account must never let its net salary be set directly from outside the class,
 * and bonuses must never be negative.
 * 
 * Task:
 * - Define a class PayrollAccount with a private double basicSalary and a private double bonus.
 * - Write a public constructor that accepts an opening basicSalary; if a negative value is given,
 *   start at 0 instead and print a warning.
 * - Write a public method creditBonus(double amount) that rejects amount <= 0 with a message,
 *   otherwise adds it to bonus.
 * - Write a public method deductTax(double percent) that reduces basicSalary by that percentage,
 *   rejecting any percent outside the 0-100 range with a message.
 * - Write a public getNetSalary() method that returns basicSalary + bonus for read-only access.
 *   There must be no public way to set basicSalary or bonus directly.
 */

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Initialized to 0.0");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0.0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Bonus amount must be greater than 0.");
            return;
        }
        this.bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Error: Tax percentage must be between 0 and 100.");
            return;
        }
        this.basicSalary -= this.basicSalary * (percent / 100.0);
        String formattedPercent = (percent == (long) percent) ? String.valueOf((long) percent) : String.valueOf(percent);
        System.out.println("Tax deducted: " + formattedPercent + "%");
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

public class Question2_PayrollSalaryManagement {
    public static void main(String[] args) {
        // Sample Test Case
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
