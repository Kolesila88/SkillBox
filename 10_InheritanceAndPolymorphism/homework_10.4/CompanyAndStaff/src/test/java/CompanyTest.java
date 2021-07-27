import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.lakeev.companyandstaff.company.Company;
import ru.lakeev.companyandstaff.random.ValuesGenerator;
import ru.lakeev.companyandstaff.staff.Manager;
import ru.lakeev.companyandstaff.staff.Operator;
import ru.lakeev.companyandstaff.staff.StaffFactory;
import ru.lakeev.companyandstaff.staff.TopManager;
import ru.lakeev.companyandstaff.staff.parent.Employee;

@DisplayName("Тест класса ru.lakeev.companyandstaff.company.Company.java")
public class CompanyTest {

  private Company testCompany;
  private List<Employee> hiredEmployees;

  @BeforeEach
  public void setUp() {
    testCompany = new Company();
    hiredEmployees = new ArrayList<>();
    hiredEmployees.addAll(StaffFactory
        .createAndGetEmployeeList(Operator.class.getSimpleName(), 100));
    hiredEmployees.addAll(StaffFactory
        .createAndGetEmployeeList(Manager.class.getSimpleName(), 50));
    hiredEmployees.addAll(StaffFactory
        .createAndGetEmployeeList(TopManager.class.getSimpleName(), 5));
  }

  @Test
  @DisplayName("Тест метода getStaff, запрос пустого списка сотрудников.")
  void getEmptyStaffSet() {
    assertEquals(0, testCompany.getStaff().size(),
        "Размер полученного множества не равен 0.");
    assertTrue(testCompany.getStaff().isEmpty(), "В ответ получено не пустое множество.");
  }

  @Test
  @DisplayName("Тест метода getStaff, запрос списка сотрудников.")
  void getStaffSet() {
    testCompany.hireAll(hiredEmployees);
    assertEquals(hiredEmployees.size(), testCompany.getStaff().size(),
        String.format("Размер полученного множества не равен %d.", hiredEmployees.size()));
    boolean allEmployeesContainsInStaff = true;
    for (Employee employee : hiredEmployees) {
      if (!testCompany.getStaff().contains(employee)) {
        allEmployeesContainsInStaff = false;
        break;
      }
    }
    assertTrue(allEmployeesContainsInStaff, "Не все сотрудники сохранены в множестве.");
    List<Employee> hiredEmployeesNumTwo =
        StaffFactory.createAndGetEmployeeList(Operator.class.getSimpleName(), 10);
    testCompany.hireAll(hiredEmployeesNumTwo);
    assertEquals(hiredEmployees.size() + hiredEmployeesNumTwo.size(),
        testCompany.getStaff().size(), String.format("Размер полученного множества не равен %d.",
            hiredEmployees.size() + hiredEmployeesNumTwo.size()));
    for (Employee employee : hiredEmployeesNumTwo) {
      if (!testCompany.getStaff().contains(employee)) {
        allEmployeesContainsInStaff = false;
        break;
      }
    }
    assertTrue(allEmployeesContainsInStaff, "Не все сотрудники сохранены в множестве.");
  }

  @Test
  @DisplayName("Тест метода hire, найм Manager.")
  void hireManager() {
    testCompany.hireAll(hiredEmployees);
    int employeesCount = testCompany.getStaff().size();
    Employee employee = StaffFactory.createAndGetEmployee(Manager.class.getSimpleName());
    testCompany.hire(employee);
    assertEquals(employeesCount + 1, testCompany.getStaff().size(),
        String.format("Размер полученного множества не равен %d.", employeesCount + 1));
    assertTrue(testCompany.getStaff().contains(employee), employee.toString()
        .concat(" - нет в множестве сотрудников компании."));
    assertTrue(employee.getId() != 0, "Сотруднику не присвоен id.");
    assertNotNull(employee.getCompany(), "Не установлена компания.");
  }

  @Test
  @DisplayName("Тест метода hire, найм Operator.")
  void hireOperator() {
    testCompany.hireAll(hiredEmployees);
    int employeesCount = testCompany.getStaff().size();
    Employee employee = StaffFactory.createAndGetEmployee(Operator.class.getSimpleName());
    testCompany.hire(employee);
    assertEquals(employeesCount + 1, testCompany.getStaff().size(),
        String.format("Размер полученного множества не равен %d.", employeesCount + 1));
    assertTrue(testCompany.getStaff().contains(employee), employee.toString()
        .concat(" - нет в множестве сотрудников компании."));
    assertTrue(employee.getId() != 0, "Сотруднику не присвоен id.");
    assertNotNull(employee.getCompany(), "Не установлена компания.");
  }

  @Test
  @DisplayName("Тест метода hire, найм TopManager.")
  void hireTopManager() {
    testCompany.hireAll(hiredEmployees);
    int employeesCount = testCompany.getStaff().size();
    Employee employee = StaffFactory.createAndGetEmployee(TopManager.class.getSimpleName());
    testCompany.hire(employee);
    assertEquals(employeesCount + 1, testCompany.getStaff().size(),
        String.format("Размер полученного множества не равен %d.", employeesCount + 1));
    assertTrue(testCompany.getStaff().contains(employee), employee.toString()
        .concat(" - нет в множестве сотрудников компании."));
    assertTrue(employee.getId() != 0, "Сотруднику не присвоен id.");
    assertNotNull(employee.getCompany(), "Не установлена компания.");
  }

  @Test
  @DisplayName("Тест метода hireAll.")
  void hireAll() {

    testCompany.hireAll(hiredEmployees);
    assertEquals(hiredEmployees.size(), testCompany.getStaff().size(),
        "Множество не ожидаемого размера.");
    for (Employee employee : hiredEmployees) {
      assertTrue(testCompany.getStaff().contains(employee),
          employee.toString().concat(" - не в множестве сотрутников компании."));
      assertTrue(employee.getId() != 0, employee.toString().concat(" - не присвоен id."));
      assertNotNull(employee.getCompany(), employee.toString()
          .concat(" - не установлено место работы."));
    }
  }

  @Test
  @DisplayName("Тест метода fire, увольнение из пустого списка.")
  void fireFromEmptySet() {

    int staffSizeBefore = testCompany.getStaff().size();
    Employee employee = StaffFactory.createAndGetEmployee(Manager.class.getSimpleName());
    testCompany.fire(employee);
    assertEquals(staffSizeBefore, testCompany.getStaff().size(),
        "Сотрудник был удален из пустого множества.");
  }

  @Test
  @DisplayName("Тест метода fire, увольнение не нанятого сотрудника.")
  void fireNotHiredEmployee() {

    testCompany.hireAll(hiredEmployees);
    int staffSizeBefore = testCompany.getStaff().size();
    Employee employee = StaffFactory.createAndGetEmployee(Manager.class.getSimpleName());
    assertThrows(IllegalArgumentException.class, () -> testCompany.fire(employee),
        "Был уволен не нанятый сотрудник.");
    assertEquals(staffSizeBefore, testCompany.getStaff().size(),
        "Размер множества изменился полсе некорректного увольнения не нанятого сотрудника.");
  }

  @Test
  @DisplayName("Тест метода fire, корректное увольнение.")
  void fireEmployee() {

    testCompany.hireAll(hiredEmployees);
    int staffSizeBefore = testCompany.getStaff().size();
    Employee employee =
        hiredEmployees.get(ValuesGenerator.getInstance().nextInt(hiredEmployees.size()));
    testCompany.fire(employee);
    assertEquals(staffSizeBefore - 1, testCompany.getStaff().size(),
        "Размер множества не корректен полсе увольнения сотрудника.");
    assertFalse(testCompany.getStaff().contains(employee),
        "Уволенный сотрудник все еще в множестве сотрудников компании.");
  }

  @Test
  @DisplayName("Тест метода getIncome, проверка корректности расчета прибыли компании.")
  void getCompanyIncome() {

    BigDecimal managerProfitSum = BigDecimal.ZERO;
    assertEquals(managerProfitSum.doubleValue(), testCompany.getIncome().doubleValue(),
        "Доход компании не равен нулю при отсутствии Manager в штате.");
    testCompany.hireAll(hiredEmployees);
    for (Employee employee : testCompany.getStaff()) {
      if (employee instanceof Manager) {
        managerProfitSum = managerProfitSum.add(employee.getManagerProfit());
      }
    }
    assertEquals(managerProfitSum.doubleValue(), testCompany.getIncome().doubleValue(),
        "Доход компании не равен сумме профита менеджеров.");
  }

  @Test
  @DisplayName(
      "Тест метода getIncome, проверка корректности расчета прибыли компании после найма менеджера.")
  void getCompanyIncomeAfterHiringManager() {

    testCompany.hireAll(hiredEmployees);
    BigDecimal managerProfitSum = BigDecimal.ZERO;
    for (Employee employee : testCompany.getStaff()) {
      if (employee instanceof Manager) {
        managerProfitSum = managerProfitSum.add(employee.getManagerProfit());
      }
    }
    Employee employee = StaffFactory.createAndGetEmployee(Manager.class.getSimpleName());
    testCompany.hire(employee);
    assertEquals(managerProfitSum.add(employee.getManagerProfit()).doubleValue(),
        testCompany.getIncome().doubleValue(),
        "Актуальный доход не равен сумме дохода до найма и профита нанятого менеджера.");
  }

  @Test
  @DisplayName(
      "Тест метода getIncome, проверка корректности расчета прибыли компании после увольнения менеджера.")
  void getCompanyIncomeAfterManagerWasFired() {

    testCompany.hireAll(hiredEmployees);
    BigDecimal managerProfitSum = BigDecimal.ZERO;
    for (Employee employee : testCompany.getStaff()) {
      if (employee instanceof Manager) {
        managerProfitSum = managerProfitSum.add(employee.getManagerProfit());
      }
    }
    Employee firedEmployee = null;
    for (Employee employee : testCompany.getStaff()) {
      if (employee instanceof Manager) {
        firedEmployee = employee;
        testCompany.fire(employee);
        break;
      }
    }

    assertNotNull(firedEmployee, "Никто не был уволен.");
    assertEquals(managerProfitSum.subtract(firedEmployee.getManagerProfit()).doubleValue(),
        testCompany.getIncome().doubleValue(),
        "Актуальный доход не равен сумме дохода до найма и профита нанятого менеджера.");
  }

  @Test
  @DisplayName(
      "Тест метода getIncome, проверка корректности расчета прибыли компании после найма или увольнения сотрудников не приносящих компании прямой прибыли.")
  void getCompanyIncomeAfterHiredOrFiredUnprofitableEmployees() {

    testCompany.hireAll(hiredEmployees);
    BigDecimal managerProfitSum = BigDecimal.ZERO;
    for (Employee employee : testCompany.getStaff()) {
      if (employee instanceof Manager) {
        managerProfitSum = managerProfitSum.add(employee.getManagerProfit());
      }
    }
    testCompany.hireAll(StaffFactory
        .createAndGetEmployeeList(Operator.class.getSimpleName(), 20));
    assertEquals(managerProfitSum.doubleValue(), testCompany.getIncome().doubleValue(),
        "Доход компанни изменился после найма операторов.");
    testCompany.hireAll(StaffFactory
        .createAndGetEmployeeList(TopManager.class.getSimpleName(), 2));
    assertEquals(managerProfitSum.doubleValue(), testCompany.getIncome().doubleValue(),
        "Доход компанни изменился после найма топ-менеджеров.");
    for (Employee employee : testCompany.getStaff()) {
      if (employee instanceof Operator) {
        testCompany.fire(employee);
        break;
      }
    }
    assertEquals(managerProfitSum.doubleValue(), testCompany.getIncome().doubleValue(),
        "Доход компанни изменился после увольнения оператора.");
    for (Employee employee : testCompany.getStaff()) {
      if (employee instanceof TopManager) {
        testCompany.fire(employee);
        break;
      }
    }
    assertEquals(managerProfitSum.doubleValue(), testCompany.getIncome().doubleValue(),
        "Доход компанни изменился после увольнения топ-менеджера.");
  }

  @Test
  @DisplayName(
      "Тест метода getSortedEmployeeList, получаем отсортированный по getMonthSalary список Employee.")
  void getSortedListCompanyEmployees() {

    testCompany.hireAll(hiredEmployees);
    List<Employee> companyEmployeesSortedList = testCompany.getSortedEmployeeList();
    boolean isSortedList = true;
    for (int i = 0; i < companyEmployeesSortedList.size() - 1; i++) {
      if (companyEmployeesSortedList.get(i).getMonthSalary() >
          companyEmployeesSortedList.get(i + 1).getMonthSalary()) {
        isSortedList = false;
        break;
      }
    }
    assertTrue(isSortedList, "Список не осортирован!");
  }

  @Test
  @DisplayName(
      "Тест метода getSortedEmployeeList, получаем пустой список.")
  void getEmptySortedListCompanyEmployees() {

    assertTrue(testCompany.getSortedEmployeeList().isEmpty(), "Получен не пустой список.");
  }

  @Test
  @DisplayName(
      "Тест метода getTopSalaryStaff, получаем первые 25 позицый.")
  void getTopSalaryStaff() {

    testCompany.hireAll(hiredEmployees);
    int positionCount = 25;
    List<Employee> topSalaryList = testCompany.getTopSalaryStaff(positionCount);
    assertEquals(positionCount, topSalaryList.size(), "Размер списка отличается от заданного.");

    boolean isSorted = true;
    for (int i = 0; i < topSalaryList.size() - 1; i++) {
      if (topSalaryList.get(i).getMonthSalary() < topSalaryList.get(i + 1).getMonthSalary()) {
        isSorted = false;
      }
    }
    assertTrue(isSorted, "Список не отсортирован.");

    boolean isTopSalary = true;
    for (Employee employee : topSalaryList) {
      for (Employee checkEmployee : testCompany.getStaff()) {
        if (checkEmployee.getMonthSalary() > employee.getMonthSalary()
              && !topSalaryList.contains(checkEmployee)) {
          isTopSalary = false;
        }
      }
    }
    assertTrue(isTopSalary, "В список попали не топ зарплаты.");
  }

  @Test
  @DisplayName(
      "Тест метода getLowestSalaryStaff, получаем первые 25 позицый.")
  void getLowestSalaryStaff() {
    testCompany.hireAll(hiredEmployees);
    int positionCount = 25;
    List<Employee> lowSalaryList = testCompany.getLowestSalaryStaff(positionCount);
    assertEquals(positionCount, lowSalaryList.size(), "Размер списка отличается от заданного.");

    boolean isSorted = true;
    for (int i = 0; i < lowSalaryList.size() - 1; i++) {
      if (lowSalaryList.get(i).getMonthSalary() > lowSalaryList.get(i + 1).getMonthSalary()) {
        isSorted = false;
      }
    }
    assertTrue(isSorted, "Список не отсортирован.");

    boolean isLowSalary = true;
    for (Employee employee : lowSalaryList) {
      for (Employee checkEmployee : testCompany.getStaff()) {
        if (checkEmployee.getMonthSalary() < employee.getMonthSalary()
            && !lowSalaryList.contains(checkEmployee)) {
          isLowSalary = false;
        }
      }
    }
    assertTrue(isLowSalary, "В список попали не топ зарплаты.");
  }
}
