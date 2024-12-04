import java.io.*;
import java.util.*;

public class PayrollSystem {
    private List<Employee> employees;
    private Deductions deductions;
    private String csvFilePath;

    // Constructor
    public PayrollSystem(String csvFilePath, Deductions deductions) throws IOException {
        this.csvFilePath = csvFilePath;
        this.deductions = deductions;
        this.employees = loadEmployeesFromCSV(csvFilePath);
    }



    // gets the employees from CSV
    private List<Employee> loadEmployeesFromCSV(String csvFilePath) throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            br.readLine(); // Skip the tittle lines at the very top
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String employeeID = data[0];
                String name = data[1];
                String position = data[2];
                double salary = Double.parseDouble(data[3]);
                int yearsWorked = Integer.parseInt(data[4]);
                double hourlyRate = Double.parseDouble(data[5]);
                int hoursWorked = Integer.parseInt(data[6]);

                Employee emp = new Employee(employeeID, name, position, salary, yearsWorked, hourlyRate, hoursWorked);
                employees.add(emp);
            }
        }
        return employees;


    }

    // makes and display a payslip for an employee
    public void generatePayslip(String employeeID) {
        for (Employee emp : employees) {
            if (emp.getEmployeeID().equals(employeeID)) {
                double grossPay = emp.getHourlyRate() > 0
                        ? emp.getHourlyRate() * emp.getHoursWorked()
                        : emp.getSalary();


                // Calculate tax deductions
                double incomeTax = deductions.calculateIncomeTax(grossPay);
                double prsi = deductions.calculatePRSI(grossPay);
                double usc = deductions.calculateUSC(grossPay);
                double healthInsurance = deductions.getHealthInsuranceFee();
                double unionFee = deductions.getUnionFee();
                double totalDeductions = incomeTax + prsi + usc + healthInsurance + unionFee;

                // make and show payslip
                Payslip payslip = new Payslip(emp, grossPay, totalDeductions,
                        incomeTax, healthInsurance, unionFee,
                        prsi, usc);
                payslip.displayPayslip();
                return;
            }
        }
        System.out.println("Employee not found!");
    }


    // Add a new employee and save to the CSV
    public void addEmployee(Employee emp) {
        employees.add(emp);
        saveEmployeesToCSV();
        System.out.println("Employee added successfully!");
    }

    // Save employees to CSV
    private void saveEmployeesToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            // Write the header
            bw.write("Employee ID,Name,Position,Salary,Years Worked,Hourly Rate,Hours Worked");
            bw.newLine();

            // Write employee data
            for (Employee emp : employees) {
                bw.write(emp.getEmployeeID() + "," +
                        emp.getName() + "," +
                        emp.getPosition() + "," +
                        emp.getSalary() + "," +
                        emp.getYearsWorked() + "," +
                        emp.getHourlyRate() + "," +
                        emp.getHoursWorked());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to CSV: " + e.getMessage());
        }
    }
}

