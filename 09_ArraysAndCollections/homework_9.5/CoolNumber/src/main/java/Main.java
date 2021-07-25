import enumirations.RegExs;
import enumirations.StrPatterns;
import generator.CoolNumbers;
import java.util.Scanner;
import storage.CoolNumbersStorage;

public class Main {

  private static final CoolNumbersStorage STORAGE = CoolNumbersStorage
      .getStorage(CoolNumbers.generateCoolNumbers());

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println(String.format(StrPatterns.HELLO_MSG_PATTERN.getPattern(),
          System.lineSeparator(), System.lineSeparator()));

      String number = scanner.nextLine().toUpperCase();

      if (number.matches(RegExs.CAR_NUMBER.getRegEx())) {
        CoolNumbers.bruteForceSearchInList(STORAGE.getNumbersList(), number);
        CoolNumbers.binarySearchInList(STORAGE.getNumbersList(), number);
        CoolNumbers.searchInTreeSet(STORAGE.getNumbersTreeSet(), number);
        CoolNumbers.searchInHashSet(STORAGE.getNumbersHashSet(), number);
      } else {
        System.out.println(String
            .format(StrPatterns.WRONG_NUMBER_FORMAT_PATTERN.getPattern(), System.lineSeparator()));
      }
    }
  }
}
