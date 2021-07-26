package ru.lakeev.bankaccounts.accounts;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import ru.lakeev.bankaccounts.enumirations.Msg;
import ru.lakeev.bankaccounts.enumirations.Pttrn;

public class DepositAccount extends BankAccount {

  private LocalDate lastIncome;

  public void put(double amountToPut) {

    if (amountToPut > 0) {

      setAccAmount(
          BigDecimal.valueOf(getAccAmount()).add(BigDecimal.valueOf(amountToPut)).doubleValue());
      lastIncome = LocalDate.now();
      System.out.printf(
          Msg.REPLENISHMENT_MSG.getMessage().concat(Msg.DEPOSIT_DATE_MSG.getMessage()),
          amountToPut, getAccAmount(),
          DateTimeFormatter.ofPattern(Pttrn.DATE_PATTERN.getPattern())
              .localizedBy(new Locale("ru"))
              .format(lastIncome.plusMonths(1L)),
          DateTimeFormatter.ofPattern(Pttrn.DATE_PATTERN.getPattern())
              .localizedBy(new Locale("ru"))
              .format(LocalDate.now()));
    } else {

      System.err.printf(Msg.INCORRECT_AMOUNT_MSG.getMessage(), amountToPut);
    }
  }

  public boolean take(double amountToTake) {

    if (LocalDate.now().isAfter(lastIncome.plusMonths(1L)) && amountToTake > 0
        && amountToTake <= getAccAmount()) {

      setAccAmount(BigDecimal.valueOf(getAccAmount()).subtract(BigDecimal.valueOf(amountToTake))
          .doubleValue());
      System.out.printf(Msg.TAKING_CASH_MSG.getMessage(), amountToTake, getAccAmount());
      return true;
    } else {

      if (LocalDate.now().isBefore(lastIncome.plusMonths(1L))) {

        System.err.printf(
            Msg.INCORRECT_AMOUNT_MSG.getMessage().concat(Msg.DEPOSIT_DATE_MSG.getMessage()),
            amountToTake,
            DateTimeFormatter.ofPattern(Pttrn.DATE_PATTERN.getPattern())
                .localizedBy(new Locale("ru"))
                .format(lastIncome.plusMonths(1)),
            DateTimeFormatter.ofPattern(Pttrn.DATE_PATTERN.getPattern())
                .localizedBy(new Locale("ru"))
                .format(LocalDate.now()));
      } else if (amountToTake <= 0) {

        System.err.printf(Msg.INCORRECT_AMOUNT_MSG.getMessage(), amountToTake);
      } else if (amountToTake > getAccAmount()) {

        System.err.printf(
            Msg.INSUFFICIENT_FUNDS.getMessage(), getAccAmount(), amountToTake);
      } else {

        System.err.print(Msg.UNKNOWN_ERR_MSG.getMessage());
      }
      return false;
    }
  }
}
