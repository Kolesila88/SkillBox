package formatter;

import enumirations.Messages;
import enumirations.RegExs;
import enumirations.StrPatts;
import enumirations.Values;

public class PhoneFormatter {

  private static String phone;

  public static String cleanPhone(String input) {

    phone = input;
    phone = phone
        .replaceAll(RegExs.NOT_DIGITS_PATTERN.getRegEx(), StrPatts.EMPTY_LINE_STR.getStrPatt());

    if (isCorrectNumber(phone)) {

      return phone;
    } else {

      return Messages.WRONG_NUMBER_FORMAT.getMessage();
    }
  }

  private static boolean isCorrectNumber(String verifiedPhoneNumber) {

    if (verifiedPhoneNumber.length() != Values.PHONE_LENGTH.getVal()) {

      if (verifiedPhoneNumber.length() == Values.PHONE_NUMBER_LENGTH_WITHOUT_COUNTRY_CODE.getVal()
          && String.valueOf(phone.charAt(Values.ZERO.getVal()))
          .matches(RegExs.NOT_SEVEN_OR_EIGHT_PATTERN.getRegEx())) {

        phone = StrPatts.EMPTY_LINE_STR.getStrPatt().concat(phone);
        return true;
      } else {

        return false;
      }
    } else {
      if (String.valueOf(phone.charAt(Values.ZERO.getVal()))
          .matches(RegExs.EIGHT_PATTERN.getRegEx())) {

        phone = StrPatts.SEVEN_STR.getStrPatt().concat(phone.substring(Values.ONE.getVal()));
      }
      return true;
    }
  }
}
