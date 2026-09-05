/*
 * Linear Search Problem 2: Search for a Specific Word in a List of
 * Sentences
 *
 * Problem:
 * You are given an array of sentences (strings). Write a program that
 * performs Linear Search to find the first sentence containing a
 * specific word. If the word is found, return the sentence. If no
 * sentence contains the word, return "Not Found".
 *
 * Approach:
 * 1. Iterate through the list of sentences.
 * 2. For each sentence, check if it contains the specific word.
 * 3. If the word is found, return the current sentence.
 * 4. If no sentence contains the word, return "Not Found".
 */

public class SearchWordInSentences {

    public static String findSentenceWithWord(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            String[] words = sentence.toLowerCase().split("\\s+");
            for (String word : words) {
                if (word.replaceAll("[^a-zA-Z]", "").equals(targetWord.toLowerCase())) {
                    return sentence;
                }
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "The weather is nice today.",
                "I love programming in Java.",
                "Binary search is efficient for sorted data."
        };
        String targetWord = "java";

        String result = findSentenceWithWord(sentences, targetWord);
        System.out.println("Result: " + result);
    }
}
