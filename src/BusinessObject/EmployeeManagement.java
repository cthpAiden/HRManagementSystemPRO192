package BusinessObject;
import DataObjects.EmployeeDAO;
import Entities.Employee;
import Utilities.DataInput;
import Utilities.Menu;
import java.time.LocalDate;
import java.util.List;

public class EmployeeManagement {
    EmployeeDAO dao;

    public EmployeeManagement(EmployeeDAO dao) {
        this.dao = dao;
    }

    public void process() {
        while (true) {
            // Thêm chức năng Search vào menu
            Menu.print("\n--- EMPLOYEE MENU ---|1. Add|2. Update|3. Remove|4. Search|5. List|6. Back");
            int choice = DataInput.getInteger("");
            if (choice == 1) addNew();
            else if (choice == 2) update();
            else if (choice == 3) remove();
            else if (choice == 4) search(); // Gọi hàm tìm kiếm
            else if (choice == 5) list();
            else if (choice == 6) break;
        }
    }

    public void addNew() {
        System.out.println("Add New Employee:");
        String id;
        while(true) {
            id = DataInput.getString("Enter ID (Exxx): ");
            if (dao.getEmployeeById(id) != null) System.out.println("ID existed!");
            else if (!id.matches("E\\d{3}")) System.out.println("Format Exxx!");
            else break;
        }
        String name = DataInput.getString("Name: ");
        String dept = DataInput.getString("Dept: ");
        String job = DataInput.getString("Job: ");
        LocalDate date = DataInput.getDate("Join Date (dd/MM/yyyy): ");
        double salary = DataInput.getDouble("Salary: ");
        String type = DataInput.getString("Full time? (Y/N): ");
        
        Employee e = new Employee(id, name, dept, job, date, salary, type.equalsIgnoreCase("Y"));
        dao.addEmployee(e);
        System.out.println("Success!");
    }

    public void list() {
        System.out.println("LIST OF EMPLOYEES:");
        List<Employee> list = dao.getEmployees();
        if (list.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee e : list) {
                System.out.println(e);
            }
        }
    }

    public void remove() {
        String id = DataInput.getString("Enter ID to remove: ");
        Employee e = dao.getEmployeeById(id);
        if (e != null) {
            dao.removeEmployee(e);
            System.out.println("Deleted.");
        } else {
            System.out.println("Not found.");
        }
    }

    
    public void update() {
        String id = DataInput.getString("Enter ID to update: ");
        Employee e = dao.getEmployeeById(id);
        if (e == null) { System.out.println("Not found."); return; }
        
        System.out.println("Updating info for: " + e.getName());
        System.out.println("(Press Enter to keep current value)");

        // Update Name
        String name = DataInput.getString("New Name: ");
        if (!name.isEmpty()) e.setName(name);

        // Update Dept
        String dept = DataInput.getString("New Dept: ");
        if (!dept.isEmpty()) e.setDepartment(dept);

        // Update Job
        String job = DataInput.getString("New Job: ");
        if (!job.isEmpty()) e.setJobTitle(job);
        
        // Update Salary
        System.out.print("New Salary (Enter 0 to skip): ");
        try {
            String salStr = DataInput.getString(""); 
            if (!salStr.isEmpty()) {
                double salary = Double.parseDouble(salStr);
                if (salary > 0) e.setBasicSalary(salary);
            }
        } catch (Exception ex) { }

        String type = DataInput.getString("Change to FullTime? (Y/N/Enter to skip): ");
        if (!type.isEmpty()) {
            e.setFullTime(type.equalsIgnoreCase("Y"));
        }
        
        System.out.println("Updated successfully.");
    }

    public void search() {
        String name = DataInput.getString("Enter name to search: ").toLowerCase();
        boolean found = false;
        System.out.println("SEARCH RESULT:");
        
        for (Employee e : dao.getEmployees()) {
            if (e.getName().toLowerCase().contains(name)) {
                System.out.println(e);
                found = true;
            }
        }
        
        if (!found) System.out.println("No employee found with name: " + name);
    }
}