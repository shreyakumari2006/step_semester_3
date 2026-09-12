/**
 * Problem M5 (Practice): Student and College Information Management
 * 
 * Scenario:
 * A club member's first draft of Student stores attendance, name, AND the college name
 * as instance fields — meaning every single student object ends up with its own copy of
 * "SRM Institute of Science and Technology" typed in separately. Fix the design.
 * 
 * Task:
 * - Define a class Student with instance fields name and attendance, and a static field
 *   collegeName shared by every student.
 * - Add a static field studentCount that increments once inside the constructor, every time.
 * - Write a static method printCollegeInfo() that prints collegeName and studentCount —
 *   and must not reference any instance field.
 * - Create two Student objects, then call printCollegeInfo() through the class name,
 *   not through either object.
 */

class Student {
    String name;
    double attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class Question5_StudentAndCollegeInformationManagement {
    public static void main(String[] args) {
        // Create two Student objects
        Student student1 = new Student("Aarav", 88.5);
        Student student2 = new Student("Diya", 92.0);

        // Call printCollegeInfo() through the class name
        Student.printCollegeInfo();
    }
}
