package calculator;

public class EarningsCalculator {

  private final static int RESET_COUNTER = -1;
  private final static int ZERO = 0;
  private final static int ZERO_CHAR_CODE = 48;
  private final static int NINE_CHAR_CODE = 57;

  public static Integer getAmountSalaries(String text) {

    int amountSalaries = ZERO;

    String analyzedText = text;
    for (int i = ZERO; i < analyzedText.length(); i++) {

      if (isDigit(analyzedText.charAt(i))) {

        analyzedText = analyzedText.substring(i).trim();
        amountSalaries += Integer.parseInt(analyzedText.substring(ZERO, analyzedText.indexOf(' ')));
        analyzedText = analyzedText.substring(analyzedText.indexOf(' ')).trim();
        i = RESET_COUNTER;
      }
    }
    return amountSalaries;
  }

  private static boolean isDigit(char c) {

    if (c >= ZERO_CHAR_CODE && c <= NINE_CHAR_CODE) {

      return true;
    } else {

      return false;
    }
  }
}
