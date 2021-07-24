package input;

import java.util.Scanner;

public class Input {

  private static Scanner instance;

  public static Scanner getInstance() {

    if (instance == null) {

      instance = new Scanner(System.in);
    }
    return instance;
  }
}
