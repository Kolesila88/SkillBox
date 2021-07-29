package ru.lakeev.customerlist.messages;

public enum CommandExpMsg {

  STORAGE_IS_EMPTY("The storage is empty."),
  COMMAND_ERROR(String.format(
      "Wrong command! Available command examples: %n%s", Msg.COMMAND_EXAMPLES.getMsg()));

  private String msg;

  CommandExpMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
}
