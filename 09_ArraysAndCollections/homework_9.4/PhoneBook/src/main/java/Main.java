import enumirations.Messages;
import executor.CommandExecutor;
import input.Input;

public class Main {

  public static void main(String[] args) {

    System.out.println(String
        .format(Messages.ENTER.getMessage(), System.lineSeparator(), System.lineSeparator()));

    while (true) {
      String command = Input.getScanner()
          .nextLine()
          .toUpperCase();
      if (command.equals("EXIT")) {
        break;
      }
      CommandExecutor.execute(command);
    }
  }
}
