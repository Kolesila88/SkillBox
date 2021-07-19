package collector;

import format.DateFormatPatterns;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import lang.Lang;

public class BirthdayCollector {

  public static String collectBirthdays(int year, int month, int day) {

    //TODO реализуйте метод для построения строки в следующем виде
    //0 - 31.12.1990 - Mon
    //1 - 31.12.1991 - Tue

    StringBuilder builder = new StringBuilder();
    LocalDate verifiedDate = LocalDate.of(year, month, day);
    LocalDate now = LocalDate.now();

    for (int i = 0; ; i++) {

      if (now.compareTo(verifiedDate) >= BigInteger.ZERO.intValue()) {

        builder.append(i)
            .append(" - ")
            .append(DateTimeFormatter
                .ofPattern(DateFormatPatterns.SKILLBOX_DATE_FORMAT_PATTERN.getPattern())
                .localizedBy(new Locale(Lang.ENG.getLang()))
                .format(verifiedDate))
            .append(System.lineSeparator());
        verifiedDate = verifiedDate.plusYears(1);

      } else {

        break;
      }
    }
    return builder.toString();
  }
}
