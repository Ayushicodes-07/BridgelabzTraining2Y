/*
 * 6. Heap Sort - Sort Job Applicants by Salary
 *
 * Problem Statement:
 * A company receives job applications with different expected salary
 * demands. Implement Heap Sort to sort these salary demands in
 * ascending order.
 *
 * Hint:
 * - Build a Max Heap from the array.
 * - Extract the largest element (root) and place it at the end.
 * - Reheapify the remaining elements and repeat until sorted.
 */

public class HeapSort {

    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            heapify(salaries, i, 0);
        }
    }

    private static void heapify(int[] salaries, int size, int rootIndex) {
        int largest = rootIndex;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if (left < size && salaries[left] > salaries[largest]) {
            largest = left;
        }
        if (right < size && salaries[right] > salaries[largest]) {
            largest = right;
        }

        if (largest != rootIndex) {
            int temp = salaries[rootIndex];
            salaries[rootIndex] = salaries[largest];
            salaries[largest] = temp;

            heapify(salaries, size, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaries = {55000, 42000, 68000, 51000, 39000, 72000};

        System.out.println("Before Sorting: " + java.util.Arrays.toString(salaries));
        heapSort(salaries);
        System.out.println("After Sorting:  " + java.util.Arrays.toString(salaries));
    }
}
