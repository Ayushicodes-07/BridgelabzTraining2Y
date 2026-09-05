/*
 * 5. Selection Sort - Sort Exam Scores
 *
 * Problem Statement:
 * A university needs to sort students' exam scores in ascending order.
 * Implement Selection Sort to achieve this.
 *
 * Hint:
 * - Find the minimum element in the array.
 * - Swap it with the first unsorted element.
 * - Repeat the process for the remaining elements.
 */

public class SelectionSort {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = scores[i];
                scores[i] = scores[minIndex];
                scores[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] scores = {72, 45, 98, 63, 81, 34};

        System.out.println("Before Sorting: " + java.util.Arrays.toString(scores));
        selectionSort(scores);
        System.out.println("After Sorting:  " + java.util.Arrays.toString(scores));
    }
}
