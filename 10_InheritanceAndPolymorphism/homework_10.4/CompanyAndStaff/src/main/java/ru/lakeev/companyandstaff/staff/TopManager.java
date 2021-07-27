package ru.lakeev.companyandstaff.staff;

import java.math.BigDecimal;
import java.math.RoundingMode;
import ru.lakeev.companyandstaff.staff.parent.CompanyEmployee;
import ru.lakeev.companyandstaff.staff.parent.Employee;

public class TopManager extends CompanyEmployee {

  private static final BigDecimal BONUS_PERCENT = BigDecimal.valueOf(150);
  private static final BigDecimal TOP_MANAGER_FIX_SALARY = BigDecimal.valueOf(75_000);
  private static final BigDecimal KPI = BigDecimal.valueOf(10_000_000);

  private TopManager() {
    setCategory("TopManager");
    setFixSalary(TOP_MANAGER_FIX_SALARY);
    setBonus(BONUS_PERCENT); // в процентах от общей прибыли
    setBonusAmount(BigDecimal.ZERO);
    setManagerProfit(BigDecimal.ZERO);
    setSalary(getFixSalary().add(getBonusAmount()));
  }

  @Override
  public double getMonthSalary() {

    BigDecimal income = getCompany().getIncome();
    if (income.compareTo(KPI) > -1) {

      setBonusAmount(getFixSalary()
          .multiply(getBonus())
          .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
    } else {

      setBonusAmount(BigDecimal.ZERO);
    }
    return getSalary().add(getBonusAmount()).doubleValue();
  }

  protected static Employee getNewInstance() {

    return new TopManager();
  }
}
