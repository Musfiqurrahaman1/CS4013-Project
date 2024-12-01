public class Payslip {
    private Employee employee;
    private double grossSalary;
    private double totalDeductions;
    private double netSalary;

    // Constructor
    public Payslip(Employee employee, double grossSalary, double totalDeductions) {
        this.employee = employee;
        this.grossSalary = grossSalary;
        this.totalDeductions = totalDeductions;
        this.netSalary = grossSalary - totalDeductions;
    }

    // Display payslip
    public void displayPayslip() {
        System.out.println("Payslip for: " + employee.getName());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Years Worked: " + employee.getYearsWorked());
        System.out.println("Gross Salary: €" + grossSalary);
        System.out.println("Total Deductions: €" + totalDeductions);
        System.out.println("Net Salary: €" + netSalary);
    }
}

