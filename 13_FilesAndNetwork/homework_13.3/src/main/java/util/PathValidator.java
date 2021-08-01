package util;

import java.nio.file.Paths;

public class PathValidator {

  public static boolean isValidPath(String path) {

    if (path.matches( "([A-Z][:][\\\\|/])?.+[\\\\|/]?.+\\.csv") && Paths.get(path).toFile().exists()) {

      return true;
    } else {

      return false;
    }
  }
}
