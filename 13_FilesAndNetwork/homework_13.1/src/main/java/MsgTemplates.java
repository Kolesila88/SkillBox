public enum MsgTemplates {

  I_O_EXP_MSG_TEMPLATE("Invalid path format: %s." ),
  FILE_FORMAT_EXP_MSG_TEMPLATE("Folder %s not found, or specified file is not a folder."),
  FILES_LOG_TEMPLATE("Folder: %s. Path: %s. Size: %d bytes."),
  CONSOLE_LOG_TEMPLATE("Folder size %s\t is %s\tCount of files: %d.");

  private String pattern;

  MsgTemplates(String pattern) {

    this.pattern = pattern;
  }

  public String getPattern() {

    return pattern;
  }
}
