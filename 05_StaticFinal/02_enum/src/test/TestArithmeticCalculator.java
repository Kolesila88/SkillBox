package test;

import main.model.ArithmeticCalculator;
import main.operation.Operation;
import main.message.Messages;

import java.math.BigDecimal;
import java.util.Random;

public class TestArithmeticCalculator {

  //Генератор случайных чисел
  private static Random random = new Random();

  private static int iterationCount = 100_000;

  public static void main(String[] args) {

    boolean theCycleWasInterrupted = false;

    for (int i = 0; i < iterationCount; i++) {

      //Переменные для хранения случайных значений
      double testFirstValue = getRandomValue();
      double testSecondValue = getRandomValue();

      //Инициализация тестируемого объекта
      ArithmeticCalculator testArithmeticCalculator = new ArithmeticCalculator(testFirstValue,
          testSecondValue);

      boolean testIsSuccessfully;
      //Запускаем тестовые сценарии
      testIsSuccessfully = calculateAdditionTest(testArithmeticCalculator, testFirstValue,
          testSecondValue);

      if (!testIsSuccessfully) {

        System.out.println(Messages.TEST_FAILED_MSG.getMessage());
        theCycleWasInterrupted = true;
        break;
      }
      testIsSuccessfully = calculateSubtractTest(testArithmeticCalculator, testFirstValue,
          testSecondValue);

      if (!testIsSuccessfully) {

        System.out.println(Messages.TEST_FAILED_MSG.getMessage());
        theCycleWasInterrupted = true;
        break;
      }
      testIsSuccessfully = calculateMultiplyTest(testArithmeticCalculator, testFirstValue,
          testSecondValue);

      if (!testIsSuccessfully) {

        System.out.println(Messages.TEST_FAILED_MSG.getMessage());
        theCycleWasInterrupted = true;
        break;
      }
      testIsSuccessfully = calculateDivisionTest(testArithmeticCalculator, testFirstValue,
          testSecondValue);

      if (!testIsSuccessfully) {

        System.out.println(Messages.TEST_FAILED_MSG.getMessage());
        theCycleWasInterrupted = true;
        break;
      }
    }

    if (!theCycleWasInterrupted) {
      System.out.println(Messages.TEST_PASSED_SUCCESSFULLY_MSG.getMessage());
    }
  }

  private static double getRandomValue() {

    return Double.parseDouble(String
        .format("%8.4f", random.nextDouble())
        .replace(',', '.'));
  }

  private static boolean calculateAdditionTest(ArithmeticCalculator testArithmeticCalculator,
      double firstValue,
      double secondValue) {

    BigDecimal expendedValue = new BigDecimal(String.valueOf(firstValue))
        .add(new BigDecimal(String.valueOf(secondValue)));
    BigDecimal additionalResult = testArithmeticCalculator.calculate(Operation.ADD);

    if (expendedValue.compareTo(additionalResult) == 0) {

      return true;
    } else {

      System.out.println(String
          .format(Messages.DETAILED_RESULT_MSG.getMessage(), firstValue, System.lineSeparator(),
              secondValue, System.lineSeparator(), expendedValue,
              System.lineSeparator(),additionalResult));
      return false;
    }
  }

  private static boolean calculateSubtractTest(ArithmeticCalculator testArithmeticCalculator,
      double firstValue,
      double secondValue) {

    BigDecimal expendedValue = new BigDecimal(String.valueOf(firstValue))
        .subtract(new BigDecimal(String.valueOf(secondValue)));
    BigDecimal subtractionResult = testArithmeticCalculator.calculate(Operation.SUBTRACT);

    if (expendedValue.compareTo(subtractionResult) == 0) {

      return true;
    } else {

      System.out.println(String
          .format(Messages.DETAILED_RESULT_MSG.getMessage(), firstValue, System.lineSeparator(),
              secondValue, System.lineSeparator(), expendedValue, System.lineSeparator(),
              subtractionResult));
      return false;
    }
  }

  private static boolean calculateMultiplyTest(ArithmeticCalculator testArithmeticCalculator,
      double firstValue,
      double secondValue) {

    BigDecimal expendedValue = new BigDecimal(String.valueOf(firstValue))
        .multiply(new BigDecimal(String.valueOf(secondValue)));
    BigDecimal multiplicationResult = testArithmeticCalculator.calculate(Operation.MULTIPLY);

    if (expendedValue.compareTo(multiplicationResult) == 0) {

      return true;
    } else {
        System.out.println("multiplication!");
      System.out.println(String
          .format(Messages.DETAILED_RESULT_MSG.getMessage(), firstValue, System.lineSeparator(),
              secondValue, System.lineSeparator(), expendedValue, System.lineSeparator(),
              multiplicationResult));
      return false;
    }
  }

  private static boolean calculateDivisionTest(ArithmeticCalculator testArithmeticCalculator,
      double firstValue,
      double secondValue) {

    if (secondValue == 0.0000) {

      System.out.println(String
          .format(Messages.DIVISION_BY_ZERO_IS_NOT_ALLOWED.getMessage(),System.lineSeparator(),
              firstValue, System.lineSeparator(), secondValue, System.lineSeparator(), "-",
              System.lineSeparator(), "-"));
      return true;
    } else {

      BigDecimal expendedValue = new BigDecimal(String.valueOf(firstValue))
          .divide(new BigDecimal(String.valueOf(secondValue)), 4, BigDecimal.ROUND_DOWN);
      BigDecimal divisionResult = testArithmeticCalculator.calculate(Operation.DIVIDE);

      if (expendedValue.compareTo(divisionResult) == 0) {

        return true;
      } else {
                 System.out.println(String
            .format(Messages.DETAILED_RESULT_MSG.getMessage(), firstValue, System.lineSeparator(),
                secondValue, System.lineSeparator(), expendedValue, System.lineSeparator(),
                divisionResult));
        return false;
      }
    }
  }
}
