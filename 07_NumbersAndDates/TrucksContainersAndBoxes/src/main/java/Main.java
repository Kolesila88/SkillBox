import java.util.Scanner;

import calculator.TrucksAndContainersCalculator;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    while (true) {

      String boxes = scanner.nextLine();

      if (isNumber(boxes)) {

        int boxCount = Integer.parseInt(boxes);

        System.out.println(TrucksAndContainersCalculator
            .arrangeBoxesIntoContainersAndTrucks(boxCount));
      } else {

        break;
      }
    }
    scanner.close();
  }

  private static boolean isNumber(String string) {

    String numberPattern = "\\d*";

    if (string.matches(numberPattern)) {

      return true;
    } else {

      return false;
    }
  }
}
