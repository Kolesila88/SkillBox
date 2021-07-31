import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class FileUtils {

  private static final Marker EXCEPTION = MarkerManager.getMarker("EXCEPTION");
  private static final Logger LOGGER = LogManager.getRootLogger();

  public static void copyFolder(String sourceDirectory, String destinationDirectory)
      throws IOException {

    if (Paths.get(sourceDirectory).toFile().exists()) {

      if (Paths.get(sourceDirectory).toFile().isDirectory()) {

        copyAllFiles(sourceDirectory, destinationDirectory);
      } else {

        Files.copy(Paths.get(sourceDirectory), Paths.get(destinationDirectory));
      }
    } else {

      throw new FileNotFoundException(String.format("File %s not exists.", sourceDirectory));
    }
  }

  public static Logger getLogger() {
    return LOGGER;
  }

  private static void copyAllFiles(String sourceDirectory, String destinationDirectory)
      throws IOException {
    TreeMap<Path, Path> paths = new TreeMap<>();

    Files.walk(Paths.get(sourceDirectory))
        .forEach(p -> {
          paths.put(p, Paths.get(destinationDirectory
              .concat("\\").concat(Paths.get(sourceDirectory).relativize(p).toString())));
          try {
            Files.copy(p, paths.get(p));
          } catch (IOException e) {
            LOGGER.error(EXCEPTION,
                Arrays.toString(e.getStackTrace()).concat(System.lineSeparator())
                    .concat(e.getMessage()));
          }
        });
  }
}
