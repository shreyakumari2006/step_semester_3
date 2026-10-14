import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Coding Assignment for Category C
 * Problem 4: The Festival Bonus Calculator
 * 
 * Task:
 * A company pays a festival bonus to its employees. Full-time employees, part-time employees,
 * and interns each receive the bonus in a different way. For every employee, calculate the bonus,
 * display it with the employee's name, and then display the total bonus paid.
 * 
 * Input:
 * The first line contains an integer N, the number of employees. Each of the next N lines contains
 * EmployeeType Name MonthlySalary:
 * - FULLTIME Name MonthlySalary
 * - PARTTIME Name MonthlySalary
 * - INTERN Name MonthlySalary
 * 
 * Output:
 * For each employee, display Name: Bonus, formatted to two decimal places.
 * Finally, display Total Bonus: GrandTotal, also formatted to two decimal places.
 * 
 * Business Rules:
 * - Full-time employees get 10% of their monthly salary.
 * - Part-time employees get 5% of their monthly salary.
 * - Interns get a fixed bonus of ₹2,000, whatever their salary.
 * 
 * Constraints:
 * - 1 <= N <= 1000
 * - Name is a single word
 * - 1000 <= MonthlySalary <= 500000
 * 
 * Sample Input:
 * 3
 * FULLTIME Asha 50000
 * PARTTIME Ravi 30000
 * INTERN Neha 15000
 * 
 * Expected Output:
 * Asha: 5000.00
 * Ravi: 1500.00
 * Neha: 2000.00
 * Total Bonus: 8500.00
 */

// Base class demonstrating inheritance and polymorphism
abstract class Employee {
    private final String name;
    private final double monthlySalary;
    private final String employeeType;

    public Employee(String name, double monthlySalary, String employeeType) {
        this.name = name;
        this.monthlySalary = monthlySalary;
        this.employeeType = employeeType;
    }

    public String getName() {
        return name;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    // Abstract method to calculate festival bonus polymorphically
    public abstract double calculateBonus();

    public void display() {
        System.out.printf("%s: %.2f%n", name, calculateBonus());
    }
}

class FullTimeEmployee extends Employee {
    private static final double BONUS_RATE = 0.10; // 10%

    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary, "FULLTIME");
    }

    @Override
    public double calculateBonus() {
        return getMonthlySalary() * BONUS_RATE;
    }
}

class PartTimeEmployee extends Employee {
    private static final double BONUS_RATE = 0.05; // 5%

    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary, "PARTTIME");
    }

    @Override
    public double calculateBonus() {
        return getMonthlySalary() * BONUS_RATE;
    }
}

class InternEmployee extends Employee {
    private static final double FIXED_BONUS = 2000.0; // ₹2,000 fixed

    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary, "INTERN");
    }

    @Override
    public double calculateBonus() {
        return FIXED_BONUS;
    }
}

public class Question4_TheFestivalBonusCalculator {
    public static void main(String[] args) {
        System.out.println("=== Problem 4: The Festival Bonus Calculator ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "FULLTIME Asha 50000\n"
                    + "PARTTIME Ravi 30000\n"
                    + "INTERN Neha 15000";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Employee> employees = new ArrayList<>();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();

            Employee employee;
            if (type.equalsIgnoreCase("FULLTIME")) {
                employee = new FullTimeEmployee(name, salary);
            } else if (type.equalsIgnoreCase("PARTTIME")) {
                employee = new PartTimeEmployee(name, salary);
            } else if (type.equalsIgnoreCase("INTERN")) {
                employee = new InternEmployee(name, salary);
            } else {
                throw new IllegalArgumentException("Unknown employee type: " + type);
            }

            employees.add(employee);
            grandTotal += employee.calculateBonus();
        }

        for (Employee emp : employees) {
            emp.display();
        }
        System.out.printf("Total Bonus: %.2f%n", grandTotal);
    }
}
