package BusinessObject;
import DataObjects.AttendanceDAO;
import DataObjects.EmployeeDAO;
import Entities.Attendance;
import Utilities.DataInput;
import Utilities.Menu;
import java.time.LocalDate;

public class AttendanceManagement {
    AttendanceDAO attDAO;
    EmployeeDAO empDAO;

    public AttendanceManagement(AttendanceDAO attDAO, EmployeeDAO empDAO) {
        this.attDAO = attDAO;
        this.empDAO = empDAO;
    }

    public void process() {
        while (true) {
            Menu.print("\n--- ATTENDANCE ---|1. Record|2. View History|3. Back");
            int choice = DataInput.getInteger("");
            if (choice == 1) record();
            else if (choice == 2) view();
            else break;
        }
    }

    public void record() {
        String id = DataInput.getString("Emp ID: ");
        if (empDAO.getEmployeeById(id) == null) {
            System.out.println("Employee not found!");
            return;
        }

        LocalDate date = DataInput.getDate("Date (dd/MM/yyyy): ");
        if (attDAO.isAttendanceExists(id, date)) {
            System.out.println("Already recorded for this day!");
            return;
        }

        String status = "";
        while(true) {
            status = DataInput.getString("Status (Active/Inactive): ");
            if (status.equalsIgnoreCase("Active") || status.equalsIgnoreCase("Inactive")) break;
            System.out.println("Only Active or Inactive!");
        }

        double ot = DataInput.getDouble("Overtime Hours: ");
        
        attDAO.addAttendance(new Attendance(id, date, status, ot));
        System.out.println("Recorded.");
    }

    public void view() {
        String id = DataInput.getString("Emp ID to view: ");
        for (Attendance a : attDAO.getAttendanceByEmployee(id)) {
            System.out.println(a);
        }
    }
}