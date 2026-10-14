/**
 * Problem 5: The Attendance Sheet
 * 
 * Scenario:
 * A teacher marks which students are present in class today.
 * 
 * Problem Statement:
 * Design an AttendanceSheet class that stores present students internally but only
 * reveals a count and a yes/no lookup — never the full list.
 * 
 * Requirements:
 * - Store the names of present students in a private array (fixed size is fine — assume a maximum class size).
 * - Provide a method to mark a student present.
 * - Provide a method that returns how many students are present, and another that checks whether one specific name is present.
 * - There should be no method that returns the whole array of names.
 * 
 * Expected Behavior:
 * - Marking "Ana", "Ben", and "Ana" again present results in a count of 2 (no duplicates).
 * - isPresent("Ben") returns true; isPresent("Chen") returns false.
 * - There's no way to retrieve the full list of present students directly.
 * 
 * Sample Input/Output:
 * AttendanceSheet sheet = new AttendanceSheet(30);
 * sheet.markPresent("Ana"); sheet.markPresent("Ben"); sheet.markPresent("Ana");
 * sheet.getPresentCount() -> 2
 * sheet.isPresent("Ben") -> true
 */

class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Max class capacity must be greater than 0.");
        }
        this.presentStudents = new String[maxCapacity];
        this.count = 0;
    }

    public void markPresent(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            System.out.println("Warning: Invalid student name.");
            return;
        }

        String trimmedName = studentName.trim();

        // Check if student is already marked present (avoid duplicates)
        if (isPresent(trimmedName)) {
            System.out.println("Notice: " + trimmedName + " is already marked present.");
            return;
        }

        if (this.count >= this.presentStudents.length) {
            System.out.println("Warning: Attendance sheet is full. Cannot add " + trimmedName + ".");
            return;
        }

        this.presentStudents[this.count] = trimmedName;
        this.count++;
        System.out.println("Marked present: " + trimmedName);
    }

    public int getPresentCount() {
        return this.count;
    }

    public boolean isPresent(String studentName) {
        if (studentName == null) {
            return false;
        }
        String searchName = studentName.trim();
        for (int i = 0; i < this.count; i++) {
            if (this.presentStudents[i].equalsIgnoreCase(searchName)) {
                return true;
            }
        }
        return false;
    }

    public int getMaxCapacity() {
        return this.presentStudents.length;
    }
}

public class Question5_TheAttendanceSheet {
    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Attendance Sheet ===");
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Duplicate, count should remain 2

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
