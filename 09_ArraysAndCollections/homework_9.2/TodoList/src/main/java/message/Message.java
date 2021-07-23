package message;

public enum Message {

  COMMAND_LIST("Введите команду:" + System.lineSeparator() + "ADD описание запланированного события"
      + ", или ADD номер в списке и описание запланированного события = добавить в список"
      + System.lineSeparator() + "DELETE номер в списке = удалить дело." + System.lineSeparator()
      + "EDIT номер в списке = редактировать дело." + System.lineSeparator()
      + "LIST-распечатать список актуальных дел." + System.lineSeparator()
      + "EXIT = завершение работы."),
  BAD_COMMAND("Неверная команда." + System.lineSeparator() + COMMAND_LIST);

  private String message;

  Message(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
