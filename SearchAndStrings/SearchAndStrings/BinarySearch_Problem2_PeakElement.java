/*
 * Binary Search Problem 2: Find the Peak Element in an Array
 *
 * Problem:
 * A peak element is an element that is greater than its neighbors. Write
 * a program that performs Binary Search to find a peak element in an
 * array. If there are multiple peak elements, return any one of them.
 *
 * Approach:
 * 1. Initialize left as 0 and right as n - 1.
 * 2. Perform a binary search:
 *    - Find the middle element mid = (left + right) / 2.
 *    - If arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1], arr[mid]
 *      is a peak element.
 *    - If arr[mid] < arr[mid - 1], then search the left half, updating
 *      right = mid - 1.
 *    - If arr[mid] < arr[mid + 1], then search the right half, updating
 *      left = mid + 1.
 * 3. Continue until a peak element is found.
 */

public class PeakElementBinarySearch {

    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1; // peak is on the right side
            } else {
                right = mid; // peak is on the left side (including mid)
            }
        }

        return left; // index of a peak element
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}
