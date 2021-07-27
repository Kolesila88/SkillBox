import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.lakeev.companyandstaff.company.Company;
import ru.lakeev.companyandstaff.staff.Operator;
import ru.lakeev.companyandstaff.staff.StaffFactory;
import ru.lakeev.companyandstaff.staff.parent.Employee;

@DisplayName("Тест класса ru.lakeev.companyandstaff.staff.Operator.java")
public class OperatorTest {

  private Employee operator;
  private Company company;

  @BeforeEach
  public void setUp() {

    operator = StaffFactory.createAndGetEmployee(Operator.class.getSimpleName());
    company = new Company();
    company.hire(operator);
  }

  @Test
  @DisplayName("Тест метода getMonthSalary.")
  void getMonthSalaryTest() {
    BigDecimal expected = operator.getSalary();
    assertEquals(expected.doubleValue(), operator.getMonthSalary(),
        "Месячная зарплата не равна фиксированной ставке.");
  }
}
