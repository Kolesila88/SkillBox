public class ReverseArray {

  private static final byte ZERO = 0;
  private static final byte ONE = 1;
  private static final byte TWO = 2;

  public static String[] reverse(String[] strings) {

    String remember;
    for (int colorIndex = ZERO; colorIndex < (strings.length / TWO); colorIndex++) {
      remember = strings[colorIndex];
      strings[colorIndex] = strings[(strings.length - ONE) - colorIndex];
      strings[(strings.length - ONE) - colorIndex] = remember;
    }

    return strings;
  }
}
