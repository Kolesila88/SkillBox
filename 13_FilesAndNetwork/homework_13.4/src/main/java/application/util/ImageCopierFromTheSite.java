package application.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ImageCopierFromTheSite {

  private static String fileName;

  public static void copyImageFromSite(String pathToTheProcessedSite, String pathToSaveFolder)
      throws IOException {

    getLinks(pathToTheProcessedSite).stream().filter(Validator::thisIsALink)
        .filter(Validator::thisIsImageFile)
        .forEach(p -> {
          try {
            URL url = new URL(p);
            ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
            String[] pathSubstrings = p.split("/");
            for (String str : pathSubstrings) {
              if (Validator.thisIsImage(str)) {
                fileName = str.replaceAll("[~?=!]", "");
              }
            }
            if (fileName.length() > 100) {
              fileName = fileName.substring(fileName.length() - 100);
            }
            String path = pathToSaveFolder + "/" + fileName;
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.getChannel()
                .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
          } catch (Exception e) {

            AppLogger.logMessage(e.getMessage());
            AppLogger.logException(e);
          }
        });
  }

  private static List<String> getLinks(String pathToTheProcessedSite) throws IOException {
    Document doc = Jsoup.connect(pathToTheProcessedSite)
        .userAgent("Chrome/4.0.249.0 Safari/532.5")
        .referrer("http://www.google.com")
        .get();

    Elements elements = doc.select("img");
    return elements.stream()
        .map(e -> e.attr("src"))
        .collect(Collectors.toList());

  }
}
