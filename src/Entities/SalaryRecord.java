package Entities;
public class SalaryRecord {
    private String employeeId;
    private double totalSalary;
    private int month;
    private int year;
    
    public SalaryRecord(String employeeId, double totalSalary, int month, int year) {
        this.employeeId = employeeId;
        this.totalSalary = totalSalary;
        this.month = month;
        this.year = year;
    }
    public double getTotalSalary() { return totalSalary; }
    @Override
    public String toString() {
        return String.format("EmpID: %s | %d/%d | Total: %.0f VND", employeeId, month, year, totalSalary);
    }
}