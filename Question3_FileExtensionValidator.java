/**
 * STEP SEM-3 · CodinClub | Powered by BridgeLabz
 * Day 2 Live-Coding Session — 5 Problems
 * 
 * Question 3: File Extension Validator
 * 
 * Scenario:
 * An assignment-upload portal must check whether an uploaded filename has an accepted
 * extension (pdf, docx, zip) regardless of case, before accepting the submission.
 * 
 * Task:
 * - Accept a filename string.
 * - Find the last '.' using lastIndexOf('.') and extract the extension with substring().
 * - Compare the extension case-insensitively against the accepted list: pdf, docx, zip.
 * - Print "Accepted" or "Rejected — invalid file type".
 * 
 * Suggested method signature(s):
 * String validateFileExtension(String filename)
 * 
 * Sample Input / Output:
 * Input: "Assignment1.PDF"
 * Output: Accepted
 * 
 * Input: "notes.txt"
 * Output: Rejected — invalid file type
 * 
 * Concepts covered:
 * lastIndexOf(), substring(), equalsIgnoreCase(), conditional logic.
 */
public class Question3_FileExtensionValidator {

    /**
     * Validates whether the given filename has an accepted extension (pdf, docx, zip)
     * regardless of case.
     * 
     * @param filename The name of the uploaded file.
     * @return "Accepted" if the file extension is valid; otherwise "Rejected — invalid file type".
     */
    public static String validateFileExtension(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Rejected — invalid file type";
        }

        // Find last '.' in filename
        int lastDotIndex = filename.lastIndexOf('.');

        // If dot not found or dot is at the very end
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        // Extract extension with substring()
        String extension = filename.substring(lastDotIndex + 1);

        // Compare extension case-insensitively against accepted list: pdf, docx, zip
        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Day 2 - Problem 3: File Extension Validator ===");

        // Sample Test Case 1: Uppercase PDF
        String file1 = "Assignment1.PDF";
        System.out.println("\nSample Input 1: \"" + file1 + "\"");
        System.out.println("Output: " + validateFileExtension(file1));

        // Sample Test Case 2: Rejected file type (.txt)
        String file2 = "notes.txt";
        System.out.println("\nSample Input 2: \"" + file2 + "\"");
        System.out.println("Output: " + validateFileExtension(file2));

        // Additional Test Case 1: Case-insensitive ZIP
        String file3 = "submission_archive.Zip";
        System.out.println("\nTest Case 3: \"" + file3 + "\"");
        System.out.println("Output: " + validateFileExtension(file3));

        // Additional Test Case 2: Multi-dot filename (.docx)
        String file4 = "project.final.version.DOCX";
        System.out.println("\nTest Case 4: \"" + file4 + "\"");
        System.out.println("Output: " + validateFileExtension(file4));

        // Additional Test Case 3: No extension
        String file5 = "README";
        System.out.println("\nTest Case 5: \"" + file5 + "\"");
        System.out.println("Output: " + validateFileExtension(file5));
    }
}
