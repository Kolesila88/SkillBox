package com.java.computer.test;

enum Messages {
  TEST_PASSED_SUCCESSFULLY_MSG(
      "Tests passed successfully!!!\nExpended value: \n%s\nResult value: \n%s"),
  TEST_FAILED_MSG("Test failed!!!\nExpended value: \n%s\nResult value: \n%s");


  private final String message;

  Messages(String message) {

    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
