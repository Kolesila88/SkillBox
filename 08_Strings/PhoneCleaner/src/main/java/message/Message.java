package message;

public enum Message {

  WRONG_NUMBER_FORMAT("Неверный формат номера");

  private String message;

  Message(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
