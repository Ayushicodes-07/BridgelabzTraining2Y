/*
 * StringBuffer Problem 2: Compare StringBuffer with StringBuilder for
 * String Concatenation
 *
 * Problem:
 * Write a program that compares the performance of StringBuffer and
 * StringBuilder for concatenating strings. For large datasets (e.g.,
 * concatenating 1 million strings), compare the execution time of both
 * classes.
 *
 * Approach:
 * 1. Initialize two StringBuffer and StringBuilder objects.
 * 2. Perform string concatenation in both objects, appending 1 million
 *    strings (e.g., "hello").
 * 3. Measure the time taken to complete the concatenation using
 *    System.nanoTime() for both StringBuffer and StringBuilder.
 * 4. Output the time taken by both classes for comparison.
 */

public class CompareStringBufferAndStringBuilder {

    private static final int ITERATIONS = 1_000_000;

    public static void main(String[] args) {
        // StringBuffer timing
        long startBuffer = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            sbBuffer.append("hello");
        }
        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        // StringBuilder timing
        long startBuilder = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            sbBuilder.append("hello");
        }
        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        System.out.println("StringBuffer time (ns):  " + bufferTime);
        System.out.println("StringBuilder time (ns): " + builderTime);

        if (builderTime < bufferTime) {
            System.out.println("StringBuilder was faster (no synchronization overhead).");
        } else {
            System.out.println("StringBuffer was faster in this run.");
        }
    }
}
