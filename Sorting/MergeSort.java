/*
 * 3. Merge Sort - Sort an Array of Book Prices
 *
 * Problem Statement:
 * A bookstore maintains a list of book prices in an array. Implement
 * Merge Sort to sort the prices in ascending order.
 *
 * Hint:
 * - Divide the array into two halves recursively.
 * - Sort both halves individually.
 * - Merge the sorted halves by comparing elements.
 */

public class MergeSort {

    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }

    private static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(prices, left, leftArr, 0, n1);
        System.arraycopy(prices, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k++] = leftArr[i++];
            } else {
                prices[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            prices[k++] = leftArr[i++];
        }
        while (j < n2) {
            prices[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        int[] prices = {499, 1999, 299, 4999, 999, 149};

        System.out.println("Before Sorting: " + java.util.Arrays.toString(prices));
        mergeSort(prices, 0, prices.length - 1);
        System.out.println("After Sorting:  " + java.util.Arrays.toString(prices));
    }
}
