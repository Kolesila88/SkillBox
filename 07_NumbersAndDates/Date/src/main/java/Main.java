import collector.BirthdayCollector;

public class Main {

  public static void main(String[] args) {

    int day = 31;
    int month = 12;
    int year = 1990;

    System.out.println(BirthdayCollector.collectBirthdays(year, month, day));
  }
}
