package util;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import storage.Movements;
import util.templates.LogTemplates;

public class MovementsLogger {

  private static final Marker EXCEPTION = MarkerManager.getMarker("EXCEPTION");
  private static final Marker CONSOLE = MarkerManager.getMarker("CONSOLE");
  private static final Logger logger = LogManager.getRootLogger();

  public static void logReport(Movements movements) {

    logger.info(CONSOLE,String.format(LogTemplates.REPORT_CONSOLE_LOG_TEMPLATE.getTemplate(),
        movements.getExpenseSum(), movements.getIncomeSum(), movements.getBilling()));
  }

  public static void logException(Exception e) {

    logger.error(EXCEPTION, Arrays.toString(e.getStackTrace()).concat(System.lineSeparator())
        .concat(e.getMessage()));
  }
  public static void logMessage(String message) {

    logger.info(CONSOLE, message);
  }
}
