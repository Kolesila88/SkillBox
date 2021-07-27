package client.parent;

import enumirations.Msg;
import java.math.BigDecimal;

public abstract class Client {

  protected BigDecimal amount;

  protected Client() {

    setAmount(0.0);
  }

  protected void setAmount(double amount) {

    this.amount = BigDecimal.valueOf(amount);
  }

  public double getAmount() {

    return amount.doubleValue();
  }

  protected void printTariffCondition(
      double amount, String tariffName, String putCond, String takeCond) {

    System.out.printf(
        Msg.TARIFF_CONDITION_MSG.getMessage(), amount, tariffName, putCond, takeCond);
  }

  abstract public void put(double amountToPut);

  abstract public void take(double amountToTake);

  abstract public void printClientCondition();

}
