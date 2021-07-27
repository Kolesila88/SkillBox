package enumirations;

public enum Conditions {

  NO_COMMISSION("без комиссии"),
  LP_TAKE("комиссия 1% от суммы снятия"),
  IB_PUT("комиссия 1% для суммы менее 1000 руб. и 0,5% от 1000 руб. и выше");


  private String conditions;

  Conditions(String conditions){

    this.conditions = conditions;
  }

  public String getConditions() {

    return conditions;
  }
}
