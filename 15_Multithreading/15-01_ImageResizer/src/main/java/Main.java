import enumirations.ConsoleMsg;
import enumirations.ExceptionMsg;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import log.AppLogger;
import resizer.ImageResizer;

public class Main {

  private static int newWidth;
  private static String dstFolder;

  public static void main(String[] args) {

    //Инициализация путей и ширины.
    Scanner scanner = new Scanner(System.in);
    File srcDir = getSrcFolder(scanner);
    setDstFolder(scanner);
    setNewWidth(scanner);
    //Работа с данными.
    long start = System.currentTimeMillis();
    File[] files = srcDir.listFiles();
    List<File[]> filesArrays = listOfCompressedFileArrays(files);
    filesResize(filesArrays, dstFolder, start);
  }

  //Метод запускает для каждого элемента массива свой поток.
  private static void filesResize(List<File[]> filesArrays, String dstFolder, long start) {

    filesArrays.forEach(fa -> {
      ImageResizer resizer = new ImageResizer(fa, newWidth, dstFolder, start);
      resizer.start();
    });
  }

  //Метод равномерно распределяет файлы, из входного массива.
  private static List<File[]> listOfCompressedFileArrays(File[] files) {

    List<File[]> filesArrays = new ArrayList<>();
    final int processors = Runtime.getRuntime().availableProcessors();
    int imageArraySize = files.length / processors;
    int lastCopyFileNumber = 0;
    int remains = files.length - (imageArraySize * processors);
    if (remains != 0) {
      for (int i = 0; i < processors; i++) {
        imageArraySize++;
        File[] threadFilesArray = new File[imageArraySize];
        System.arraycopy(files, lastCopyFileNumber, threadFilesArray, 0, threadFilesArray.length);
        lastCopyFileNumber += imageArraySize - 1;
        imageArraySize--;
        remains--;
        filesArrays.add(threadFilesArray);
      }
    } else {
      File[] threadFilesArray = new File[imageArraySize];
      System.arraycopy(files, lastCopyFileNumber, threadFilesArray, 0, threadFilesArray.length);
      filesArrays.add(threadFilesArray);
    }
    return filesArrays;
  }

  //Метод проверяет корректность указанной ширины.
  private static boolean theCorrectFormat(String string) {

    if (string.matches("[0-9]*[1-9][0-9]+")) {
      return true;
    } else {
      return false;
    }
  }

  //Метод установки ширины
  private static void setNewWidth(Scanner scanner) {

    while (true) {
      try {
        AppLogger.logMessage(ConsoleMsg.SET_IMG_WITH_MSG.getMsg());
        String insertString = scanner.nextLine();
        if (theCorrectFormat(insertString)) {
          newWidth = Integer.parseInt(insertString);
          break;
        } else {
          throw new IOException(ExceptionMsg.INCORRECT_DATA_MSG.getMsg());
        }
      } catch (IOException e) {
        AppLogger.logException(e);
      }
    }
  }

  //Проверка корректности пути.
  private static boolean thisIsTheCorrectPath(String path) {

    if (path.matches("[A-Z][:]\\\\.+") || path.matches("[A-Z][:]/.+") || path
        .matches("/users/.+")) {
      return true;
    } else {
      return false;
    }
  }

  //Задаем путь к папке с обрабатываемыми данными.
  private static File getSrcFolder(Scanner scanner) {

    while (true) {
      try {
        AppLogger.logMessage(ConsoleMsg.SET_DATA_DIR_MSG.getMsg());
        String string = scanner.nextLine();
        if (thisIsTheCorrectPath(string)) {
          File srcDir = new File(string);
          if (srcDir.isDirectory() && srcDir.exists()) {
            return srcDir;
          } else {
            throw new IOException(ExceptionMsg.DIR_NOT_EXIST.getMsg());
          }
        } else {
          throw new IOException(ExceptionMsg.INVALID_PATH_MSG.getMsg());
        }
      } catch (IOException e) {

        AppLogger.logException(e);
      }
    }
  }

  //Задаем путь для сохранения измененных изображений.
  private static void setDstFolder(Scanner scanner) {

    while (true) {
      try {
        AppLogger.logMessage(ConsoleMsg.SET_SAVE_DIR_MSG.getMsg());
        String string = scanner.nextLine();
        if (thisIsTheCorrectPath(string)) {
          File dstDir = new File(string);
          if (!dstDir.exists()) {
            Files.createDirectory(dstDir.toPath());
            dstFolder = string;
            break;
          } else {
            if (dstDir.isDirectory()) {
              dstFolder = string;
              break;
            } else {
              throw new IOException(ExceptionMsg.SP_FILE_NOT_DIR.getMsg());
            }
          }
        } else {
          throw new IOException(ExceptionMsg.INVALID_PATH_MSG.getMsg());
        }
      } catch (IOException e) {
        AppLogger.logException(e);
      }
    }
  }
}

