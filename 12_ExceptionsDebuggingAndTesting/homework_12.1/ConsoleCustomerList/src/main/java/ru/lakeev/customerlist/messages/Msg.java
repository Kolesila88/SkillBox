package ru.lakeev.customerlist.messages;

public enum Msg {

  CUSTOMER_COUNT_MSG("There are %s customers"),
  CUSTOMER_TO_STR("%s - %s - %s"),
  ADD_COMMAND("add Василий Петров vasily.petrov@gmail.com +79215637722"),
  COMMAND_EXAMPLES(String.format("\t%s%n\tlist%n\tcount%n\tremove Василий Петров", ADD_COMMAND)),
  HELP_TEXT(String.format("Command examples:%n%s", COMMAND_EXAMPLES));

  private String msg;

  Msg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
}
