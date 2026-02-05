package Entities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {  
    private String id;
    private String name;
    private String department;
    private String jobTitle;
    private LocalDate joiningDate;
    private double basicSalary;
    private boolean isFullTime; 
    
    public Employee(String id, String name, String department, String jobTitle, 
                    LocalDate joiningDate, double basicSalary, boolean isFullTime) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.jobTitle = jobTitle;
        this.joiningDate = joiningDate;
        this.basicSalary = basicSalary;
        this.isFullTime = isFullTime;
    }
   
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
  
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public LocalDate getJoiningDate() { return joiningDate; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double salary) { this.basicSalary = salary; }

    public boolean isFullTime() { return isFullTime; }
    public void setFullTime(boolean isFullTime) { this.isFullTime = isFullTime; }

    @Override
    public String toString(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        String type = isFullTime ? "Full-Time" : "Part-Time";
        return String.format("%-8s | %-20s | %-10s | %-12s | %-10.0f | %s",
                id, name, department, joiningDate.format(fmt), basicSalary, type);
    }
}