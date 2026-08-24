import java.util.Scanner;

class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        if (number < 0) {
            System.exit(0);
        }
        
        String[] results = new String[number + 1];
        for (int i = 0; i <= number; i++) {
            if (i == 0) {
                results[i] = "0";
            } else if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }
        
        for (int i = 1; i < results.length; i++) {
            System.out.print("Position " + i + " = " + results[i]);
            if (i < results.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        input.close();
    }
}