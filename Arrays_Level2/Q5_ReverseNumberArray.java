import java.util.Scanner;

/*
 * Q5: Take a number as input and reverse it by storing digits
 * in an array and displaying the array in reverse order.
 */
public class Q5_ReverseNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        boolean isNegative = number < 0;
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

        // Store digits in natural (original) order: digits[0] = first digit of number
        int[] digits = new int[count];
        long t = temp;
        if (t == 0) {
            digits[0] = 0;
        } else {
            int idx = count - 1;
            while (t != 0) {
                digits[idx] = (int) (t % 10); // last digit goes to the last free slot from the end
                idx--;
                t = t / 10;
            }
        }

        // Reverse array
        int[] reversed = new int[count];
        for (int i = 0; i < count; i++) {
            reversed[i] = digits[count - 1 - i];
        }

        System.out.print("Reversed number: ");
        if (isNegative) {
            System.out.print("-");
        }
        for (int i = 0; i < count; i++) {
            System.out.print(reversed[i]);
        }
        System.out.println();

        sc.close();
    }
}
