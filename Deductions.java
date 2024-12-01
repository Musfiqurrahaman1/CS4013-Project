public class Deductions {
    private double incomeTaxRate;
    private double healthInsuranceFee;
    private double unionFee;

    // Constructor
    public Deductions(double incomeTaxRate, double healthInsuranceFee, double unionFee) {
        this.incomeTaxRate = incomeTaxRate;
        this.healthInsuranceFee = healthInsuranceFee;
        this.unionFee = unionFee;
    }

    // Calculate total deductions
    public double calculateDeductions(double grossSalary) {
        double tax = grossSalary * incomeTaxRate;
        return tax + healthInsuranceFee + unionFee;
    }
}
