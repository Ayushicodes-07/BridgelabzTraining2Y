import java.util.Scanner;

/*
 * Q3: Store the digits of a number in an array (max 10 digits) and
 * find the largest and second largest digit.
 */
public class Q3_LargestSecondLargestDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // handle 0 as a special case
        if (number == 0) {
            digits[index++] = 0;
        }

        long temp = Math.abs(number);
        while (temp != 0) {
            if (index == maxDigit) {
                break; // array full, stop adding remaining digits
            }
            int digit = (int) (temp % 10);
            digits[index] = digit;
            index++;
            temp = temp / 10;
        }

        int largest = 0, secondLargest = 0;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Digits stored: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }

        System.out.println("\nLargest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        sc.close();
    }
}
