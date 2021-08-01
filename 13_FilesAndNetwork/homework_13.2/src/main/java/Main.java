import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Main {

  private static final Marker CONSOLE = MarkerManager.getMarker("CONSOLE");
  private static final Marker EXCEPTION = MarkerManager.getMarker("EXCEPTION");

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String sourceDirectory;
    String destinationDirectory;

    while (true) {

      FileUtils.getLogger().info(CONSOLE,
          "Specify the absolute path to the copied file, or enter \"EXIT\" to exit from program.");
      sourceDirectory = scanner.nextLine().trim();
      if (sourceDirectory.matches("EXIT")) {
        break;
      }
      FileUtils.getLogger()
          .info(CONSOLE, "Specify the absolute path to the location where the copied file is saved.");
      destinationDirectory = scanner.nextLine().trim();
      try {
        if (isCorrectPathsSpecified(sourceDirectory, destinationDirectory)) {

          FileUtils.copyFolder(sourceDirectory, destinationDirectory);
        } else {
          throw new IOException(
              String.format("Invalid format %s or %s.", sourceDirectory, destinationDirectory));
        }
      } catch (Exception e) {

        FileUtils.getLogger().error(EXCEPTION,
            Arrays.toString(e.getStackTrace()).concat(System.lineSeparator())
                .concat(e.getMessage()));
      }
    }
  }

  private static boolean isCorrectPathsSpecified(String sourceDirectory,
      String destinationDirectory) {

    String regex = "[A-Z][:]\\\\.+";
    if (sourceDirectory.matches(regex) && destinationDirectory.matches(regex)) {

      return true;
    } else {

      return false;
    }
  }
}
