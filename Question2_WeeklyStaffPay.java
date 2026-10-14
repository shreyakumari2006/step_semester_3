import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 2: Weekly Staff Pay
 * 
 * Task:
 * A small company pays three kinds of staff every week: full-time staff receive a fixed weekly salary,
 * hourly staff are paid by the hour with overtime, and interns receive a fixed stipend. Every staff member
 * has a name, and the payroll screen must list each person's pay and the total.
 * 
 * A generic "staff member" with no pay rule must never be created.
 * 
 * Input / Output:
 * Input: The first line contains N. Each of the next N lines is one of:
 * - FULLTIME Name weeklySalary
 * - HOURLY Name hours rate
 * - INTERN Name stipend
 * 
 * Output: For each person, print Name: pay. Finally, print Total Payroll: total, formatted to two decimal places.
 * 
 * Business Rules:
 * - Full-time staff are paid their fixed weekly salary.
 * - Hourly staff are paid rate for the first 40 hours and 1.5 * rate for every hour above 40.
 * - Interns are paid their fixed stipend.
 * 
 * Sample Input:
 * 3
 * FULLTIME Asha 12000
 * HOURLY Ravi 45 200
 * INTERN Neha 5000
 * 
 * Expected Output:
 * Asha: 12000.00
 * Ravi: 9500.00
 * Neha: 5000.00
 * Total Payroll: 26500.00
 */

// Abstract base class preventing direct instantiation of a generic staff member
abstract class StaffMember {
    private final String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method forcing each subclass to define its own pay calculation rule
    public abstract double calculatePay();

    public void display() {
        System.out.printf("%s: %.2f%n", name, calculatePay());
    }
}

class FullTimeStaff extends StaffMember {
    private final double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private static final double STANDARD_HOURS = 40.0;
    private static final double OVERTIME_MULTIPLIER = 1.5;

    private final double hoursWorked;
    private final double hourlyRate;

    public HourlyStaff(String name, double hoursWorked, double hourlyRate) {
        super(name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public double calculatePay() {
        if (hoursWorked <= STANDARD_HOURS) {
            return hoursWorked * hourlyRate;
        } else {
            double regularPay = STANDARD_HOURS * hourlyRate;
            double overtimeHours = hoursWorked - STANDARD_HOURS;
            double overtimePay = overtimeHours * (hourlyRate * OVERTIME_MULTIPLIER);
            return regularPay + overtimePay;
        }
    }
}

class InternStaff extends StaffMember {
    private final double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    public double getStipend() {
        return stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class Question2_WeeklyStaffPay {
    public static void main(String[] args) {
        System.out.println("=== Problem 2: Weekly Staff Pay ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "FULLTIME Asha 12000\n"
                    + "HOURLY Ravi 45 200\n"
                    + "INTERN Neha 5000";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<StaffMember> staffList = new ArrayList<>();
        double totalPayroll = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            String name = scanner.next();

            StaffMember staff;
            if (type.equalsIgnoreCase("FULLTIME")) {
                double salary = scanner.nextDouble();
                staff = new FullTimeStaff(name, salary);
            } else if (type.equalsIgnoreCase("HOURLY")) {
                double hours = scanner.nextDouble();
                double rate = scanner.nextDouble();
                staff = new HourlyStaff(name, hours, rate);
            } else if (type.equalsIgnoreCase("INTERN")) {
                double stipend = scanner.nextDouble();
                staff = new InternStaff(name, stipend);
            } else {
                throw new IllegalArgumentException("Unknown staff type: " + type);
            }

            staffList.add(staff);
            totalPayroll += staff.calculatePay();
        }

        for (StaffMember member : staffList) {
            member.display();
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
    }
}
