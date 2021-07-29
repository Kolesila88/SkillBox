package ru.lakeev.customerlist;

import java.util.Scanner;
import ru.lakeev.customerlist.exceptions.CommandException;
import ru.lakeev.customerlist.exceptions.CustomerException;
import ru.lakeev.customerlist.messages.CommandExpMsg;
import ru.lakeev.customerlist.messages.Msg;
import ru.lakeev.customerlist.storage.CustomerStorage;

public class Main {


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CustomerStorage executor = new CustomerStorage();

    while (true) {
      String command = scanner.nextLine();
      String[] tokens = command.split("\\s+", 2);

      try {
        switch (tokens[0]) {

          case "add":
            if (tokens.length == 1) {
              throw new CommandException(CommandExpMsg.COMMAND_ERROR.getMsg());
            } else {
              executor.addCustomer(tokens[1]);
              break;
            }
          case "list":
            if (tokens.length > 1) {
              throw new CommandException(CommandExpMsg.COMMAND_ERROR.getMsg());
            } else {
              executor.listCustomers();
              break;
            }
          case "remove":
            if (tokens.length != 3) {
              throw new CommandException(CommandExpMsg.COMMAND_ERROR.getMsg());
            } else {
              executor.removeCustomer(tokens[1]);
              break;
            }
          case "count":
            if (tokens.length > 1) {
              throw new CommandException(CommandExpMsg.COMMAND_ERROR.getMsg());
            } else {
              System.out.println(
                  String.format(Msg.CUSTOMER_COUNT_MSG.getMsg(), executor.getCount()));
            }
          case "get":
            if (tokens.length != 3) {
              throw new CommandException(CommandExpMsg.COMMAND_ERROR.getMsg());
            } else {
              executor.getCustomer(tokens[1]);
              break;
            }
          case "help":
            if (tokens.length > 1) {
              throw new CommandException(CommandExpMsg.COMMAND_ERROR.getMsg());
            } else {
              System.out.println(Msg.HELP_TEXT.getMsg());
              break;
            }
          default:
            throw new CommandException(CommandExpMsg.COMMAND_ERROR.getMsg());
        }
      } catch (CustomerException | CommandException ex) {
        System.err.println(ex.getMessage());
      }
    }
  }
}
