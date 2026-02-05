package Entities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Attendance {
    private String employeeId;
    private LocalDate date;
    private String status;
    private double overtimeHours;

    public Attendance(String employeeId, LocalDate date, String status, double overtimeHours) {
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
        this.overtimeHours = overtimeHours;
    }

    public String getEmployeeId() { return employeeId; }
    public LocalDate getDate() { return date; }
    public String getStatus() { return status; }
    public double getOvertimeHours() { return overtimeHours; }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%s | %s | %-10s | OT: %.1f", employeeId, date.format(fmt), status, overtimeHours);
    }
}