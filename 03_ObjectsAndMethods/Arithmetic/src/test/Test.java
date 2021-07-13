package test;

import arithmetic.Arithmetic;

import java.util.Random;

public class Test {

  //Сообщения о успешном\неуспешном прохождении теста
  private static final String TEST_PASSED_SUCCESSFULLY_MSG = "Test passed successfully!!!";
  private static final String TEST_FAILED_MSG = "Test failed!!!";

  //Герератор случайных значений
  private static Random random = new Random();

  public static void main(String[] args) {

    //Значения передаваемые в конструктор
    final int firstValue = getRandomValue();
    final int secondValue = getRandomValue();

    //Значения ожидаемые в качестве результата
    final int expectedSum = firstValue + secondValue;
    final int expectedResultingMultiplication = firstValue * secondValue;
    final int expectedMaxValue = Math.max(firstValue, secondValue);
    final int expectedMinValue = Math.min(firstValue, secondValue);

    //Инициализация объекта тестируемого класса
    Arithmetic testArithmetic = new Arithmetic(firstValue, secondValue);

    //Сравнение ожидаемых и фактически полученных значений
    if (expectedSum == testArithmetic.sumOfValues()
        && expectedResultingMultiplication == testArithmetic.multiplicationOfValues()
        && expectedMaxValue == testArithmetic.getMaxValue()
        && expectedMinValue == testArithmetic.getMinValue()) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }

    //Выводим в консоль полученный результат
    System.out
        .println("Expected sum of values = " + expectedSum + ". The resulting sum of values = "
            + testArithmetic.sumOfValues() + "." + System.lineSeparator()
            + "Expected result of multiplying values = " + expectedResultingMultiplication +
            ". The resulting multiplication of values = " + testArithmetic.multiplicationOfValues()
            + "." + System.lineSeparator() + "Expected maximum value = " + expectedMaxValue +
            ". Received maximum value = " + testArithmetic.getMaxValue() + "."
            + System.lineSeparator() + "Expected minimum value = " + expectedMinValue +
            ". Received minimum value = " + testArithmetic.getMinValue() + ".");
  }

  private static int getRandomValue() {

    //Возможный диапазон значений от MIN_VALUE до MAX_VALUE
    final int MIN_VALUE = 1;
    final int MAX_VALUE = 100;

    return random.nextInt(MAX_VALUE) + MIN_VALUE;
  }
}
