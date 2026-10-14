import java.util.Arrays;

/**
 * Question 2: Best Time to Buy and Sell Stock (Problem 12 - Category C)
 * 
 * Scenario:
 * A crypto investor wants to know the single best day to buy and best day to sell to make
 * the largest possible profit, found in one single pass through prices from left to right.
 * 
 * Concepts covered:
 * Single-pass linear traversal, tracking running minimum and running maximum, algorithm optimization.
 */
public class Question2_BestTimeToBuyAndSellStock {

    /**
     * Calculates the maximum profit that can be achieved by buying on one day and selling on a later day.
     * 
     * @param prices Array of daily stock/asset prices.
     * @return Maximum profit possible, or 0 if no profit can be made.
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        // Walk through the array once
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profitToday = prices[i] - minPrice;
                if (profitToday > maxProfit) {
                    maxProfit = profitToday;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("=== Question 2: Best Time to Buy and Sell Stock ===");

        // Test Case 1: Profitable
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("\nTest Case 1 Input: " + Arrays.toString(prices1));
        System.out.println("Output: " + maxProfit(prices1));

        // Test Case 2: Strictly decreasing prices
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("\nTest Case 2 Input: " + Arrays.toString(prices2));
        System.out.println("Output: " + maxProfit(prices2));
    }
}
