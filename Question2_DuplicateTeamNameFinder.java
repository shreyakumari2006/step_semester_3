import java.util.Arrays;

/**
 * Problem 2: Duplicate Team Name Finder
 * 
 * Problem Statement:
 * Hackathon registration is chaotic, and the organizers suspect the same team accidentally
 * submitted their name twice under two different form entries. Write a method that scans the
 * list of registered team names and reports the first duplicate it finds.
 * 
 * Requirements:
 * - Compare every name against every other name using plain nested loops — no Collections class of any kind.
 * - Report the first duplicate found, scanning in order; if none exist, say so clearly.
 * 
 * Function Signature(s):
 * static String findDuplicateTeam(String[] teamNames)
 * 
 * Examples:
 * Input: {"ByteForce", "CodeCrafters", "ByteForce"}
 * Output: "Duplicate Found: ByteForce"
 * 
 * Input: {"ByteForce", "CodeCrafters", "NullPointers"}
 * Output: "No Duplicates Found"
 * 
 * Constraints:
 * Up to 100 team names. Comparison is case-sensitive.
 */

public class Question2_DuplicateTeamNameFinder {

    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length == 0) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            if (teamNames[i] == null) continue;
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Duplicate Team Name Finder ===");

        String[] test1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println("Input: " + Arrays.toString(test1));
        System.out.println("Output: " + findDuplicateTeam(test1));

        String[] test2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println("\nInput: " + Arrays.toString(test2));
        System.out.println("Output: " + findDuplicateTeam(test2));
    }
}
