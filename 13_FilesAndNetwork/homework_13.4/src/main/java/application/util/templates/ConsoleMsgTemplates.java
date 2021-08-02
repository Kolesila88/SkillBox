package application.util.templates;

public enum ConsoleMsgTemplates {

  SPECIFY_PATH_TO_SITE("Specify the path to the site being processed, or specify \"EXIT\" to terminate the program."),
  SPECIFY_PATH_TO_FOLDER("Specify the path to the save folder.");

  private String template;

  ConsoleMsgTemplates(String template) {

    this.template = template;
  }

  public String getTemplate() {

    return template;
  }
}
