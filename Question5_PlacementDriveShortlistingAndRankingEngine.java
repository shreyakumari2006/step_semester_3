import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 5: Placement Drive Shortlisting & Ranking Engine
 * 
 * Topics Integrated:
 * Arrays, Method Overloading, Static Methods, Standard Library (Arrays.sort), Constructors & Encapsulation
 * 
 * Problem Statement:
 * The placement cell wants one script to do two jobs: decide who's eligible for a company's coding round,
 * and rank everyone who qualifies. Eligibility isn't one simple rule — a strong CGPA alone is enough,
 * but a borderline CGPA can still qualify through a genuinely good coding test score. Once shortlisted,
 * candidates should be ranked by a composite score, using Java's own sort rather than writing a sort by hand.
 * 
 * Requirements:
 * - Provide two overloaded isEligible(...) checks: a CGPA-only quick filter, and a combined
 *   CGPA-and-coding-score filter for borderline cases.
 * - Candidate must implement Comparable<Candidate> so that Arrays.sort(...) alone can rank a shortlisted
 *   array by composite score, descending.
 * 
 * Function Signature(s):
 * public Candidate(String name, double cgpa, int codingScore)
 * static boolean isEligible(double cgpa)
 * static boolean isEligible(double cgpa, int codingScore)
 * int compareTo(Candidate other)
 * static String shortlistAndRank(Candidate[] candidates)
 * 
 * Examples:
 * Input:
 * shortlistAndRank(new Candidate[]{
 *   new Candidate("Aisha", 8.2, 40),
 *   new Candidate("Rohit", 6.8, 65),
 *   new Candidate("Meena", 6.0, 90),
 *   new Candidate("Karan", 7.5, 20)
 * })
 * Output: "1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)"
 * 
 * Explanation:
 * Aisha and Karan clear the CGPA-only bar directly. Rohit's CGPA alone falls just short,
 * but a strong coding score of 65 clears the combined check. Meena clears neither check
 * and is left out entirely, regardless of her high coding score.
 * 
 * Constraints:
 * cgpa is 0-10. codingScore is 0-100. Up to 500 candidates in a batch.
 */

class Candidate implements Comparable<Candidate> {
    private final String name;
    private final double cgpa;
    private final int codingScore;
    private final double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        // Composite score = (CGPA * 10) + (codingScore / 2)
        this.compositeScore = (cgpa * 10.0) + (codingScore / 2.0);
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    public double getCompositeScore() {
        return compositeScore;
    }

    // Overloaded static eligibility filter 1: Direct CGPA cutoff
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Overloaded static eligibility filter 2: Borderline CGPA with strong coding score
    public static boolean isEligible(double cgpa, int codingScore) {
        if (isEligible(cgpa)) {
            return true;
        }
        return cgpa >= 6.5 && codingScore >= 60;
    }

    @Override
    public int compareTo(Candidate other) {
        // Descending order by composite score
        return Double.compare(other.compositeScore, this.compositeScore);
    }
}

public class Question5_PlacementDriveShortlistingAndRankingEngine {

    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> eligibleList = new ArrayList<>();
        for (Candidate c : candidates) {
            if (c != null && Candidate.isEligible(c.getCgpa(), c.getCodingScore())) {
                eligibleList.add(c);
            }
        }

        if (eligibleList.isEmpty()) {
            return "No candidates eligible.";
        }

        Candidate[] shortlisted = eligibleList.toArray(new Candidate[0]);
        // Sort using standard library's Arrays.sort (utilizing Candidate's compareTo)
        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ")
              .append(shortlisted[i].getName()).append(" (")
              .append(String.format("%.1f", shortlisted[i].getCompositeScore()))
              .append(")");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Placement Drive Shortlisting & Ranking Engine ===");

        Candidate[] candidates = new Candidate[]{
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        String result = shortlistAndRank(candidates);
        System.out.println("Output:\n\"" + result + "\"");
    }
}
