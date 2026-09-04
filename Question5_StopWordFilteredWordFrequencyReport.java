import java.util.*;

/**
 * Question 5: Stop-Word-Filtered Word Frequency Report
 * 
 * Scenario:
 * The T&P team needs word frequency analysis of feedback paragraphs, but common filler words
 * ("the", "was", "and", "a", "in") should be excluded so the report highlights meaningful
 * themes instead of function words.
 * 
 * Concepts covered:
 * toLowerCase(), punctuation removal, split(), stop-word filtering, Map/frequency counting, sorting.
 */
public class Question5_StopWordFilteredWordFrequencyReport {

    // Fixed list of common stop words to filter out
    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList("the", "was", "and", "a", "in"));

    /**
     * Cleans feedback text, filters out stop words, counts word frequencies,
     * and prints unique words sorted by frequency in descending order.
     * 
     * @param feedback Paragraph of feedback text.
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No words to analyze.");
            return;
        }

        // Normalize: convert to lowercase and remove punctuation
        String normalized = feedback.toLowerCase().replaceAll("[^a-z0-9\\s]", " ");

        // Split into words
        String[] words = normalized.trim().split("\\s+");

        // Count frequencies of non-stop-words
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();
        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Print word counts
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Question 5: Stop-Word-Filtered Word Frequency Report ===");

        // Test Case 1: Assignment sample
        String feedback1 = "The mentor was great, the session was great and clean";
        System.out.println("\nTest Case 1 Input: \"" + feedback1 + "\"");
        System.out.println("Output:");
        printFilteredWordFrequency(feedback1);

        // Test Case 2: Additional feedback example
        String feedback2 = "A coding session was practical and the explanation in class was clear and helpful";
        System.out.println("\nTest Case 2 Input: \"" + feedback2 + "\"");
        System.out.println("Output:");
        printFilteredWordFrequency(feedback2);
    }
}
