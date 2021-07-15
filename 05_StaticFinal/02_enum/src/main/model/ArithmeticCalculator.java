package main.model;

import main.operation.Operation;

import java.math.BigDecimal;

public class ArithmeticCalculator {

  private final BigDecimal firstValue;
  private final BigDecimal secondValue;

  public ArithmeticCalculator(double firstValue, double secondValue) {

    this.firstValue = new BigDecimal(String.valueOf(firstValue));
    this.secondValue = new BigDecimal(String.valueOf(secondValue));
  }

  public BigDecimal calculate(Operation operation) {

    switch (operation) {

      case ADD:

        return firstValue.add(secondValue);
      case SUBTRACT:

        return firstValue.subtract(secondValue);
      case MULTIPLY:

        return firstValue.multiply(secondValue);
      case DIVIDE:

        return firstValue.divide(secondValue,  4, BigDecimal.ROUND_DOWN);
      default:

        System.out.println("Operation " + operation.name() + ", not supported!!!");
        return null;
    }
  }
}
