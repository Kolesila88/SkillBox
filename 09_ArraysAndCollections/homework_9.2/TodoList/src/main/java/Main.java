import handler.CommandExecuter;
import java.util.Scanner;
import message.Message;

public class Main {

  public static void main(String[] args) {

    CommandExecuter executer = new CommandExecuter();
    System.out.print(Message.COMMAND_LIST.getMessage());
    while (true) {
      Scanner scanner = new Scanner(System.in);
      String command = scanner.nextLine();
      if (command.matches("EXIT.*")) {
        break;
      }
      executer.execute(command);
    }
  }
}
