/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Day 2 Live-Coding Session — 5 Problems
 * 
 * Question 4: Masked Phone Number Formatter
 * 
 * Scenario:
 * A student-support call center displays a partially masked version of a registered
 * phone number on-screen for privacy, while agents confirm identity using the last 4 digits.
 * 
 * Task:
 * - Accept a phone number as a string.
 * - Validate that it is exactly 10 digits (all numeric).
 * - Build a masked version showing "XXXXXX" followed by the last 4 digits, using StringBuilder.
 * - Insert a "-" between the mask and the last 4 digits for readability.
 * - Print the final masked number, or an error message if validation fails.
 * 
 * Suggested method signature(s):
 * String maskPhoneNumber(String phone)
 * 
 * Sample Input / Output:
 * Input: "9876543210"
 * Output: XXXXXX-3210
 * 
 * Input: "98765"
 * Output: Invalid phone number
 * 
 * Concepts covered:
 * String length/digit validation, substring(), StringBuilder.insert(), masking patterns.
 */
public class Question4_MaskedPhoneNumberFormatter {

    /**
     * Masks the phone number by replacing the first 6 digits with "XXXXXX",
     * followed by a hyphen and the last 4 digits.
     * 
     * @param phone The input phone number string.
     * @return Masked phone number string if valid, otherwise "Invalid phone number".
     */
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate all characters are digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Extract last 4 digits using substring()
        String lastFour = phone.substring(6);

        // Build masked string using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(lastFour);

        // Insert '-' between mask and last 4 digits
        sb.insert(6, "-");

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Day 2 - Problem 4: Masked Phone Number Formatter ===");

        // Sample Test Case 1: Valid 10-digit number
        String phone1 = "9876543210";
        System.out.println("\nSample Input 1: \"" + phone1 + "\"");
        System.out.println("Output: " + maskPhoneNumber(phone1));

        // Sample Test Case 2: Invalid length (5 digits)
        String phone2 = "98765";
        System.out.println("\nSample Input 2: \"" + phone2 + "\"");
        System.out.println("Output: " + maskPhoneNumber(phone2));

        // Additional Test Case 1: Non-numeric characters
        String phone3 = "98765abcde";
        System.out.println("\nTest Case 3: \"" + phone3 + "\"");
        System.out.println("Output: " + maskPhoneNumber(phone3));

        // Additional Test Case 2: 11-digit number
        String phone4 = "98765432109";
        System.out.println("\nTest Case 4: \"" + phone4 + "\"");
        System.out.println("Output: " + maskPhoneNumber(phone4));

        // Additional Test Case 3: Another valid number
        String phone5 = "9123456789";
        System.out.println("\nTest Case 5: \"" + phone5 + "\"");
        System.out.println("Output: " + maskPhoneNumber(phone5));
    }
}
