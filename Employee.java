public class Employee {
    private String employeeID;
    private String name;
    private String position;
    private int yearsWorked;
    private double salary;

    // Constructor
    public Employee(String employeeID, String name, String position, int yearsWorked, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.position = position;
        this.yearsWorked = yearsWorked;
        this.salary = salary;
    }

    // Getters and Setters
    public String getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public int getYearsWorked() { return yearsWorked; }
    public double getSalary() { return salary; }

    public void setSalary(double salary) { this.salary = salary; }
}
