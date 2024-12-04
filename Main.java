import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // CSV file path
        String csvFilePath = "/Users/jusmiruddin/Desktop/yuh.csv";

        //deductions
        Deductions deductions = new Deductions(0.02, 50, 10, 0.05, 0.08); // 20% tax, €50 insurance, €10 union fee, PRSI 5%, USC 8%

        try {

            // Initialize Payroll System
            PayrollSystem payrollSystem = new PayrollSystem(csvFilePath, deductions);

            // cli meu for the csv
            Scanner scanner = new Scanner(System.in); // scanner so user can type in values
            while (true) {
                System.out.println("\nPayroll System");
                System.out.println("1. Display Payslip");
                System.out.println("2. Add New Employee");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // goes to a newline

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
                        System.out.print("Enter Salary (for full-time): ");
                        double salary = scanner.nextDouble();
                        System.out.print("Enter Hourly Rate (0 for full-time): ");
                        double hourlyRate = scanner.nextDouble();
                        System.out.print("Enter Hours Worked (0 for full-time): ");
                        int hoursWorked = scanner.nextInt();
                        System.out.print("Enter Years Worked: ");
                        int yearsWorked = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        // Create a new employee
                        Employee newEmployee = new Employee(newID, name, position, salary, yearsWorked, hourlyRate, hoursWorked);

                        // Add the new employee to the payroll system
                        payrollSystem.addEmployee(newEmployee);
                        System.out.println("Employee added successfully!");
                        break;
                    case 3:
                        // Exit system
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


