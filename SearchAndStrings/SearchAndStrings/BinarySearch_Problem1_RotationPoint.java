/*
 * Binary Search Problem 1: Find the Rotation Point in a Rotated Sorted
 * Array
 *
 * Problem:
 * You are given a rotated sorted array. Write a program that performs
 * Binary Search to find the index of the smallest element in the array
 * (the rotation point).
 *
 * Approach:
 * 1. Initialize left as 0 and right as n - 1.
 * 2. Perform a binary search:
 *    - Find the middle element mid = (left + right) / 2.
 *    - If arr[mid] > arr[right], the smallest element is in the right
 *      half, so update left = mid + 1.
 *    - If arr[mid] < arr[right], the smallest element is in the left
 *      half, so update right = mid.
 * 3. Continue until left equals right, and then return arr[left] (the
 *    rotation point).
 */

public class RotationPointBinarySearch {

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // index of the smallest element
    }

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};

        int rotationIndex = findRotationPoint(arr);
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + arr[rotationIndex]);
    }
}
