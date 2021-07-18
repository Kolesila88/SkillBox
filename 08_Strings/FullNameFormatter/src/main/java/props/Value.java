package props;

public enum Value {

  ZERO(0),
  ONE(1),
  TWO(2),
  CAP_CHAR_MAX_VAL(1071),
  CAP_CHAR_MIN_VAL(1040),
  CHAR_MIN_VAL(1072),
  CHAR_MAX_VAL(1103),
  CAP_YO_CHAR_VAL(1025),
  YO_CHAR_VAL(1105),
  SPACE_CHAR_VAL(45),
  HYPHEN_CHAR_VAL(32);

  private final int value;

  Value(int value) {

    this.value = value;
  }

  public int getValue() {

    return value;
  }
}
