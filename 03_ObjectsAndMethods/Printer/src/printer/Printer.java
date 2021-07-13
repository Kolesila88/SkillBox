package printer;

public class Printer {

  private String queue;
  private int pendingPagesCount;
  private int totalCountOfPagesPrinted;

  public Printer() {

    queue = "Список документов на печать:";
    pendingPagesCount = 0;
    totalCountOfPagesPrinted = 0;
  }

  public void clear() {

    queue = "Список документов на печать:";
    pendingPagesCount = 0;
  }

  public void print() {

    System.out.println(queue);
    totalCountOfPagesPrinted += pendingPagesCount;
    clear();
  }

  public int getPendingPagesCount() {

    return pendingPagesCount;
  }

  public int getTotalCountOfPagesPrinted() {

    return totalCountOfPagesPrinted;
  }

  public void append(String text) {

    append(text, 1);
  }

  public void append(String text, int pages) {

    queue = queue + System.lineSeparator() + text + " - " + pages + " стр.";
    pendingPagesCount += pages;
  }

  public void append(String text, String title, int pages) {

    pendingPagesCount += pages;
    queue = queue + System.lineSeparator() + title + System.lineSeparator() + text + " - " + pages
        + " стр.";
  }

  public String getQueue() {

    return queue;
  }
}
