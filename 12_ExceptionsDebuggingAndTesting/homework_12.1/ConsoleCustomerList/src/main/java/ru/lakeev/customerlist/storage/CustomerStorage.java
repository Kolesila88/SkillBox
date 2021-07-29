package ru.lakeev.customerlist.storage;

import java.util.HashMap;
import java.util.Map;
import ru.lakeev.customerlist.exceptions.CommandException;
import ru.lakeev.customerlist.exceptions.CustomerException;
import ru.lakeev.customerlist.messages.CommandExpMsg;
import ru.lakeev.customerlist.messages.CustomerExpMsg;
import ru.lakeev.customerlist.model.Customer;

public class CustomerStorage {

  private final Map<String, Customer> storage;

  public CustomerStorage() {
    storage = new HashMap<>();
  }

  public void addCustomer(String data) throws CustomerException, CommandException {
    if (data.split("\\s+").length != 4) {

      throw new CommandException(CommandExpMsg.COMMAND_ERROR.getMsg());
    } else {

      final int INDEX_NAME = 0;
      final int INDEX_SURNAME = 1;
      final int INDEX_EMAIL = 2;
      final int INDEX_PHONE = 3;

      String[] components = data.split("\\s+");
      String name = components[INDEX_NAME].concat(" ").concat(components[INDEX_SURNAME]);

      if (isName(name) && isPhone(components[INDEX_PHONE].replaceAll("\\s", ""))
          && isEmail(components[INDEX_EMAIL])) {

        storage.put(name,
            new Customer(name,
                components[INDEX_PHONE].replaceAll("[^\\d\\+]", ""),
                components[INDEX_EMAIL]));
      } else {
        if (!isName(name)) {
          throw new CustomerException(String
              .format(CustomerExpMsg.INCORRECT_FORMAT.getMsg(), "name.", "Василий Петров"));
        } else if (!isPhone(components[INDEX_PHONE])) {
          throw new CustomerException(String
              .format(CustomerExpMsg.INCORRECT_FORMAT.getMsg(), "phone.", "+79215637722"));
        } else if (!isEmail(components[INDEX_EMAIL])) {
          throw new CustomerException(String
              .format(CustomerExpMsg.INCORRECT_FORMAT.getMsg(), "email.", "vasily.petrov@gmail.com"));
        }
      }
    }
  }

  public void listCustomers() throws CommandException {
    if (storage.isEmpty()) {

      throw new CommandException(CommandExpMsg.STORAGE_IS_EMPTY.getMsg());
    } else {
      storage.values().forEach(System.out::println);
    }
  }

  public void removeCustomer(String name) throws CommandException, CustomerException {
    if (storage.isEmpty()) {

      throw new CommandException(CommandExpMsg.STORAGE_IS_EMPTY.getMsg());
    } else if (!isName(name)) {

      throw new CustomerException(String
          .format(CustomerExpMsg.INCORRECT_FORMAT.getMsg(), "name.", "Василий Петров"));
    } else {
      storage.remove(name);
    }
  }

  public Customer getCustomer(String name) throws CommandException, CustomerException {
    if (storage.isEmpty()) {

      throw new CommandException(CommandExpMsg.STORAGE_IS_EMPTY.getMsg());
    } else if (!isName(name)) {

      throw new CustomerException(String
          .format(CustomerExpMsg.INCORRECT_FORMAT.getMsg(), "name.", "Василий Петров"));
    } else {
      if (storage.containsKey(name)) {

        return storage.get(name);
      } else {

        throw new CustomerException(CustomerExpMsg.NOT_CUSTOMER.getMsg());
      }
    }
  }

  public int getCount() {

    return storage.size();
  }

  private boolean isPhone(String text) {

    final String phonePattern =
        "[+]?[7-8]?[-]?[(]?[\\d]{3}[)]?[-]?[\\d]{3}[-]?[\\d]{2}[-]?[\\d]{2}";
    return text.matches(phonePattern);
  }

  private boolean isName(String text) {

    final String namePattern =
        "[А-Я][а-я]+[-[А-Я]]?[а-я]*\\s[А-Я][а-я]+[-[А-Я]]?[а-я]*";
    return text.matches(namePattern);
  }

  private boolean isEmail(String text) {

    final String mailPattern = "\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*\\.\\w{2,4}";
    return text.matches(mailPattern);
  }
}