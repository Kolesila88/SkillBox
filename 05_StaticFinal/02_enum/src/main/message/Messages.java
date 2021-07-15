package main.message;

public enum Messages {

  TEST_PASSED_SUCCESSFULLY_MSG("Tests passed successfully!!!"),
  TEST_FAILED_MSG("Test failed!!!"),
  DETAILED_RESULT_MSG("firstValue = %s%ssecondValue = %s%sexpendedValue = %s%sresultValue = %s"),
  DIVISION_BY_ZERO_IS_NOT_ALLOWED(
      "Division by zero is not allowed!!!%sfirstValue = %s%ssecondValue = %s%sexpendedValue = %s%sresultValue = %s"),
  NOT_SUPPORT_MSG("Operation %s, not supported!!!");


  private final String message;

  Messages(String message) {

    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
