package util.templates;

public enum ExceptionMsgTemplate {
INVALID_PATH_TEMPLATE("The path: \"%s\" is invalid or the file does not exist."),
INCORRECTLY_PROCESSED_OPERATION(
    "The type and amount of the operation were processed incorrectly: income = %s expense = %s.");


  private String template;

  ExceptionMsgTemplate(String template) {

    this.template = template;
  }

  public String getTemplate() {

    return template;
  }
}
