import java.io.IOException;
import java.util.Scanner;
import storage.Movements;
import util.MovementsLogger;
import util.PathValidator;
import util.templates.ExceptionMsgTemplate;
import util.templates.LogTemplates;

public class Main {

  private static final String PATH_TO_FILE = "src/main/resources/movementList.csv";

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String pathToFile;

    while (true) {
      MovementsLogger.logMessage(LogTemplates.INFO_CONSOLE_LOG_TEMPLATE.getTemplate());

      pathToFile = scanner.nextLine().trim();
      pathToFile = pathToFile.isBlank() ? PATH_TO_FILE : pathToFile;
      if (pathToFile.equals("EXIT")) {
        break;
      }
      if (PathValidator.isValidPath(pathToFile)) {
        MovementsLogger.logReport(new Movements(pathToFile));
      } else {

        try {
          throw new IOException(
              String.format(ExceptionMsgTemplate.INVALID_PATH_TEMPLATE.getTemplate(), pathToFile));
        } catch (IOException e) {

          MovementsLogger.logException(e);
        }
      }
    }
  }
}
