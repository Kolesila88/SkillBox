import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Main {

  private static final Marker CONSOLE = MarkerManager.getMarker("CONSOLE");

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Logger logger = LogManager.getRootLogger();
    while (true) {
      logger.info(CONSOLE, "Введите путь до папки.");
      String path = scanner.nextLine();
      if (path.matches("EXIT")) {
        break;
      }
      long calculateFolderSizeResponse = FileUtils.calculateFolderSize(path);
      long calculateFilesCountInFolderResponse = FileUtils.calculateFilesCountInFolder(path);
      if (calculateFolderSizeResponse != -1 && calculateFilesCountInFolderResponse != -1) {
        logger.info(CONSOLE, String
            .format(MsgTemplates.CONSOLE_LOG_TEMPLATE.getPattern(), path,
                formatResponse(calculateFolderSizeResponse), calculateFilesCountInFolderResponse));
      }
    }
  }

  private static String formatResponse(long value) {

    final long KILOBYTE = 1024;
    final long MEGABYTE = 1048576;
    final long GIGABYTE = 1073741824;

    if (value > GIGABYTE) {

      return BigDecimal.valueOf(value)
          .divide(BigDecimal.valueOf(GIGABYTE), 3, RoundingMode.HALF_UP)
          .toString().concat(" Gb.");
    } else if (value > MEGABYTE) {

      return BigDecimal.valueOf(value)
          .divide(BigDecimal.valueOf(MEGABYTE), 3, RoundingMode.HALF_UP).toString()
          .concat(" Mb.");
    } else if (value > KILOBYTE) {

      return BigDecimal.valueOf(value)
          .divide(BigDecimal.valueOf(KILOBYTE), 3, RoundingMode.HALF_UP).toString()
          .concat(" Kb.");
    } else {

      return String.valueOf(value).concat(" Bites.");
    }
  }

}
