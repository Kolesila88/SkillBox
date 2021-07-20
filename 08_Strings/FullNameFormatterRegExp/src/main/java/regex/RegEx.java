package regex;

public enum RegEx {

  VALID_SURNAME_REGEX("[А-Я][а-я]+[-]?[А-Я]?[а-я]*"),
  VALID_NAME_AND_PATRONYMIC_REGEX("[А-Я][а-я]+"),
  SEVERAL_SPACES_REGEX("\\s+"),
  SPACE_REGEX("\\s"),
  VALID_FULL_NAME_REGEX("[А-Я][а-я]+[-]?[А-Я]?[а-я]*\\s[А-Я][а-я]+\\s[А-Я][а-я]+");

  private String regEx;

  RegEx(String regEx) {

    this.regEx = regEx;
  }

  public String getRegEx() {

    return regEx;
  }
}
