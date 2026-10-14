/**
 * Problem 2: The Quiz Scorecard
 * 
 * Scenario:
 * A quiz app records whether each answer you gave was right or wrong.
 * 
 * Problem Statement:
 * Design a Scorecard class that stores each answer's result privately, and reveals only
 * the final score — never the raw list of right/wrong answers.
 * 
 * Requirements:
 * - Store the results (true for correct, false for incorrect) in a private array, filled in one answer at a time.
 * - Provide a method to record the next answer's result.
 * - Expose only the total score (count of correct answers) — never the array itself, in any form.
 * - The total number of questions must be fixed when the scorecard is created.
 * 
 * Expected Behavior:
 * - Recording correct, correct, wrong, correct gives a score of 3.
 * - There's no getter that returns the array of results, directly or indirectly.
 * - Trying to record more answers than the fixed question count should be ignored or rejected.
 * 
 * Sample Input/Output:
 * Scorecard sc = new Scorecard(4);
 * sc.recordAnswer(true); sc.recordAnswer(true); sc.recordAnswer(false); sc.recordAnswer(true);
 * sc.getScore() -> 3
 */

class Scorecard {
    private final boolean[] results;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        if (totalQuestions <= 0) {
            throw new IllegalArgumentException("Total questions must be greater than 0.");
        }
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (this.recordedCount >= this.results.length) {
            System.out.println("Warning: Cannot record more answers. All " + this.results.length + " questions have already been answered.");
            return;
        }
        this.results[this.recordedCount] = isCorrect;
        this.recordedCount++;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < this.recordedCount; i++) {
            if (this.results[i]) {
                score++;
            }
        }
        return score;
    }

    public int getTotalQuestions() {
        return this.results.length;
    }

    public int getRecordedCount() {
        return this.recordedCount;
    }
}

public class Question2_TheQuizScorecard {
    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Quiz Scorecard ===");
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Total Questions: " + sc.getTotalQuestions());
        System.out.println("Answers Recorded: " + sc.getRecordedCount());
        System.out.println("Final Score: " + sc.getScore());

        // Attempting to record beyond capacity
        sc.recordAnswer(true);
    }
}
