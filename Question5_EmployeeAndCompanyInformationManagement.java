/**
 * Problem M5: Employee and Company Information Management
 * 
 * Scenario:
 * A trainee developer's first draft of Employee stores empName, salary, AND the company name
 * as instance fields — meaning every single employee object ends up with its own copy of
 * "Bright Horizon Technologies" typed in separately. Fix the design.
 * 
 * Task:
 * - Define a class Employee with instance fields empName and salary, and a static field
 *   companyName shared by every employee.
 * - Add a static field employeeCount that increments once inside the constructor, every time.
 * - Write a static method printCompanyInfo() that prints companyName and employeeCount —
 *   and must not reference any instance field.
 * - Create three Employee objects, then call printCompanyInfo() through the class name,
 *   not through any object.
 */

class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class Question5_EmployeeAndCompanyInformationManagement {
    public static void main(String[] args) {
        // Create three Employee objects
        Employee emp1 = new Employee("Alice", 75000.0);
        Employee emp2 = new Employee("Bob", 60000.0);
        Employee emp3 = new Employee("Charlie", 85000.0);

        // Call printCompanyInfo() through the class name (not through any object instance)
        Employee.printCompanyInfo();
    }
}
