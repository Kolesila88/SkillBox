package regex;

public enum RegEx {

  SPACE_REGEX("\\s"),
  SEVERAL_SPACES_REGEX("\\s+"),
  INVALID_CHARACTER_REGEX("[^\\s\\’A-Za-z]");

  private final String regex;

  RegEx(String regex) {

    this.regex = regex;
  }

  public String getRegex() {

    return regex;
  }
}
