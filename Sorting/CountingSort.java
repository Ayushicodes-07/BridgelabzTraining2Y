/*
 * 7. Counting Sort - Sort Student Ages
 *
 * Problem Statement:
 * A school collects students' ages (ranging from 10 to 18) and wants
 * them sorted. Implement Counting Sort for this task.
 *
 * Hint:
 * - Create a count array to store the frequency of each age.
 * - Compute cumulative frequencies to determine positions.
 * - Place elements in their correct positions in the output array.
 */

public class CountingSort {

    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Store frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute cumulative frequencies
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements into output array (stable placement, right to left)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Copy sorted output back into original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] ages = {15, 12, 18, 14, 10, 16, 13, 17};

        System.out.println("Before Sorting: " + java.util.Arrays.toString(ages));
        countingSort(ages, 10, 18); // ages range from 10 to 18
        System.out.println("After Sorting:  " + java.util.Arrays.toString(ages));
    }
}
