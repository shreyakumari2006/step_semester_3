/**
 * Problem M1 (Practice): Student Placement Record Management
 * 
 * Scenario:
 * The T&P cell currently tracks student placements using three parallel arrays —
 * names, companies, packages — and it has already gone out of sync twice this month.
 * Rebuild it the OOP way.
 * 
 * Task:
 * - Define a class PlacementRecord with fields String studentName, String company, and double packageLpa.
 * - Write a constructor that sets all three fields.
 * - Write an instance method printRecord() that prints one formatted line.
 * - Create three PlacementRecord objects for different students, store them in an array of PlacementRecord,
 *   and print each one in a loop.
 */

class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class Question1_StudentPlacementRecordManagement {
    public static void main(String[] args) {
        // Create three PlacementRecord objects
        PlacementRecord[] records = new PlacementRecord[] {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        // Print each record using a loop
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
