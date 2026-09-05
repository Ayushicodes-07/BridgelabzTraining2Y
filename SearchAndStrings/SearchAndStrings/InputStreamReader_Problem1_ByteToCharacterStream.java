/*
 * InputStreamReader Problem 1: Convert Byte Stream to Character Stream
 * Using InputStreamReader
 *
 * Problem:
 * Write a program that uses InputStreamReader to read binary data from a
 * file and print it as characters. The file contains data encoded in a
 * specific charset (e.g., UTF-8).
 *
 * Approach:
 * 1. Create a FileInputStream object to read the binary data from the file.
 * 2. Wrap the FileInputStream in an InputStreamReader to convert the byte
 *    stream into a character stream.
 * 3. Use a BufferedReader to read characters efficiently from the
 *    InputStreamReader.
 * 4. Read the file line by line and print the characters to the console.
 * 5. Handle any encoding exceptions as needed.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ConvertByteStreamToCharacterStream {

    public static void readFileAsCharacters(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

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
        readFileAsCharacters(filePath);
    }
}
