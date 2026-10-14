/**
 * Question 1: ATM PIN Length Validator
 * 
 * Scenario:
 * An ATM app must check that a PIN a customer enters is exactly 4 digits long before
 * allowing them to continue, using only the most basic checks.
 * 
 * Concepts covered:
 * length(), if/else, comparison operator — the smallest possible building blocks.
 */
public class Question1_AtmPinLengthValidator {

    /**
     * Checks whether the given PIN has a valid length of exactly 4 characters.
     * 
     * @param pin The PIN string entered by customer.
     */
    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length is valid.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Question 1: ATM PIN Length Validator ===");

        // Test Case 1: Less than 4 digits
        String pin1 = "123";
        System.out.println("\nTest Case 1 Input: \"" + pin1 + "\"");
        System.out.print("Output: ");
        checkPinLength(pin1);

        // Test Case 2: Exactly 4 digits
        String pin2 = "5678";
        System.out.println("\nTest Case 2 Input: \"" + pin2 + "\"");
        System.out.print("Output: ");
        checkPinLength(pin2);

        // Test Case 3: More than 4 digits
        String pin3 = "12345";
        System.out.println("\nTest Case 3 Input: \"" + pin3 + "\"");
        System.out.print("Output: ");
        checkPinLength(pin3);
    }
}
