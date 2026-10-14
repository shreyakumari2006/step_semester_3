/**
 * Category C: Data Structure Practice
 * Part A — Coding Problems
 * Problem 8: Student Grade Assignment
 * 
 * Task:
 * Write a program that reads a student's marks (out of 100) and prints their corresponding grade
 * based on the following criteria:
 * - A: 90 or above
 * - B: 75 to 89
 * - C: 60 to 74
 * - D: 40 to 59
 * - F: Below 40
 * 
 * Example:
 * Sample Input:
 * 72
 * 95
 * 35
 * 
 * Expected Output:
 * Grade C
 * Grade A
 * Grade F
 */

public class Question8_StudentGradeAssignment {

    public static String assignGrade(int marks) {
        if (marks >= 90) {
            return "Grade A";
        } else if (marks >= 75) {
            return "Grade B";
        } else if (marks >= 60) {
            return "Grade C";
        } else if (marks >= 40) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 8: Student Grade Assignment ===");

        int[] sampleMarks = {72, 95, 35};
        for (int marks : sampleMarks) {
            System.out.println(assignGrade(marks));
        }
    }
}
