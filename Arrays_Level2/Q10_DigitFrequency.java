import java.util.Scanner;

/*
 * Q10: Take a number as input, find the frequency of each digit (0-9)
 * in the number using an array, and display the frequency of each digit.
 */
public class Q10_DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        long temp = Math.abs(number);

        // Count digits
        int count = 0;
        if (temp == 0) {
            count = 1;
        } else {
            long t = temp;
            while (t != 0) {
                count++;
                t = t / 10;
            }
        }

        int[] digits = new int[count];
        int idx = 0;
        long t = temp;
        if (t == 0) {
            digits[0] = 0;
        } else {
            while (t != 0) {
                digits[idx] = (int) (t % 10);
                idx++;
                t = t / 10;
            }
        }

        int[] frequency = new int[10];
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        System.out.println("\n--- Digit Frequency ---");
        for (int d = 0; d <= 9; d++) {
            if (frequency[d] > 0) {
                System.out.println("Digit " + d + " -> Frequency: " + frequency[d]);
            }
        }

        sc.close();
    }
}
