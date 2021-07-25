package enumirations;

public enum Values {

  ZERO(0),
  ONE(1),
  TWO(2),
  PHONE_LENGTH(11),
  PHONE_NUMBER_LENGTH_WITHOUT_COUNTRY_CODE(10);

  private int val;

  Values(int val) {

    this.val = val;
  }

  public int getVal() {

    return val;
  }

}
