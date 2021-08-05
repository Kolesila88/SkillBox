package resizer;

import enumirations.ConsoleMsg;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import log.AppLogger;
import org.imgscalr.Scalr;

public class ImageResizer extends Thread {

  private File[] files;
  private String dstFolder;
  private int newWidth;
  private long start;

  public ImageResizer(File[] files, int newWidth, String dstFolder, long start) {

    this.files = files;
    this.dstFolder = dstFolder;
    this.newWidth = newWidth;
    this.start = start;
  }

  @Override
  public void run() {
    AppLogger.logMessage(ConsoleMsg.THREAD_STARTED_MSG.getMsg());

    try {
      for (File file : files) {
        BufferedImage image = ImageIO.read(file);
        if (image == null) {
          continue;
        }
        int newHeight = (int) Math.round(
            image.getHeight() / (image.getWidth() / (double) newWidth)
        );
        BufferedImage newImage = Scalr.resize(image, newWidth, newHeight, Scalr.OP_ANTIALIAS);

        File newFile = new File(dstFolder.concat("/".concat(file.getName())));
        ImageIO.write(newImage, "jpg", newFile);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      AppLogger.logException(ex);
    }
    AppLogger.logMessage(
        String.format(ConsoleMsg.THREAD_FINISHED_MSG.getMsg(), System.currentTimeMillis() - start));
  }
}
