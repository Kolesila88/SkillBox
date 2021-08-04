package enumirations;

public enum TableTemplates {

  AVG_TABLE_TEMP("%-35s | %14s | %21s | %21s | %17s | %14s |"),
  PURCHASES_PER_MONTH_TABLE_TEMP("%-35s | %5s | %14s |");

  private String value;

  TableTemplates(String value) {

    this.value = value;
  }

  public String getValue() {

    return value;
  }
}
