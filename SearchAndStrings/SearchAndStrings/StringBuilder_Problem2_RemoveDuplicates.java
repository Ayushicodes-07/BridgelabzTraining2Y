/*
 * StringBuilder Problem 2: Remove Duplicates from a String Using StringBuilder
 *
 * Problem:
 * Write a program that uses StringBuilder to remove all duplicate characters
 * from a given string while maintaining the original order.
 *
 * Approach:
 * 1. Initialize an empty StringBuilder and a HashSet to keep track of characters.
 * 2. Iterate over each character in the string:
 *    - If the character is not in the HashSet, append it to the StringBuilder
 *      and add it to the HashSet.
 * 3. Return the StringBuilder as a string without duplicates.
 */

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesUsingStringBuilder {

    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);

        System.out.println("Original: " + input);
        System.out.println("Without Duplicates: " + result);
    }
}
