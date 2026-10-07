import java.util.Arrays;

/**
 * Problem 2: The Playlist
 * 
 * Scenario:
 * A music app lets you build a playlist of songs.
 * 
 * Problem Statement:
 * Design a Playlist class that stores songs internally but returns a safe copy of the list,
 * so nobody can sneak in changes from outside.
 * 
 * Requirements:
 * - Store song titles in a private array (assume a fixed maximum size).
 * - Provide a method to add a song, and one that returns all the songs added so far — as a copy, not the original array.
 * - Changing the array returned by that method must not affect the playlist's real contents.
 * - Provide a read-only count of how many songs are in the playlist.
 * 
 * Expected Behavior:
 * - Adding "Song A" and "Song B" and then asking for the list returns both, in order.
 * - Modifying the array you got back from the playlist does not change what the playlist actually holds.
 * - getSongCount() always matches how many songs have actually been added.
 * 
 * Sample Input/Output:
 * Playlist p = new Playlist(10);
 * p.addSong("Song A"); p.addSong("Song B");
 * String[] copy = p.getSongs();
 * copy[0] = "Hacked"; // p.getSongs()[0] is still "Song A"
 */

class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Max capacity must be greater than 0.");
        }
        this.songs = new String[maxCapacity];
        this.count = 0;
    }

    public void addSong(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Warning: Song title cannot be null or empty.");
            return;
        }
        if (this.count >= this.songs.length) {
            System.out.println("Warning: Playlist is full. Cannot add \"" + title + "\".");
            return;
        }
        this.songs[this.count] = title;
        this.count++;
        System.out.println("Added song: \"" + title + "\"");
    }

    // Defensive copy: return a new array with only the added songs
    public String[] getSongs() {
        return Arrays.copyOf(this.songs, this.count);
    }

    public int getSongCount() {
        return this.count;
    }

    public int getMaxCapacity() {
        return this.songs.length;
    }
}

public class Question2_ThePlaylist {
    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Playlist ===");
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        System.out.println("Song count: " + p.getSongCount());

        // Defensive copy test
        String[] copy = p.getSongs();
        System.out.println("Returned copy: " + Arrays.toString(copy));

        System.out.println("\nAttempting to modify the returned array:");
        copy[0] = "Hacked";
        System.out.println("Modified copy[0] to: " + copy[0]);

        System.out.println("Playlist p.getSongs()[0] is still: \"" + p.getSongs()[0] + "\"");
        System.out.println("Current playlist contents: " + Arrays.toString(p.getSongs()));
    }
}
