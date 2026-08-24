import java.util.Scanner;

/*
 * Q9: Rewrite Q8 to store marks of students in Physics, Chemistry, Maths
 * using a 2D array and then compute percentage and grade.
 * marksData[i][0]=physics, [i][1]=chemistry, [i][2]=maths
 */
public class Q9_StudentGradeCalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marksData = new double[n][3];
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

            marksData[i][0] = physics;
            marksData[i][1] = chemistry;
            marksData[i][2] = maths;
            i++;
        }

        for (i = 0; i < n; i++) {
            double total = marksData[i][0] + marksData[i][1] + marksData[i][2];
            percentage[i] = total / 3.0;
            grade[i] = getGrade(percentage[i]);
        }

        System.out.println("\n--- Student Report (2D Array) ---");
        for (i = 0; i < n; i++) {
            System.out.printf("Student %d -> Physics: %.1f, Chemistry: %.1f, Maths: %.1f, Percentage: %.2f%%, Grade: %s%n",
                    (i + 1), marksData[i][0], marksData[i][1], marksData[i][2], percentage[i], grade[i]);
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
