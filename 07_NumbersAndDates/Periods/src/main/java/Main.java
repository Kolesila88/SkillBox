import java.time.LocalDate;
import java.time.Period;

public class Main {

  public static void main(String[] args) {

    LocalDate birthday = LocalDate.of(1995, 5, 23);

    System.out.println(getPeriodFromBirthday(birthday));
  }

  private static String getPeriodFromBirthday(LocalDate birthday) {

    Period period = Period.between(birthday, LocalDate.now());
    return new String()
        .concat(Integer.toString(period.getYears()))
        .concat(" years, ")
        .concat(Integer.toString(period.getMonths()))
        .concat(" month, ")
        .concat(Integer.toString(period.getDays()))
        .concat(" days.");
  }
}
