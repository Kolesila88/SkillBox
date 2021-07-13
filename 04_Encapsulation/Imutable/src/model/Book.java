package model;

public class Book {

  private final String name;
  private final String author;
  private final int pagesCount;
  private final String numberIsbn;

  public Book(String name, String author, int pagesCount, String numberIsbn) {

    this.name = name;
    this.author = author;
    this.pagesCount = pagesCount;
    this.numberIsbn = numberIsbn;
  }

  public String getName() {
    return name;
  }

  public String getAuthor() {
    return author;
  }

  public int getPagesCount() {
    return pagesCount;
  }

  public String getNumberIsbn() {
    return numberIsbn;
  }
}
