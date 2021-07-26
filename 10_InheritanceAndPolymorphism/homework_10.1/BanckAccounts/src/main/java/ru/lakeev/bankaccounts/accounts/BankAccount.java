package ru.lakeev.bankaccounts.accounts;

import java.math.BigDecimal;
import ru.lakeev.bankaccounts.accountsnumbersset.AccountsNumbersSet;
import ru.lakeev.bankaccounts.enumirations.Msg;

public class BankAccount {

  private String accountNumber;
  private BigDecimal accAmount;

  public BankAccount() {

    setAccAmount(0.0);
    setAccountNumber(AccountsNumbersSet.generateAndGetAccNum());
  }

  public void put(double amountToPut) {

    if (amountToPut > 0) {

      accAmount = accAmount.add(BigDecimal.valueOf(amountToPut));
      System.out.printf(
          Msg.REPLENISHMENT_MSG.getMessage(), amountToPut, accAmount.doubleValue());
    } else {

      System.err.printf(Msg.INCORRECT_AMOUNT_MSG.getMessage(), amountToPut);
    }
  }

  public boolean take(double amountToTake) {

    if (amountToTake > 0 && amountToTake <= accAmount.doubleValue()) {

      accAmount = accAmount.subtract(BigDecimal.valueOf(amountToTake));
        System.out.printf(Msg.TAKING_CASH_MSG.getMessage(), amountToTake, accAmount.doubleValue());
        return true;
    } else {

      if (amountToTake <= 0) {

        System.err.printf(Msg.INCORRECT_AMOUNT_MSG.getMessage(), amountToTake);
      } else if (amountToTake > accAmount.doubleValue()) {

        System.err.printf(Msg.INSUFFICIENT_FUNDS.getMessage(), accAmount.doubleValue(), amountToTake);
      } else {

        System.err.print(Msg.UNKNOWN_ERR_MSG.getMessage());
      }
    }
    return false;
  }

  public boolean send(BankAccount receiver, double amount) {

    if (amount > 0 && amount <= getAccAmount()) {

      if (take(amount)) {
        receiver.put(amount);
      }
      return true;
    } else {

      if (amount <= 0) {

        System.err.printf(Msg.INCORRECT_AMOUNT_MSG.getMessage(), amount);
      } else if (amount > accAmount.doubleValue()) {

        System.err.printf(Msg.INSUFFICIENT_FUNDS.getMessage(), accAmount.doubleValue(), amount);
      } else {

        System.err.print(Msg.UNKNOWN_ERR_MSG.getMessage());
      }
      return false;
    }
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  private void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getAccAmount() {

    return accAmount.doubleValue();
  }

  public void setAccAmount(double actualBalance) {

    this.accAmount = new BigDecimal(actualBalance);
  }
}
