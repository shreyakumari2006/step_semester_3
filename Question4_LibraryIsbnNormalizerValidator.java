/**
 * Question 4: Library ISBN Normalizer & Validator
 * 
 * Scenario:
 * A library system's book-intake scanner reads in book barcodes and needs to normalize 13-character codes.
 * A valid code is exactly 13 characters: 3 letters (publisher code) + 4 digits (year) + 6 characters (catalog number).
 * Scanned codes sometimes have stray spaces or a mixed-case publisher code.
 * 
 * Concepts covered:
 * trim(), substring(), string concatenation, Character.isLetter()/isDigit(), StringBuilder, multi-stage validation.
 */
public class Question4_LibraryIsbnNormalizerValidator {

    /**
     * Normalizes raw code by trimming leading/trailing spaces and uppercasing the first 3 characters.
     * 
     * @param raw The raw barcode/ISBN input string.
     * @return Normalized string.
     */
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return null;
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Uppercase first 3 characters and leave the rest untouched
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates normalized code and returns formatted string or error message.
     * 
     * @param code The normalized code string.
     * @return Formatted display string if valid, otherwise error message.
     */
    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: length must be 13 characters";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate next 4 characters (index 3 to 6) are digits (year)
        for (int i = 3; i < 7; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: year must be 4 digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        // Build formatted display line using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(publisher).append("] ");
        sb.append("YEAR: ").append(year).append(" / CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Question 4: Library ISBN Normalizer & Validator ===");

        // Test Case 1: Valid input with stray spaces and lowercase publisher
        String raw1 = "  pre2020101-Q1  ";
        String normalized1 = normalizeCode(raw1);
        String result1 = validateAndFormat(normalized1);
        System.out.println("\nTest Case 1 Input: \"" + raw1 + "\"");
        System.out.println("Output: " + result1);

        // Test Case 2: Invalid publisher code (contains digits)
        String raw2 = "  12p2020101-Q1  ";
        String normalized2 = normalizeCode(raw2);
        String result2 = validateAndFormat(normalized2);
        System.out.println("\nTest Case 2 Input: \"" + raw2 + "\"");
        System.out.println("Output: " + result2);

        // Test Case 3: Invalid length
        String raw3 = "  pre2020  ";
        String normalized3 = normalizeCode(raw3);
        String result3 = validateAndFormat(normalized3);
        System.out.println("\nTest Case 3 Input: \"" + raw3 + "\"");
        System.out.println("Output: " + result3);
    }
}
