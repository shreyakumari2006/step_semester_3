import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Problem 4: Examination Question Grader
 * 
 * Task:
 * An examination system needs to evaluate answers for different types of questions (e.g., Multiple Choice,
 * True/False, Essay). Each question type has a specific grading logic. The system must process a list of
 * questions with provided answers and determine the score for each, then calculate the total score.
 * 
 * Input Format:
 * The first line contains an integer N, the number of questions.
 * Each of the next N lines contains QuestionType QuestionText CorrectAnswer StudentAnswer [Points]:
 * - MCQ "What is 2+2?" "4" "4" 10
 * - TF "Water boils at 100C?" "True" "True" 5
 * - ESSAY "Discuss OOP principles" "Polymorphism, Inheritance, Encapsulation" "I talked about Polymorphism and Inheritance." 20
 * 
 * Output Format:
 * For each question, display QuestionType: Score, formatted to two decimal places.
 * Finally, display Total Score: OverallScore, also formatted to two decimal places.
 * 
 * Business Rules:
 * - Multiple Choice Question (MCQ): Full points if StudentAnswer exactly matches CorrectAnswer.
 * - True/False Question (TF): Full points if StudentAnswer exactly matches CorrectAnswer.
 * - Essay Question (ESSAY): Partial points.
 *   - If StudentAnswer contains at least two of the keywords from CorrectAnswer (comma-separated, case-insensitive), award 75% of Points.
 *   - If one keyword, award 50% of Points.
 *   - Otherwise, 0 points.
 * 
 * Constraints:
 * - 1 <= N <= 100
 * - Points are positive integers.
 * - All string comparisons are case-insensitive for essay keywords.
 * 
 * Sample Input:
 * 4
 * MCQ "What is the capital of France?" "Paris" "Paris" 10
 * TF "The Earth is flat?" "False" "True" 5
 * ESSAY "Name two primary OOP principles." "Inheritance, Polymorphism, Encapsulation" "Polymorphism is one." 20
 * ESSAY "Describe abstraction and composition." "Abstraction, Composition" "I talked about abstraction " 15
 * 
 * Expected Output:
 * MCQ: 10.00
 * TF: 0.00
 * ESSAY: 10.00
 * ESSAY: 7.50
 * Total Score: 27.50
 */

// Base class demonstrating inheritance and polymorphism
abstract class ExamQuestion {
    private final String questionType;
    private final String questionText;
    private final String correctAnswer;
    private final String studentAnswer;
    private final double points;

    public ExamQuestion(String questionType, String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionType = questionType;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public double getPoints() {
        return points;
    }

    // Abstract method to evaluate score polymorphically
    public abstract double evaluateScore();

    public void display() {
        System.out.printf("%s: %.2f%n", questionType, evaluateScore());
    }
}

class McqQuestion extends ExamQuestion {
    public McqQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("MCQ", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        if (getStudentAnswer() != null && getStudentAnswer().trim().equalsIgnoreCase(getCorrectAnswer().trim())) {
            return getPoints();
        }
        return 0.0;
    }
}

class TrueFalseQuestion extends ExamQuestion {
    public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("TF", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        if (getStudentAnswer() != null && getStudentAnswer().trim().equalsIgnoreCase(getCorrectAnswer().trim())) {
            return getPoints();
        }
        return 0.0;
    }
}

class EssayQuestion extends ExamQuestion {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("ESSAY", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        if (getStudentAnswer() == null || getCorrectAnswer() == null) {
            return 0.0;
        }

        String[] keywords = getCorrectAnswer().split(",");
        int matchCount = 0;
        String studentAnswerLower = getStudentAnswer().toLowerCase();

        for (String keyword : keywords) {
            String cleanKw = keyword.trim().toLowerCase();
            if (!cleanKw.isEmpty() && studentAnswerLower.contains(cleanKw)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return getPoints() * 0.75;
        } else if (matchCount == 1) {
            return getPoints() * 0.50;
        } else {
            return 0.0;
        }
    }
}

public class Question4_ExaminationQuestionGrader {
    public static void main(String[] args) {
        System.out.println("=== Problem 4: Examination Question Grader ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "4\n"
                    + "MCQ \"What is the capital of France?\" \"Paris\" \"Paris\" 10\n"
                    + "TF \"The Earth is flat?\" \"False\" \"True\" 5\n"
                    + "ESSAY \"Name two primary OOP principles.\" \"Inheritance, Polymorphism, Encapsulation\" \"Polymorphism is one.\" 20\n"
                    + "ESSAY \"Describe abstraction and composition.\" \"Abstraction, Composition\" \"I talked about abstraction \" 15";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextLine()) return;

        String firstLine = scanner.nextLine().trim();
        while (firstLine.isEmpty() && scanner.hasNextLine()) {
            firstLine = scanner.nextLine().trim();
        }
        if (firstLine.isEmpty()) return;

        int n = Integer.parseInt(firstLine);
        List<ExamQuestion> questions = new ArrayList<>();
        double totalScore = 0.0;

        Pattern tokenPattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            Matcher matcher = tokenPattern.matcher(line);
            List<String> tokens = new ArrayList<>();
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    tokens.add(matcher.group(1));
                } else {
                    tokens.add(matcher.group(2));
                }
            }

            if (tokens.size() < 5) continue;

            String type = tokens.get(0);
            String questionText = tokens.get(1);
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            ExamQuestion question;
            if (type.equalsIgnoreCase("MCQ")) {
                question = new McqQuestion(questionText, correctAnswer, studentAnswer, points);
            } else if (type.equalsIgnoreCase("TF")) {
                question = new TrueFalseQuestion(questionText, correctAnswer, studentAnswer, points);
            } else if (type.equalsIgnoreCase("ESSAY")) {
                question = new EssayQuestion(questionText, correctAnswer, studentAnswer, points);
            } else {
                throw new IllegalArgumentException("Unknown question type: " + type);
            }

            questions.add(question);
            totalScore += question.evaluateScore();
        }

        for (ExamQuestion q : questions) {
            q.display();
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
    }
}
