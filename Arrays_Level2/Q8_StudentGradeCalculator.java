import java.util.Scanner;

/*
 * Q8: Take marks of students in Physics, Chemistry, Maths.
 * Compute percentage and grade as per:
 * A: 80% and above
 * B: 70-79%
 * C: 60-69%
 * D: 50-59%
 * E: 40-49%
 * R: 39% and below
 */
public class Q8_StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3]; // physics, chemistry, maths
        double[] percentage = new double[n];
        String[] grade = new String[n];

        int i = 0;
        while (i < n) {
            System.out.println("Enter marks for student " + (i + 1) + " (out of 100 each):");

            System.out.print("Physics: ");
            double physics = sc.nextDouble();
            System.out.print("Chemistry: ");
            double chemistry = sc.nextDouble();
            System.out.print("Maths: ");
            double maths = sc.nextDouble();

            if (physics < 0 || chemistry < 0 || maths < 0) {
                System.out.println("Marks cannot be negative! Please enter again.");
                continue;
            }

            marks[i][0] = physics;
            marks[i][1] = chemistry;
            marks[i][2] = maths;
            i++;
        }

        for (i = 0; i < n; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;
            grade[i] = getGrade(percentage[i]);
        }

        System.out.println("\n--- Student Report ---");
        for (i = 0; i < n; i++) {
            System.out.printf("Student %d -> Physics: %.1f, Chemistry: %.1f, Maths: %.1f, Percentage: %.2f%%, Grade: %s%n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }

        sc.close();
    }

    static String getGrade(double percentage) {
        if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "R";
        }
    }
}
