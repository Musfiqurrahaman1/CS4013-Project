
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "/Users/jusmiruddin/Desktop/new.csv";

        // Example deductions (values can be adjusted as needed)
        Deductions deductions = new Deductions(0.2, 50, 10); // 20% tax, €50 insurance, €10 union fee

        try {
            // Initialize Payroll System
            PayrollSystem payrollSystem = new PayrollSystem(csvFilePath, deductions);

            // CLI Menu
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nPayroll System");
                System.out.println("1. Display Payslip");
                System.out.println("2. Add New Employee");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        // Generate Payslip
                        System.out.print("Enter Employee ID: ");
                        String employeeID = scanner.nextLine();
                        payrollSystem.generatePayslip(employeeID);
                        break;
                    case 2:
                        // Add New Employee
                        System.out.print("Enter Employee ID: ");
                        String newID = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Position: ");
                        String position = scanner.nextLine();
                        System.out.print("Enter Years Worked: ");
                        int yearsWorked = scanner.nextInt();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine(); // consume newline

                        Employee newEmployee = new Employee(newID, name, position, yearsWorked, salary);
                        payrollSystem.addEmployee(newEmployee);
                        System.out.println("Employee added successfully!");
                        break;
                    case 3:
                        // Exit
                        System.out.println("Exiting system...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error initializing payroll system: " + e.getMessage());
        }
    }
}
