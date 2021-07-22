
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Hospital {

  private static final Random RANDOM = new Random();

  private static final float MIN_TEMPERATURE = (float) 32.0;
  private static final float MAX_TEMPERATURE = (float) 40.0;
  private static final float MIN_TEMPERATURE_OF_A_HEALTHY_PERSON = (float) 36.2;
  private static final float MAX_TEMPERATURE_OF_A_HEALTHY_PERSON = (float) 36.9;

  private static final int ZERO = 0;
  private static final int ONE = 1;
  private static final int TWO = 2;
  private static final int DIFFERENCE_BETWEEN_MIN_AND_MAX_TEMP_PLUS_ONE =
      (int) (MAX_TEMPERATURE - MIN_TEMPERATURE + ONE);

  private static final String EMPTY_LINE = "";
  private static final String SPACE = " ";
  private static final String REPORT_PATTERN =
      "Температуры пациентов: %s\nСредняя температура: %.2f\nКоличество здоровых: %d";

  public static float[] generatePatientsTemperatures(int patientsCount) {

    float[] patientTemps = new float[patientsCount];

    for (int patIndex = ZERO; patIndex < patientsCount; patIndex++) {

      patientTemps[patIndex] = getTemperature();
    }
    return patientTemps;
  }

  public static String getReport(float[] temperatureData) {

    String temperatureList = EMPTY_LINE;
    int healthyPatientsCount = ZERO;
    BigDecimal tempSum = new BigDecimal(ZERO);

    for (float patientTemp : temperatureData) {

      temperatureList = temperatureList
          .concat(Float.toString(patientTemp))
          .concat(SPACE);
      tempSum = tempSum.add(BigDecimal.valueOf(patientTemp));

      if (patientTemp >= MIN_TEMPERATURE_OF_A_HEALTHY_PERSON
          && patientTemp <= MAX_TEMPERATURE_OF_A_HEALTHY_PERSON) {

        healthyPatientsCount++;
      }
    }
    return String.format(REPORT_PATTERN,
        temperatureList.trim(),
        tempSum.divide(new BigDecimal(temperatureData.length), TWO, RoundingMode.HALF_UP),
        healthyPatientsCount);
  }

  private static float getTemperature() {

    float temperature = new BigDecimal(MIN_TEMPERATURE
        + (DIFFERENCE_BETWEEN_MIN_AND_MAX_TEMP_PLUS_ONE * RANDOM.nextFloat()))
        .setScale(ONE, RoundingMode.HALF_UP)
        .floatValue();

    if (temperature > MAX_TEMPERATURE) {

      temperature = MAX_TEMPERATURE;
    }
    return temperature;
  }
}
