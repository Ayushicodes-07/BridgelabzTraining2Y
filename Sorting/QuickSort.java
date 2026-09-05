/*
 * 4. Quick Sort - Sort Product Prices
 *
 * Problem Statement:
 * An e-commerce company wants to display product prices in ascending
 * order. Implement Quick Sort to sort the product prices.
 *
 * Hint:
 * - Pick a pivot element (first, last, or random).
 * - Partition the array such that elements smaller than the pivot are
 *   on the left and larger ones are on the right.
 * - Recursively apply Quick Sort on left and right partitions.
 */

public class QuickSort {

    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // choosing last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] prices = {799, 199, 2499, 599, 99, 1299};

        System.out.println("Before Sorting: " + java.util.Arrays.toString(prices));
        quickSort(prices, 0, prices.length - 1);
        System.out.println("After Sorting:  " + java.util.Arrays.toString(prices));
    }
}
