/**
 * Problem 4: The Traffic Light
 * 
 * Scenario:
 * A traffic light cycles through red, green, and yellow, in order.
 * 
 * Problem Statement:
 * Design a TrafficLight class where the color can only move forward through its cycle,
 * never be set to an arbitrary color directly.
 * 
 * Requirements:
 * - The current color must be private, changed only by a next() method that moves red -> green -> yellow -> red, in that order.
 * - There must be no method that sets the color directly to any value.
 * - Provide a read-only way to check the current color.
 * - Give the light a final ID, fixed when it's created.
 * 
 * Expected Behavior:
 * - A new light starts on red.
 * - Calling next() repeatedly cycles red -> green -> yellow -> red -> green ... forever, in that exact order.
 * - There's no way to jump the light straight to, say, yellow without going through the proper order.
 * 
 * Sample Input/Output:
 * TrafficLight t = new TrafficLight("TL-9");
 * t.getColor() -> "RED"
 * t.next() -> "GREEN"
 * t.next() -> "YELLOW"
 * t.next() -> "RED"
 */

class TrafficLight {
    private static final String[] CYCLE = {"RED", "GREEN", "YELLOW"};

    private final String id;
    private int currentIndex;

    public TrafficLight(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Traffic light ID cannot be null or empty.");
        }
        this.id = id;
        this.currentIndex = 0; // Starts on RED
    }

    public String getColor() {
        return CYCLE[this.currentIndex];
    }

    public String getId() {
        return this.id;
    }

    // Moves strictly to the next state in the sequence: RED -> GREEN -> YELLOW -> RED
    public String next() {
        this.currentIndex = (this.currentIndex + 1) % CYCLE.length;
        return getColor();
    }
}

public class Question4_TheTrafficLight {
    public static void main(String[] args) {
        System.out.println("=== Problem 4: The Traffic Light ===");
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("TrafficLight ID: " + t.getId());
        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");

        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
    }
}
