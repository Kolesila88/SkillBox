package ru.lakeev.companyandstaff;

import java.util.ArrayList;
import java.util.List;
import ru.lakeev.companyandstaff.company.Company;
import ru.lakeev.companyandstaff.random.ValuesGenerator;
import ru.lakeev.companyandstaff.staff.Manager;
import ru.lakeev.companyandstaff.staff.Operator;
import ru.lakeev.companyandstaff.staff.StaffFactory;
import ru.lakeev.companyandstaff.staff.TopManager;
import ru.lakeev.companyandstaff.staff.parent.Employee;

public class Main {


  public static void main(String[] args) {

    try {

      Company company = new Company();
      ArrayList<Employee> list = new ArrayList<>();

      Employee topManager = StaffFactory.createAndGetEmployee(TopManager.class.getSimpleName());
      company.hire(topManager);
      Employee operator1 = StaffFactory.createAndGetEmployee(Operator.class.getSimpleName());
      company.hire(operator1);
      Employee manager1 = StaffFactory.createAndGetEmployee(Manager.class.getSimpleName());
      company.hire(manager1);

      list.addAll(StaffFactory
          .createAndGetEmployeeList(Operator.class.getSimpleName(), 179));
      list.addAll(StaffFactory
          .createAndGetEmployeeList(Manager.class.getSimpleName(), 79));
      list.addAll(StaffFactory
          .createAndGetEmployeeList(TopManager.class.getSimpleName(), 9));
      company.hireAll(list);

      printEmployeeList(company);
      printEmployeeTopSalaryList(company, 15);
      printEmployeeLowestSalaryList(company, 30);
      printSortEmployeeList(company);

      List<Employee> employees = new ArrayList<>(company.getStaff());
      int listSizeBefore = company.getStaff().size();
      while (true) {
        int employeeIndex = ValuesGenerator
            .getInstance()
            .nextInt(employees.size() - 1);
        if (company.getStaff().contains(employees.get(employeeIndex))) {
          company.fire(employees.get(employeeIndex));
        }
        if (company.getStaff().size() == listSizeBefore / 2) {
          break;
        }
      }
      printSortEmployeeList(company);
      printEmployeeTopSalaryList(company, 15);
      printEmployeeLowestSalaryList(company, 30);
    } catch (Exception e) {

      System.err.println(e.getMessage());
    }
  }

  private static void printSortEmployeeList(Company company) {

    StringBuilder report = new StringBuilder("Отсортированный по зарплатам список сотрудников:");
    report.append(System.lineSeparator());
    int lineNumber = 1;
    for (Employee employee : company.getSortedEmployeeList()) {
      report.append("\t#")
          .append(lineNumber++)
          .append(" ")
          .append(employee.toString())
          .append(System.lineSeparator());
    }
    System.out.println(report.toString());
  }

  private static void printEmployeeList(Company company) {

    StringBuilder report = new StringBuilder("Неотсортированный список сотрудников:");
    report.append(System.lineSeparator());
    int lineNumber = 1;
    for (Employee employee : company.getStaff()) {
      report.append("\t#")
          .append(lineNumber++)
          .append(" ")
          .append(employee.toString())
          .append(System.lineSeparator());
    }
    System.out.println(report.toString());
  }

  private static void printEmployeeLowestSalaryList(Company company, int count) {

    StringBuilder report = new StringBuilder(String
        .format("%d самых низко оплачивемых сотрудников:", count));
    report.append(System.lineSeparator());
    int lineNumber = 1;
    for (Employee employee : company.getLowestSalaryStaff(count)) {
      report.append("\t#")
          .append(lineNumber++)
          .append(" ")
          .append(employee.toString())
          .append(System.lineSeparator());
    }
    System.out.println(report.toString());
  }

  private static void printEmployeeTopSalaryList(Company company, int count) {

    StringBuilder report = new StringBuilder(String
        .format("%d самых высоко оплачиваемых сотрудников:", count));
    report.append(System.lineSeparator());
    int lineNumber = 1;
    for (Employee employee : company.getTopSalaryStaff(count)) {
      report.append("\t#")
          .append(lineNumber++)
          .append(" ")
          .append(employee.toString())
          .append(System.lineSeparator());
    }
    System.out.println(report.toString());
  }
}
