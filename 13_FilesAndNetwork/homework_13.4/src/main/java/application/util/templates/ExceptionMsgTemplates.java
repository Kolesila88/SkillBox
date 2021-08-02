package application.util.templates;

public enum ExceptionMsgTemplates {


  INCORRECT_PATH_TO_PROCESSED_SITE("The path: %s - not path to site."),
  INCORRECT_PATH_TO_SAVE_FOLDER("The path: %s - not valid path to folder.");


  private String template;

  ExceptionMsgTemplates(String template) {

    this.template = template;
  }

  public String getTemplate() {

    return template;
  }
}
