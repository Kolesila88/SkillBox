package calculator;

public class TotalEarningsCalculator {

  public static final int ZERO = 0;
  public static final String SPACE_REG_EX = "\\s";
  public static final String EMPTY_STR_REG_EX = "";
  public static final String COMMA_REG_EX = ",";
  public static final String NUMBER_REG_EX = "[0-9]+";

  public static int calculateSalarySum(String text){

    int salarySum = ZERO;
    String[] words = text.split(SPACE_REG_EX);

    for (int i = ZERO; i < words.length; i++){

      words[i] = words[i].trim().replaceAll(COMMA_REG_EX, EMPTY_STR_REG_EX);
      if (words[i].matches(NUMBER_REG_EX)){

        salarySum += Integer.parseInt(words[i]);
      }
    }
    return salarySum;
  }
}
