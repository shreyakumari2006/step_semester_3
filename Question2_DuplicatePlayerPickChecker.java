import java.util.Arrays;

/**
 * Problem 2: Duplicate Player Pick Checker
 * Category C Assignment Problems - Easy Tier
 * 
 * Topics Integrated:
 * Arrays, Strings, Nested Loops
 * 
 * Problem Statement:
 * A glitch in the fantasy app's draft screen occasionally lets a user tap the same player twice
 * before the UI catches up, silently adding them to the lineup twice. Write a method that checks
 * a submitted lineup for a repeated player name before it's accepted.
 * 
 * Requirements:
 * - Compare every name against every other name using plain nested loops — no Collections class of any kind.
 * - Report the first duplicate found, scanning in order; if none exist, say so clearly.
 */
public class Question2_DuplicatePlayerPickChecker {

    /**
     * Checks for repeated player names using plain nested loops.
     * 
     * @param playerNames Array of player names in the submitted lineup.
     * @return "Duplicate Found: <name>" if a duplicate exists, otherwise "No Duplicates Found".
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length == 0) {
            return "No Duplicates Found";
        }

        // Pairwise comparison using nested loops without any Collections class
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Duplicate Player Pick Checker ===");

        // Test Case 1: Contains duplicates
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("\nTest Case 1 Input: " + Arrays.toString(lineup1));
        System.out.println("Output: " + findDuplicatePick(lineup1));

        // Test Case 2: No duplicates
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("\nTest Case 2 Input: " + Arrays.toString(lineup2));
        System.out.println("Output: " + findDuplicatePick(lineup2));

        // Test Case 3: Another duplicate case
        String[] lineup3 = {"Dhoni", "Jadeja", "Ashwin", "Shami", "Jadeja"};
        System.out.println("\nTest Case 3 Input: " + Arrays.toString(lineup3));
        System.out.println("Output: " + findDuplicatePick(lineup3));
    }
}
