package enumirations;

public enum OperationType {

  TAKE("Снятие."),
  PUT("Пополнение.");

  private String type;

  OperationType(String type) {
    this.type = type;
  }

  public String getType() {

    return type;
  }
}
