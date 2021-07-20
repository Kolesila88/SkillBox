import java.io.IOException;
import loader.TextLoader;
import regex.RegEx;

public class Main {

  public static final String PATH = ".\\src\\main\\resources\\text.txt";
  public static final String SPACE = " ";

  public static void main(String[] args) throws IOException {

    String text = TextLoader.getTextFrom(PATH);
    System.out.println(splitTextIntoWords(text));
  }

  public static String splitTextIntoWords(String text) {

    return text
        .replaceAll(RegEx.INVALID_CHARACTER_REGEX.getRegex(), SPACE)
        .replaceAll(RegEx.SEVERAL_SPACES_REGEX.getRegex(), SPACE)
        .replaceAll(RegEx.SPACE_REGEX.getRegex(), System.lineSeparator())
        .trim();
  }
}