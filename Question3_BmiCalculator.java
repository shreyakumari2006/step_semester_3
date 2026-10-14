import java.util.Random;

/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Day 1 Live-Coding Session — 5 Problems
 * 
 * Question 3: BMI Calculator for a Team
 * 
 * Scenario:
 * The Corporate Wellness Program
 * An organization's HR wellness team is running a health check-up camp for a department
 * of employees. For each employee, height (in meters) and weight (in kg) are recorded,
 * and the system must calculate BMI and classify their health status, then present
 * all details in a clean table for the wellness report.
 * 
 * Task:
 * - Take height (m) and weight (kg) for a team of people (suggested: 10; use arrays,
 *   and random values for a fast live demo).
 * - Compute BMI = weight / (height * height).
 * - Classify status:
 *   - BMI < 18.5 -> Underweight
 *   - 18.5–24.9 -> Normal
 *   - 25–29.9 -> Overweight
 *   - >= 30 -> Obese
 * - Display a table: Person | Height (m) | Weight (kg) | BMI | Status.
 * 
 * Suggested method signature(s):
 * String getBmiStatus(double bmi) +
 * void printWellnessReport(double[] heights, double[] weights)
 * 
 * Sample Input / Output:
 * Person 1 — Height: 1.75 m, Weight: 70 kg -> BMI: 22.86 | Status: Normal
 * Person 2 — Height: 1.60 m, Weight: 90 kg -> BMI: 35.16 | Status: Obese
 * 
 * Concepts covered:
 * Parallel/2D arrays, arithmetic operations, conditional logic, formatted tabular output.
 */
public class Question3_BmiCalculator {

    /**
     * Classifies health status based on BMI.
     * 
     * @param bmi The Body Mass Index value.
     * @return Status string: "Underweight", "Normal", "Overweight", or "Obese".
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Calculates BMI for each team member and prints a clean formatted wellness report table.
     * 
     * @param heights Array of heights in meters.
     * @param weights Array of weights in kilograms.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid data: heights and weights arrays must be non-null and equal length.");
            return;
        }

        System.out.printf("%-10s | %-10s | %-11s | %-6s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = (h > 0) ? (w / (h * h)) : 0.0;
            String status = getBmiStatus(bmi);

            System.out.printf("%-10s | %-10.2f | %-11.2f | %-6.2f | %-12s%n",
                    "Person " + (i + 1), h, w, bmi, status);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Day 1 - Problem 3: BMI Calculator for a Team ===");

        // Sample Test Case Demo (matching prompt sample inputs)
        System.out.println("\n--- Sample Team Test Case ---");
        double[] sampleHeights = {1.75, 1.60, 1.80, 1.68};
        double[] sampleWeights = {70.0, 90.0, 55.0, 78.0};
        printWellnessReport(sampleHeights, sampleWeights);

        // 10-person Department Live Demo
        System.out.println("\n--- Corporate Wellness 10-Person Team Report ---");
        Random random = new Random(101);
        double[] teamHeights = new double[10];
        double[] teamWeights = new double[10];

        for (int i = 0; i < 10; i++) {
            // Generate heights between 1.50m and 1.90m
            teamHeights[i] = 1.50 + (random.nextDouble() * 0.40);
            // Generate weights between 45kg and 100kg
            teamWeights[i] = 45.0 + (random.nextDouble() * 55.0);
        }

        printWellnessReport(teamHeights, teamWeights);
    }
}
