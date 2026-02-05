package BusinessObject;
import DataObjects.AttendanceDAO;
import DataObjects.EmployeeDAO;
import Utilities.DataInput;
import Utilities.Menu;

public class Program {
    public static void main(String[] args) {
        
        EmployeeDAO empDAO = new EmployeeDAO();
        AttendanceDAO attDAO = new AttendanceDAO();
      
        EmployeeManagement em = new EmployeeManagement(empDAO);
        AttendanceManagement am = new AttendanceManagement(attDAO, empDAO);
        SalaryManagement sm = new SalaryManagement(empDAO, attDAO);

        while (true) {
            System.out.println("\n========== HR Management System ==========");
            Menu.print("1. Employee|2. Attendance|3. Salary|4. Exit");
            int choice = DataInput.getInteger("");
            
            if (choice == 1) em.process();
            else if (choice == 2) am.process();
            else if (choice == 3) sm.process();
            else {
                System.out.println("Bye!");
                System.exit(0);
            }
        }
    }
}