/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Day 1 Live-Coding Session — 5 Problems
 * 
 * Question 5: Reverse Customer Name
 * 
 * Scenario:
 * The Customer Identity Verification System
 * You are developing a customer identity verification module for a banking application.
 * As part of an internal security exercise, the system generates a reversed version of a
 * customer's name to verify whether the application correctly processes character sequences
 * without modifying the original data. This feature is used only for testing and training
 * purposes. The system should accept a customer's name and display its reverse while
 * keeping the original name unchanged.
 * 
 * Task:
 * - Develop a method that reverses the given customer name.
 * - The method takes one input argument: customerName.
 * - It should return the name in reverse order.
 * - Call this method from main and print both the original and reversed names.
 * 
 * Suggested method signature(s):
 * String reverseCustomerName(String customerName)
 * 
 * Sample Input / Output:
 * Input: "Sunil"
 * Output:
 * Original Name: Sunil
 * Reversed Name: linuS
 * 
 * Concepts covered:
 * String traversal, character array manipulation, string reconstruction.
 */
public class Question5_ReverseCustomerName {

    /**
     * Reverses the given customer name while preserving the original string.
     * 
     * @param customerName The original customer name string.
     * @return The reversed customer name string.
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] original = customerName.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(reversed);
    }

    /**
     * Helper method to call reverseCustomerName and print both original and reversed names.
     * 
     * @param name The customer name to test.
     */
    public static void displayCustomerNameReversal(String name) {
        String reversed = reverseCustomerName(name);
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed);
    }

    public static void main(String[] args) {
        System.out.println("=== Day 1 - Problem 5: Reverse Customer Name ===");

        // Sample Test Case
        String sampleName = "Sunil";
        System.out.println("\nSample Test Case:");
        displayCustomerNameReversal(sampleName);

        // Additional Test Case 1: First and last name
        String name2 = "Ada Lovelace";
        System.out.println("\nTest Case 2:");
        displayCustomerNameReversal(name2);

        // Additional Test Case 2: Single name with mixed casing
        String name3 = "Alexander";
        System.out.println("\nTest Case 3:");
        displayCustomerNameReversal(name3);

        // Additional Test Case 3: Palindromic name
        String name4 = "Hannah";
        System.out.println("\nTest Case 4:");
        displayCustomerNameReversal(name4);
    }
}
