package DataObjects;
import Entities.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    
    private List<Employee> list = new ArrayList<>();

    public void addEmployee(Employee e) {
        list.add(e);
    }

    public List<Employee> getEmployees() {
        return list;
    }

    public Employee getEmployeeById(String id) {
        for (Employee e : list) {
            if (e.getId().equalsIgnoreCase(id)) return e;
        }
        return null;
    }

    public void removeEmployee(Employee e) {
        list.remove(e);
    }
}