/*
 * Challenge Problem: Compare StringBuilder, StringBuffer, FileReader, and
 * InputStreamReader
 *
 * Problem:
 * Write a program that:
 * 1. Uses StringBuilder and StringBuffer to concatenate a list of strings
 *    1,000,000 times.
 * 2. Uses FileReader and InputStreamReader to read a large file (e.g.,
 *    100MB) and print the number of words in the file.
 *
 * Approach:
 * 1. StringBuilder and StringBuffer:
 *    - Create a list of strings (e.g., "hello").
 *    - Concatenate the strings 1,000,000 times using both StringBuilder
 *      and StringBuffer.
 *    - Measure and compare the time taken for each.
 * 2. FileReader and InputStreamReader:
 *    - Read a large text file (100MB) using FileReader and
 *      InputStreamReader.
 *    - Count the number of words by splitting the text on whitespace
 *      characters.
 *    - Print the word count and compare the time taken for reading the
 *      file.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CompareStringAndFileClasses {

    private static final int ITERATIONS = 1_000_000;

    public static void main(String[] args) {
        compareStringBuilderAndStringBuffer();

        String filePath = "large_file.txt"; // replace with actual large file path
        compareFileReaderAndInputStreamReader(filePath);
    }

    private static void compareStringBuilderAndStringBuffer() {
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append("hello");
        }
        long builderTime = System.nanoTime() - startBuilder;

        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            sbf.append("hello");
        }
        long bufferTime = System.nanoTime() - startBuffer;

        System.out.println("StringBuilder time (ns): " + builderTime);
        System.out.println("StringBuffer time (ns):  " + bufferTime);
    }

    private static void compareFileReaderAndInputStreamReader(String filePath) {
        // FileReader word count
        long startFileReader = System.nanoTime();
        int wordCountFileReader = countWords(() -> {
            try {
                return new BufferedReader(new FileReader(filePath));
            } catch (IOException e) {
                return null;
            }
        });
        long fileReaderTime = System.nanoTime() - startFileReader;

        // InputStreamReader word count
        long startISR = System.nanoTime();
        int wordCountISR = countWords(() -> {
            try {
                return new BufferedReader(
                        new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
            } catch (IOException e) {
                return null;
            }
        });
        long isrTime = System.nanoTime() - startISR;

        System.out.println("FileReader word count: " + wordCountFileReader
                + " | time (ns): " + fileReaderTime);
        System.out.println("InputStreamReader word count: " + wordCountISR
                + " | time (ns): " + isrTime);
    }

    private static int countWords(ReaderSupplier supplier) {
        int wordCount = 0;

        try (BufferedReader br = supplier.get()) {
            if (br == null) {
                System.out.println("Could not open file for reading.");
                return 0;
            }
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    wordCount += line.trim().split("\\s+").length;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return wordCount;
    }

    @FunctionalInterface
    private interface ReaderSupplier {
        BufferedReader get() throws IOException;
    }
}
