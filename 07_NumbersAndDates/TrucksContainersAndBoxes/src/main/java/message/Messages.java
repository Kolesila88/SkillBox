package message;

public enum Messages {
  TRUCK_INFO_MSG("Грузовик: %s%s"),
  CONTAINER_INFO_MSG("\tКонтейнер: %s%s"),
  BOX_INFO_MSG("\t\tЯщик: %s%s"),
  RESULT_INFO_MSG("Необходимо:%sгрузовиков - %s шт.%sконтейнеров - %s шт.");

  private final String message;

  Messages(String message) {

    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
