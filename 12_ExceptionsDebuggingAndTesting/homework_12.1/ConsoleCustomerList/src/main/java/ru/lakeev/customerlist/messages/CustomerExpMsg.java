package ru.lakeev.customerlist.messages;

public enum CustomerExpMsg {

  NOT_CUSTOMER("Not customer data."),
  INCORRECT_FORMAT("Incorrect format customer %s%nCorrect format: %s.%n");

  private String msg;

  CustomerExpMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
}
