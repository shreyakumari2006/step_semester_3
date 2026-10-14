import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Coding Assignment for Category C
 * Problem 3: The Hostel Electricity Bill
 * 
 * Task:
 * A hostel has three kinds of rooms: single rooms, shared rooms, and AC rooms. Each room type
 * calculates its monthly electricity bill differently. For shared rooms, the bill is split equally
 * among the occupants, and the amount shown is what each occupant pays. For every room, calculate
 * the bill, display it, and then display the total of all bills shown.
 * 
 * Input:
 * The first line contains an integer N, the number of rooms. Each of the next N lines contains
 * RoomType Units [AdditionalParam]:
 * - SINGLE Units
 * - SHARED Units Occupants
 * - AC Units
 * 
 * Output:
 * For each room, display RoomType: BillAmount, formatted to two decimal places.
 * Finally, display Total: GrandTotal, also formatted to two decimal places.
 * 
 * Business Rules:
 * - Single room: ₹8 per unit.
 * - Shared room: ₹6 per unit, divided equally by the number of occupants.
 * - AC room: ₹10 per unit, plus a fixed charge of ₹200.
 * 
 * Constraints:
 * - 1 <= N <= 200
 * - Units is a positive whole number
 * - 2 <= Occupants <= 4
 * 
 * Sample Input:
 * 3
 * SINGLE 120
 * SHARED 150 3
 * AC 100
 * 
 * Expected Output:
 * SINGLE: 960.00
 * SHARED: 300.00
 * AC: 1200.00
 * Total: 2460.00
 */

// Base class demonstrating inheritance and polymorphism
abstract class HostelRoom {
    private final String roomType;
    private final int units;

    public HostelRoom(String roomType, int units) {
        this.roomType = roomType;
        this.units = units;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getUnits() {
        return units;
    }

    // Abstract method to calculate room bill polymorphically
    public abstract double calculateBill();

    public void display() {
        System.out.printf("%s: %.2f%n", roomType, calculateBill());
    }
}

class SingleRoom extends HostelRoom {
    private static final double RATE_PER_UNIT = 8.0;

    public SingleRoom(int units) {
        super("SINGLE", units);
    }

    @Override
    public double calculateBill() {
        return getUnits() * RATE_PER_UNIT;
    }
}

class SharedRoom extends HostelRoom {
    private static final double RATE_PER_UNIT = 6.0;
    private final int occupants;

    public SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }

    public int getOccupants() {
        return occupants;
    }

    @Override
    public double calculateBill() {
        return (getUnits() * RATE_PER_UNIT) / occupants;
    }
}

class ACRoom extends HostelRoom {
    private static final double RATE_PER_UNIT = 10.0;
    private static final double FIXED_CHARGE = 200.0;

    public ACRoom(int units) {
        super("AC", units);
    }

    @Override
    public double calculateBill() {
        return (getUnits() * RATE_PER_UNIT) + FIXED_CHARGE;
    }
}

public class Question3_TheHostelElectricityBill {
    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Hostel Electricity Bill ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "SINGLE 120\n"
                    + "SHARED 150 3\n"
                    + "AC 100";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<HostelRoom> rooms = new ArrayList<>();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String type = scanner.next();
            int units = scanner.nextInt();

            HostelRoom room;
            if (type.equalsIgnoreCase("SINGLE")) {
                room = new SingleRoom(units);
            } else if (type.equalsIgnoreCase("SHARED")) {
                int occupants = scanner.nextInt();
                room = new SharedRoom(units, occupants);
            } else if (type.equalsIgnoreCase("AC")) {
                room = new ACRoom(units);
            } else {
                throw new IllegalArgumentException("Unknown room type: " + type);
            }

            rooms.add(room);
            grandTotal += room.calculateBill();
        }

        for (HostelRoom r : rooms) {
            r.display();
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
