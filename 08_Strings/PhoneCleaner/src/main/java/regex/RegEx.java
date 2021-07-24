package regex;

public enum RegEx {
  NOT_DIGITS_PATTERN("[^0-9]"),
  NOT_SEVEN_OR_EIGHT_PATTERN("[^7-8]"),
  EIGHT_PATTERN("[8]"),
  SPACE_PATTERN("[\\s]"),
  PHONE_NUMBER_PATTERN
      ("[+]?[7-8]?[-]?[(]?[\\d]{3}[)]?[-]?[\\d]{3}[-]?[\\d]{2}[-]?[\\d]{2}");

  private String regEx;

  RegEx(String regEx) {

    this.regEx = regEx;
  }

  public String getRegEx() {

    return regEx;
  }
}
