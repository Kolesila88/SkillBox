package cleaner;

import message.Message;
import regex.RegEx;

public class PhoneCleaner {

  private static final byte ZERO = 0;
  private static final byte ONE = 1;
  private static final byte PHONE_LENGTH = 11;
  private static final byte PHONE_NUMBER_LENGTH_WITHOUT_COUNTRY_CODE = 10;

  private static final String SEVEN = "7";
  private static final String EMPTY_LINE = "";

  private static String phone;

  public static String cleanPhone(String input) {

    if (input.replaceAll(RegEx.SPACE_PATTERN.getRegEx(), EMPTY_LINE)
        .matches(RegEx.PHONE_NUMBER_PATTERN.getRegEx())) {
      phone = input;
      phone = phone.replaceAll(RegEx.NOT_DIGITS_PATTERN.getRegEx(), EMPTY_LINE);

      if (isCorrectNumber(phone)) {

        return phone;
      } else {

        return Message.WRONG_NUMBER_FORMAT.getMessage();
      }
    } else {

      return Message.WRONG_NUMBER_FORMAT.getMessage();
    }
  }

  private static boolean isCorrectNumber(String verifiedPhoneNumber) {

    if (verifiedPhoneNumber.length() != PHONE_LENGTH) {

      if (verifiedPhoneNumber.length() == PHONE_NUMBER_LENGTH_WITHOUT_COUNTRY_CODE
          && String.valueOf(phone.charAt(ZERO))
          .matches(RegEx.NOT_SEVEN_OR_EIGHT_PATTERN.getRegEx())) {

        phone = SEVEN.concat(phone);
        return true;
      } else {

        return false;
      }
    } else {
      if (String.valueOf(phone.charAt(ZERO))
          .matches(RegEx.EIGHT_PATTERN.getRegEx())) {

        phone = SEVEN.concat(phone.substring(ONE));
      }
      return true;
    }
  }
}
