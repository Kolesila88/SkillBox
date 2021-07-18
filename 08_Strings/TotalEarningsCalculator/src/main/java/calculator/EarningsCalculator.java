package calculator;

public class EarningsCalculator {

  private final static int RESET_COUNTER = -1;
  private final static int ZERO = 0;

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

    if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
        || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {

      return true;
    } else {

      return false;
    }
  }
}
