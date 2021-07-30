package exceptions;

public class FileFormatException extends Exception {

  public FileFormatException() {
    super();
  }

  public FileFormatException(String message) {
    super(message);
  }

  public FileFormatException(String message, Throwable cause) {
    super(message,  cause);
  }

  public FileFormatException(Throwable cause) {
    super(cause);
  }

  protected FileFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message,  cause,  enableSuppression,  writableStackTrace);
  }
}
