package emumirations;

public enum Command {

  EXIT("0"),
  ADD("ADD"),
  DELETE("DELETE"),
  CLEAR("CLEAR"),
  LIST("LIST"),
  YES("Y"),
  NOT("N");

  private String cmd;

  Command(String cmd) {

    this.cmd = cmd;
  }

  public String getCmd() {

    return cmd;
  }
}
