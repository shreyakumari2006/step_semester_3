/**
 * Question 3: Product Inventory CSV Parser
 * 
 * Scenario:
 * The warehouse manager receives inventory updates as CSV lines and needs a quick parser
 * to split each line into fields and print a formatted record.
 * 
 * Concepts covered:
 * split(), array length validation, string concatenation, formatted output.
 */
public class Question3_ProductInventoryCsvParser {

    /**
     * Parses a CSV inventory record line and prints formatted output.
     * 
     * @param csvLine A CSV line in the form "ProductName,Price,Quantity".
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Split CSV line by comma
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String price = fields[1].trim();
        String quantity = fields[2].trim();

        // Print formatted record
        System.out.println("Product: " + productName + " | Price: $" + price + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        System.out.println("=== Question 3: Product Inventory CSV Parser ===");

        // Test Case 1: Valid CSV line
        String csv1 = "Wireless Mouse,25,150";
        System.out.println("\nTest Case 1 Input: \"" + csv1 + "\"");
        System.out.print("Output: ");
        parseInventoryRecord(csv1);

        // Test Case 2: Invalid CSV line (insufficient fields)
        String csv2 = "Wireless Mouse,USD";
        System.out.println("\nTest Case 2 Input: \"" + csv2 + "\"");
        System.out.print("Output: ");
        parseInventoryRecord(csv2);

        // Test Case 3: Another valid item
        String csv3 = "Mechanical Keyboard,75,40";
        System.out.println("\nTest Case 3 Input: \"" + csv3 + "\"");
        System.out.print("Output: ");
        parseInventoryRecord(csv3);
    }
}
