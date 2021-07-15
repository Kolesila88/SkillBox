package test;

import model.CargoDescription;
import model.Dimensions;

import java.math.BigDecimal;

public class TestCargoDescription {

  //Сообщения о успешности/не успешности теста
  private static final String TEST_PASSED_SUCCESSFULLY_MSG = "Test passed successfully!!!";
  private static final String TEST_FAILED_MSG = "Test failed!!!";

  //Переменные для хранения тестовых данных объекта класса Dimensions
  private static final BigDecimal TEST_WIDTH_IN_CENTIMETERS = new BigDecimal(50);
  private static final BigDecimal TEST_HEIGHT_IN_CENTIMETERS = new BigDecimal(30);
  private static final BigDecimal TEST_LENGTH_IN_CENTIMETERS = new BigDecimal(103);

  //Переменные для хранения тестовых данных объекта CargoDescription
  private static final Dimensions TEST_DIMENSIONS = new Dimensions(TEST_WIDTH_IN_CENTIMETERS,
          TEST_HEIGHT_IN_CENTIMETERS,
          TEST_LENGTH_IN_CENTIMETERS);
  private static final double TEST_WEIGHT_IN_KILOGRAMS = 70;
  private static final String TEST_DELIVERY_ADDRESS = "Some address";
  private static final boolean TEST_DO_NOT_TORN = false;
  private static final String TEST_REGISTRATION_NUMBER = "010203RN302010";
  private static final boolean TEST_FRAGILE = false;

  //Переменные для хранения устанавливаемых тестовых данных объекта класса Dimensions
  private static final BigDecimal ALTERNATIVE_TEST_WIDTH_IN_CENTIMETERS = new BigDecimal(10);
  private static final BigDecimal ALTERNATIVE_TEST_HEIGHT_IN_CENTIMETERS = new BigDecimal(20);
  private static final BigDecimal ALTERNATIVE_TEST_LENGTH_IN_CENTIMETERS = new BigDecimal(30);

  //Переменные для хранения устанавливаемых тестовых данных объекта CargoDescription
  private static final Dimensions ALTERNATIVE_TEST_DIMENSIONS = new Dimensions(
          ALTERNATIVE_TEST_WIDTH_IN_CENTIMETERS,
          ALTERNATIVE_TEST_HEIGHT_IN_CENTIMETERS, ALTERNATIVE_TEST_LENGTH_IN_CENTIMETERS);
  private static final double ALTERNATIVE_TEST_WEIGHT_IN_KILOGRAMS = 87;
  private static final String ALTERNATIVE_TEST_DELIVERY_ADDRESS = "Some alternative address";
  private static final boolean ALTERNATIVE_TEST_DO_NOT_TORN = true;
  private static final String ALTERNATIVE_TEST_REGISTRATION_NUMBER = "090807RN708090";
  private static final boolean ALTERNATIVE_TEST_FRAGILE = true;

  public static void main(String[] args) {

    //Инициализируем объект тестирования
    CargoDescription testCargoDescription = new CargoDescription(TEST_DIMENSIONS,
            TEST_WEIGHT_IN_KILOGRAMS, TEST_DELIVERY_ADDRESS, TEST_DO_NOT_TORN, TEST_REGISTRATION_NUMBER,
            TEST_FRAGILE);

    //Вызываем тесты get-методов класса CargoDescription
    System.out.println("CargoDescription getters test started.");
    getDimensionsTest(testCargoDescription, TEST_DIMENSIONS);
    getWeightInKilogramsTest(testCargoDescription, TEST_WEIGHT_IN_KILOGRAMS);
    getDeliveryAddressTest(testCargoDescription, TEST_DELIVERY_ADDRESS);
    isDoNotTornTest(testCargoDescription, TEST_DO_NOT_TORN);
    getRegistrationNumberTest(testCargoDescription, TEST_REGISTRATION_NUMBER);
    isFragileTest(testCargoDescription, TEST_FRAGILE);
    System.out.println("CargoDescription getters test finish.");

    //Вызываем тесты copy-методов класса CargoDescription
    System.out.println("CargoDescription copy and set methods test started.");
    copyCargoDescriptionAndSetDimensionsTest(testCargoDescription, ALTERNATIVE_TEST_DIMENSIONS);
    copyCargoDescriptionAndSetWeightInKilogramsTest(testCargoDescription,
            ALTERNATIVE_TEST_WEIGHT_IN_KILOGRAMS);
    copyCargoDescriptionAndSetDeliveryAddressTest(testCargoDescription,
            ALTERNATIVE_TEST_DELIVERY_ADDRESS);
    copyCargoDescriptionAndSetDoNotTornTest(testCargoDescription, ALTERNATIVE_TEST_DO_NOT_TORN);
    copyCargoDescriptionAndSetRegistrationNumberTest(testCargoDescription,
            ALTERNATIVE_TEST_REGISTRATION_NUMBER);
    copyCargoDescriptionAndSetFragileTest(testCargoDescription, ALTERNATIVE_TEST_FRAGILE);
    System.out.println("CargoDescription copy and set methods test finish.");


  }

  //Тесты get-методов класса CargoDescription
  public static void getDimensionsTest(CargoDescription testCargoDescription,
      Dimensions expendedDimensions) {

    if (testCargoDescription.getDimensions().equals(expendedDimensions)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void getWeightInKilogramsTest(CargoDescription testCargoDescription,
      double expendedWeightInKilograms) {

    if (testCargoDescription.getWeightInKilograms() == expendedWeightInKilograms) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void getDeliveryAddressTest(CargoDescription testCargoDescription,
      String expendedDeliveryAddress) {

    if (testCargoDescription.getDeliveryAddress().equals(expendedDeliveryAddress)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void isDoNotTornTest(CargoDescription testCargoDescription,
      boolean expendedDoNotTornStatus) {

    if (testCargoDescription.isDoNotTorn() == expendedDoNotTornStatus) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void getRegistrationNumberTest(CargoDescription testCargoDescription,
      String expendedRegistrationNumber) {

    if (testCargoDescription.getRegistrationNumber().equals(expendedRegistrationNumber)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void isFragileTest(CargoDescription testCargoDescription,
      boolean expendedFragileStatus) {

    if (testCargoDescription.isFragile() == expendedFragileStatus) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  //Тесты методов копирования и измения значения переменной
  public static void copyCargoDescriptionAndSetDimensionsTest(CargoDescription testCargoDescription,
      Dimensions alternativeTestDimensions) {

    Dimensions dimensionsBefore = testCargoDescription.getDimensions();
    CargoDescription copyCargoDescription =
        CargoDescription
            .copyCargoDescriptionAndSetDimensions(testCargoDescription, alternativeTestDimensions);
    if (testCargoDescription.getDimensions().equals(dimensionsBefore)
        && copyCargoDescription.getDimensions().equals(alternativeTestDimensions)
        && testCargoDescription.getWeightInKilograms() == copyCargoDescription
        .getWeightInKilograms()
        && testCargoDescription.getDeliveryAddress()
        .equals(copyCargoDescription.getDeliveryAddress())
        && testCargoDescription.isDoNotTorn() == copyCargoDescription.isDoNotTorn()
        && testCargoDescription.getRegistrationNumber()
        .equals(copyCargoDescription.getRegistrationNumber())
        && testCargoDescription.isFragile() == copyCargoDescription.isFragile()) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }

  }

  public static void copyCargoDescriptionAndSetWeightInKilogramsTest(
      CargoDescription testCargoDescription,
      double alternativeTestWeightInKilograms) {

    double weightInKilogramsBefore = testCargoDescription.getWeightInKilograms();
    CargoDescription copyCargoDescription = CargoDescription
        .copyCargoDescriptionAndSetWeightInKilograms(testCargoDescription,
            alternativeTestWeightInKilograms);

    if (testCargoDescription.getDimensions().equals(copyCargoDescription.getDimensions())
        && testCargoDescription.getWeightInKilograms() == weightInKilogramsBefore
        && copyCargoDescription.getWeightInKilograms() == alternativeTestWeightInKilograms
        && testCargoDescription.getDeliveryAddress()
        .equals(copyCargoDescription.getDeliveryAddress())
        && testCargoDescription.isDoNotTorn() == copyCargoDescription.isDoNotTorn()
        && testCargoDescription.getRegistrationNumber()
        .equals(copyCargoDescription.getRegistrationNumber())
        && testCargoDescription.isFragile() == copyCargoDescription.isFragile()) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void copyCargoDescriptionAndSetDeliveryAddressTest(
      CargoDescription testCargoDescription,
      String alternativeTestDeliveryAddress) {

    String deliveryAddressBefore = testCargoDescription.getDeliveryAddress();
    CargoDescription copyCargoDescription = CargoDescription
        .copyCargoDescriptionAndSetDeliveryAddress(testCargoDescription,
            alternativeTestDeliveryAddress);
    if (testCargoDescription.getDimensions().equals(copyCargoDescription.getDimensions())
        && testCargoDescription.getWeightInKilograms() == copyCargoDescription
        .getWeightInKilograms()
        && testCargoDescription.getDeliveryAddress().equals(deliveryAddressBefore)
        && copyCargoDescription.getDeliveryAddress().equals(alternativeTestDeliveryAddress)
        && testCargoDescription.isDoNotTorn() == copyCargoDescription.isDoNotTorn()
        && testCargoDescription.getRegistrationNumber()
        .equals(copyCargoDescription.getRegistrationNumber())
        && testCargoDescription.isFragile() == copyCargoDescription.isFragile()) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void copyCargoDescriptionAndSetDoNotTornTest(CargoDescription testCargoDescription,
      boolean alternativeTestDoNotTornStatus) {

    boolean doNotTurnBefore = testCargoDescription.isDoNotTorn();
    CargoDescription copyCargoDescription = CargoDescription
        .copyCargoDescriptionAndSetDoNotTorn(testCargoDescription, alternativeTestDoNotTornStatus);
    if (testCargoDescription.getDimensions().equals(copyCargoDescription.getDimensions())
        && testCargoDescription.getWeightInKilograms() == copyCargoDescription
        .getWeightInKilograms()
        && testCargoDescription.getDeliveryAddress()
        .equals(copyCargoDescription.getDeliveryAddress())
        && copyCargoDescription.isDoNotTorn() == alternativeTestDoNotTornStatus
        && testCargoDescription.isDoNotTorn() == doNotTurnBefore
        && testCargoDescription.getRegistrationNumber()
        .equals(copyCargoDescription.getRegistrationNumber())
        && testCargoDescription.isFragile() == copyCargoDescription.isFragile()) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }

  }

  public static void copyCargoDescriptionAndSetRegistrationNumberTest(
      CargoDescription testCargoDescription,
      String alternativeTestRegistrationNumber) {

    String registrationNumberBefore = testCargoDescription.getRegistrationNumber();
    CargoDescription copyCargoDescription = CargoDescription
        .copyCargoDescriptionAndSetRegistrationNumber(testCargoDescription,
            alternativeTestRegistrationNumber);

    if (testCargoDescription.getDimensions().equals(copyCargoDescription.getDimensions())
        && testCargoDescription.getWeightInKilograms() == copyCargoDescription
        .getWeightInKilograms()
        && testCargoDescription.getDeliveryAddress()
        .equals(copyCargoDescription.getDeliveryAddress())
        && testCargoDescription.isDoNotTorn() == copyCargoDescription.isDoNotTorn()
        && testCargoDescription.getRegistrationNumber().equals(registrationNumberBefore)
        && copyCargoDescription.getRegistrationNumber().equals(alternativeTestRegistrationNumber)
        && testCargoDescription.isFragile() == copyCargoDescription.isFragile()) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void copyCargoDescriptionAndSetFragileTest(CargoDescription testCargoDescription,
      boolean alternativeTestFragileStatus) {

    boolean fragileStatusBefore = testCargoDescription.isFragile();
    CargoDescription copyCargoDescription = CargoDescription
        .copyCargoDescriptionAndSetFragile(testCargoDescription, alternativeTestFragileStatus);

    if (testCargoDescription.getDimensions().equals(copyCargoDescription.getDimensions())
        && testCargoDescription.getWeightInKilograms() == copyCargoDescription
        .getWeightInKilograms()
        && testCargoDescription.getDeliveryAddress()
        .equals(copyCargoDescription.getDeliveryAddress())
        && testCargoDescription.isDoNotTorn() == copyCargoDescription.isDoNotTorn()
        && testCargoDescription.getRegistrationNumber()
        .equals(copyCargoDescription.getRegistrationNumber())
        && testCargoDescription.isFragile() == fragileStatusBefore
        && copyCargoDescription.isFragile() == alternativeTestFragileStatus) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }

  }
}

