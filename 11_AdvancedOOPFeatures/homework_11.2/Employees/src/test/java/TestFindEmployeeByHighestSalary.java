import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Поиск сотрудника с максимальной зарплатой среди тех, кто пришёл в 2017 году ")
public class TestFindEmployeeByHighestSalary {

  @Test
  @DisplayName("Входные данные - staff.txt ")
  void getEmployee() throws ParseException {
    List<Employee> staff = Employee.loadStaffFromFile("data/staff.txt");
    LocalDate date = LocalDate.of(2017, 01, 31);
    Employee expectedEmployee = new Employee("Дмитрий Кочергин", 140000, date);
    Optional<Employee> actualEmployee = Main.findEmployeeWithHighestSalary(staff, 2017);
    assertEquals(expectedEmployee, actualEmployee.get());
  }

}
