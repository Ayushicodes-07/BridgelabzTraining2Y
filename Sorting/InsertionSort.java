/*
 * 2. Insertion Sort - Sort Employee IDs
 *
 * Problem Statement:
 * A company stores employee IDs in an unsorted array. Implement Insertion
 * Sort to sort the employee IDs in ascending order.
 *
 * Hint:
 * - Divide the array into sorted and unsorted parts.
 * - Pick an element from the unsorted part and insert it into its
 *   correct position in the sorted part.
 * - Repeat for all elements.
 */

public class InsertionSort {

    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;

        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;

            // Shift elements greater than key one position ahead
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }
            employeeIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIds = {1042, 1005, 1099, 1010, 1077, 1001};

        System.out.println("Before Sorting: " + java.util.Arrays.toString(employeeIds));
        insertionSort(employeeIds);
        System.out.println("After Sorting:  " + java.util.Arrays.toString(employeeIds));
    }
}
