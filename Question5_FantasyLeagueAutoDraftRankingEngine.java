import java.util.Arrays;

/**
 * Problem 5: Fantasy League Auto-Draft Ranking Engine
 * Category C Assignment Problems - Advanced Tier
 * 
 * Topics Integrated:
 * Arrays, Method Overloading, Static Methods, Standard Library (Arrays.sort),
 * Constructors & Encapsulation
 * 
 * Problem Statement:
 * An auto-draft feature needs to decide which players are draftable and rank them by fantasy points
 * — but the draft rule isn't one simple cutoff. A player with a long track record qualifies on
 * experience alone, but a newer player still needs to be both reasonably experienced and currently fit
 * to make the cut.
 * 
 * Requirements:
 * - Provide two overloaded isDraftable(...) checks: a matches-played-only rule for established players,
 *   and a combined matches-and-fitness rule for everyone else — decide the exact thresholds yourself.
 * - Player must implement Comparable<Player> so that Arrays.sort(...) alone can rank the draftable array
 *   by fantasy points, descending, with no separate comparison logic written elsewhere.
 */
public class Question5_FantasyLeagueAutoDraftRankingEngine {

    /**
     * Checks if an established player is draftable based on experience alone.
     * Established player rule: matchesPlayed >= 10.
     * 
     * @param matchesPlayed Total matches played by the player.
     * @return true if player meets the experience bar, false otherwise.
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Overloaded check for players considering both match experience and fitness status.
     * Established players (matches >= 10) qualify regardless of injury.
     * Newer players qualify if they have reasonable experience (matches >= 5) and are not injured.
     * 
     * @param matchesPlayed Total matches played.
     * @param injured       Current injury status of the player.
     * @return true if draftable under either rule, false otherwise.
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return isDraftable(matchesPlayed) || (matchesPlayed >= 5 && !injured);
    }

    /**
     * Filters draftable players, sorts them using Arrays.sort, and formats the leaderboard.
     * 
     * @param players Array of submitted Player objects.
     * @return Ranked list formatted as "1. Name | 2. Name | ...".
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        // Count how many players qualify as draftable
        int count = 0;
        for (Player p : players) {
            if (p != null && isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                count++;
            }
        }

        if (count == 0) {
            return "No draftable players";
        }

        // Populate array of draftable players
        Player[] draftable = new Player[count];
        int index = 0;
        for (Player p : players) {
            if (p != null && isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable[index++] = p;
            }
        }

        // Sort using the standard library Arrays.sort (utilizing Player's compareTo method)
        Arrays.sort(draftable);

        // Format ranked output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append((i + 1)).append(". ").append(draftable[i].getName());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Fantasy League Auto-Draft Ranking Engine ===");

        // Test Case 1: Example from assignment
        Player[] lineup1 = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 28.0, true)
        };

        System.out.println("\nTest Case 1 Input:");
        for (Player p : lineup1) {
            System.out.println("  " + p);
        }
        System.out.println("Output: \"" + draftAndRank(lineup1) + "\"");

        // Test Case 2: Another lineup
        Player[] lineup2 = {
            new Player("Rohit", 18, 52.0, true),
            new Player("Gill", 6, 50.0, false),
            new Player("Ishan", 4, 45.0, true),
            new Player("Pant", 8, 42.0, false)
        };

        System.out.println("\nTest Case 2 Input:");
        for (Player p : lineup2) {
            System.out.println("  " + p);
        }
        System.out.println("Output: \"" + draftAndRank(lineup2) + "\"");
    }
}
