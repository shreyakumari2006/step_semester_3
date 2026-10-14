/**
 * Problem M3: Employee Profile Creation
 * 
 * Scenario:
 * Interns join without a fixed salary structure yet; permanent employees join with a known salary
 * from day one. Support both without writing the same setup logic twice.
 * 
 * Task:
 * - Define a class Employee with fields empId, empName, salary, and isIntern.
 * - Write a constructor Employee(String empId, String empName, double salary) for permanent employees,
 *   setting isIntern to false.
 * - Write a second constructor Employee(String empId, String empName) for interns, which uses this(...)
 *   to chain to the three-argument constructor above with salary set to 0, then sets isIntern to true afterwards.
 * - Write a method printProfile() that prints all four fields on one line.
 * - Create one Employee object with each constructor and call printProfile() on both.
 */

class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns chaining via this(...)
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class Question3_EmployeeProfileCreation {
    public static void main(String[] args) {
        // Create permanent employee
        Employee permanentEmp = new Employee("E-101", "Divya", 65000);

        // Create intern employee
        Employee internEmp = new Employee("E-102", "Arjun");

        // Print profiles
        permanentEmp.printProfile();
        internEmp.printProfile();
    }
}
