package executor;

import enumirations.Messages;
import enumirations.RegExs;
import enumirations.StrPatts;
import enumirations.Values;
import formatter.PhoneFormatter;
import input.Input;
import storage.PhoneBook;

public class CommandExecutor {

  private static PhoneBook phoneBook = new PhoneBook();

  public static void execute(String command) {

    switch (command) {
      case "LIST":

        if (phoneBook.getAllContacts().size() == Values.ZERO.getVal()) {

          System.out.println(Messages.PHONE_BOOK_IS_EMPTY.getMessage());
        } else {

          for (String contact : phoneBook.getAllContacts()) {

            System.out.println(contact);
          }
        }
        break;
      default:

        searchAddOrUpdateContact(command);
        break;
    }
  }

  private static void searchAddOrUpdateContact(String command) {

    if (command.matches(RegExs.NAME_PATTERN.getRegEx())) {

      if (phoneBook.getPhonesByName(command).size() == Values.ZERO.getVal()) {

        processName(command);
      } else {

        for (String contact : phoneBook.getPhonesByName(command)) {

          System.out.println(contact);
        }
      }
    } else if (command
        .replaceAll(RegExs.SPACE_PATTERN.getRegEx(), StrPatts.EMPTY_LINE_STR.getStrPatt())
        .matches(RegExs.PHONE_NUMBER_PATTERN.getRegEx())) {

      processPhoneNum(command);
    } else {

      System.out.println(Messages.WRONG_INPUT_FORMAT.getMessage());
    }
  }

  private static void processName(String command) {

    if (phoneBook.getPhonesByName(command).size() == Values.ZERO.getVal()) {

      System.out.println(String
          .format(Messages.NAME_NOT_FOUND_IN_PHONE_BOOK.getMessage(), System.lineSeparator(),
              command));
      inputPhoneNumFromScannerAndSaveContact(command);
    } else {

      for (String contact : phoneBook.getPhonesByName(command)) {

        System.out.println(contact);
      }
    }
  }

  private static void processPhoneNum(String command) {

    if (phoneBook.getNameByPhone(PhoneFormatter.cleanPhone(
        command
            .replaceAll(RegExs.SPACE_PATTERN.getRegEx(), StrPatts.EMPTY_LINE_STR.getStrPatt())))
        .equals(StrPatts.EMPTY_LINE_STR.getStrPatt())) {

      System.out.println(String
          .format(Messages.PHONE_NOT_FOUND_IN_PHONE_BOOK.getMessage(), System.lineSeparator(),
              PhoneFormatter
                  .cleanPhone(command.replaceAll(RegExs.SPACE_PATTERN.getRegEx(),
                      StrPatts.EMPTY_LINE_STR.getStrPatt()))));
      inputNameFromScannerAndSaveContact(command);

    } else {

      System.out.println(phoneBook.getNameByPhone(PhoneFormatter.cleanPhone(command)));
    }
  }

  private static void inputNameFromScannerAndSaveContact(String number) {

    while (true) {

      String name = Input.getScanner().nextLine().toUpperCase();

      if (name.matches(RegExs.NAME_PATTERN.getRegEx())) {

        String contPhoneNum = PhoneFormatter.cleanPhone(number
            .replaceAll(RegExs.SPACE_PATTERN.getRegEx(), StrPatts.EMPTY_LINE_STR.getStrPatt()));
        phoneBook.addContact(contPhoneNum, name);
        break;
      } else {

        System.out.println(Messages.WRONG_INPUT_FORMAT.getMessage());
      }
    }
  }

  public static void inputPhoneNumFromScannerAndSaveContact(String name) {

    while (true) {

      String phone = Input.getScanner().nextLine();

      if (phone.replaceAll(RegExs.SPACE_PATTERN.getRegEx(), StrPatts.EMPTY_LINE_STR.getStrPatt())
          .matches(RegExs.PHONE_NUMBER_PATTERN.getRegEx())) {

        phone = PhoneFormatter.cleanPhone(phone);
        phoneBook.addContact(phone, name);
        break;
      } else {

        System.out.println(Messages.WRONG_INPUT_FORMAT.getMessage());
      }
    }
  }
}
