package ru.lakeev.customerlist.exceptions;

public class CustomerException extends Exception {

  protected CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public CustomerException() {
    super();
  }

  public CustomerException(String message) {
    super(message);
  }

  public CustomerException(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomerException(Throwable cause) {
    super(cause);
  }
}
