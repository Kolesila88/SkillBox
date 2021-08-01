import exceptions.FileFormatException;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class FileUtils {

  private static final Marker EXCEPTION = MarkerManager.getMarker("EXCEPTION");
  private static final Marker FILES = MarkerManager.getMarker("FILES");
  private static final Logger LOGGER = LogManager.getRootLogger();

  public static long calculateFolderSize(String path) {

    try {
      Path pathToDir = getPath(path);
      return Files.walk(pathToDir)
          .map(Path::toFile)
          .filter(File::isFile)
          .mapToLong(File::length).sum();

    } catch (Exception e) {
      LOGGER.error( EXCEPTION,  e.getMessage());
      e.printStackTrace();
      return -1;
    }
  }

  public static long calculateFilesCountInFolder(String path) {

    try {
      Path pathToDir = getPath(path);
      return Files.walk(pathToDir)
          .map(Path::toFile)
          .peek(f -> LOGGER.info(FILES, String.format(MsgTemplates.FILES_LOG_TEMPLATE.getPattern(),
              f.isDirectory(), f.getAbsolutePath(), f.length())))
          .filter(File::isFile).count();

    } catch (Exception e) {
      LOGGER.error( EXCEPTION,  e.getMessage());
      e.printStackTrace();
      return -1;
    }
  }

  private static Path getPath(String stringPath) throws IOException, FileFormatException {

    Path pathToDir = Paths.get(stringPath);
    if (!stringPath.matches("[A-Z][:][\\\\|/].+")) {

      throw new IOException(
          String.format(MsgTemplates.I_O_EXP_MSG_TEMPLATE.getPattern(), stringPath));
    } else if (!pathToDir.toFile().exists() || !pathToDir.toFile().isDirectory()) {

      throw new FileFormatException(String
          .format(MsgTemplates.FILE_FORMAT_EXP_MSG_TEMPLATE.getPattern(), stringPath));
    } else {

      return pathToDir;
    }
  }
}
