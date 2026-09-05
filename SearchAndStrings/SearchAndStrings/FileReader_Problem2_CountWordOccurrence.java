/*
 * FileReader Problem 2: Count the Occurrence of a Word in a File Using
 * FileReader
 *
 * Problem:
 * Write a program that uses FileReader and BufferedReader to read a file
 * and count how many times a specific word appears in the file.
 *
 * Approach:
 * 1. Create a FileReader to read from the file and wrap it in a
 *    BufferedReader.
 * 2. Initialize a counter variable to keep track of word occurrences.
 * 3. For each line in the file, split it into words and check if the
 *    target word exists.
 * 4. Increment the counter each time the word is found.
 * 5. Print the final count.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordOccurrenceInFile {

    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String filePath = "sample.txt"; // replace with actual file path
        String targetWord = "java";

        int occurrences = countWordOccurrences(filePath, targetWord);
        System.out.println("The word \"" + targetWord + "\" appears " + occurrences + " time(s).");
    }
}
