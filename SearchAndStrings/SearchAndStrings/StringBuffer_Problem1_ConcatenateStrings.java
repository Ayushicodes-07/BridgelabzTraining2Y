/*
 * StringBuffer Problem 1: Concatenate Strings Efficiently Using StringBuffer
 *
 * Problem:
 * You are given an array of strings. Write a program that uses StringBuffer
 * to concatenate all the strings in the array efficiently.
 *
 * Approach:
 * 1. Create a new StringBuffer object.
 * 2. Iterate through each string in the array and append it to the StringBuffer.
 * 3. Return the concatenated string after the loop finishes.
 * 4. Using StringBuffer ensures efficient string concatenation due to its
 *    mutable nature.
 */

public class ConcatenateStringsUsingStringBuffer {

    public static String concatenate(String[] words) {
        StringBuffer sb = new StringBuffer();

        for (String word : words) {
            sb.append(word);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Learning", " ", "Java", " ", "is", " ", "fun", "!"};
        String result = concatenate(words);

        System.out.println("Concatenated String: " + result);
    }
}
