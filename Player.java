/**
 * Represents a fantasy sports player with their statistics and fitness status.
 */
public class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    @Override
    public int compareTo(Player other) {
        // Sort descending by batting average / fantasy points
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', matchesPlayed=" + matchesPlayed + ", battingAverage=" + battingAverage + ", injured=" + injured + "}";
    }
}
