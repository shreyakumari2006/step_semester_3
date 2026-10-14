/**
 * Question 4: The Warehouse Inventory Balancer
 */
public class Question4_WarehouseInventoryBalancer {

    /**
     * Analyzes inventory quantities of two warehouse sections, computes totals, checks balance status,
     * and identifies the highest-quantity item across both sections.
     * 
     * @param sectionA Array of item quantities in Section A.
     * @param sectionB Array of item quantities in Section B.
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        // Validation: Check for null inputs
        if (sectionA == null || sectionB == null) {
            System.out.println("Invalid Input: Section arrays cannot be null.");
            return;
        }

        // Validation: Check for empty arrays
        if (sectionA.length == 0 || sectionB.length == 0) {
            System.out.println("Invalid Input: Section arrays cannot be empty.");
            return;
        }

        // Validation: Check for equal length
        if (sectionA.length != sectionB.length) {
            System.out.println("Invalid Input: Section A and Section B must have equal length.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestItemIndex = -1; // 1-based index

        // Calculate total for Section A and find highest quantity
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemIndex = i + 1;
            }
        }

        // Calculate total for Section B and update highest quantity if strictly greater
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemIndex = i + 1;
            }
        }

        // Determine balance status
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQuantity, highestSection, highestItemIndex);
    }

    public static void main(String[] args) {
        System.out.println("=== Question 4: Warehouse Inventory Balancer ===");

        // Test Case 1: Balanced with tie on max item (Section A Item 3)
        int[] sectionA1 = {20, 15, 30};
        int[] sectionB1 = {25, 10, 30};
        System.out.println("\nTest Case 1 Input: sectionA={20,15,30}, sectionB={25,10,30}");
        System.out.print("Output: ");
        analyzeInventory(sectionA1, sectionB1);

        // Test Case 2: Not Balanced with highest item in Section B
        int[] sectionA2 = {10, 20, 15};
        int[] sectionB2 = {30, 25, 5};
        System.out.println("\nTest Case 2 Input: sectionA={10,20,15}, sectionB={30,25,5}");
        System.out.print("Output: ");
        analyzeInventory(sectionA2, sectionB2);
    }
}
