
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.lakeev.companyandstaff.company.Company;
import ru.lakeev.companyandstaff.staff.Manager;
import ru.lakeev.companyandstaff.staff.Operator;
import ru.lakeev.companyandstaff.staff.StaffFactory;
import ru.lakeev.companyandstaff.staff.TopManager;
import ru.lakeev.companyandstaff.staff.parent.CompanyEmployee;
import ru.lakeev.companyandstaff.staff.parent.Employee;

@DisplayName("Тест класса ru.lakeev.companyandstaff.staff.StaffFactory.java")
public class StaffFactoryTest {

  private static final int EMPLOYEES_COUNT = 15;

  @Test
  @DisplayName("Тест метода createAndGetEmployee, создание Operator")
  void testCreateAndGetOperator() {
    Employee employee = StaffFactory.createAndGetEmployee(Operator.class.getSimpleName());
    assertEquals(employee.getClass().getSimpleName(), Operator.class.getSimpleName(),
        "Полученная сущность не объект класса Operator");
    assertTrue(employee instanceof Operator,
        "Полученная сущность не объект класса Operator");
    assertNotNull(employee.getFullName(), "Не заполнено имя.");
    assertNotNull(employee.getCategory(), "Не заполнена должность.");
    assertNotNull(employee.getGender(), "Не заполнен гендер.");
    assertNotNull(employee.getSalary(), "Не заполнена зарплата.");
  }

  @Test
  @DisplayName("Тест метода createAndGetEmployee, создание Manager")
  void testCreateAndGetManager() {
    Employee employee = StaffFactory.createAndGetEmployee(Manager.class.getSimpleName());
    assertEquals(employee.getClass().getSimpleName(), Manager.class.getSimpleName(),
        "Полученная сущность не объект класса Manager");
    assertTrue(employee instanceof Manager,
        "Полученная сущность не объект класса Manager");
    assertNotNull(employee.getFullName(), "Не заполнено имя.");
    assertNotNull(employee.getCategory(), "Не заполнена должность.");
    assertNotNull(employee.getGender(), "Не заполнен гендер.");
    assertNotNull(employee.getSalary(), "Не заполнена зарплата.");
  }

  @Test
  @DisplayName("Тест метода createAndGetEmployee, создание TopManager")
  void testCreateAndGetTopManager() {
    Employee employee = StaffFactory.createAndGetEmployee(TopManager.class.getSimpleName());
    assertEquals(employee.getClass().getSimpleName(), TopManager.class.getSimpleName(),
        "Полученная сущность не объект класса TopManager.");
    assertTrue(employee instanceof TopManager,
        "Полученная сущность не объект класса TopManager.");
    assertNotNull(employee.getFullName(), "Не заполнено имя.");
    assertNotNull(employee.getCategory(), "Не заполнена должность.");
    assertNotNull(employee.getGender(), "Не заполнен гендер.");
    assertNotNull(employee.getSalary(), "Не заполнена зарплата.");
  }

  @Test
  @DisplayName("Тест метода createAndGetEmployee, создание некорректного класса")
  void testCreateAndGetCompanyEmployee() {

    assertThrows(IllegalArgumentException.class,
        () -> StaffFactory.createAndGetEmployee(Company.class.getSimpleName()),
        "Обработан некорректный аргумент");
  }

  @Test
  @DisplayName("Тест метода createAndGetEmployeeList, создание списка Operator")
  void testCreateAndGetCompanyOperatorsList() {

    boolean allEmployeesIsInstanceOfOperator = true;
    boolean allRequiredFieldsFilled = true;
    List<Employee> employees = StaffFactory
        .createAndGetEmployeeList(Operator.class.getSimpleName(), EMPLOYEES_COUNT);
    for (Employee employee : employees) {
      if (!(employee instanceof Operator)) {
        allEmployeesIsInstanceOfOperator = false;
        break;
      } else if (employee.getFullName() == null || employee.getCategory() == null
          || employee.getGender() == null || employee.getSalary() == null) {
        allRequiredFieldsFilled = false;
        break;
      }
    }
    assertTrue(allEmployeesIsInstanceOfOperator, "Не все employee являются операторами.");
    assertTrue(allRequiredFieldsFilled, "Не у всех объектов заполненны обязательные поля.");
    assertEquals(employees.size(), EMPLOYEES_COUNT, String
        .format("Список не соответствует заданной длинне: %d", EMPLOYEES_COUNT));
  }

  @Test
  @DisplayName("Тест метода createAndGetEmployeeList, создание списка Manager")
  void testCreateAndGetCompanyManagersList() {

    boolean allEmployeesIsInstanceOfManager = true;
    boolean allRequiredFieldsFilled = true;
    List<Employee> employees = StaffFactory
        .createAndGetEmployeeList(Manager.class.getSimpleName(), EMPLOYEES_COUNT);
    for (Employee employee : employees) {
      if (!(employee instanceof Manager)) {
        allEmployeesIsInstanceOfManager = false;
        break;
      } else if (employee.getFullName() == null || employee.getCategory() == null
          || employee.getGender() == null || employee.getSalary() == null) {
        allRequiredFieldsFilled = false;
        break;
      }
    }
    assertTrue(allEmployeesIsInstanceOfManager, "Не все employee являются менеджерами.");
    assertTrue(allRequiredFieldsFilled, "Не у всех объектов заполненны обязательные поля.");
    assertEquals(employees.size(), EMPLOYEES_COUNT, String
        .format("Список не соответствует заданной длинне: %d", EMPLOYEES_COUNT));
  }

  @Test
  @DisplayName("Тест метода createAndGetEmployeeList, создание списка TopManager")
  void testCreateAndGetCompanyTopManagersList() {

    boolean allEmployeesIsInstanceOfTopManager = true;
    boolean allRequiredFieldsFilled = true;
    List<Employee> employees = StaffFactory
        .createAndGetEmployeeList(TopManager.class.getSimpleName(), EMPLOYEES_COUNT);
    for (Employee employee : employees) {
      if (!(employee instanceof TopManager)) {
        allEmployeesIsInstanceOfTopManager = false;
        break;
      } else if (employee.getFullName() == null || employee.getCategory() == null
          || employee.getGender() == null || employee.getSalary() == null) {
        allRequiredFieldsFilled = false;
        break;
      }
    }
    assertTrue(allEmployeesIsInstanceOfTopManager, "Не все employee являются топ-менеджерами.");
    assertTrue(allRequiredFieldsFilled, "Не у всех объектов заполненны обязательные поля.");
    assertEquals(employees.size(), EMPLOYEES_COUNT, String
        .format("Список не соответствует заданной длинне: %d", EMPLOYEES_COUNT));
  }

  @Test
  @DisplayName("Тест метода createAndGetEmployeeList, создание списка CompanyEmployee")
  void testCreateAndGetCompanyEmployeeList() {

    assertThrows(IllegalArgumentException.class, () -> StaffFactory
            .createAndGetEmployeeList(CompanyEmployee.class.getSimpleName(), EMPLOYEES_COUNT),
        "Обработан некорректный аргумент");
  }
}
