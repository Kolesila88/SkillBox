package handler;

import java.math.BigInteger;
import message.Message;
import regex.RegEx;
import storage.TodoList;

public class CommandExecuter {

  private final TodoList todoList;

  public CommandExecuter() {

    todoList = new TodoList();
  }

  public void execute(String command) {

    switch (command.split(RegEx.SPACE_REGEX.getRegex())[BigInteger.ZERO.intValue()]) {
      case "ADD":

        executeAdd(command);
        break;
      case "DELETE":

        executeDelete(command);
        break;
      case "EDIT":

        executeEdit(command);
        break;
      case "LIST":

        executeList();
        break;
      default:

        System.out.println(Message.BAD_COMMAND.getMessage());
        break;
    }
  }

  private void executeAdd(String command) {

    if (command.split(RegEx.SPACE_REGEX.getRegex())[BigInteger.ONE.intValue()].trim()
        .matches(RegEx.NUMBER_REGEX.getRegex())) {

      todoList.add(Integer.parseInt(command
              .split(RegEx.SPACE_REGEX.getRegex())[BigInteger.ONE.intValue()].trim()),
          command.split(RegEx.NUMBER_REGEX.getRegex())[BigInteger.ONE.intValue()].trim());
    } else {

      todoList.add(command.split(RegEx.ADD_REGEX.getRegex())[BigInteger.ONE.intValue()].trim());
    }
  }

  private void executeDelete(String command) {

    if (command.split(RegEx.SPACE_REGEX.getRegex())[BigInteger.ONE.intValue()]
        .matches(RegEx.NUMBER_REGEX.getRegex())
        && Integer.parseInt(command.split(
        RegEx.SPACE_REGEX.getRegex())[BigInteger.ONE.intValue()]) < todoList
        .getTodo().size()) {

      todoList.delete(Integer.parseInt(command
          .split(RegEx.SPACE_REGEX.getRegex())[BigInteger.ONE.intValue()]));
    }
  }

  private void executeEdit(String command) {

    if (command.split(RegEx.SPACE_REGEX.getRegex())[BigInteger.ONE.intValue()]
        .matches(RegEx.NUMBER_REGEX.getRegex())
        && Integer.parseInt(command
        .split(RegEx.SPACE_REGEX.getRegex())[BigInteger.ONE.intValue()]) <
        todoList.getTodo().size()) {

      todoList.edit(command.split(RegEx.NUMBER_REGEX.getRegex())[BigInteger.ONE.intValue()]
              .trim(),
          Integer.parseInt(command
              .split(RegEx.SPACE_REGEX.getRegex())[BigInteger.ONE.intValue()]));
    }
  }

  private void executeList() {

    for (String s : todoList.getTodo()) {
      System.out.println(s);
    }
  }
}
