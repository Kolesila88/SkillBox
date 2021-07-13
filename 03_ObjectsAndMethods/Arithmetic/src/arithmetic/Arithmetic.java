package arithmetic;

public class Arithmetic {

  private int firstValue;
  private int secondValue;

  public Arithmetic(int firstValue, int secondValue) {

    this.firstValue = firstValue;
    this.secondValue = secondValue;
  }

  public int sumOfValues() {

    return firstValue + secondValue;
  }

  public int multiplicationOfValues() {

    return firstValue * secondValue;
  }

  public int getMaxValue() {
    if (firstValue > secondValue) {

      return firstValue;
    } else {

      return secondValue;
    }
  }

  public int getMinValue() {
    if (firstValue < secondValue) {

      return firstValue;
    } else {

      return secondValue;
    }
  }
}
