package emumirations;

public enum RegEx {

  MAIL_PATTERN("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}"),
  SPACE_PATTERN("\\s");

  private String regex;

  RegEx(String regex){

    this.regex = regex;
  }

  public String getRegex(){

    return regex;
  }
}
