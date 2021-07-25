package generator;

import enumirations.DigitalVals;
import enumirations.StrPatterns;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CoolNumbers {


  private static final char[] COOL_CAR_NUM_CHARS =
      {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};

  public static List<String> generateCoolNumbers() {

    List<String> carNumbersList = new ArrayList<>();

    for (int firstCharInd = DigitalVals.ZERO.getVal(); firstCharInd < COOL_CAR_NUM_CHARS.length;
        firstCharInd++) {

      for (int carNum = DigitalVals.ZERO.getVal();
          carNum < DigitalVals.INVALID_DIGIT_IN_CAR_NUM.getVal(); carNum++) {

        for (int secondCharInd = DigitalVals.ZERO.getVal();
            secondCharInd < COOL_CAR_NUM_CHARS.length; secondCharInd++) {

          for (int thirdCharInd = DigitalVals.ZERO.getVal();
              thirdCharInd < COOL_CAR_NUM_CHARS.length; thirdCharInd++) {

            for (int regIndex = DigitalVals.ONE.getVal();
                regIndex <= DigitalVals.MAX_REG_INDEX.getVal(); regIndex++) {

              String strRegIndex = Integer.toString(regIndex);
              strRegIndex = formatRegIndex(strRegIndex);
              collectAndAddInListCarNumber(
                  carNumbersList, carNum, firstCharInd, secondCharInd, thirdCharInd, strRegIndex);
            }
          }
        }
      }
    }
    return carNumbersList;
  }

  public static boolean bruteForceSearchInList(List<String> list, String number) {

    long startSearch = System.nanoTime();
    boolean numberIsContained = list.contains(number);
    long durationSearch = System.nanoTime() - startSearch;

    if (numberIsContained) {

      System.out.println(String.format(StrPatterns.FOUND_RESULT_PATTERN.getPattern(),
          "Поиск перебором:", "", System.lineSeparator(), durationSearch, System.lineSeparator()));
    } else {

      System.out.println(String
          .format(StrPatterns.FOUND_RESULT_PATTERN.getPattern(),
              "Поиск перебором:", "не", System.lineSeparator(), durationSearch,
              System.lineSeparator()));
    }
    return numberIsContained;
  }

  public static boolean binarySearchInList(List<String> sortedList, String number) {
    long startSearch = System.nanoTime();
    long numberIndex = Collections.binarySearch(sortedList, number);
    long durationSearch = System.nanoTime() - startSearch;

    if (numberIndex >= 0) {

      System.out.println(String.format(StrPatterns.FOUND_RESULT_PATTERN.getPattern(),
          "Бинарный поиск:", "", System.lineSeparator(), durationSearch, System.lineSeparator()));
      return true;
    } else {

      System.out.println(String.format(StrPatterns.FOUND_RESULT_PATTERN.getPattern(),
          "Бинарный поиск:", "не", System.lineSeparator(), durationSearch, System.lineSeparator()));
      return false;
    }
  }

  public static boolean searchInHashSet(Set<String> hashSet, String number) {
    long startSearch = System.nanoTime();
    boolean numberIsContained = hashSet.contains(number);
    long durationSearch = System.nanoTime() - startSearch;

    if (numberIsContained) {

      System.out.println(String.format(StrPatterns.FOUND_RESULT_PATTERN.getPattern(),
          "Поиск в HashSet:", "", System.lineSeparator(), durationSearch, System.lineSeparator()));
    } else {

      System.out.println(String.format(StrPatterns.FOUND_RESULT_PATTERN.getPattern(),
          "Поиск в HashSet:", "не", System.lineSeparator(), durationSearch,
          System.lineSeparator()));
    }
    return numberIsContained;
  }

  public static boolean searchInTreeSet(Set<String> treeSet, String number) {
    long startSearch = System.nanoTime();
    boolean numberIsContained = treeSet.contains(number);
    long durationSearch = System.nanoTime() - startSearch;

    if (numberIsContained) {

      System.out.println(String.format(StrPatterns.FOUND_RESULT_PATTERN.getPattern(),
          "Поиск в TreeSet:", "", System.lineSeparator(), durationSearch, System.lineSeparator()));
    } else {

      System.out.println(String.format(StrPatterns.FOUND_RESULT_PATTERN.getPattern(),
          "Поиск в TreeSet:", "не", System.lineSeparator(), durationSearch,
          System.lineSeparator()));
    }
    return numberIsContained;
  }

  private static String formatRegIndex(String stringRegionIndex) {

    if (stringRegionIndex.length() == 1) {
      return String
          .format(StrPatterns.ONE_ZERO_PATTERN.getPattern(), stringRegionIndex);
    }
    return stringRegionIndex;
  }

  private static void collectAndAddInListCarNumber(List<String> carNumbersList,
      int carNum, int firstCharInd, int secondCharInd, int thirdCharInd, String stringRegionIndex) {

    String carNumber =
        Character.toString(COOL_CAR_NUM_CHARS[firstCharInd])
            .concat(Integer.toString(carNum))
            .concat(Integer.toString(carNum))
            .concat(Integer.toString(carNum))
            .concat(Character.toString(COOL_CAR_NUM_CHARS[secondCharInd]))
            .concat(Character.toString(COOL_CAR_NUM_CHARS[thirdCharInd]))
            .concat(stringRegionIndex);
    carNumbersList.add(carNumber);
  }
}
