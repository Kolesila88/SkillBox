package test;

import model.Dimensions;

import java.math.BigDecimal;

public class TestDimension {

  //Сообщения о успешности/не успешности теста
  private static final String TEST_PASSED_SUCCESSFULLY_MSG = "Test passed successfully!!!";
  private static final String TEST_FAILED_MSG = "Test failed!!!";

  //Переменные для хранения тестовых данных
  private static final BigDecimal testWidthInCentimeters = new BigDecimal(50);
  private static final BigDecimal testHeightInCentimeters = new BigDecimal(30);
  private static final BigDecimal testLengthInCentimeters = new BigDecimal(103);

  //Переменные с ожидаемыми ответами
  private static final BigDecimal expectedVolumeOfCargo = new BigDecimal(154500);
  private static final BigDecimal expectedWidthInCentimeters = new BigDecimal(50);
  private static final BigDecimal expectedHeightInCentimeters = new BigDecimal(30);
  private static final BigDecimal expectedLengthInCentimeters = new BigDecimal(103);

  public static void main(String[] args) {

    //Инициализация тестируемого объекта
    System.out.println("Dimension tests is started.");
    Dimensions testDimensions = new Dimensions(testWidthInCentimeters,
        testHeightInCentimeters,
        testLengthInCentimeters);

    //Вызов тестов
    getWidthInCentimetersTest(testDimensions, expectedWidthInCentimeters);
    getHeightInCentimetersTest(testDimensions, expectedHeightInCentimeters);
    getLengthInCentimetersTest(testDimensions, expectedLengthInCentimeters);
    calculateAndGetTheVolumeOfCargoTest(testDimensions, expectedVolumeOfCargo);
    equalsTest(testDimensions);
    System.out.println("Dimension tests finish.");
  }

  //Тесты get-методов класса Dimensions
  public static void getWidthInCentimetersTest(Dimensions testDimensions,
      BigDecimal expectedWidthInCentimeters) {

    if (testDimensions.getWidthInCentimeters().equals(expectedWidthInCentimeters)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void getHeightInCentimetersTest(Dimensions testDimensions,
      BigDecimal expectedHeightInCentimeters) {

    if (testDimensions.getHeightInCentimeters().equals(expectedHeightInCentimeters)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void getLengthInCentimetersTest(Dimensions testDimensions,
      BigDecimal expectedLengthInCentimeters) {

    if (testDimensions.getLengthInCentimeters().equals(expectedLengthInCentimeters)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  //Тест метода calculateAndGetTheVolumeOfCargo()
  public static void calculateAndGetTheVolumeOfCargoTest(Dimensions testDimensions,
      BigDecimal expectedVolumeOfCargo) {

    if (testDimensions.calculateAndGetTheVolumeOfCargo().equals(expectedVolumeOfCargo)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  //Тест метода equals()
  public static void equalsTest(Dimensions testDimensions) {

    Dimensions comparedDimensions = new Dimensions(
        expectedWidthInCentimeters, expectedHeightInCentimeters, expectedLengthInCentimeters);

    if (testDimensions.equals(comparedDimensions)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }
}
