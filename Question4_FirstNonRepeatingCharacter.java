/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Day 1 Live-Coding Session — 5 Problems
 * 
 * Question 4: First Non-Repeating Character
 * 
 * Scenario:
 * The Unique Letter Hunt Mini-Game
 * A code-learning platform runs a light-hearted "Unique Letter Hunt" mini-game between
 * exercises: a player types any word or sentence, and the app must instantly find and
 * highlight the first character that appears only once in the entire input — a fun,
 * quick way to reinforce character-frequency thinking between coding drills.
 * 
 * Task:
 * - Accept an input string (a word or short sentence).
 * - Compute the frequency of every character in the string.
 * - Scan the string left to right and find the first character whose frequency is exactly 1.
 * - Print that character, or a clear message if no non-repeating character exists.
 * 
 * Suggested method signature(s):
 * char findFirstNonRepeatingChar(String text)
 * 
 * Sample Input / Output:
 * Input: "swiss" -> Output: First Non-Repeating Character: 'w'
 * Input: "aabbcc" -> Output: No Non-Repeating Character Found
 * 
 * Concepts covered:
 * Character frequency counting, loops, HashMap/array-based counting, early-exit scanning.
 */
public class Question4_FirstNonRepeatingCharacter {

    /**
     * Finds the first character in the given text that appears only once.
     * Returns '\0' if no non-repeating character exists.
     * 
     * @param text The input text to search.
     * @return The first non-repeating character, or '\0' if none found.
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Frequency table for ASCII characters
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) {
                freq[ch]++;
            }
        }

        // Scan from left to right to find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && freq[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    /**
     * Helper method to call findFirstNonRepeatingChar and print formatted output.
     * 
     * @param text The input text.
     */
    public static void displayFirstNonRepeatingChar(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Day 1 - Problem 4: First Non-Repeating Character ===");

        // Sample Test Case 1: "swiss" (w is first non-repeating)
        String input1 = "swiss";
        System.out.println("\nSample Input 1: \"" + input1 + "\"");
        System.out.print("Output: ");
        displayFirstNonRepeatingChar(input1);

        // Sample Test Case 2: "aabbcc" (no non-repeating characters)
        String input2 = "aabbcc";
        System.out.println("\nSample Input 2: \"" + input2 + "\"");
        System.out.print("Output: ");
        displayFirstNonRepeatingChar(input2);

        // Additional Test Case 1: "stress" (t is first non-repeating)
        String input3 = "stress";
        System.out.println("\nTest Case 3: \"" + input3 + "\"");
        System.out.print("Output: ");
        displayFirstNonRepeatingChar(input3);

        // Additional Test Case 2: Sentence with unique letter
        String input4 = "coding arcade";
        System.out.println("\nTest Case 4: \"" + input4 + "\"");
        System.out.print("Output: ");
        displayFirstNonRepeatingChar(input4);
    }
}
