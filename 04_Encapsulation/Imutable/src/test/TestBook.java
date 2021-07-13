package test;

import model.Book;

public class TestBook {

  //Сообщения о успешности/не успешности теста
  private static final String TEST_PASSED_SUCCESSFULLY_MSG = "Test passed successfully!!!";
  private static final String TEST_FAILED_MSG = "Test failed!!!";

  //Переменные для хранения тестовых данных
  private static final String testName = "Чистый код";
  private static final String testAuthor = "Роберт Мартин";
  private static final int testPagesCount = 332;
  private static final String testNumberIsbn = "978-5-496-00487-9";


  public static void main(String[] args) {

    //Инициализация объекта класса book.
    Book testBook = new Book(testName, testAuthor, testPagesCount, testNumberIsbn);

    System.out.println("Book test is started.");
    //Вызов методов тестирования
    getNameTest(testBook, testName);
    getAuthorTest(testBook, testAuthor);
    getPagesCount(testBook, testPagesCount);
    getNumberISBNTest(testBook, testNumberIsbn);
    System.out.println("Book test finish.");
  }

  //Тесты get-методов класса Book
  public static void getNameTest(Book testBook, String expendedName) {

    if (testBook.getName().equals(expendedName)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void getAuthorTest(Book testBook, String expendedAuthor) {

    if (testBook.getAuthor().equals(expendedAuthor)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  public static void getPagesCount(Book testBook, int expendedPagesCount) {

    if (testBook.getPagesCount() != expendedPagesCount) {

      System.out.println(TEST_FAILED_MSG);
    } else {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    }
  }

  public static void getNumberISBNTest(Book testBook, String expendedNumberISBN) {

    if (testBook.getNumberIsbn().equals(expendedNumberISBN)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }
}
