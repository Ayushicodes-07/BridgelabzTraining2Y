/*
 * FileReader Problem 1: Read a File Line by Line Using FileReader
 *
 * Problem:
 * Write a program that uses FileReader to read a text file line by line
 * and print each line to the console.
 *
 * Approach:
 * 1. Create a FileReader object to read from the file.
 * 2. Wrap the FileReader in a BufferedReader to read lines efficiently.
 * 3. Use a loop to read each line using the readLine() method and print
 *    it to the console.
 * 4. Close the file after reading all the lines.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {

    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "sample.txt"; // replace with actual file path
        readFile(filePath);
    }
}
