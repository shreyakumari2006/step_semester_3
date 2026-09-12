/**
 * Problem M3 (Practice): Course Credit Management
 * 
 * Scenario:
 * Some courses come with a separate lab component and lab credit count; most don't.
 * Support both without writing the same setup logic twice.
 * 
 * Task:
 * - Define a class Course with fields code, title, credits, and labCredits.
 * - Write a constructor Course(String code, String title, int credits, int labCredits)
 *   that sets all four fields directly.
 * - Write a second constructor Course(String code, String title, int credits) for theory-only
 *   courses, which uses this(...) to chain to the four-argument constructor above with labCredits set to 0.
 * - Write a method totalCredits() returning credits + labCredits.
 * - Create one Course object with each constructor and print totalCredits() for both.
 */

class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    // Four-argument constructor for courses with lab component
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Three-argument constructor chaining via this(...) for theory-only courses
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return this.credits + this.labCredits;
    }
}

public class Question3_CourseCreditManagement {
    public static void main(String[] args) {
        // Theory-only course
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);

        // Course with lab component
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        // Print total credits for both
        System.out.println(theoryCourse.code + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.code + " total credits: " + labCourse.totalCredits());
    }
}
