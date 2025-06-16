package Exercises;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {
    // Task 1:
    public static double media(File archiveAddress) throws IOException {
        // Instantiating scanner and declaring vars
        Scanner input = new Scanner(archiveAddress);
        double media;

        // Getting sum of the numbers
        media = 0;
        int counter = 0;
        while (input.hasNextInt()) {
            media+=input.nextInt();
            counter++;
        }
        input.close();

        // Returning media:
        return media / counter;
    }

//     Task 2:
    public static String[] product(File archiveAddress, int productCode) throws IOException {
        // Instantiating Scanner and declaring vars:
        Scanner input = new Scanner(archiveAddress);
        String line = "";
        Pattern doubleAsString = Pattern.compile("(\\d+),(\\d+)");
        Matcher matcher;
        int vectorsSize = 0;
        int lineIndex = 0;

        // Solving for vectorsSize in order to declare variables that depends on this value.
        while (input.hasNext()) {
            input.nextLine();
            vectorsSize++;
        }
        input.close();

        // Declaring vars with parameter vectorsSize
        String[] names = new String[vectorsSize];
        double[] values = new double[vectorsSize];
        input = new Scanner(archiveAddress); // Rebuilding input

        // Sweeping lines of the archive:
        while (input.hasNextLine()) {
            // Preparing the line:
            line = input.nextLine();
            matcher = doubleAsString.matcher(line);
            line = matcher.replaceAll("@$1.$2"); // Using regex to identify the double value (by parameter as @) and updating line

            // Splitting the value of the line, storing at values
            values[lineIndex] = Double.parseDouble(line.split("@")[line.split("@").length -1].trim());

            // Creating substring of the name, storing at names
            names[lineIndex] = line.substring(0, line.indexOf("@"));

            lineIndex++; // Updating lineIndex
        }
        input.close(); // Closing input
        return new String[]{names[productCode], String.valueOf(values[productCode])};
    }
}