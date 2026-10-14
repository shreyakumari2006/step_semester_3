/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Day 2 Live-Coding Session — 5 Problems
 * 
 * Question 1: Vowel & Consonant Counter
 * 
 * Scenario:
 * A library orientation kiosk counts vowels and consonants in a submitted book title
 * for a simple text-stats display.
 * 
 * Task:
 * - Accept a string (assume only letters and spaces).
 * - Loop through each character using charAt().
 * - Count vowels (a, e, i, o, u — case-insensitive) and consonants separately; ignore spaces.
 * - Print the total vowels and total consonants.
 * 
 * Suggested method signature(s):
 * void countVowelsAndConsonants(String text)
 * 
 * Sample Input / Output:
 * Input: "Java Programming"
 * Output: Vowels: 5 | Consonants: 10
 * 
 * Concepts covered:
 * charAt(), length(), loops, case-insensitive character comparison.
 */
public class Question1_VowelAndConsonantCounter {

    /**
     * Counts vowels and consonants in the given text and prints the formatted totals.
     * Vowels (a, e, i, o, u) are counted case-insensitively.
     * Spaces are ignored.
     * 
     * @param text The input string (letters and spaces).
     */
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Ignore spaces
            if (ch == ' ') {
                continue;
            }

            char lower = Character.toLowerCase(ch);
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                vowels++;
            } else if (Character.isLetter(lower)) {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        System.out.println("=== Day 2 - Problem 1: Vowel & Consonant Counter ===");

        // Sample Test Case
        String input1 = "Java Programming";
        System.out.println("\nSample Input: \"" + input1 + "\"");
        System.out.print("Output: ");
        countVowelsAndConsonants(input1);

        // Additional Test Case 1: Uppercase & lowercase vowels
        String input2 = "CodinClub BridgeLabz";
        System.out.println("\nTest Case 2: \"" + input2 + "\"");
        System.out.print("Output: ");
        countVowelsAndConsonants(input2);

        // Additional Test Case 2: Only vowels
        String input3 = "A E I O U a e i o u";
        System.out.println("\nTest Case 3: \"" + input3 + "\"");
        System.out.print("Output: ");
        countVowelsAndConsonants(input3);

        // Additional Test Case 3: Only consonants
        String input4 = "rhythm fly pry";
        System.out.println("\nTest Case 4: \"" + input4 + "\"");
        System.out.print("Output: ");
        countVowelsAndConsonants(input4);
    }
}
