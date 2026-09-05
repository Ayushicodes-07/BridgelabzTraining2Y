/*
 * Binary Search Problem 4: Find the First and Last Occurrence of an
 * Element in a Sorted Array
 *
 * Problem:
 * Given a sorted array and a target element, write a program that uses
 * Binary Search to find the first and last occurrence of the target
 * element in the array. If the element is not found, return -1.
 *
 * Approach:
 * 1. Use binary search to find the first occurrence:
 *    - Perform a regular binary search, but if the target is found,
 *      continue searching on the left side (right = mid - 1) to find
 *      the first occurrence.
 * 2. Use binary search to find the last occurrence:
 *    - Similar to finding the first occurrence, but once the target is
 *      found, continue searching on the right side (left = mid + 1) to
 *      find the last occurrence.
 * 3. Return the indices of the first and last occurrence. If not found,
 *    return -1.
 */

public class FirstAndLastOccurrenceBinarySearch {

    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // keep searching left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // keep searching right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 5, 7, 9, 9, 12};
        int target = 4;

        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);

        System.out.println("First occurrence index: " + first);
        System.out.println("Last occurrence index: " + last);
    }
}
