import java.util.Scanner;

class OddEvenSorter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();
        
        if (number <= 0) {
            System.err.println("Error: Not a natural number.");
            System.exit(0);
        }
        
        int size = number / 2 + 1;
        int[] evenArray = new int[size];
        int[] oddArray = new int[size];
        int evenIndex = 0;
        int oddIndex = 0;
        
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenArray[evenIndex] = i;
                evenIndex++;
            } else {
                oddArray[oddIndex] = i;
                oddIndex++;
            }
        }
        
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddArray[i] + " ");
        }
        System.out.println();
        
        System.out.print("Even numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenArray[i] + " ");
        }
        System.out.println();
        input.close();
    }
}