package ru.lakeev.companyandstaff.staff;

import java.math.BigDecimal;
import java.math.RoundingMode;
import ru.lakeev.companyandstaff.staff.parent.CompanyEmployee;
import ru.lakeev.companyandstaff.staff.parent.Employee;

public class Manager extends CompanyEmployee {

  private static final BigDecimal BONUS_PERCENT = BigDecimal.valueOf(5);
  private static final BigDecimal MANAGER_FIX_SALARY = BigDecimal.valueOf(30_000);

  private Manager() {

    setCategory("Manager");
    setManagerProfit(BigDecimal.valueOf(115_000)
        .add(BigDecimal.valueOf(Math.round(25_000 * Math.random()))));
    setFixSalary(MANAGER_FIX_SALARY);
    setBonus(BONUS_PERCENT);// в процентах от заработанной им прибыли
    setBonusAmount(getManagerProfit()
        .multiply(getBonus())
        .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
    setSalary(getFixSalary());
  }

  @Override
  public double getMonthSalary() {

    return getSalary().add(getBonusAmount()).doubleValue();
  }

  protected static Employee getNewInstance() {

    return new Manager();
  }
}
