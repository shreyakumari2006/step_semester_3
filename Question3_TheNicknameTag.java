/**
 * Problem 3: The Nickname Tag
 * 
 * Scenario:
 * A chat app shows a friendly short nickname instead of your full name.
 * 
 * Problem Statement:
 * Create an immutable NameTag class that takes a full name once and builds a nickname
 * from it — first name plus the last name's initial.
 * 
 * Requirements:
 * - Take one full name string in the constructor (e.g., "Maria Gomez") and split it into first and last name.
 * - Store whatever you keep as final fields — nothing about the name should be changeable after creation.
 * - Provide a method that returns the nickname (e.g., "Maria G."), built from the stored parts.
 * - Assume the full name always has exactly one first name and one last name, separated by a single space.
 * 
 * Expected Behavior:
 * - new NameTag("Maria Gomez").getNickname() returns "Maria G."
 * - Once created, there is no method that changes the stored name in any way.
 * - Two NameTag objects built from the same full name behave identically but remain separate objects.
 * 
 * Sample Input/Output:
 * NameTag tag = new NameTag("Maria Gomez");
 * tag.getNickname() -> "Maria G."
 */

final class NameTag {
    private final String firstName;
    private final String lastName;
    private final String nickname;

    public NameTag(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be null or empty.");
        }
        String[] parts = fullName.trim().split(" ");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Full name must contain both first name and last name separated by a space.");
        }
        this.firstName = parts[0];
        this.lastName = parts[parts.length - 1];
        this.nickname = this.firstName + " " + this.lastName.charAt(0) + ".";
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}

public class Question3_TheNicknameTag {
    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Nickname Tag ===");
        NameTag tag1 = new NameTag("Maria Gomez");
        System.out.println("Full Name: " + tag1.getFullName());
        System.out.println("Nickname: " + tag1.getNickname());

        NameTag tag2 = new NameTag("Alan Turing");
        System.out.println("Full Name: " + tag2.getFullName());
        System.out.println("Nickname: " + tag2.getNickname());

        // Verifying immutability and object independence
        NameTag tag3 = new NameTag("Maria Gomez");
        System.out.println("tag1 nickname equals tag3 nickname: " + tag1.getNickname().equals(tag3.getNickname()));
        System.out.println("tag1 is separate object from tag3: " + (tag1 != tag3));
    }
}
