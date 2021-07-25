package enumirations;

public enum StrPatterns {

  HELLO_MSG_PATTERN(
      "Введите автомобильный номер в формате \"АnnnВЕrrr\".%sГде n это цифры, r- индекс региона,"
          + "%sа АВЕ заглавные буквы."),
  WRONG_NUMBER_FORMAT_PATTERN("Неверный формат номера.%sВведите номер в указанном формате."),
  FOUND_RESULT_PATTERN("%s номер %s найден.%sПоиск занял %d наносекунд.%s"),
  ONE_ZERO_PATTERN("0%s");

  private String strPatt;

  StrPatterns(String strPatt) {

    this.strPatt = strPatt;
  }

  public String getPattern() {

    return strPatt;
  }
}
