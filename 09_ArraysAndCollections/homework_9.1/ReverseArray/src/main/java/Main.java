import regex.RegEx;

public class Main {

  public static void main(String[] args) {
    String line = "Каждый охотник желает знать, где сидит фазан";

    ReverseArray.reverse(line.split(RegEx.LINE_SPLITTER.getRegEx()));
  }
}
