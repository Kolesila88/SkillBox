package enumirations;

public enum StrPatts {

  CONTACT_FORMAT_STR("%s - %s"),
  COMMA_AND_SPACEBAR_STR(", "),
  HYPHEN_STR(" - "),
  SEVEN_STR("7"),
  EMPTY_LINE_STR("");

  private String pattern;

  StrPatts(String pattern) {

    this.pattern = pattern;
  }

  public String getStrPatt() {

    return pattern;
  }


}
