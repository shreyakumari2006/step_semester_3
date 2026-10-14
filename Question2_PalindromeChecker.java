/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Day 1 Live-Coding Session — 5 Problems
 * 
 * Question 2: Palindrome Checker (3 Approaches)
 * 
 * Scenario:
 * The QA Text Verification Toolkit
 * The QA team on a coding assessment platform is building a small internal toolkit
 * to sanity-check palindrome-detection logic before it ships to students as a graded
 * exercise. To make sure the logic is solid regardless of implementation style, the
 * toolkit must verify a given text using three independent approaches — iterative
 * comparison, recursion, and array reversal — and confirm all three agree on the result.
 * 
 * Task:
 * - Accept a text input (e.g., a word or short phrase).
 * - Implement an iterative check: compare characters from both ends moving toward the middle.
 * - Implement a recursive check: recursively compare the first and last characters,
 *   shrinking the substring each call.
 * - Implement an array-reversal check: convert the string to a character array, reverse it,
 *   and compare it to the original.
 * - Print the result of all three approaches for the same input — they should always agree.
 * 
 * Suggested method signature(s):
 * boolean isPalindromeIterative(String text) +
 * boolean isPalindromeRecursive(String text) +
 * boolean isPalindromeArrayReversal(String text)
 * 
 * Sample Input / Output:
 * Input: "madam"
 * Output: Iterative: Palindrome | Recursive: Palindrome | Array Reversal: Palindrome
 * 
 * Input: "hello"
 * Output: Iterative: Not Palindrome | Recursive: Not Palindrome | Array Reversal: Not Palindrome
 * 
 * Concepts covered:
 * Loops, recursion, array manipulation, string comparison, comparing implementation trade-offs.
 */
public class Question2_PalindromeChecker {

    /**
     * Checks if a string is a palindrome using an iterative two-pointer approach.
     * 
     * @param text The input text to check.
     * @return true if palindrome, false otherwise.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            return false;
        }

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Checks if a string is a palindrome using recursion by shrinking the substring each call.
     * 
     * @param text The input text to check.
     * @return true if palindrome, false otherwise.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) {
            return false;
        }

        // Base cases: empty string or single character is always a palindrome
        if (text.length() <= 1) {
            return true;
        }

        // If outer characters do not match, not a palindrome
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        // Recursively check inner substring
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Checks if a string is a palindrome by converting to a character array, reversing it,
     * and comparing it to the original text.
     * 
     * @param text The input text to check.
     * @return true if palindrome, false otherwise.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) {
            return false;
        }

        char[] originalChars = text.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        for (int i = 0; i < originalChars.length; i++) {
            reversedChars[i] = originalChars[originalChars.length - 1 - i];
        }

        return new String(reversedChars).equals(text);
    }

    /**
     * Verifies text using all three approaches and prints formatted result.
     * 
     * @param text The text to evaluate.
     */
    public static void verifyPalindrome(String text) {
        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayReversalResult = isPalindromeArrayReversal(text);

        String iterStr = iterativeResult ? "Palindrome" : "Not Palindrome";
        String recStr = recursiveResult ? "Palindrome" : "Not Palindrome";
        String arrStr = arrayReversalResult ? "Palindrome" : "Not Palindrome";

        System.out.println("Iterative: " + iterStr + " | Recursive: " + recStr + " | Array Reversal: " + arrStr);
    }

    public static void main(String[] args) {
        System.out.println("=== Day 1 - Problem 2: Palindrome Checker (3 Approaches) ===");

        // Sample Test Case 1: Palindrome
        String input1 = "madam";
        System.out.println("\nSample Input 1: \"" + input1 + "\"");
        System.out.print("Output: ");
        verifyPalindrome(input1);

        // Sample Test Case 2: Not Palindrome
        String input2 = "hello";
        System.out.println("\nSample Input 2: \"" + input2 + "\"");
        System.out.print("Output: ");
        verifyPalindrome(input2);

        // Additional Test Case 1: Another Palindrome
        String input3 = "racecar";
        System.out.println("\nTest Case 3: \"" + input3 + "\"");
        System.out.print("Output: ");
        verifyPalindrome(input3);

        // Additional Test Case 2: Single character
        String input4 = "a";
        System.out.println("\nTest Case 4: \"" + input4 + "\"");
        System.out.print("Output: ");
        verifyPalindrome(input4);
    }
}
