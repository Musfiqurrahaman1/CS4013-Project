public class Employee {
    private String employeeID;
    private String name;
    private String position;
    private double salary;
    private int yearsWorked;
    private double hourlyRate;
    private int hoursWorked;

    // Constructor
    public Employee(String employeeID, String name, String position, double salary, int yearsWorked, double hourlyRate, int hoursWorked) {
        this.employeeID = employeeID;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.yearsWorked = yearsWorked;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Getters
    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public int getYearsWorked() {
        return yearsWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    // String version of the Employee for CSV writing
    public String toCSV() {
        return employeeID + "," + name + "," + position + "," + salary + "," + yearsWorked + "," + hourlyRate + "," + hoursWorked;
    }
}
