public class Payslip {
    private Employee employee;
    private double grossPay;
    private double totalDeductions;
    private double incomeTax;
    private double healthInsurance;
    private double unionFee;
    private double prsi;
    private double usc;

    // Constructor
    public Payslip(Employee employee, double grossPay, double totalDeductions,
                   double incomeTax, double healthInsurance, double unionFee,
                   double prsi, double usc) {
        this.employee = employee;
        this.grossPay = grossPay;
        this.totalDeductions = totalDeductions;
        this.incomeTax = incomeTax;
        this.healthInsurance = healthInsurance;
        this.unionFee = unionFee;
        this.prsi = prsi;
        this.usc = usc;
    }


    public void displayPayslip() {  // this displays all the nessesary info needed on a payslip
        System.out.println("\n=== Payslip ===");
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Employee Type: " + (employee.getHourlyRate() > 0 ? "Part-Time" : "Full-Time"));
        System.out.println("Gross Pay: €" + grossPay);
        System.out.println("Income Tax: €" + incomeTax);
        System.out.println("PRSI: €" + prsi);
        System.out.println("USC: €" + usc);
        System.out.println("Health Insurance: €" + healthInsurance);
        System.out.println("Union Fee: €" + unionFee);
        System.out.println("Total Deductions: €" + totalDeductions);
        System.out.println("Net Pay: €" + (grossPay - totalDeductions));
        System.out.println("================");
    }
}

