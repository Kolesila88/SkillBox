package main.test;

import main.model.Basket;
import java.util.Random;

public class TestBasket {

  //Сообщения о успешности\неуспешности теста
  private static final String TEST_PASSED_SUCCESSFULLY_MSG = "Test passed successfully!!!";
  private static final String TEST_FAILED_MSG = "Test failed!!!";

  //Информация о продуктах добавляемых в корзину в тестах
  private static final String FIRST_TEST_PRODUCT_NAME = "Milk";
  private static final double FIRST_TEST_PRODUCT_PRICE = 40;
  private static final String SECOND_TEST_PRODUCT_NAME = "Bread";
  private static final double SECOND_TEST_PRODUCT_PRICE = 35;
  private static final String THIRD_TEST_PRODUCT_NAME = "Pineapple";
  private static final double THIRD_TEST_PRODUCT_PRICE = 320;
  private static final String FOURTH_TEST_PRODUCT_NAME = "Butter";
  private static final double FOURTH_TEST_PRODUCT_PRICE = 200;

  //Генератор случайных чисел
  private static final Random random = new Random();

  public static void main(String[] args) {

    //Запуск тестов
    increaseCountOfItemsInBasketsTest(getRandomCount());
    increaseTotalPriceOfItemsInBasketsTest(getRandomCount());
    Basket testBasket = new Basket();
    getAveragePriceOfItemsTest(getRandomCount(), testBasket);
    getAverageTotalBasketPriceTest(getRandomCount(), testBasket);
  }

  //Метод генерации случайного числа в указанном диапазоне
  private static int getRandomCount() {

    //Диапазон генерируемых значений от MIN_PRODUCT_COUNT до MAX_PRODUCT_COUNT
    int MIN_PRODUCT_COUNT = 1;
    int MAX_PRODUCT_COUNT = 10;

    return random.nextInt(MAX_PRODUCT_COUNT) + MIN_PRODUCT_COUNT;
  }

  //Методы тестирования
  private static void increaseCountOfItemsInBasketsTest(int productCount) {

    int countOfItemsInBasketsBefore = Basket.getCountOfItemsInBaskets();
    Basket testBasket = new Basket();
    testBasket.add(FIRST_TEST_PRODUCT_NAME, FIRST_TEST_PRODUCT_PRICE, productCount);
    int countOfItemsInBasketsAfter = Basket.getCountOfItemsInBaskets();

    if (countOfItemsInBasketsAfter == countOfItemsInBasketsBefore + productCount) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG + "\ncountOfItemsInBasketsAfter: "
          + countOfItemsInBasketsAfter + " == countOfItemsInBasketsBefore: "
          + countOfItemsInBasketsBefore
          + " + productCount: " + productCount);
    } else {

      System.out.println(TEST_FAILED_MSG + "\n" + countOfItemsInBasketsBefore + " == "
          + countOfItemsInBasketsAfter + " + " + productCount);
    }

  }

  private static void increaseTotalPriceOfItemsInBasketsTest(int productCount) {

    double totalPriceOfItemsInBasketsBefore = Basket.getTotalPriceOfItemsInBaskets();
    Basket testBasket = new Basket();
    testBasket.add(SECOND_TEST_PRODUCT_NAME, SECOND_TEST_PRODUCT_PRICE, productCount);
    double totalPriceOfItemsInBasketsAfter = Basket.getTotalPriceOfItemsInBaskets();

    if (totalPriceOfItemsInBasketsAfter ==
        totalPriceOfItemsInBasketsBefore + SECOND_TEST_PRODUCT_PRICE * productCount) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG + "\ntotalPriceOfItemsInBasketsAfter: "
          + totalPriceOfItemsInBasketsAfter + " == totalPriceOfItemsInBasketsBefore: "
          + totalPriceOfItemsInBasketsBefore + " + productPrice: " + SECOND_TEST_PRODUCT_PRICE
          + " * productCount: " + productCount);
    } else {

      System.out.println(TEST_FAILED_MSG + "\n" + totalPriceOfItemsInBasketsBefore + " == "
          + totalPriceOfItemsInBasketsAfter + " + " + SECOND_TEST_PRODUCT_PRICE + " * "
          + productCount);
    }
  }

  private static void getAveragePriceOfItemsTest(int productCount, Basket testBasket) {

    double totalPriceOfItemsInBasketsBefore = Basket.getTotalPriceOfItemsInBaskets();
    int totalCountOfItemsInBasketsBefore = Basket.getCountOfItemsInBaskets();
    double averagePriceOfItemsBefore =
        totalPriceOfItemsInBasketsBefore / totalCountOfItemsInBasketsBefore;

    if (averagePriceOfItemsBefore == Basket.getAveragePriceOfItems()) {

      testBasket.add(THIRD_TEST_PRODUCT_NAME, THIRD_TEST_PRODUCT_PRICE, productCount, productCount);
      checkTheTotalPriceOfProductsAfter(totalPriceOfItemsInBasketsBefore,
          totalCountOfItemsInBasketsBefore,
          productCount);
    } else {

      System.out.println(TEST_FAILED_MSG + "\n" + averagePriceOfItemsBefore + " == "
          + Basket.getAveragePriceOfItems());
    }
  }

  private static void checkTheTotalPriceOfProductsAfter(double totalPriceOfItemsInBasketsBefore,
      int totalCountOfItemsInBasketsBefore,
      int productCount) {

    double totalPriceOfItemsInBasketsAfter = Basket.getTotalPriceOfItemsInBaskets();
    double expendedTotalPriceOfItemsInBaskets =
        totalPriceOfItemsInBasketsBefore + THIRD_TEST_PRODUCT_PRICE * productCount;

    if (totalPriceOfItemsInBasketsAfter != expendedTotalPriceOfItemsInBaskets) {

      System.out.println(
          TEST_FAILED_MSG + "\ntotalPriceOfItemsInBasketsAfter: " + totalPriceOfItemsInBasketsAfter
              + " == expendedTotalPriceOfItemsInBaskets: " + expendedTotalPriceOfItemsInBaskets);
    } else {

      checkTheTotalCountOfProductsInBasketsAfter(totalPriceOfItemsInBasketsAfter,
          totalCountOfItemsInBasketsBefore,
          productCount);
    }
  }

  private static void checkTheTotalCountOfProductsInBasketsAfter(
      double totalPriceOfItemsInBasketsAfter,
      int totalCountOfItemsInBasketsBefore,
      int productCount) {

    int totalCountOfItemsInBasketsAfter = Basket.getCountOfItemsInBaskets();
    int expendedTotalCountOfItemsInBaskets = totalCountOfItemsInBasketsBefore + productCount;

    if (totalCountOfItemsInBasketsAfter != expendedTotalCountOfItemsInBaskets) {

      System.out.println(
          TEST_FAILED_MSG + "\ntotalCountOfItemsInBasketsAfter: " + totalCountOfItemsInBasketsAfter
              + " == expendedTotalCountOfItemsInBaskets: " + expendedTotalCountOfItemsInBaskets);
    } else {

      checkAveragePriceOfItemsAfter(totalPriceOfItemsInBasketsAfter,
          totalCountOfItemsInBasketsAfter);
    }

  }

  private static void checkAveragePriceOfItemsAfter(double totalPriceOfItemsInBasketsAfter,
      int totalCountOfItemsInBasketsAfter) {

    double averagePriceOfItemsAfter = Basket.getAveragePriceOfItems();
    double expendedAveragePriceOfItems =
        totalPriceOfItemsInBasketsAfter / totalCountOfItemsInBasketsAfter;

    if (averagePriceOfItemsAfter != expendedAveragePriceOfItems) {

      System.out.println(TEST_FAILED_MSG + "\naveragePriceOfItemsAfter: " + averagePriceOfItemsAfter
          + " == expendedAveragePriceOfItems: " + expendedAveragePriceOfItems);
    } else {

      System.out.println(
          TEST_PASSED_SUCCESSFULLY_MSG + "\naveragePriceOfItemsAfter: " + averagePriceOfItemsAfter
              + " == expendedAveragePriceOfItems: " + expendedAveragePriceOfItems);
    }

  }

  private static void getAverageTotalBasketPriceTest(int productCount, Basket testBasket) {

    int countOfBasketsBefore = Basket.getCount();
    double totalPriceOfItemsInBasketsBefore = Basket.getTotalPriceOfItemsInBaskets();

    if (totalPriceOfItemsInBasketsBefore / countOfBasketsBefore == Basket
        .getAverageTotalBasketPrice()) {

      testBasket.add(FOURTH_TEST_PRODUCT_NAME, FOURTH_TEST_PRODUCT_PRICE, productCount);
      checkTotalPriceOfItemsInBaskets(totalPriceOfItemsInBasketsBefore, productCount);
    } else {
      System.out.println(
          TEST_FAILED_MSG + "\naverageTotalBasketPrice: " + Basket.getAverageTotalBasketPrice()
              + " == totalPriceOfItemsInBasketsBefore: " + totalPriceOfItemsInBasketsBefore
              + " / countOfBasketsBefore:" + countOfBasketsBefore);
    }
  }

  private static void checkTotalPriceOfItemsInBaskets(double totalPriceOfItemsInBasketsBefore,
      int productCount) {

    double totalPriceOfItemsInBasketsAfter = Basket.getTotalPriceOfItemsInBaskets();
    double expendedTotalPriceOfItemsInBasket =
        totalPriceOfItemsInBasketsBefore + FOURTH_TEST_PRODUCT_PRICE * productCount;

    if (totalPriceOfItemsInBasketsAfter == expendedTotalPriceOfItemsInBasket) {

      checkAverageTotalBasketPriceAfter(totalPriceOfItemsInBasketsAfter);
    } else {

      System.out.println(
          TEST_FAILED_MSG + "\ntotalPriceOfItemsInBasketsAfter: " + totalPriceOfItemsInBasketsAfter
              + " == expendedTotalPriceOfItemsInBasket: " + expendedTotalPriceOfItemsInBasket);
    }
  }

  private static void checkAverageTotalBasketPriceAfter(double totalPriceOfItemsInBasketsAfter) {

    double averageTotalBasketPriceAfter = Basket.getAverageTotalBasketPrice();
    int countOfBasketsAfter = Basket.getCount();
    double expendedAverageTotalBasketPrice = totalPriceOfItemsInBasketsAfter / countOfBasketsAfter;

    if (averageTotalBasketPriceAfter == expendedAverageTotalBasketPrice) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG + "\naverageTotalBasketPriceAfter: "
          + averageTotalBasketPriceAfter + " == expendedAverageTotalBasketPrice: "
          + expendedAverageTotalBasketPrice);
    } else {

      System.out.println(
          TEST_FAILED_MSG + "\naverageTotalBasketPriceAfter: " + averageTotalBasketPriceAfter
              + " == expendedAverageTotalBasketPrice: " + expendedAverageTotalBasketPrice);
    }
  }
}
