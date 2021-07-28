
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {

  private static final String STAFF_TXT = "data/staff.txt";

  public static void main(String[] args) {

    List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
    Optional<Employee> employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
    employeeMaxSalary.ifPresent(System.out::println);
  }

  public static Optional<Employee> findEmployeeWithHighestSalary(List<Employee> staff, int year) {

    return staff.stream()
        .filter(e -> e.getWorkStart().getYear() == year)
        .max(Comparator.comparing(Employee::getSalary));
  }
}