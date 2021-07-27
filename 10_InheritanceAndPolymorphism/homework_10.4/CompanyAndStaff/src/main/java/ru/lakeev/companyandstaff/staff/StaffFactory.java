package ru.lakeev.companyandstaff.staff;

import java.util.ArrayList;
import java.util.List;
import ru.lakeev.companyandstaff.staff.parent.Employee;

public class StaffFactory {

  private static final String EMPLOYEE_CATEGORY_EXP =
      "A non-existing employee category was transferred.";

  public static Employee createAndGetEmployee(String employeeCategory) {

    switch (employeeCategory) {

      case "Operator":
        return Operator.getNewInstance();

      case "Manager":
        return Manager.getNewInstance();

      case "TopManager":
        return TopManager.getNewInstance();

      default:

        throw new IllegalArgumentException(EMPLOYEE_CATEGORY_EXP);
    }
  }

  public static List<Employee> createAndGetEmployeeList(String employeeCategory,
      int employeeCount) {

    List<Employee> employees = new ArrayList<>();
    switch (employeeCategory) {

      case "Operator":
        for (int i = 0; i < employeeCount; i++) {
          employees.add(Operator.getNewInstance());
        }
        return employees;

      case "Manager":
        for (int i = 0; i < employeeCount; i++) {
          employees.add(Manager.getNewInstance());
        }
        return employees;

      case "TopManager":
        for (int i = 0; i < employeeCount; i++) {
          employees.add(TopManager.getNewInstance());
        }
        return employees;

      default:

        throw new IllegalArgumentException(EMPLOYEE_CATEGORY_EXP);
    }
  }
}
