package enumirations;

public enum RegExs {

  NOT_DIGITS_PATTERN("[^0-9]"),
  NOT_SEVEN_OR_EIGHT_PATTERN("[^7-8]"),
  EIGHT_PATTERN("[8]"),
  SPACE_PATTERN("[\\s]"),
  NAME_PATTERN("[а-яА-Я][[а-яА-Я][0-9]():№]+\\s?[[а-яА-Я][0-9]():№]*"),
  PHONE_NUMBER_PATTERN("[+]?[7-8]?[-]?[(]?[0-9]{3}[)]?[-]?[0-9]{3}[-]?[0-9]{2}[-]?[0-9]{2}");

  private String regEx;

  RegExs(String regEx) {

    this.regEx = regEx;
  }

  public String getRegEx() {

    return regEx;
  }
}
