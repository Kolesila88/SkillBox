package calculator;

import java.math.BigDecimal;

public class GeometryCalculator {

  // метод должен использовать абсолютное значение radius
  public static double getCircleSquare(double radius) {

    return new BigDecimal(Math.PI).multiply(
        BigDecimal.valueOf(Math.pow(Math.abs(radius), 2.0))).doubleValue();
  }

  // метод должен использовать абсолютное значение radius
  public static double getSphereVolume(double radius) {

    return new BigDecimal("4")
        .divide(new BigDecimal("3"), 11, BigDecimal.ROUND_HALF_UP)
        .multiply(new BigDecimal(String.valueOf(Math.PI))
            .multiply(BigDecimal.valueOf(Math.pow(Math.abs(radius), 3.0))))
        .doubleValue();
  }

  public static boolean isTrianglePossible(double a, double b, double c) {

    if ((Math.max(a + b, c) == a + b && Math.max(a + b, c) > 0)
        && (Math.max(b + c, a) == b + c && Math.max(b + c, a) > 0)
        && (Math.max(c + a, b) == c + a && Math.max(c + a, b) > b)) {

      return true;
    } else {

      return false;
    }
  }

  // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
  // методом isTrianglePossible, если невозможен вернуть -1.0
  public static double getTriangleSquare(double a, double b, double c) {

    if (isTrianglePossible(a, b, c)) {

      return Math.sqrt(BigDecimal.valueOf((a + b + c) / 2)
          .multiply(new BigDecimal(String.valueOf(BigDecimal.valueOf((a + b + c) / 2)
              .subtract(BigDecimal.valueOf(a)))))
          .multiply(new BigDecimal(String.valueOf(BigDecimal.valueOf((a + b + c) / 2)
              .subtract(BigDecimal.valueOf(b)))))
          .multiply(new BigDecimal(String.valueOf(BigDecimal.valueOf((a + b + c) / 2)
              .subtract(BigDecimal.valueOf(c)))))
          .doubleValue());
    } else {

      return -1;
    }
  }
}
