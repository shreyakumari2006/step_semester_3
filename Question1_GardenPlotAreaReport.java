import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 1: Garden Plot Area Report
 * 
 * Task:
 * A community garden rents out plots of three shapes: circular, rectangular, and triangular.
 * Every plot has an owner, and every plot's area is calculated with a different formula.
 * The garden office needs the area of each plot and the total area rented.
 * Adding a new plot shape later should not require changes to the code that prints the report.
 * 
 * Input / Output:
 * Input: The first line contains N, the number of plots. Each of the next N lines contains
 * the shape, the owner's name (one word), and the measurements:
 * - CIRCLE Owner radius
 * - RECTANGLE Owner length width
 * - TRIANGLE Owner base height
 * 
 * Output: For each plot, print Owner (SHAPE): area. Finally, print Total Area: total.
 * All values are formatted to two decimal places.
 * 
 * Business Rules:
 * - Circle area = pi * radius * radius (using Math.PI).
 * - Rectangle area = length * width.
 * - Triangle area = 0.5 * base * height.
 * 
 * Sample Input:
 * 3
 * CIRCLE Asha 5
 * RECTANGLE Ravi 4 6
 * TRIANGLE Neha 10 3
 * 
 * Expected Output:
 * Asha (CIRCLE): 78.54
 * Ravi (RECTANGLE): 24.00
 * Neha (TRIANGLE): 15.00
 * Total Area: 117.54
 */

// Abstract base class representing a generic garden plot
abstract class GardenPlot {
    private final String owner;
    private final String shape;

    public GardenPlot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }

    public String getOwner() {
        return owner;
    }

    public String getShape() {
        return shape;
    }

    // Abstract method to calculate plot area
    public abstract double calculateArea();

    public void display() {
        System.out.printf("%s (%s): %.2f%n", owner, shape, calculateArea());
    }
}

class CircularPlot extends GardenPlot {
    private final double radius;

    public CircularPlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectangularPlot extends GardenPlot {
    private final double length;
    private final double width;

    public RectangularPlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TriangularPlot extends GardenPlot {
    private final double base;
    private final double height;

    public TriangularPlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Question1_GardenPlotAreaReport {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Garden Plot Area Report ===");

        if (args.length > 0 && args[0].equals("--cli")) {
            processFromScanner(new Scanner(System.in));
        } else {
            String sampleInput = "3\n"
                    + "CIRCLE Asha 5\n"
                    + "RECTANGLE Ravi 4 6\n"
                    + "TRIANGLE Neha 10 3";
            System.out.println("Sample Input:");
            System.out.println(sampleInput);
            System.out.println("\nOutput:");
            processFromScanner(new Scanner(sampleInput));
        }
    }

    public static void processFromScanner(Scanner scanner) {
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<GardenPlot> plots = new ArrayList<>();
        double totalArea = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNext()) break;
            String shape = scanner.next();
            String owner = scanner.next();

            GardenPlot plot;
            if (shape.equalsIgnoreCase("CIRCLE")) {
                double radius = scanner.nextDouble();
                plot = new CircularPlot(owner, radius);
            } else if (shape.equalsIgnoreCase("RECTANGLE")) {
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                plot = new RectangularPlot(owner, length, width);
            } else if (shape.equalsIgnoreCase("TRIANGLE")) {
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                plot = new TriangularPlot(owner, base, height);
            } else {
                throw new IllegalArgumentException("Unknown plot shape: " + shape);
            }

            plots.add(plot);
            totalArea += plot.calculateArea();
        }

        // Display report without needing to know specific subclass types
        for (GardenPlot plot : plots) {
            plot.display();
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }
}
