import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.lakeev.companyandstaff.company.Company;
import ru.lakeev.companyandstaff.staff.Manager;
import ru.lakeev.companyandstaff.staff.StaffFactory;
import ru.lakeev.companyandstaff.staff.parent.Employee;

@DisplayName("Тест класса ru.lakeev.companyandstaff.staff.Manager.java")
public class ManagerTest {

  private Employee testManager;
  private Company company;
  private BigDecimal bonusPersent;

  @BeforeEach
  public void setUp() {

    testManager = StaffFactory.createAndGetEmployee(Manager.class.getSimpleName());
    company = new Company();
    bonusPersent = BigDecimal.valueOf(5);
    company.hire(testManager);
  }

  @Test
  @DisplayName("Тест метода getMonthSalary.")
  void getMonthSalaryTest() {
    BigDecimal expected = testManager.getSalary().add(testManager.getManagerProfit()
        .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP).multiply(bonusPersent));
    assertEquals(expected.doubleValue(), testManager.getMonthSalary(),
        "Месячная зарплата не равна сумме фиксированной ставки и бонуса от суммы продаж.");
  }
}
