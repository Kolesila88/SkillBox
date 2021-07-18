package message;

public enum Message {

  FORMATTED_NAME_MSG("Фамилия: %s%sИмя: %s%sОтчество: %s"),
  NOT_NAME_MSG("Введенная строка не является ФИО");

  private final String message;

  Message(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
