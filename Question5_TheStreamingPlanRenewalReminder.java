import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Coding Assignment for Category C
 * Problem 5: The Streaming Plan Renewal Reminder
 * 
 * Task:
 * A video streaming service offers three subscription plans: Basic, Standard, and Premium.
 * Each plan stays valid for a different number of days from its start date. For every subscriber,
 * calculate the date on which the plan must be renewed and display it.
 * 
 * Input:
 * The first line contains an integer N, the number of subscribers. Each of the next N lines contains
 * PlanType Name StartDate, where StartDate is in the format YYYY-MM-DD:
 * - BASIC Name StartDate
 * - STANDARD Name StartDate
 * - PREMIUM Name StartDate
 * 
 * Output:
 * For each subscriber, display Name: RenewalDate, where RenewalDate is formatted as YYYY-MM-DD.
 * 
 * Business Rules:
 * - Basic plan: valid for 30 days.
 * - Standard plan: valid for 90 days.
 * - Premium plan: valid for 365 days.
 * - The renewal date is the start date plus the plan's validity in days.
 * 
 * Constraints:
 * - 1 <= N <= 100
 * - Name is a single word
 * - StartDate is a valid date
 * 
 * Sample Input:
 * 4
 * BASIC Asha 2024-01-15
 * STANDARD Ravi 2024-02-01
 * PREMIUM Neha 2024-03-10
 * BASIC Kiran 2024-12-20
 * 
 * Expected Output:
 * Asha: 2024-02-14
 * Ravi: 2024-05-01
 * Neha: 2025-03-10
 * Kiran: 2025-01-19
 */

// Base class demonstrating inheritance and polymorphism
abstract class StreamingSubscription {
    private final String planType;
    private final String subscriberName;
    private final LocalDate startDate;

    public StreamingSubscription(String planType, String subscriberName, LocalDate startDate) {
        this.planType = planType;
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public String getPlanType() {
        return planType;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    // Abstract method to calculate renewal date polymorphically
    public abstract LocalDate calculateRenewalDate();

    public void display() {
        System.out.printf("%s: %s%n", subscriberName, calculateRenewalDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}

class BasicSubscription extends StreamingSubscription {
    private static final int VALIDITY_DAYS = 30;

    public BasicSubscription(String subscriberName, LocalDate startDate) {
        super("BASIC", subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return getStartDate().plusDays(VALIDITY_DAYS);
    }
}

class StandardSubscription extends StreamingSubscription {
    private static final int VALIDITY_DAYS = 90;

    public StandardSubscription(String subscriberName, LocalDate startDate) {
        super("STANDARD", subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return getStartDate().plusDays(VALIDITY_DAYS);
    }
}

class PremiumSubscription extends StreamingSubscription {
    private static final int VALIDITY_DAYS = 365;

    public PremiumSubscription(String subscriberName, LocalDate startDate) {
        super("PREMIUM", subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return getStartDate().plusDays(VALIDITY_DAYS);
    }
}

public class Question5_TheStreamingPlanRenewalReminder {
    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Streaming Plan Renewal Reminder ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "4\n"
                    + "BASIC Asha 2024-01-15\n"
                    + "STANDARD Ravi 2024-02-01\n"
                    + "PREMIUM Neha 2024-03-10\n"
                    + "BASIC Kiran 2024-12-20";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<StreamingSubscription> subscriptions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String planType = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);

            StreamingSubscription subscription;
            if (planType.equalsIgnoreCase("BASIC")) {
                subscription = new BasicSubscription(name, startDate);
            } else if (planType.equalsIgnoreCase("STANDARD")) {
                subscription = new StandardSubscription(name, startDate);
            } else if (planType.equalsIgnoreCase("PREMIUM")) {
                subscription = new PremiumSubscription(name, startDate);
            } else {
                throw new IllegalArgumentException("Unknown plan type: " + planType);
            }

            subscriptions.add(subscription);
        }

        for (StreamingSubscription sub : subscriptions) {
            sub.display();
        }
    }
}
