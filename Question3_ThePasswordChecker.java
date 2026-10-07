/**
 * Problem 3: The Password Checker
 * 
 * Scenario:
 * A signup form checks how strong your chosen password is.
 * 
 * Problem Statement:
 * Design a PasswordChecker class that accepts a password once and reveals only its strength
 * rating — never the password itself.
 * 
 * Requirements:
 * - Take the password as a string in the constructor and store it privately, with no getter that returns it.
 * - Provide a method that returns a strength label — for example "Weak" (under 6 characters),
 *   "Medium" (6-9 characters), or "Strong" (10+ characters).
 * - The password itself must never be changeable after the object is created.
 * - Use the String length (and any other simple check you like) to decide the rating.
 * 
 * Expected Behavior:
 * - A 4-character password rates "Weak".
 * - An 8-character password rates "Medium".
 * - A 12-character password rates "Strong".
 * - There is no method anywhere that returns the actual password text.
 * 
 * Sample Input/Output:
 * PasswordChecker pc = new PasswordChecker("abcd");
 * pc.getStrength() -> "Weak"
 * PasswordChecker pc2 = new PasswordChecker("abcdefghij");
 * pc2.getStrength() -> "Strong"
 */

class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }
        this.password = password;
    }

    public String getStrength() {
        int length = this.password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class Question3_ThePasswordChecker {
    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Password Checker ===");

        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("pc1.getStrength() -> " + pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("pc2.getStrength() -> " + pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("pc3.getStrength() -> " + pc3.getStrength());

        PasswordChecker pc4 = new PasswordChecker("StrongPass123!");
        System.out.println("pc4.getStrength() -> " + pc4.getStrength());
    }
}
