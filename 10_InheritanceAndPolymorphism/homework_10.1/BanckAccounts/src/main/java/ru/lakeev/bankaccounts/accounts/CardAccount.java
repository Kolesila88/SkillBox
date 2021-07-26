package ru.lakeev.bankaccounts.accounts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import ru.lakeev.bankaccounts.accountsnumbersset.AccountsNumbersSet;
import ru.lakeev.bankaccounts.enumirations.Msg;

public class CardAccount extends BankAccount {


  private CardAccount() {

    setAccAmount(0.0);
    setAccountNumber(AccountsNumbersSet.generateAndGetAccNum());
  }

  protected static CardAccount getInstance() {
    return new CardAccount();
  }

  public boolean take(double amountToTake) {

    BigDecimal commission = BigDecimal.valueOf(amountToTake)
        .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_DOWN);

    if (amountToTake > 0 && amountToTake <= getAccAmount()) {

      setAccAmount(BigDecimal.valueOf(getAccAmount()).subtract(BigDecimal.valueOf(amountToTake).add(commission)).doubleValue());
      System.out.printf(
          Msg.TAKING_CASH_MSG.getMessage().concat(Msg.COMMISSION_MSG.getMessage()),
          amountToTake, getAccAmount(), commission.doubleValue());
      return true;
    } else {

      if (amountToTake <= 0) {

        System.err.printf(Msg.INCORRECT_AMOUNT_MSG.getMessage(), amountToTake);
      } else if (amountToTake > getAccAmount()) {

        System.err.printf(
            Msg.INSUFFICIENT_FUNDS.getMessage().concat(Msg.COMMISSION_MSG.getMessage()),
            getAccAmount(), amountToTake, commission.doubleValue());
      } else {

        System.err.printf(Msg.UNKNOWN_ERR_MSG.getMessage());
      }
      return false;
    }
  }
}
