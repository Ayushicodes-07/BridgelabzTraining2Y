import java.util.Scanner;

/*
 * Q4: Rework of Q3. Instead of breaking when index == maxDigit,
 * dynamically grow the array by 10 more slots so all digits are stored.
 */
public class Q4_LargestSecondLargestDigitDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        if (number == 0) {
            digits[index++] = 0;
        }

        long temp = Math.abs(number);
        while (temp != 0) {
            if (index == maxDigit) {
                // grow the array by 10
                maxDigit += 10;
                int[] tempArray = new int[maxDigit];
                for (int j = 0; j < digits.length; j++) {
                    tempArray[j] = digits[j];
                }
                digits = tempArray;
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
