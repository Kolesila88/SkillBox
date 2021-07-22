package regex;

public enum RegEx {

  LINE_SPLITTER(",?\\s");

  private String regEx;

  RegEx(String regEx) {

    this.regEx = regEx;
  }

  public String getRegEx() {

    return regEx;
  }
}
