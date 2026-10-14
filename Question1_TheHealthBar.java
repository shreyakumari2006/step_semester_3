/**
 * Problem 1: The Health Bar
 * 
 * Scenario:
 * A game character has health that changes during battle.
 * 
 * Problem Statement:
 * Design a Character class where health can never drop below 0 or rise above its maximum,
 * and can't be set directly from outside.
 * 
 * Requirements:
 * - Health must be private, changed only through takeDamage(int amount) and heal(int amount).
 * - Health must never go below 0 (extra damage is just wasted) or above the maximum (extra healing is just wasted).
 * - The maximum health must be final, fixed when the character is created.
 * - Provide a read-only way to check current health — no setter for it.
 * 
 * Expected Behavior:
 * - A character with 100 max health that takes 30 damage has 70 health left.
 * - Healing past the maximum caps at the maximum, not above it.
 * - Damage that would take health below 0 leaves health at exactly 0, not negative.
 * 
 * Sample Input/Output:
 * Character c = new Character(100);
 * c.takeDamage(30) -> health = 70
 * c.heal(50) -> health = 100 (capped)
 * c.takeDamage(150) -> health = 0 (floored)
 */

class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException("Max health must be greater than 0.");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            System.out.println("Damage amount must be positive.");
            return;
        }
        this.health = Math.max(0, this.health - amount);
        System.out.println("c.takeDamage(" + amount + ") -> health = " + this.health + (this.health == 0 ? " (floored)" : ""));
    }

    public void heal(int amount) {
        if (amount <= 0) {
            System.out.println("Heal amount must be positive.");
            return;
        }
        this.health = Math.min(this.maxHealth, this.health + amount);
        System.out.println("c.heal(" + amount + ") -> health = " + this.health + (this.health == this.maxHealth ? " (capped)" : ""));
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }
}

public class Question1_TheHealthBar {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Health Bar ===");
        Character c = new Character(100);
        System.out.println("Created Character with Max Health: " + c.getMaxHealth() + ", Initial Health: " + c.getHealth());

        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);

        System.out.println("Final Health: " + c.getHealth());
    }
}
