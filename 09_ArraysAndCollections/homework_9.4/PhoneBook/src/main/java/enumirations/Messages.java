package enumirations;

public enum Messages {

  ENTER("Введите номер, имя или команду:%s\tLIST - вывести в консоль список контактов."
      + "%s\tEXIT - выход из программы."),
  PHONE_BOOK_IS_EMPTY("В телефонной книге нет записей."),
  NAME_NOT_FOUND_IN_PHONE_BOOK(
      "Такого имени в телефонной книге нет.%sВведите номер телефона для абонента “%s”"),
  PHONE_NOT_FOUND_IN_PHONE_BOOK(
      "Такого номера нет в телефонной книге.%sВведите имя абонента для номера “%s”:"),
  WRONG_INPUT_FORMAT("Неверный формат ввода"),
  WRONG_NUMBER_FORMAT("Неверный формат номера");

  private String message;

  Messages(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
