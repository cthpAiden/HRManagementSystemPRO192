package BusinessObject;
import DataObjects.AttendanceDAO;
import DataObjects.EmployeeDAO;
import Entities.Attendance;
import Entities.Employee;
import Utilities.DataInput;
import Utilities.Menu;
import java.util.List;

public class SalaryManagement {
    EmployeeDAO empDAO;
    AttendanceDAO attDAO;

    public SalaryManagement(EmployeeDAO empDAO, AttendanceDAO attDAO) {
        this.empDAO = empDAO;
        this.attDAO = attDAO;
    }

    public void process() {
        while(true) {
            Menu.print("\n--- SALARY ---|1. Calculate|2. Back");
            if (DataInput.getInteger("") == 1) calculate();
            else break;
        }
    }

    public void calculate() {
        String id = DataInput.getString("Emp ID: ");
        Employee e = empDAO.getEmployeeById(id);
        if (e == null) { System.out.println("Not found!"); return; }

        int month = DataInput.getInteger("Month: ");
        
        List<Attendance> list = attDAO.getAttendanceByEmployee(id);
        double totalOT = 0;
        int absentCount = 0;

        for (Attendance a : list) {
            if (a.getDate().getMonthValue() == month) {
                totalOT += a.getOvertimeHours();
                
                if (a.getStatus().equalsIgnoreCase("Inactive")) {
                    absentCount++;
                }
            }
        }

        
        double otRate = e.isFullTime() ? 80000 : 50000;
        double salary = e.getBasicSalary() + (totalOT * otRate) - (absentCount * 100000);

        System.out.println("--- RESULT ---");
        System.out.println("Basic: " + e.getBasicSalary());
        System.out.println("OT Pay: " + (totalOT * otRate));
        System.out.println("Deduct: -" + (absentCount * 100000));
        System.out.println("TOTAL: " + salary);
    }
}