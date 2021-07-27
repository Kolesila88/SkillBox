package ru.lakeev.companyandstaff.staff.parent;

import java.math.BigDecimal;
import java.util.Random;
import ru.lakeev.companyandstaff.company.Company;
import ru.lakeev.companyandstaff.gender.Gender;
import ru.lakeev.companyandstaff.name.FullName;
import ru.lakeev.companyandstaff.random.ValuesGenerator;

public abstract class CompanyEmployee implements Employee {

  private static final Random RANDOM = ValuesGenerator.getInstance();

  private int id;
  private String fullName;
  private Gender gender;
  private Company company;
  private String category;

  private BigDecimal fixSalary;
  private BigDecimal managerProfit;
  private BigDecimal bonus;
  private BigDecimal bonusAmount;

  private BigDecimal salary;

  protected CompanyEmployee() {

    this.gender = (RANDOM.nextBoolean()) ? Gender.MALE : Gender.FEMALE;
    this.fullName = FullName.createAndGetFullName(gender);
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {

    this.id = id;
  }

  @Override
  public String getFullName() {
    return fullName;
  }

  @Override
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public BigDecimal getSalary() {
    return salary;
  }

  protected void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  @Override
  public Company getCompany() {
    return company;
  }

  @Override
  public void setCompany(Company company) {

    this.company = company;
  }

  @Override
  public Gender getGender() {
    return gender;
  }

  public String toString() {

    return (String.format("%d. %s - %s - з/п %.2f", id, category, fullName, getMonthSalary()));
  }

  protected void setFixSalary(BigDecimal fixSalary) {
    this.fixSalary = fixSalary;
  }

  protected BigDecimal getFixSalary() {
    return fixSalary;
  }

  protected void setManagerProfit(BigDecimal managerProfit) {
    this.managerProfit = managerProfit;
  }

  public BigDecimal getManagerProfit() {
    return managerProfit;
  }

  protected void setBonus(BigDecimal bonus) {
    this.bonus = bonus;
  }

  protected BigDecimal getBonus() {
    return bonus;
  }

  protected void setBonusAmount(BigDecimal bonusAmount) {
    this.bonusAmount = bonusAmount;
  }

  protected BigDecimal getBonusAmount() {
    return bonusAmount;
  }
}
