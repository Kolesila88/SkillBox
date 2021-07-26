package ru.lakeev.bankaccounts.enumirations;

public enum Msg {
  TAKING_CASH_MSG("Снятие наличных: %.2f руб\t%nБаланс: %.2f руб%n"),
  UNKNOWN_ERR_MSG("Операция не выполнена по неизвестным причинам.%n"),
  DEPOSIT_DATE_MSG("%nДепозит до: %s.%n\tТекущая дата: %s"),
  COMMISSION_MSG("\tКомиссия: %.2f руб.%n"),
  INSUFFICIENT_FUNDS("Недостаточно средств%n\tБаланс: %.2f руб.%n\tСумма снятия: %.2f руб.%n"),
  INCORRECT_AMOUNT_MSG("Операция не возможна.\t%nСумма операции: %.2f руб."),
  REPLENISHMENT_MSG("Пополнение: %.2f руб.%n\tБаланс: %.2f руб.%n"),
  ACC_TO_STRING_MSG("Аккаунт № %s.Баланс: %2.f.%n");

  private String message;

  Msg(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
