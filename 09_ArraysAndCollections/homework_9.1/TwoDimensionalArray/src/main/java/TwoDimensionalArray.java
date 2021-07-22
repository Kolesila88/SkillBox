public class TwoDimensionalArray {

  private static final char SYMBOL = 'X';
  private static final char SPACE = ' ';

  private static final int ZERO = 0;
  private static final int ONE = 1;

  public static char[][] getTwoDimensionalArray(int size) {

    char[][] twoDimArray = new char[size][size];

    for (int i = ZERO; i < twoDimArray.length; i++) {

      for (int j = ZERO; j < twoDimArray.length; j++) {
        twoDimArray[i][j] = SPACE;
      }
      twoDimArray[i][i] = SYMBOL;
      twoDimArray[i][twoDimArray.length - i - ONE] = SYMBOL;
    }
    return twoDimArray;
  }
}
