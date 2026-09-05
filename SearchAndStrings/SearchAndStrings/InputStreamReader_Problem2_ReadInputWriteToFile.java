/*
 * InputStreamReader Problem 2: Read User Input and Write to File Using
 * InputStreamReader
 *
 * Problem:
 * Write a program that uses InputStreamReader to read user input from the
 * console and write the input to a file. Each input should be written as
 * a new line in the file.
 *
 * Approach:
 * 1. Create an InputStreamReader to read from System.in (the console).
 * 2. Wrap the InputStreamReader in a BufferedReader for efficient reading.
 * 3. Create a FileWriter to write to the file.
 * 4. Read user input using readLine() and write the input to the file.
 * 5. Repeat the process until the user enters "exit" to stop inputting.
 * 6. Close the file after the input is finished.
 */

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInputWriteToFile {

    public static void main(String[] args) {
        String filePath = "user_input.txt"; // replace with desired output path

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(filePath)) {

            String line;
            System.out.println("Enter text (type 'exit' to stop):");

            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }

            System.out.println("Input saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
