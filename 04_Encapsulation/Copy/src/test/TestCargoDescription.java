package test;

import model.CargoDescription;
import model.Dimensions;

import java.math.BigDecimal;

public class TestCargoDescription {

  //Сообщения о успешности/не успешности теста
  private static final String TEST_PASSED_SUCCESSFULLY_MSG = "Test passed successfully!!!";
  private static final String TEST_FAILED_MSG = "Test failed!!!";

  //Переменные для хранения тестовых данных объекта класса Dimensions
  private static final BigDecimal testWidthInCentimeters = new BigDecimal(50);
  private static final BigDecimal testHeightInCentimeters = new BigDecimal(30);
  private static final BigDecimal testLengthInCentimeters = new BigDecimal(103);

  //Переменные для хранения тестовых данных объекта CargoDescription
  private static final Dimensions testDimensions = new Dimensions(testWidthInCentimeters,
      testHeightInCentimeters,
      testLengthInCentimeters);
  private static final double testWeightInKilograms = 70;
  private static final String testDeliveryAddress = "Some address";
  private static final boolean testDoNotTorn = false;
  private static final String testRegistrationNumber = "010203RN302010";
  private static final boolean testFragile = false;

  //Переменные для хранения устанавливаемых тестовых данных объекта класса Dimensions
  private static final BigDecimal alternativeTestWidthInCentimeters = new BigDecimal(10);
  private static final BigDecimal alternativeTestHeightInCentimeters = new BigDecimal(20);
  private static final BigDecimal alternativeTestLengthInCentimeters = new BigDecimal(30);

  //Переменные для хранения устанавливаемых тестовых данных объекта CargoDescription
  private static final Dimensions alternativeTestDimensions = new Dimensions(
      alternativeTestWidthInCentimeters,
      alternativeTestHeightInCentimeters, alternativeTestLengthInCentimeters);
  private static final double alternativeTestWeightInKilograms = 87;
  private static final String alternativeTestDeliveryAddress = "Some alternative address";
  private static final boolean alternativeTestDoNotTorn = true;
  private static final String alternativeTestRegistrationNumber = "090807RN708090";
  private static final boolean alternativeTestFragile = true;

  public static void main(String[] args) {

    //Инициализируем объект тестирования
    CargoDescription testCargoDescription = new CargoDescription(testDimensions,
        testWeightInKilograms, testDeliveryAddress, testDoNotTorn, testRegistrationNumber,
        testFragile);

    //Вызываем тесты get-методов класса CargoDescription
    System.out.println("CargoDescription getters test started.");
    getDimensionsTest(testCargoDescription, testDimensions);
    getWeightInKilogramsTest(testCargoDescription, testWeightInKilograms);
    getDeliveryAddressTest(testCargoDescription, testDeliveryAddress);
    isDoNotTornTest(testCargoDescription, testDoNotTorn);
    getRegistrationNumberTest(testCargoDescription, testRegistrationNumber);
    isFragileTest(testCargoDescription, testFragile);
    System.out.println("CargoDescription getters test finish.");

    //Вызываем тесты copy-методов класса CargoDescription
    System.out.println("CargoDescription copy and set methods test started.");
    copyCargoDescriptionAndSetDimensionsTest(testCargoDescription, alternativeTestDimensions);
    copyCargoDescriptionAndSetWeightInKilogramsTest(testCargoDescription,
        alternativeTestWeightInKilograms);
    copyCargoDescriptionAndSetDeliveryAddressTest(testCargoDescription,
        alternativeTestDeliveryAddress);
    copyCargoDescriptionAndSetDoNotTornTest(testCargoDescription, alternativeTestDoNotTorn);
    copyCargoDescriptionAndSetRegistrationNumberTest(testCargoDescription,
        alternativeTestRegistrationNumber);
    copyCargoDescriptionAndSetFragileTest(testCargoDescription, alternativeTestFragile);
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

