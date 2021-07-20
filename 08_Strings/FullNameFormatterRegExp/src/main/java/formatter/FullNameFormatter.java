package formatter;

import message.Message;
import regex.RegEx;

public class FullNameFormatter {

  private static final byte ZERO = 0;
  private static final byte ONE = 1;
  private static final byte TWO = 2;

  public static String getFormattedFullName(String input) {

    String inputFullName = input
        .replaceAll(RegEx.SEVERAL_SPACES_REGEX.getRegEx(), Message.SPACE_MSG.getMessage())
        .trim();

    if (!inputFullName.matches(RegEx.VALID_FULL_NAME_REGEX.getRegEx())) {

      return Message.NOT_NAME_MSG.getMessage();
    } else {

      String[] fullName = inputFullName.split(RegEx.SPACE_REGEX.getRegEx());
      if (fullName[ZERO].trim().matches(RegEx.VALID_SURNAME_REGEX.getRegEx())
          && fullName[ONE].trim().matches(RegEx.VALID_NAME_AND_PATRONYMIC_REGEX.getRegEx())
          && fullName[TWO].trim().matches(RegEx.VALID_NAME_AND_PATRONYMIC_REGEX.getRegEx())) {

        return String.format(
            Message.FORMATTED_NAME_MSG.getMessage(),
            fullName[ZERO].trim(),
            System.lineSeparator(),
            fullName[ONE].trim(),
            System.lineSeparator(),
            fullName[TWO].trim());
      } else {

        return Message.NOT_NAME_MSG.getMessage();
      }
    }
  }
}
