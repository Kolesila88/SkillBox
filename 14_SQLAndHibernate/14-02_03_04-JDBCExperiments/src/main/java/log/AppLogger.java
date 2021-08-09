package log;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class AppLogger<T> {

  private static final Marker EXCEPTION = MarkerManager.getMarker("EXCEPTION");
  private static final Marker CONSOLE = MarkerManager.getMarker("CONSOLE");
  private static final Logger LOGGER = LogManager.getRootLogger();

  public AppLogger() {
  }

  public static void logException(Exception e) {

    LOGGER.error(EXCEPTION, Arrays.toString(e.getStackTrace()).concat(System.lineSeparator())
        .concat(e.getMessage()));
  }

  public static void logMessage(String message) {

    LOGGER.info(CONSOLE, message);
  }

  public void logResponse(List<T> entities) {

    entities.forEach(p -> LOGGER.info(CONSOLE, p.toString()));
    System.out.println();
  }
}

