package formatter;

import message.Message;
import props.Value;

public class FullNameFormatter {

  private static int spacesCount = Value.ZERO.getValue();

  public static String getFormattedFullName(String input) {

    String fullName = input.trim();

    if (isName(fullName)) {

      if (spacesCount != Value.TWO.getValue()) {

        return Message.NOT_NAME_MSG.getMessage();
      }

      resetSpacesCount();
      return String.format(
          Message.FORMATTED_NAME_MSG.getMessage(),
          fullName.substring(Value.ZERO.getValue(), fullName.indexOf(' ')).trim(),
          System.lineSeparator(),
          fullName.substring(fullName.indexOf(' '), fullName.lastIndexOf(' ')).trim(),
          System.lineSeparator(),
          fullName.substring(fullName.lastIndexOf(' '), fullName.length()).trim());
    } else {

      resetSpacesCount();
      return Message.NOT_NAME_MSG.getMessage();
    }
  }

  private static boolean isName(String fullName) {

    char c = fullName.charAt(Value.ZERO.getValue());
    if (c > Value.CAP_CHAR_MAX_VAL.getValue()
        || (c < Value.CAP_CHAR_MIN_VAL.getValue()
        && c != Value.CAP_YO_CHAR_VAL.getValue())) {

      return false;
    }

    for (int i = Value.ZERO.getValue(); i < fullName.length(); i++) {

      c = fullName.charAt(i);

      if (!isValidCharacter(fullName, c, i)) {

        return false;
      }

      if (c == ' ') {
        spacesCount++;
      }
    }
    return true;
  }

  private static boolean isValidCharacter(String fullName, char c, int i) {

    if ((c < Value.CAP_CHAR_MIN_VAL.getValue() && (c != Value.CAP_YO_CHAR_VAL.getValue()
        || c != Value.HYPHEN_CHAR_VAL.getValue() || c != Value.SPACE_CHAR_VAL.getValue()))
        && (c > Value.CHAR_MAX_VAL.getValue() && c != Value.YO_CHAR_VAL.getValue())
        || ((c == Value.HYPHEN_CHAR_VAL.getValue()
        && (fullName.charAt(i - Value.ONE.getValue()) < Value.CHAR_MIN_VAL.getValue()
        || fullName.charAt(i - Value.ONE.getValue()) > Value.CHAR_MAX_VAL.getValue()))
        || (c == Value.HYPHEN_CHAR_VAL.getValue()
        && (fullName.charAt(i + Value.ONE.getValue()) < Value.CAP_CHAR_MIN_VAL.getValue()
        || fullName.charAt(i + Value.ONE.getValue()) > Value.CAP_CHAR_MAX_VAL.getValue())))
        || (c == Value.SPACE_CHAR_VAL.getValue()
        && fullName.charAt(i + Value.ONE.getValue()) > Value.CAP_CHAR_MAX_VAL.getValue())
        || (c == Value.SPACE_CHAR_VAL.getValue()
        && fullName.charAt(i + Value.ONE.getValue()) < Value.CAP_CHAR_MIN_VAL.getValue()
        && fullName.charAt(i + Value.ONE.getValue()) != Value.CAP_YO_CHAR_VAL.getValue())) {

      return false;
    } else {

      return true;
    }
  }

  private static void resetSpacesCount() {

    spacesCount = Value.ZERO.getValue();
  }
}
