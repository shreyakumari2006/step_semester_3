/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Day 2 Live-Coding Session — 5 Problems
 * 
 * Question 2: CSV Student Record Parser
 * 
 * Scenario:
 * The T&P team receives student registration data as CSV lines and needs a quick parser
 * to split each line into fields and print a formatted record.
 * 
 * Task:
 * - Accept a CSV line in the form "Name,RollNumber,Department".
 * - Use split(",") to break it into fields.
 * - Validate that exactly 3 fields are present; if not, print "Invalid Record".
 * - Print a formatted record: "Name: ... | Roll No: ... | Dept: ...".
 * 
 * Suggested method signature(s):
 * void parseStudentRecord(String csvLine)
 * 
 * Sample Input / Output:
 * Input: "Ananya Verma,RA2211003010123,CSE"
 * Output: Name: Ananya Verma | Roll No: RA2211003010123 | Dept: CSE
 * 
 * Input: "Ananya Verma,CSE"
 * Output: Invalid Record
 * 
 * Concepts covered:
 * split(), array length validation, string concatenation, formatted output.
 */
public class Question2_CsvStudentRecordParser {

    /**
     * Parses a CSV student record line and prints the formatted record.
     * If the line does not contain exactly 3 fields, prints "Invalid Record".
     * 
     * @param csvLine A CSV line in the format "Name,RollNumber,Department".
     */
    public static void parseStudentRecord(String csvLine) {
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

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        if (name.isEmpty() || rollNumber.isEmpty() || department.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Print formatted record
        System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
    }

    public static void main(String[] args) {
        System.out.println("=== Day 2 - Problem 2: CSV Student Record Parser ===");

        // Sample Test Case 1: Valid record
        String input1 = "Ananya Verma,RA2211003010123,CSE";
        System.out.println("\nSample Input 1: \"" + input1 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(input1);

        // Sample Test Case 2: Invalid record (only 2 fields)
        String input2 = "Ananya Verma,CSE";
        System.out.println("\nSample Input 2: \"" + input2 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(input2);

        // Additional Test Case 1: Extra fields
        String input3 = "Rahul Sharma,RA2211003010456,ECE,4th Year";
        System.out.println("\nTest Case 3: \"" + input3 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(input3);

        // Additional Test Case 2: Another valid record
        String input4 = "Priya Nair,RA2211003010789,IT";
        System.out.println("\nTest Case 4: \"" + input4 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(input4);
    }
}
