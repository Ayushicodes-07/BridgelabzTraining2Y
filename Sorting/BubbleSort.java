/*
 * 1. Bubble Sort - Sort Student Marks
 *
 * Problem Statement:
 * A school maintains student marks in an array. Implement Bubble Sort
 * to sort the student marks in ascending order.
 *
 * Hint:
 * - Traverse through the array multiple times.
 * - Compare adjacent elements and swap if needed.
 * - Repeat the process until no swaps are required.
 */

public class BubbleSort {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] marks = {88, 45, 67, 23, 91, 56, 12};

        System.out.println("Before Sorting: " + java.util.Arrays.toString(marks));
        bubbleSort(marks);
        System.out.println("After Sorting:  " + java.util.Arrays.toString(marks));
    }
}
