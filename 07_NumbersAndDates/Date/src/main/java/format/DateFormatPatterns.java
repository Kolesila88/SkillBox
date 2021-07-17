package format;

public enum DateFormatPatterns {

  SKILLBOX_DATE_FORMAT_PATTERN("dd.MM.yyyy - E");

  private String pattern;

  DateFormatPatterns(String pattern) {

    this.pattern = pattern;
  }

  public String getPattern() {

    return pattern;
  }
}
