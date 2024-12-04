/**
 * The Deductions class calculates the total deductions on an employee's salary,
 * including income tax, health insurance fees, and union fees.
 */



public class Deductions {
    private double incomeTaxRate;
    private double healthInsuranceFee;
    private double unionFee;
    private double prsiRate;


    private double uscRate;


    /**
     * Constructor to initialize the deduction rates and fees.
     *
     * @param incomeTaxRate       The rate of income tax.
     * @param healthInsuranceFee  The fixed health insurance fee.
     * @param unionFee            The fixed union fee.
     */


    // Constructor
    public Deductions(double incomeTaxRate, double healthInsuranceFee, double unionFee, double prsiRate, double uscRate) {
        this.incomeTaxRate = incomeTaxRate;
        this.healthInsuranceFee = healthInsuranceFee;
        this.unionFee = unionFee;
        this.prsiRate = prsiRate;
        this.uscRate = uscRate;
    }




    public double calculateIncomeTax(double grossPay) {
        return grossPay * incomeTaxRate;
    }

    public double calculatePRSI(double grossPay) {             // calculates all the nessesary taxes
        return grossPay * prsiRate;
    }

    public double calculateUSC(double grossPay) {
        return grossPay * uscRate;
    }

    /**
     * Calculates the total deductions for a given gross salary.
     *
     * @param grossSalary The gross salary of the employee.
     * @return The total deductions.
     */




    public double calculateTotalDeductions(double grossPay) {
        double incomeTax = calculateIncomeTax(grossPay);
        double prsi = calculatePRSI(grossPay);
        double usc = calculateUSC(grossPay);
        return incomeTax + prsi + usc + healthInsuranceFee + unionFee;
    }

    public double getHealthInsuranceFee() {
        return healthInsuranceFee;
    }

    public double getUnionFee() {
        return unionFee;
    }
}
