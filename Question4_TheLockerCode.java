/**
 * Problem 4: The Locker Code
 * 
 * Scenario:
 * A gym locker has a combination code that members can change.
 * 
 * Problem Statement:
 * Design a Locker class where the combination can be changed, but never read back directly
 * from outside the class.
 * 
 * Requirements:
 * - The combination code must be private, with no getter at all.
 * - Provide a method to change the code that requires the current code to be entered correctly first.
 * - If the wrong current code is given, the change must be rejected and the code must stay the same.
 * - Give the locker a final locker number, fixed at creation.
 * 
 * Expected Behavior:
 * - Changing the code with the correct current code succeeds.
 * - Changing the code with the wrong current code leaves the combination unchanged.
 * - There is no way, from outside the class, to read the current code.
 * 
 * Sample Input/Output:
 * Locker l = new Locker(101, "1234");
 * l.changeCode("1234", "5678") -> success
 * l.changeCode("0000", "9999") -> rejected, code is still "5678"
 */

class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String initialCode) {
        if (initialCode == null || initialCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Initial combination code cannot be null or empty.");
        }
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public boolean changeCode(String oldCode, String newCode) {
        // Check the old code first before touching the field
        if (oldCode == null || !this.combinationCode.equals(oldCode)) {
            System.out.println("Code change rejected: Incorrect current code entered.");
            return false;
        }

        if (newCode == null || newCode.trim().isEmpty()) {
            System.out.println("Code change rejected: New code cannot be null or empty.");
            return false;
        }

        this.combinationCode = newCode;
        System.out.println("Code change successful: Locker #" + this.lockerNumber + " combination updated.");
        return true;
    }

    public int getLockerNumber() {
        return this.lockerNumber;
    }

    // Optional authentication check without revealing internal code
    public boolean unlock(String enteredCode) {
        return this.combinationCode.equals(enteredCode);
    }
}

public class Question4_TheLockerCode {
    public static void main(String[] args) {
        System.out.println("=== Problem 4: The Locker Code ===");
        Locker l = new Locker(101, "1234");
        System.out.println("Created Locker #" + l.getLockerNumber());

        // Attempt 1: Successful code change
        boolean res1 = l.changeCode("1234", "5678");
        System.out.println("l.changeCode(\"1234\", \"5678\") -> " + (res1 ? "success" : "rejected"));

        // Attempt 2: Rejected code change due to incorrect old code
        boolean res2 = l.changeCode("0000", "9999");
        System.out.println("l.changeCode(\"0000\", \"9999\") -> " + (res2 ? "success" : "rejected, code is still \"5678\""));

        // Verify locker unlocks only with the updated code "5678"
        System.out.println("Unlock with '1234': " + l.unlock("1234"));
        System.out.println("Unlock with '5678': " + l.unlock("5678"));
    }
}
