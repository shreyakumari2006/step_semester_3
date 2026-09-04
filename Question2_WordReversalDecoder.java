/**
 * Question 2: Word Reversal Decoder
 * 
 * Scenario:
 * The slang name "Hamverpod" secret game involves reversing every word in a sentence
 * individually while keeping the word order the same, as if words had themselves "read back".
 * 
 * Concepts covered:
 * split(), StringBuilder / reverse(), loops, string joining.
 */
public class Question2_WordReversalDecoder {

    /**
     * Reverses each word in the given sentence while preserving the word order.
     * 
     * @param sentence A sentence of words separated by spaces.
     * @return The sentence with each individual word reversed.
     */
    public static String reverseWordByWord(String sentence) {
        if (sentence == null) {
            return null;
        }

        if (sentence.isEmpty()) {
            return "";
        }

        // Split sentence into words separated by single space
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder(words[i]).reverse();
            result.append(reversedWord);

            // Add space between words
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Question 2: Word Reversal Decoder ===");

        // Test Case 1: Sample input
        String sentence1 = "hello world";
        String decoded1 = reverseWordByWord(sentence1);
        System.out.println("\nTest Case 1 Input: \"" + sentence1 + "\"");
        System.out.println("Output: \"" + decoded1 + "\"");

        // Test Case 2: Additional test
        String sentence2 = "Java is fun";
        String decoded2 = reverseWordByWord(sentence2);
        System.out.println("\nTest Case 2 Input: \"" + sentence2 + "\"");
        System.out.println("Output: \"" + decoded2 + "\"");
    }
}
