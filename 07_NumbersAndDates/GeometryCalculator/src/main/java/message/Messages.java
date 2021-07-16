package message;

public enum Messages {

  COMMANDS_MSG("%s" + System.lineSeparator() + "\t- 1 : Сalculating the square of a circle."
      + System.lineSeparator() + "\t- 2 : Сalculating the square of a triangle."
      + System.lineSeparator() + "\t- 3 : Calculating the volume of a sphere."
      + System.lineSeparator() + "\t- 0 : Exit from program."),
  ENTER_COMMAND_MSG("Enter command number:"),
  EXIT_MSG("Exit from program."),
  ENTER_RADIUS_MSG("Enter %s radius."),
  ENTER_VALUE_MSG("Enter the value of side %s:" + System.lineSeparator() + "\tX,X-for decimal."
      + System.lineSeparator() + "\tX-for integer."),
  CIRCLE_RESULT_MSG("The area of a circle with a radius of %s cm is %s square centimeters"),
  TRIANGLE_RESULT_MSG("The area of a triangle with sides of %s, %s, %s centimeters"
      + "is equal to %s square centimeters."),
  TRIANGLE_DOES_NOT_EXIST_MSG(
      "Triangle with sides equal to %s, %s, %s centimeters, does not exist"),
  SPHERE_RESULT_MSG("The volume of a sphere with a radius of %s centimeters is equal to %s"
      + " cubic centimeters."),
  INCORRECT_OPERATION_MSG("%s - Incorrect operation." + System.lineSeparator() +
      "Enter the supported operation number." + System.lineSeparator()
      + "\tSupported operations numbers:");

  private final String message;

  Messages(String message) {

    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
