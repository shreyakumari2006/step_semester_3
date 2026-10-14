/**
 * Question 3: The Traffic Signal Streak Analyzer
 */
public class Question3_TrafficSignalStreakAnalyzer {

    /**
     * Scans through the signal log string and finds the longest continuous streak of the same signal.
     * 
     * @param signalLog Sequence of signal readings (e.g., "RRGGGYRR").
     */
    public static void findLongestStreak(String signalLog) {
        // Validation: Check for null or empty string
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Invalid Input: Signal log cannot be null or empty.");
            return;
        }

        char maxChar = signalLog.charAt(0);
        int maxStreak = 1;

        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;

        // Traverse through the log and track consecutive identical character streaks
        for (int i = 1; i < signalLog.length(); i++) {
            char ch = signalLog.charAt(i);

            if (ch == currentChar) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxChar = currentChar;
                }
                currentChar = ch;
                currentStreak = 1;
            }
        }

        // Check the final streak after loop ends
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxChar = currentChar;
        }

        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        System.out.println("=== Question 3: Traffic Signal Streak Analyzer ===");

        // Test Case 1
        String log1 = "RRGGGYRR";
        System.out.println("\nTest Case 1 Input: \"" + log1 + "\"");
        System.out.print("Output: ");
        findLongestStreak(log1);

        // Test Case 2
        String log2 = "RRRRYYGG";
        System.out.println("\nTest Case 2 Input: \"" + log2 + "\"");
        System.out.print("Output: ");
        findLongestStreak(log2);

        // Test Case 3: Single character streak
        String log3 = "RGBYRGB";
        System.out.println("\nTest Case 3 Input: \"" + log3 + "\"");
        System.out.print("Output: ");
        findLongestStreak(log3);
    }
}
