package executor;

import emumirations.Command;
import java.util.List;
import emumirations.Message;
import emumirations.RegEx;
import storage.EmailList;

public class CommandExecutor {

  private static final int ZERO = 0;
  private static final int ONE = 1;

  private static CommandExecutor instance = new CommandExecutor();

  private final EmailList emailList;

  private CommandExecutor() {

    emailList = new EmailList();
  }

  public static CommandExecutor getInstance() {
    if (instance == null) {

      instance = new CommandExecutor();
    }
    return instance;
  }

  public void execute(String command) {

    if (command.split(RegEx.SPACE_PATTERN.getRegex())[ZERO].equals(Command.ADD.getCmd())
        && command.split(RegEx.SPACE_PATTERN.getRegex())[ONE]
        .matches(RegEx.MAIL_PATTERN.getRegex())) {

      emailList.add(command.split(RegEx.SPACE_PATTERN.getRegex())[ONE].trim());
    } else if (command.split(RegEx.SPACE_PATTERN.getRegex())[ZERO].equals(Command.ADD.getCmd())) {

      System.out.println(Message.NOT_VALID_EMAIL.getMsg());

    } else if (command.equals(Command.LIST.getCmd())) {

      List<String> sortedList = emailList.getSortedEmails();
      if (sortedList.size() > ZERO) {
        for (String email : sortedList) {

          System.out.println(email);
        }
      } else {
        System.out.println(Message.LIST_IS_EMPTY.getMsg());
      }
    } else if (command.split(RegEx.SPACE_PATTERN.getRegex())[ZERO].equals(Command.DELETE.getCmd())
          && command.split(RegEx.SPACE_PATTERN.getRegex())[ONE]
              .matches(RegEx.MAIL_PATTERN.getRegex())) {

      emailList.delete(command.split(RegEx.SPACE_PATTERN.getRegex())[ONE]);

    } else if (command.matches(Command.CLEAR.getCmd())) {

      emailList.clearSet();
    } else {

      System.out.println(Message.COMMAND_NOT_SUPPORTED.getMsg());
    }
  }
}
