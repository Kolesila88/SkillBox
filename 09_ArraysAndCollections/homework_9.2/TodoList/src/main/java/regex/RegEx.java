package regex;

public enum RegEx {

  NUMBER_REGEX("[0-9]+"),
  SPACE_REGEX("\\s"),
  ADD_REGEX("ADD");

  private String regex;

  RegEx(String regex) {

    this.regex = regex;
  }

  public String getRegex() {

    return regex;
  }
}
