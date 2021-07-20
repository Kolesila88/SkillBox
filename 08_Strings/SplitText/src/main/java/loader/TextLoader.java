package loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextLoader {

  public static String getTextFrom(String path) throws IOException {
    StringBuilder text = new StringBuilder();
    Files.readAllLines(Paths.get(path))
        .forEach(s -> text.append(s).append(System.lineSeparator()));
    return text.toString();
  }
}
