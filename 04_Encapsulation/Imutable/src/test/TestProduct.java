package test;

import model.Product;

public class TestProduct {

  //Сообщения о успешности/не успешности теста
  private static final String TEST_PASSED_SUCCESSFULLY_MSG = "Test passed successfully!!!";
  private static final String TEST_FAILED_MSG = "Test failed!!!";

  //Переменные для хранения тестовых данных
  private static final String TEST_NAME = "Книга";
  private static final int TEST_PRICE = 1230;
  private static final String TEST_BAR_CODE = "4600728006542";

  public static void main(String[] args) {

    Product testProduct = new Product(TEST_NAME, TEST_BAR_CODE);

    //Переменные со значениями ожидаемыми в качестве ответа.
    String expendedName = TEST_NAME;
    int expendedPrice = TEST_PRICE;
    String expendedBarCode = TEST_BAR_CODE;

    System.out.println("Product test is started!");

    //Вызов методов тестирования
    setPriceTest(testProduct, TEST_PRICE);
    getNameTest(testProduct, TEST_NAME);
    getPriceTest(testProduct, TEST_PRICE);
    getBarCodeTest(testProduct, TEST_BAR_CODE);

    System.out.println("Product test finish.");
  }

  //Тесты get-методов класса Product
  public static void getNameTest(Product testProduct, String expendedName) {

    if (testProduct.getName().equals(expendedName)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void getPriceTest(Product testProduct, int expendedPrice) {

    if (testProduct.getPrice() == expendedPrice) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void getBarCodeTest(Product testProduct, String expendedBarCode) {

    if (testProduct.getBarCode().equals(expendedBarCode)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  //Тесты set-методов класса Product
  public static void setPriceTest(Product testProduct, int testPrice) {

    if (testProduct.getPrice() != testPrice) {

      testProduct.setPrice(testPrice);
      if (testProduct.getPrice() == testPrice) {

        System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
      } else {

        System.out.println(TEST_FAILED_MSG);
      }
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }
}
