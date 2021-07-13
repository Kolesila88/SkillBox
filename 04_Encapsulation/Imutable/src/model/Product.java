package model;

public class Product {

  private final String name;
  private int price;
  private final String barCode;

  public Product(String name, String barCode) {

    this.name = name;
    this.barCode = barCode;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public String getBarCode() {
    return barCode;
  }

  public void setPrice(int newPrice) {

    this.price = newPrice;
  }
}
