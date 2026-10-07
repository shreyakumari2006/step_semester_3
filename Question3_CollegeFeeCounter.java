import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 3: College Fee Counter
 * 
 * Task:
 * A college collects yearly fees from three kinds of students: day scholars, hostellers, and
 * scholarship students. Every student has a name and pays tuition, but the amount and the extra
 * charges differ. Day scholars and scholarship students use the college bus; hostellers live on
 * campus and do not.
 * The fee counter needs each student's total fee and the total collected.
 * 
 * Input / Output:
 * Input: The first line contains N. Each of the next N lines contains TYPE Name,
 * where TYPE is DAY_SCHOLAR, HOSTELLER, or SCHOLAR.
 * 
 * Output: For each student, print Name: fee. Finally, print Total Collected: total, formatted to two decimal places.
 * 
 * Business Rules:
 * - Day scholar: tuition 40000.
 * - Hosteller: tuition 40000 plus hostel fee 60000.
 * - Scholarship student: half of the normal tuition (20000).
 * - Every student who uses the college bus pays a transport fee of 12000.
 * 
 * Sample Input:
 * 3
 * DAY_SCHOLAR Asha
 * HOSTELLER Ravi
 * SCHOLAR Neha
 * 
 * Expected Output:
 * Asha: 52000.00
 * Ravi: 100000.00
 * Neha: 32000.00
 * Total Collected: 184000.00
 */

// Interface for students who use the college bus service
interface BusUser {
    double BUS_FEE = 12000.0;

    default double getBusTransportFee() {
        return BUS_FEE;
    }
}

// Abstract base class representing any college student
abstract class CollegeStudent {
    private final String name;

    public CollegeStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method to get base tuition fee
    public abstract double getBaseTuitionFee();

    // Additional specific fees (e.g. hostel fee)
    public double getAdditionalFees() {
        return 0.0;
    }

    // Calculates total fee including tuition, additional fees, and bus fees if applicable
    public double calculateTotalFee() {
        double total = getBaseTuitionFee() + getAdditionalFees();
        if (this instanceof BusUser) {
            total += ((BusUser) this).getBusTransportFee();
        }
        return total;
    }

    public void display() {
        System.out.printf("%s: %.2f%n", name, calculateTotalFee());
    }
}

class DayScholarStudent extends CollegeStudent implements BusUser {
    private static final double TUITION_FEE = 40000.0;

    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double getBaseTuitionFee() {
        return TUITION_FEE;
    }
}

class HostellerStudent extends CollegeStudent {
    private static final double TUITION_FEE = 40000.0;
    private static final double HOSTEL_FEE = 60000.0;

    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double getBaseTuitionFee() {
        return TUITION_FEE;
    }

    @Override
    public double getAdditionalFees() {
        return HOSTEL_FEE;
    }
}

class ScholarshipStudent extends CollegeStudent implements BusUser {
    private static final double SCHOLARSHIP_TUITION_FEE = 20000.0; // Half of 40000

    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double getBaseTuitionFee() {
        return SCHOLARSHIP_TUITION_FEE;
    }
}

public class Question3_CollegeFeeCounter {
    public static void main(String[] args) {
        System.out.println("=== Problem 3: College Fee Counter ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "DAY_SCHOLAR Asha\n"
                    + "HOSTELLER Ravi\n"
                    + "SCHOLAR Neha";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<CollegeStudent> students = new ArrayList<>();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            String name = scanner.next();

            CollegeStudent student;
            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                student = new DayScholarStudent(name);
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                student = new HostellerStudent(name);
            } else if (type.equalsIgnoreCase("SCHOLAR") || type.equalsIgnoreCase("SCHOLARSHIP")) {
                student = new ScholarshipStudent(name);
            } else {
                throw new IllegalArgumentException("Unknown student type: " + type);
            }

            students.add(student);
            totalCollected += student.calculateTotalFee();
        }

        for (CollegeStudent s : students) {
            s.display();
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }
}
