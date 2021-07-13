package test;

import printer.Printer;

public class TestPrinter {

  private static final String TEST_PASSED_SUCCESSFULLY_MSG = "Test passed successfully!!!";
  private static final String TEST_FAILED_MSG = "Test failed!!!";

  public static void main(String[] args) {

    Printer printer = new Printer();
    appendTest(printer);
    appendTestNumberTwo(printer);
    appendTestNumberThree(printer);
    getPendingPagesCountTest(printer);
    printTest(printer);

  }

  private static void appendTest(Printer printer) {

    final String text = "Некий текст";
    final String expendedQueue = "Список документов на печать:" + System.lineSeparator()
        + "Некий текст - 1 стр.";
    final int expendedPendingPagesCount = 1;

    printer.append(text);
    System.out
        .println("Printer queue equals expendedQueue: " + expendedQueue.equals(printer.getQueue()));
    System.out.println("Printer pendingPagesCount equals expendedPendingPagesCount: "
        + (expendedPendingPagesCount == printer.getPendingPagesCount()));

    if (expendedQueue.equals(printer.getQueue()) && (expendedPendingPagesCount == printer
        .getPendingPagesCount())) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  private static void appendTestNumberTwo(Printer printer) {

    final String text = "Некий текст";
    final String expendedQueue = "Список документов на печать:" + System.lineSeparator()
        + "Некий текст - 1 стр." + System.lineSeparator() + "Некий текст - 9 стр.";
    final int pages = 9;
    final int expendedPendingPagesCount = 10;

    printer.append(text, pages);
    System.out
        .println("Printer queue equals expendedQueue: " + expendedQueue.equals(printer.getQueue()));
    System.out.println("Printer pendingPagesCount equals expendedPendingPagesCount: "
        + (expendedPendingPagesCount == printer.getPendingPagesCount()));

    if (expendedQueue.equals(printer.getQueue()) && (expendedPendingPagesCount == printer
        .getPendingPagesCount())) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  private static void appendTestNumberThree(Printer printer) {

    final String text = "Некий текст";
    final String title = "Некий заголовок";
    final String expendedQueue =
        "Список документов на печать:" + System.lineSeparator() + "Некий текст - 1 стр."
            + System.lineSeparator() + "Некий текст - 9 стр." +  System.lineSeparator()
            + "Некий заголовок" + System.lineSeparator() + "Некий текст - 7 стр.";
    final int pages = 7;
    final int expendedPendingPagesCount = 17;

    printer.append(text, title, pages);
    final String printerQueue = printer.getQueue();

    System.out.println("Printer queue equals expendedQueue: " + expendedQueue.equals(printerQueue));
    System.out.println("Printer pendingPagesCount equals expendedPendingPagesCount: "
        + (expendedPendingPagesCount == printer.getPendingPagesCount()));

    if (expendedQueue.equals(printer.getQueue()) && (expendedPendingPagesCount == printer
        .getPendingPagesCount())) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  private static void getPendingPagesCountTest(Printer printer) {

    final int expendedPendingPagesCount = 17;
    System.out.println("Printer pendingPagesCount equals expendedPendingPagesCount: "
        + (expendedPendingPagesCount == printer.getPendingPagesCount()));

    if (expendedPendingPagesCount == printer.getPendingPagesCount()) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  private static void printTest(Printer printer) {

    final String expendedQueueAfterPrinted = "Список документов на печать:";
    final String expendedQueueBeforePrinted =
        "Список документов на печать:" + System.lineSeparator() + "Некий текст - 1 стр."
            + System.lineSeparator() + "Некий текст - 9 стр." + System.lineSeparator() +
            "Некий заголовок" + System.lineSeparator() + "Некий текст - 7 стр.";
    final int expendedPendingPagesCountBeforePrinted = 17;
    final int expendedPendingPagesCountAfterPrinted = 0;
    final int expendedTotalCountOfPagesPrintedAfterPrinted = 17;
    final int expendedTotalCountOfPagesPrintedBeforePrinted = 0;

    boolean resultComparisonPendingPagesCountBeforePrinted =
        expendedPendingPagesCountBeforePrinted == printer.getPendingPagesCount();
    boolean resultComparisonTotalCountOfPagesPrintedBeforePrinted =
        expendedTotalCountOfPagesPrintedBeforePrinted == printer.getTotalCountOfPagesPrinted();
    boolean resultComparisonQueueBeforePrinted =
        expendedQueueBeforePrinted.equals(printer.getQueue());

    printer.print();

    boolean resultComparisonPendingPagesCountAfterPrinted =
        expendedPendingPagesCountAfterPrinted == printer.getPendingPagesCount();
    boolean resultComparisonTotalCountOfPagesPrintedAfterPrinted =
        expendedTotalCountOfPagesPrintedAfterPrinted == printer.getTotalCountOfPagesPrinted();
    boolean resultComparisonQueueAfterPrinted =
        expendedQueueAfterPrinted.equals(printer.getQueue());

    if (resultComparisonPendingPagesCountAfterPrinted
        && resultComparisonPendingPagesCountBeforePrinted
        && resultComparisonQueueBeforePrinted && resultComparisonQueueAfterPrinted
        && resultComparisonTotalCountOfPagesPrintedBeforePrinted
        && resultComparisonTotalCountOfPagesPrintedAfterPrinted) {
      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {
      System.out.println(TEST_FAILED_MSG);
    }


  }


}
