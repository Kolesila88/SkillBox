package enumirations;

public enum OperationResults {

  APPROVED("выполнена"),
  DECLINED("отклонена");

  private String txt;

  OperationResults(String txt) {
    this.txt = txt;
  }

  public String getTxt() {

    return txt;
  }
}
