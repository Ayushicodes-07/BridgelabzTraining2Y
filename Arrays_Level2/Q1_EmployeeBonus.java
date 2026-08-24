import java.util.Scanner;

/*
 * Q1: Find the bonus of 10 employees based on years of service.
 * - Bonus = 5% of salary if years of service > 5, else 2%
 * - Print total bonus, total old salary, total new salary
 */
public class Q1_EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;

        double[] salary = new double[n];
        double[] yearsOfService = new double[n];
        double[] newSalary = new double[n];
        double[] bonusAmount = new double[n];

        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        // Input loop with validation
        int i = 0;
        while (i < n) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double sal = sc.nextDouble();

            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            double yos = sc.nextDouble();

            if (sal < 0 || yos < 0) {
                System.out.println("Invalid input! Salary and years of service cannot be negative. Please re-enter.");
                continue; // do not increment i, ask again
            }

            salary[i] = sal;
            yearsOfService[i] = yos;
            i++;
        }

        // Calculate bonus, new salary, and totals
        for (i = 0; i < n; i++) {
            double bonusPercent = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonusAmount[i] = salary[i] * bonusPercent;
            newSalary[i] = salary[i] + bonusAmount[i];

            totalBonus += bonusAmount[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("\n--- Results ---");
        for (i = 0; i < n; i++) {
            System.out.printf("Employee %d: Old Salary = %.2f, Bonus = %.2f, New Salary = %.2f%n",
                    (i + 1), salary[i], bonusAmount[i], newSalary[i]);
        }

        System.out.printf("%nTotal Bonus Payout = %.2f%n", totalBonus);
        System.out.printf("Total Old Salary = %.2f%n", totalOldSalary);
        System.out.printf("Total New Salary = %.2f%n", totalNewSalary);

        sc.close();
    }
}
