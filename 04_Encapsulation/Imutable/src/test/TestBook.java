package test;

import model.Book;

public class TestBook {

  //Сообщения о успешности/не успешности теста
  private static final String TEST_PASSED_SUCCESSFULLY_MSG = "Test passed successfully!!!";
  private static final String TEST_FAILED_MSG = "Test failed!!!";

  //Переменные для хранения тестовых данных
  private static final String TEST_NAME = "Чистый код";
  private static final String TEST_AUTHOR = "Роберт Мартин";
  private static final int TEST_PAGES_COUNT = 332;
  private static final String TEST_NUMBER_ISBN = "978-5-496-00487-9";


  public static void main(String[] args) {

    //Инициализация объекта класса book.
    Book testBook = new Book(TEST_NAME, TEST_AUTHOR, TEST_PAGES_COUNT, TEST_NUMBER_ISBN);

    System.out.println("Book test is started.");
    //Вызов методов тестирования
    getNameTest(testBook, TEST_NAME);
    getAuthorTest(testBook, TEST_AUTHOR);
    getPagesCount(testBook, TEST_PAGES_COUNT);
    getNumberISBNTest(testBook, TEST_NUMBER_ISBN);
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
