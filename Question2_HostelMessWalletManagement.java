/**
 * Problem M2 (Practice): Hostel Mess Wallet Management
 * 
 * Scenario:
 * A hostel mess-card top-up wallet must never be allowed to go negative,
 * and its balance must never be overwritten directly from outside the class.
 * 
 * Task:
 * - Define a class MessWallet with a private double balance field.
 * - Write a public constructor that accepts an opening balance; if a negative value is given,
 *   start at 0 instead and print a warning.
 * - Write a public method topUp(double amount) that rejects amount <= 0 with a message,
 *   otherwise adds it to the balance.
 * - Write a public method deduct(double amount) that rejects any amount greater than the current balance,
 *   printing a clear message instead of allowing balance to go negative.
 * - Write a public getBalance() method for read-only access. There must be no public way to set balance
 *   directly from outside the class.
 */

class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Initialized to 0.0");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Top-up amount must be greater than 0.");
            return;
        }
        this.balance += amount;
        System.out.println("Balance after top-up: " + this.balance);
    }

    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Deduction amount must be greater than 0.");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }
}

public class Question2_HostelMessWalletManagement {
    public static void main(String[] args) {
        // Sample Test Case
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
