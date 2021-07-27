package ru.lakeev.companyandstaff.staff;

import java.math.BigDecimal;
import ru.lakeev.companyandstaff.staff.parent.CompanyEmployee;
import ru.lakeev.companyandstaff.staff.parent.Employee;

public class Operator extends CompanyEmployee {

  private static final BigDecimal OPERATOR_FIX_SALARY = BigDecimal.valueOf(35_000);

  private Operator() {
    setCategory("Operator");
    setFixSalary(OPERATOR_FIX_SALARY);
    setSalary(getFixSalary());
    setManagerProfit(BigDecimal.ZERO);
  }

  @Override
  public double getMonthSalary() {

    return getSalary().doubleValue();
  }

  protected static Employee getNewInstance() {

    return new Operator();
  }


}
