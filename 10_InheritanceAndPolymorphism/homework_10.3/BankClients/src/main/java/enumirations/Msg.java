package enumirations;

public enum Msg {

TARIFF_CONDITION_MSG("Баланс счета: %.2f руб.%nУсловия тарифа %s:%n\tПополнение - %s.%n\tСнятие - %s.%n"),
  OPERATION_DETAILS_MSG("Операция %s.%n\t%s%n\tСумма операции: %.2f руб.%n");

  private String message;

  Msg(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
