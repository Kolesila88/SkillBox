import java.util.Scanner;
import util.CommandHandler;
import message.Messages;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println(String.format(Messages.COMMANDS_MSG.getMessage(),
        "Specify the operation to be performed."));

    while (true) {

      System.out.println(Messages.ENTER_COMMAND_MSG.getMessage());
      String operationNumber = scanner.next();

      if (operationNumber.matches("0")) {

        System.out.println(Messages.EXIT_MSG.getMessage());
        break;
      } else if (operationNumber.matches("[\\d[^0]]")) {

        CommandHandler.executeAction(Byte.parseByte(operationNumber), scanner);
      } else {

        System.out.println(String.format(Messages.COMMANDS_MSG.getMessage(),
            String.format(Messages.INCORRECT_OPERATION_MSG.getMessage(), operationNumber)));
      }
    }
    scanner.close();
  }
}
