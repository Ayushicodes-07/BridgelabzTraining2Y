import java.util.Scanner;

/*
 * Q7: Rewrite Q6 using a multi-dimensional (2D) array to store
 * height, weight, and BMI for all persons.
 * personData[i][0] = height, personData[i][1] = weight, personData[i][2] = BMI
 */
public class Q7_BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            double height, weight;

            System.out.print("Enter height (in meters) of person " + (i + 1) + ": ");
            height = sc.nextDouble();
            while (height < 0) {
                System.out.print("Invalid! Enter a positive height: ");
                height = sc.nextDouble();
            }

            System.out.print("Enter weight (in kg) of person " + (i + 1) + ": ");
            weight = sc.nextDouble();
            while (weight < 0) {
                System.out.print("Invalid! Enter a positive weight: ");
                weight = sc.nextDouble();
            }

            personData[i][0] = height;
            personData[i][1] = weight;
        }

        for (int i = 0; i < number; i++) {
            double height = personData[i][0];
            double weight = personData[i][1];
            double bmi = weight / (height * height);
            personData[i][2] = bmi;
            weightStatus[i] = getStatus(bmi);
        }

        System.out.println("\n--- BMI Report (2D Array) ---");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d -> Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s%n",
                    (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
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
