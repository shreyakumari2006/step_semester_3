/**
 * Question 5: The Movie Review Word Length Profiler
 */
public class Question5_MovieReviewWordLengthProfiler {
    public static void classifyWordLengths(String review) {
        // Validation: Check for null or empty review
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Invalid Input: Review text cannot be null or empty.");
            return;
        }

        // Split review into individual words by whitespace
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("=== Question 5: Movie Review Word Length Profiler ===");

        // Test Case 1: Sample from assignment
        String review1 = "This movie was absolutely fantastic and thrilling";
        System.out.println("\nTest Case 1 Input: \"" + review1 + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review1);

        // Test Case 2: Another test review
        String review2 = "A masterpiece with breathtaking visuals and unforgettable storytelling";
        System.out.println("\nTest Case 2 Input: \"" + review2 + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review2);
    }
}
