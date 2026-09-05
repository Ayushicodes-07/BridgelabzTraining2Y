/*
 * StringBuilder Problem 1: Reverse a String Using StringBuilder
 *
 * Problem:
 * Write a program that uses StringBuilder to reverse a given string.
 * For example, if the input is "hello", the output should be "olleh".
 *
 * Approach:
 * 1. Create a new StringBuilder object.
 * 2. Append the string to the StringBuilder.
 * 3. Use the reverse() method of StringBuilder to reverse the string.
 * 4. Convert the StringBuilder back to a string and return it.
 */

public class ReverseStringUsingStringBuilder {

    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseString(input);

        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
