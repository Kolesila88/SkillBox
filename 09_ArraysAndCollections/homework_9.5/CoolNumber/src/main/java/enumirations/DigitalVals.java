package enumirations;

public enum DigitalVals {

  ZERO(0),
  ONE(1),
  TWO(2),
  INVALID_DIGIT_IN_CAR_NUM(10),
  MAX_REG_INDEX(199);

  private int val;

  DigitalVals(int val) {

    this.val = val;
  }

  public int getVal() {

    return val;
  }
}
