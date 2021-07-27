package ru.lakeev.companyandstaff.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import ru.lakeev.companyandstaff.staff.parent.Employee;

public class Company {

  private int id = 0;
  private Set<Employee> staff;

  public Company() {

    this.staff = new HashSet<>();
  }

  public void hire(Employee employee) {

    id++;
    employee.setId(id);
    employee.setCompany(this);
    staff.add(employee);
  }

  public void hireAll(List<Employee> list) {

    for (Employee employee : list) {

      id++;
      employee.setId(id);
      employee.setCompany(this);
      staff.add(employee);
    }
  }

  public void fire(Employee employee) {


      if (staff.size() > 0) {
        if (staff.contains(employee)) {
          if (!staff.remove(employee)) {

            String msg = employee.toString().concat("- НЕ БЫЛ УДАЛЕН!");
            throw new IllegalArgumentException(msg);
          }
        } else {

          String msg = employee.toString().concat("- НЕТ В СПИСКЕ СОТРУДНИКОВ!");
          throw new IllegalArgumentException(msg);
        }
      }
  }

  public BigDecimal getIncome() {

    return BigDecimal.valueOf(
        staff.stream().filter(e -> e.getManagerProfit().doubleValue() > 0)
            .mapToDouble(e -> e.getManagerProfit().doubleValue())
            .sum());
  }

  public Set<Employee> getStaff() {

    return staff;
  }

  public List<Employee> getSortedEmployeeList() {

    return staff.stream()
        .sorted(Comparator.comparing(Employee::getMonthSalary))
        .collect(Collectors.toList());
  }

  public List<Employee> getTopSalaryStaff(int count) {

    ArrayList<Employee> topSalary = new ArrayList<>();
    if (count > 0 && count <= staff.size()) {
      for (int i = staff.size() - 1; i > 0; --i) {
        topSalary.add(getSortedEmployeeList().get(i));
      }
      return topSalary.subList(0, count);
    } else if (count > 0) {
      for (int i = staff.size() - 1; i > 0; --i) {
        topSalary.add(getSortedEmployeeList().get(i));
      }
      return topSalary;
    } else {

      throw new IllegalArgumentException("Недопустимое значение count");
    }
  }

  public List<Employee> getLowestSalaryStaff(int count) {

    if (count > 0 && count <= staff.size()) {

      return getSortedEmployeeList().subList(0, count);
    } else if (count > 0) {

      return getSortedEmployeeList();
    } else {
      
      throw new IllegalArgumentException("Недопустимое значение count");
    }
  }

}