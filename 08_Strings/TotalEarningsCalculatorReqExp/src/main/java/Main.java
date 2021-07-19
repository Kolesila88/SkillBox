import calculator.TotalEarningsCalculator;

public class Main {



  public static void main(String[] args) {

    String text = "Вася заработал 15000 рублей, Петя - 60000 рубля, а Маша - 45000 рублей";
    System.out.println(TotalEarningsCalculator.calculateSalarySum(text));
  }
}