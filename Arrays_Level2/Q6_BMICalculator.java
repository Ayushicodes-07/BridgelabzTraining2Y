import java.util.Scanner;

/*
 * Q6: Find BMI of all persons in a team and display height, weight, BMI and status.
 * BMI Table:
 * <= 18.4      -> Underweight
 * 18.5 - 24.9  -> Normal
 * 25.0 - 39.9  -> Overweight
 * >= 40.0      -> Obese
 */
public class Q6_BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] height = new double[n]; // in meters
        double[] weight = new double[n]; // in kg
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter height (in meters) of person " + (i + 1) + ": ");
            height[i] = sc.nextDouble();
            System.out.print("Enter weight (in kg) of person " + (i + 1) + ": ");
            weight[i] = sc.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);
            status[i] = getStatus(bmi[i]);
        }

        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d -> Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s%n",
                    (i + 1), height[i], weight[i], bmi[i], status[i]);
        }

        sc.close();
    }

    static String getStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
