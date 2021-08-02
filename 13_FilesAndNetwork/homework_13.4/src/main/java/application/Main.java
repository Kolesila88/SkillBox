package application;

import application.util.AppLogger;
import application.util.ImageCopierFromTheSite;
import application.util.Validator;
import application.util.templates.ConsoleMsgTemplates;
import application.util.templates.ExceptionMsgTemplates;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    try {
      while (true) {
        AppLogger.logMessage(ConsoleMsgTemplates.SPECIFY_PATH_TO_SITE.getTemplate());
        String pathToTheProcessedSite = "https://".concat(scanner.nextLine().trim());
        if (pathToTheProcessedSite.split("//")[1].equals("EXIT")) {
          break;
        } else if (!Validator.thisIsASiteLink(pathToTheProcessedSite)) {
          throw new IOException(String
              .format(ExceptionMsgTemplates.INCORRECT_PATH_TO_PROCESSED_SITE.getTemplate(),
                  pathToTheProcessedSite));
        }

        AppLogger.logMessage(ConsoleMsgTemplates.SPECIFY_PATH_TO_FOLDER.getTemplate());
        String pathToSaveFolder = scanner.nextLine().trim();
        if (!Validator.isThisThePath(pathToSaveFolder)) {
          throw new IOException(String
              .format(ExceptionMsgTemplates.INCORRECT_PATH_TO_SAVE_FOLDER.getTemplate(),
                  pathToSaveFolder));
        } else if (!new File(pathToSaveFolder).exists()) {
          new File(pathToSaveFolder).mkdir();
        }
        if (pathToSaveFolder.matches("[A-Z][:]\\\\.+")) {
          pathToSaveFolder = pathToSaveFolder.replaceAll("\\\\", "/");
        }
        ImageCopierFromTheSite.copyImageFromSite(pathToTheProcessedSite, pathToSaveFolder);
      }
    } catch (Exception e) {
      AppLogger.logException(e);
      AppLogger.logMessage(e.getMessage());
    }
  }
}
