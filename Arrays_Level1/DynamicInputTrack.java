import java.util.Scanner;

class DynamicInputTrack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        System.out.println("Enter numbers (0 or negative to stop, max 10):");
        while (true) {
            if (index == 10) {
                break;
            }
            double entry = input.nextDouble();
            if (entry <= 0) {
                break;
            }
            numbers[index] = entry;
            index++;
        }
        
        System.out.print("Entered numbers: ");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }
        System.out.println("\nTotal sum: " + total);
        input.close();
    }
}