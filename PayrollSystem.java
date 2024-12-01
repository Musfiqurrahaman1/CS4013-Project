import java.io.*;
import java.util.*;

public class PayrollSystem {
    private List<Employee> employees;
    private Deductions deductions;

    String csvFilePath = "/Users/jusmiruddin/Desktop/new.csv";

    // Constructor
    public PayrollSystem(String csvFilePath , Deductions deductions) throws IOException {
        this.employees = loadEmployeesFromCSV(csvFilePath);
        this.deductions = deductions;
    }

    // Load employees from CSV
    private List<Employee> loadEmployeesFromCSV(String csvFilePath) throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Employee emp = new Employee(data[0], data[1], data[2], Integer.parseInt(data[3]),
                        Double.parseDouble(data[3]));
                employees.add(emp);
            }
        }
        return employees;
    }

    // Generate and display payslip for an employee
    public void generatePayslip(String employeeID) {
        for (Employee emp : employees) {
            if (emp.getEmployeeID().equals(employeeID)) {
                double grossSalary = emp.getSalary();
                double totalDeductions = deductions.calculateDeductions(grossSalary);
                Payslip payslip = new Payslip(emp, grossSalary, totalDeductions);
                payslip.displayPayslip();
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Add employee (Admin functionality)
    public void addEmployee(Employee emp) {
        employees.add(emp);
        // Save to CSV logic here
    }
}
