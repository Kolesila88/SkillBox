package util;

import calculator.GeometryCalculator;
import java.util.Scanner;
import message.Messages;

public class CommandHandler {

  public static void executeAction(byte operationNumber, Scanner scanner) {

    switch (operationNumber) {

      case 1:

        System.out.println(String.format(Messages.ENTER_RADIUS_MSG.getMessage(), "circle"));
        double circleRadius = scanner.nextDouble();
        System.out.println(String.format(
            Messages.CIRCLE_RESULT_MSG.getMessage(),
            circleRadius,
            GeometryCalculator.getCircleSquare(circleRadius)));
        break;
      case 2:

        System.out.println(String.format(Messages.ENTER_VALUE_MSG.getMessage(), "a"));
        double a = scanner.nextDouble();
        System.out.println(String.format(Messages.ENTER_VALUE_MSG.getMessage(), "b"));
        double b = scanner.nextDouble();
        System.out.println(String.format(Messages.ENTER_VALUE_MSG.getMessage(), "c"));
        double c = scanner.nextDouble();
        double result = GeometryCalculator.getTriangleSquare(a, b, c);

        if (result == -1) {

          System.out.println(String.format(
              Messages.TRIANGLE_DOES_NOT_EXIST_MSG.getMessage(), a, b, c));
        } else {

          System.out.println(String.format(
              Messages.TRIANGLE_RESULT_MSG.getMessage(), a, b, c, result));
        }
        break;
      case 3:

        System.out.println(String.format(Messages.ENTER_RADIUS_MSG.getMessage(), "sphere"));
        double sphereRadius = scanner.nextDouble();
        System.out.println(String.format(
            Messages.SPHERE_RESULT_MSG.getMessage(),
            sphereRadius,
            GeometryCalculator.getSphereVolume(sphereRadius)));
        break;
      default:

        System.out.println(String.format(Messages.COMMANDS_MSG.getMessage(),
            String.format(Messages.INCORRECT_OPERATION_MSG.getMessage(), operationNumber)));
        break;
    }
  }
}
