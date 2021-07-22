
import java.util.Random;

public class Main {

  private static final int MAX_SIZE = 100;

  public static void main(String[] args) {

    int size = new Random().nextInt(MAX_SIZE);
    char[][] twoDimArray = TwoDimensionalArray
        .getTwoDimensionalArray(size);

    for (char[] chars : twoDimArray) {

      for (char aChar : chars) {

        System.out.print(aChar);
      }
      System.out.println();
    }
  }
}
