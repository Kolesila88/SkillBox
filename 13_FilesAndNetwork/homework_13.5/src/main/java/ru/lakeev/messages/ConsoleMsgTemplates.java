package ru.lakeev.messages;

public enum ConsoleMsgTemplates {

  UNRECOGNIZED_COMMAND_MSG_TEMPLATE("Unrecognized command."),
  CONNECTION_ON_THE_ROUTE_MSG_TEMPLATE("\tПереход на станцию %s (%s)"),
  ROUTE_DURATION_MSG_TEMPLATE("Длительность: %.2f минут"),
  COMMANDS_LIST_MSG_TEMPLATE(
      "Enter \"EXIT\" to terminate the program.".concat(System.lineSeparator())
          .concat(" \t\t\t\t\t\t\t\t\t\t\t\tEnter \"REPORT\" to display metro statistics.".concat(System.lineSeparator())
              .concat(" \t\t\t\t\t\t\t\t\t\t\t\tEnter \"ROUTE\" to build a route.").concat(System.lineSeparator())));

  private String template;

  ConsoleMsgTemplates(String template) {

    this.template = template;
  }

  public String getTemplate() {

    return template;
  }
}
