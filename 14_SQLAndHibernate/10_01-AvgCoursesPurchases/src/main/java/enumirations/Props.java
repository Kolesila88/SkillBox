package enumirations;

public enum Props {

  DB_URL("jdbc:mysql://localhost:3306/skillbox2?serverTimezone=Europe/Moscow"),
  USER_NAME("root"),
  USER_PASSWORD("uthjqccch");

  private String value;

  Props(String value) {

    this.value = value;
  }

  public String getValue() {

    return value;
  }
}