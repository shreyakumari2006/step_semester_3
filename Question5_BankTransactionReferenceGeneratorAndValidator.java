/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Day 2 Live-Coding Session — 5 Problems
 * 
 * Question 5: Bank Transaction Reference Generator & Validator
 * 
 * Scenario:
 * A fintech onboarding module for a placement-prep hackathon needs to both normalize
 * and validate transaction reference codes. A valid reference is exactly 14 characters:
 * 3 letters (bank code) + 6 digits (date, ddMMyy) + 5 digits (sequence number).
 * Users sometimes paste codes with stray spaces or a mixed-case bank code.
 * 
 * Task:
 * - Accept a raw reference string that may contain leading/trailing spaces.
 * - Normalize it: trim() the spaces, then uppercase only the first 3 characters using
 *   substring() + concatenation — leave the rest untouched.
 * - Validate: exactly 14 characters after normalization; the first 3 characters are letters;
 *   the remaining 11 are digits (use Character.isLetter() / isDigit() in a loop — no regex).
 * - If valid, build a formatted display line with StringBuilder:
 *   "[BANKCODE] DATE: dd/MM/yy | SEQ: 12345".
 * - If invalid, print the specific reason: wrong length, non-letter bank code, or non-digit body.
 * 
 * Suggested method signature(s):
 * String normalizeReference(String raw) + String validateAndFormat(String reference)
 * 
 * Sample Input / Output:
 * Input: "  hdf03022600042  "
 * Output: [HDF] DATE: 03/02/26 | SEQ: 00042
 * 
 * Input: "12F03022600042"
 * Output: Invalid: bank code must be 3 letters
 * 
 * Concepts covered:
 * trim(), substring(), string concatenation, Character.isLetter()/isDigit(),
 * StringBuilder, multi-stage validation.
 */
public class Question5_BankTransactionReferenceGeneratorAndValidator {

    /**
     * Normalizes a raw reference by trimming leading/trailing spaces and
     * uppercasing only the first 3 characters using substring() + concatenation.
     * 
     * @param raw The raw reference input string.
     * @return Normalized reference string.
     */
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return null;
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Uppercase only the first 3 characters, leave the rest untouched
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates a normalized reference and builds a formatted display string,
     * or returns a specific error message explaining why validation failed.
     * 
     * @param reference The normalized reference string.
     * @return Formatted display string if valid, otherwise specific invalid reason.
     */
    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters (no regex)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters are digits (no regex)
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract components
        String bankCode = reference.substring(0, 3);
        String dd = reference.substring(3, 5);
        String mm = reference.substring(5, 7);
        String yy = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        // Build formatted display line using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(dd).append("/").append(mm).append("/").append(yy)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    /**
     * Helper method to normalize, validate, and print the result.
     * 
     * @param raw The raw reference input string.
     */
    public static void processReference(String raw) {
        String normalized = normalizeReference(raw);
        String result = validateAndFormat(normalized);
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("=== Day 2 - Problem 5: Bank Transaction Reference Generator & Validator ===");

        // Sample Test Case 1: Raw reference with stray spaces and lowercase bank code
        String input1 = "  hdf03022600042  ";
        System.out.println("\nSample Input 1: \"" + input1 + "\"");
        System.out.print("Output: ");
        processReference(input1);

        // Sample Test Case 2: Non-letter bank code
        String input2 = "12F03022600042";
        System.out.println("\nSample Input 2: \"" + input2 + "\"");
        System.out.print("Output: ");
        processReference(input2);

        // Additional Test Case 1: Wrong length (too short)
        String input3 = "  hdf030226  ";
        System.out.println("\nTest Case 3: \"" + input3 + "\"");
        System.out.print("Output: ");
        processReference(input3);

        // Additional Test Case 2: Non-digit body
        String input4 = "ICIC0302260004";
        System.out.println("\nTest Case 4: \"" + input4 + "\"");
        System.out.print("Output: ");
        processReference(input4);

        // Additional Test Case 3: Another valid reference
        String input5 = "  sbi15082699999  ";
        System.out.println("\nTest Case 5: \"" + input5 + "\"");
        System.out.print("Output: ");
        processReference(input5);
    }
}
