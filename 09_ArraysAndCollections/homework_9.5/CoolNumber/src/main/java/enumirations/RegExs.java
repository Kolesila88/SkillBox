package enumirations;

public enum RegExs {

  CAR_NUMBER("^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$");

  private String regEx;

  RegExs(String regEx) {

    this.regEx = regEx;
  }

  public String getRegEx() {

    return regEx;
  }
}
