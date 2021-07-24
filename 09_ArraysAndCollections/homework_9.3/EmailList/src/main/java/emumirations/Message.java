package emumirations;


public enum Message {
  LIST_IS_EMPTY("Список пуст."),
  YES_OR_NOT_MSG("Y или N"),
  EXIT_MSG("EXIT."),
  CONFIRMATION_MSG("Чтобы подтвердить действие введите: CLEAR"),
  EMAIL_NOT_IN_SET(String
      .format("Такой электронной почты нет в хранимом множестве.%sСохранить email?%s",
          System.lineSeparator(), YES_OR_NOT_MSG.getMsg())),
  COMMAND_LIST(String.format(new String("Введите команду:")
          .concat("%sADD email адрес - добавить email.%sLIST - распечатать список email'ов.")
          .concat("%sDELETE email адресс - удалить email.%sCLEAR - удалить все email.")
          .concat("%sEXIT - завершить работу программы."),
      System.lineSeparator(), System.lineSeparator(), System.lineSeparator(),
      System.lineSeparator(), System.lineSeparator())),
  COMMAND_NOT_SUPPORTED(String.format(new String("Команда не поддерживается.%s")
      .concat(COMMAND_LIST.getMsg()), System.lineSeparator())),
  NOT_VALID_EMAIL("Неверный формат email");

  private String msg;

  Message(String msg) {

    this.msg = msg;
  }

  public String getMsg() {

    return msg;
  }
}
