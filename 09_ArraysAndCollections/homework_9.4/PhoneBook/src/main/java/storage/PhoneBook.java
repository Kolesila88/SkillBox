package storage;

import enumirations.RegExs;
import enumirations.StrPatts;
import enumirations.Values;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

  private TreeMap<String, String> phoneBook;

  public PhoneBook() {

    phoneBook = new TreeMap<>();
  }

  public void addContact(String phone, String name) {

    if (phone.matches(RegExs.PHONE_NUMBER_PATTERN.getRegEx())
        && name.matches(RegExs.NAME_PATTERN.getRegEx())) {

      phoneBook.put(phone, name);
    }
  }

  public String getNameByPhone(String phone) {

    if (phoneBook.containsKey(phone)) {

      return String.format(StrPatts.CONTACT_FORMAT_STR.getStrPatt(), phoneBook.get(phone), phone);
    } else {

      return StrPatts.EMPTY_LINE_STR.getStrPatt();
    }
  }

  public Set<String> getPhonesByName(String name) {

    Set<String> contactSet = new TreeSet<>();
    if (phoneBook.containsValue(name)) {

      String contact = name.concat(StrPatts.HYPHEN_STR.getStrPatt());
      for (String phone : phoneBook.keySet()) {

        if (phoneBook.get(phone).equals(name)) {

          contact = contact.concat(phone).concat(StrPatts.COMMA_AND_SPACEBAR_STR.getStrPatt());
        }
      }
      contactSet.add(contact
          .substring(Values.ZERO.getVal(), contact.length() - Values.TWO.getVal()));
    }
    return contactSet;
  }

  public Set<String> getAllContacts() {

    Set<String> contactNameSet = new TreeSet<>();
    Set<String> contacts = new TreeSet<>();
    for (String number : phoneBook.keySet()) {

      contactNameSet.add(phoneBook.get(number));
    }
    String contact = StrPatts.EMPTY_LINE_STR.getStrPatt();
    for (String name : contactNameSet) {

      contact = contact.concat(name).concat(StrPatts.HYPHEN_STR.getStrPatt());

      for (String number : phoneBook.keySet()) {

        if (name.equals(phoneBook.get(number))) {

          contact = contact.concat(number).concat(StrPatts.COMMA_AND_SPACEBAR_STR.getStrPatt());
        }
      }
      contacts.add(contact.substring(Values.ZERO.getVal(), contact.length() - Values.TWO.getVal()));
      contact = StrPatts.EMPTY_LINE_STR.getStrPatt();
    }
    return contacts;
  }
}