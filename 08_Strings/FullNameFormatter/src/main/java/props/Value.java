package props;

public enum Value {

  ZERO(0),
  ONE(1),
  TWO(2),
  UP_CASE_CHAR_MAX_VAL(1071),
  UP_CASE_CHAR_MIN_VAL(1040),
  LOW_CASE_CHAR_MIN_VAL(1072),
  LOW_CASE_CHAR_MAX_VAL(1103),
  UP_CASE_YO_CHAR_VAL(1025),
  LOW_CASE_YO_CHAR_VAL(1105),
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
