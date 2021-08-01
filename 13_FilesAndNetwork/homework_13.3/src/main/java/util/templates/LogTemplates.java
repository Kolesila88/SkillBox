package util.templates;

public enum LogTemplates {
  INFO_CONSOLE_LOG_TEMPLATE("Specify the full path to the file being processed.\nEnter \"EXIT\""
      .concat(" to end the program.\nPress \"ENTER\" to process the default file.")),
  REPORT_CONSOLE_LOG_TEMPLATE(
      "Amount of expenses: %.2f rubles.%n\t\t\t\t\t\t\t\t\t\t\t\t Amount of income: %.2f rubles.%n"
          .concat("\t\t\t\t\t\t\t\t\t\t\t\t Amounts of expenses by organization: %s"));

  private String template;

  LogTemplates(String template) {

    this.template = template;
  }

  public String getTemplate() {

    return template;
  }
}
