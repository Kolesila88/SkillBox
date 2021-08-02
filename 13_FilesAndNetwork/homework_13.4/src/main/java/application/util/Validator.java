package application.util;

public class Validator {

  protected static boolean thisIsALink(String link) {

    if (link.matches("https://.+")) {

      return true;
    } else {

      return false;
    }
  }

  protected static boolean thisIsImage(String link) {

    if (link.matches(".+\\.(png|jpg|jpeg|bmp|gif|tif)")) {

      return true;
    } else {

      return false;
    }
  }

  protected static boolean thisIsImageFile(String link) {

    if (link.matches(".+\\.(png|jpg|jpeg|bmp|gif|tif).*")) {

      return true;
    } else {

      return false;
    }
  }

  public static boolean thisIsASiteLink(String link) {

    if (link.matches(".+\\.[a-z]{2,3}")) {

      return true;
    } else {

      return false;
    }
  }

  public static boolean isThisThePath(String path) {

    if (path.matches("[A-Z][:]\\\\.+") || path.matches(".*/.+") || path.matches("[A-Z][:]/.+")) {

      return true;
    } else {

      return false;
    }
  }

}
