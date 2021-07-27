package ru.lakeev.companyandstaff.staff.parent;

import java.math.BigDecimal;
import ru.lakeev.companyandstaff.company.Company;
import ru.lakeev.companyandstaff.gender.Gender;

public interface Employee {

  int getId();

  void setId(int id);

  String getFullName();

  String getCategory();

  BigDecimal getSalary();

  Company getCompany();

  void setCompany(Company company);

  Gender getGender();

  BigDecimal getManagerProfit();

  double getMonthSalary();
}

