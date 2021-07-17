package lang;

public enum Lang {
  ENG("en"),
  US("us"),
  RU("ru"),
  DE("de"),
  FR("fr"),
  IT("it"),
  ES("es"),
  PT("pt"),
  JP("jp"),
  CN("zh"),
  SA("ar");

  private String lang;

  Lang(String language) {

    this.lang = language;
  }

  public String getLang() {

    return lang;
  }

}
