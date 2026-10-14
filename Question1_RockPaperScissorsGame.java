import java.util.Random;

/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Day 1 Live-Coding Session — 5 Problems
 * 
 * Question 1: Rock-Paper-Scissors Game
 * 
 * Scenario:
 * The College Coding Arcade
 * The coding club is setting up a mini arcade module for orientation day, where new
 * students play a quick Rock-Paper-Scissors match against the computer as a warm-up before
 * their placement round. The club needs a simulator that plays several rounds between the
 * "player" and the "computer," records the outcome of every round, and prints a final
 * scoreboard summarizing wins, losses, draws, and the player's win percentage.
 * 
 * Task:
 * - Generate the computer's move randomly (Rock, Paper, or Scissors) for each round.
 * - Accept the player's move for each round (via input, or a predefined list for a live demo).
 * - Determine and display the winner of each round using standard Rock-Paper-Scissors rules.
 * - Repeat for N rounds (suggested N = 5).
 * - After all rounds, print a summary table: Round | Player Move | Computer Move | Result.
 * - Print the total Wins, Losses, Draws, and the player's Win Percentage.
 * 
 * Suggested method signature(s):
 * String playRound(String playerMove, String computerMove)
 * 
 * Sample Input / Output:
 * Round 1 — Player: Rock, Computer: Scissors -> Player Wins
 * Round 2 — Player: Paper, Computer: Paper -> Draw
 * Round 3 — Player: Scissors, Computer: Rock -> Computer Wins
 * Final Summary (after 5 rounds): Wins: 2 | Losses: 2 | Draws: 1 | Win % = 40.0%
 * 
 * Concepts covered:
 * Random number generation, conditional logic, loops, arrays for the round table,
 * formatted/tabular output, basic statistics (percentage calculation).
 */
public class Question1_RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    /**
     * Determines the winner of a single round of Rock-Paper-Scissors.
     * 
     * @param playerMove The move chosen by the player ("Rock", "Paper", or "Scissors").
     * @param computerMove The move chosen by the computer ("Rock", "Paper", or "Scissors").
     * @return "Player Wins", "Computer Wins", or "Draw".
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Invalid Move";
        }

        String p = playerMove.trim();
        String c = computerMove.trim();

        if (p.equalsIgnoreCase(c)) {
            return "Draw";
        }

        if ((p.equalsIgnoreCase("Rock") && c.equalsIgnoreCase("Scissors")) ||
            (p.equalsIgnoreCase("Paper") && c.equalsIgnoreCase("Rock")) ||
            (p.equalsIgnoreCase("Scissors") && c.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else if ((c.equalsIgnoreCase("Rock") && p.equalsIgnoreCase("Scissors")) ||
                   (c.equalsIgnoreCase("Paper") && p.equalsIgnoreCase("Rock")) ||
                   (c.equalsIgnoreCase("Scissors") && p.equalsIgnoreCase("Paper"))) {
            return "Computer Wins";
        } else {
            return "Invalid Move";
        }
    }

    /**
     * Generates a random move for the computer: "Rock", "Paper", or "Scissors".
     * 
     * @param random A Random instance.
     * @return The randomly chosen move.
     */
    public static String getRandomComputerMove(Random random) {
        return MOVES[random.nextInt(MOVES.length)];
    }

    /**
     * Runs a series of rounds, prints the round-by-round table, and displays the summary statistics.
     * 
     * @param playerMoves Array of moves made by the player.
     * @param computerMoves Array of moves made by the computer.
     */
    public static void runGameSimulation(String[] playerMoves, String[] computerMoves) {
        int totalRounds = playerMoves.length;
        String[] results = new String[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < totalRounds; i++) {
            results[i] = playRound(playerMoves[i], computerMoves[i]);
            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else if (results[i].equals("Draw")) {
                draws++;
            }
        }

        // Print Summary Table
        System.out.printf("%-7s | %-12s | %-13s | %-13s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-7d | %-12s | %-13s | %-13s%n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("-------------------------------------------------------");

        // Calculate win percentage
        double winPercentage = totalRounds > 0 ? ((double) wins / totalRounds) * 100.0 : 0.0;
        System.out.printf("Final Summary (after %d rounds): Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                totalRounds, wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        System.out.println("=== Day 1 - Problem 1: Rock-Paper-Scissors Game ===");

        // Test Demo 1: Predefined 5 rounds (matching sample scenario)
        System.out.println("\n--- Match 1: Predefined Demo (5 Rounds) ---");
        String[] samplePlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] sampleComputerMoves = {"Scissors", "Paper", "Rock", "Scissors", "Scissors"};
        runGameSimulation(samplePlayerMoves, sampleComputerMoves);

        // Test Demo 2: Random Simulation against computer
        System.out.println("\n--- Match 2: Random Computer Moves Simulation ---");
        Random random = new Random(42); // fixed seed for reproducible demonstration
        String[] testPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Scissors"};
        String[] randomComputerMoves = new String[testPlayerMoves.length];
        for (int i = 0; i < testPlayerMoves.length; i++) {
            randomComputerMoves[i] = getRandomComputerMove(random);
        }
        runGameSimulation(testPlayerMoves, randomComputerMoves);
    }
}
