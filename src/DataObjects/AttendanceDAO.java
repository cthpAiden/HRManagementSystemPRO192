package DataObjects;
import Entities.Attendance;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceDAO {
    private List<Attendance> list = new ArrayList<>();

    public void addAttendance(Attendance a) {
        list.add(a);
    }

    public List<Attendance> getAttendanceByEmployee(String empId) {
        
        List<Attendance> result = new ArrayList<>();
        for (Attendance a : list) {
            if (a.getEmployeeId().equalsIgnoreCase(empId)) {
                result.add(a);
            }
        }
        return result;
    }

    public boolean isAttendanceExists(String empId, LocalDate date) {
        for (Attendance a : list) {
            if (a.getEmployeeId().equalsIgnoreCase(empId) && a.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }
}