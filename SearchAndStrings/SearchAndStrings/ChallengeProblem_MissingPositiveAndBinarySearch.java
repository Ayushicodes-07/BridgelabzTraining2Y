/*
 * Challenge Problem (for both Linear and Binary Search)
 *
 * Problem:
 * You are given a list of integers. Write a program that uses Linear
 * Search to find the first missing positive integer in the list and
 * Binary Search to find the index of a given target number.
 *
 * Approach:
 * 1. Linear Search for the first missing positive integer:
 *    - Iterate through the list and mark each number in the list as
 *      visited (you can use negative marking or a separate array).
 *    - Traverse the array again to find the first positive integer that
 *      is not marked.
 * 2. Binary Search for the target index:
 *    - After sorting the array, perform binary search to find the index
 *      of the given target number.
 *    - Return the index if found, otherwise return -1.
 */

import java.util.Arrays;

public class FirstMissingPositiveAndBinarySearch {

    // Linear Search approach: find first missing positive integer
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 1]; // track 1..n

        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1; // all 1..n present, so answer is n + 1
    }

    // Binary Search approach: find index of target in sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1, 7};

        int firstMissing = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + firstMissing);

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        int target = 7;

        int index = binarySearch(sortedArr, target);
        System.out.println("Sorted array: " + Arrays.toString(sortedArr));
        System.out.println("Index of target " + target + ": " + index);
    }
}
