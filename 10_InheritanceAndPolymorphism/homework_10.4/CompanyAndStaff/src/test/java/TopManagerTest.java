import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.lakeev.companyandstaff.company.Company;
import ru.lakeev.companyandstaff.staff.Manager;
import ru.lakeev.companyandstaff.staff.StaffFactory;
import ru.lakeev.companyandstaff.staff.TopManager;
import ru.lakeev.companyandstaff.staff.parent.Employee;

@DisplayName("Тест класса ru.lakeev.companyandstaff.staff.TopManager.java")
public class TopManagerTest {

  private Employee testTopManager;
  private Company company;

  @BeforeEach
  public void setUp() {

    testTopManager = StaffFactory.createAndGetEmployee(TopManager.class.getSimpleName());
    company = new Company();
    company.hire(testTopManager);
  }

  @Test
  @DisplayName("Тест метода getMonthSalary, расчет з/п при доходе компании равном 0.")
  void getMonthSalaryWhenCompanyIncomeEqualsZeroTest() {
    BigDecimal expected = testTopManager.getSalary();
    assertEquals(company.getIncome().doubleValue(), BigDecimal.ZERO.doubleValue(),
        "Доход комкании не равен 0.");
    assertEquals(expected.doubleValue(), testTopManager.getMonthSalary(),
        "Месячная зарплата не равна фиксированной ставке.");
  }

  @Test
  @DisplayName("Тест метода getMonthSalary, расчет з/п при доходе компании менее 10_000_000.")
  void getMonthSalaryWhenCompanyIncomeLessKpi() {
    BigDecimal kpi = BigDecimal.valueOf(10_000_000);
    company.hireAll(StaffFactory
        .createAndGetEmployeeList(Manager.class.getSimpleName(), 20));
    BigDecimal expected = testTopManager.getSalary();
    assertTrue(company.getIncome().doubleValue() < kpi.doubleValue()
            && company.getIncome().doubleValue() > BigDecimal.ZERO.doubleValue(),
        "Доход комкании более 10_000_000.");
    assertEquals(expected.doubleValue(), testTopManager.getMonthSalary(),
        "Месячная зарплата не равна фиксированной ставке.");
  }

  @Test
  @DisplayName("Тест метода getMonthSalary, расчет з/п при доходе компании более 10_000_000.")
  void getMonthSalaryWhenCompanyIncomeMoreKpi() {
    BigDecimal kpi = BigDecimal.valueOf(10_000_000);
    company.hireAll(StaffFactory
        .createAndGetEmployeeList(Manager.class.getSimpleName(), 100));
    BigDecimal expected = testTopManager.getSalary().add(
        testTopManager.getSalary().divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP)
            .multiply(BigDecimal.valueOf(150)));
    assertTrue(company.getIncome().doubleValue() >= kpi.doubleValue(),
        "Доход комкании менее 10_000_000.");
    assertEquals(expected.doubleValue(), testTopManager.getMonthSalary(),
        "Месячная зарплата не равна сумме фиксированной ставки и бонуса.");
  }
}
