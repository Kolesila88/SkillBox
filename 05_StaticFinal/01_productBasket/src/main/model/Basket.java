package main.model;

public class Basket {

  private static int countOfItemsInBaskets = 0;
  private static double totalPriceOfItemsInBaskets = 0;
  private static int count = 0;

  private String items;
  private double totalPrice;
  private double limit;
  private double totalWeight;

  public Basket() {
    this.items = "";
    this.totalPrice = 0;
    this.totalWeight = 0;
    increaseCount(1);
    this.items = "Список товаров:";
    this.limit = 1000000;
  }

  public Basket(int limit) {
    this();
    this.limit = limit;
  }

  public Basket(String items, int totalPrice) {
    this();
    this.items = this.items + items;
    this.totalPrice = totalPrice;
  }

  private static void increaseCountOfItemsInBaskets(int count) {
    countOfItemsInBaskets += count;
  }

  private static void increaseTotalPriceOfItemsInBaskets(int count, double price) {
    totalPriceOfItemsInBaskets += count * price;
  }

  public static double getAveragePriceOfItems() {
    return totalPriceOfItemsInBaskets / countOfItemsInBaskets;
  }

  public static double getAverageTotalBasketPrice() {
    return totalPriceOfItemsInBaskets / count;
  }

  public static int getCountOfItemsInBaskets() {
    return countOfItemsInBaskets;
  }

  public static double getTotalPriceOfItemsInBaskets() {
    return totalPriceOfItemsInBaskets;
  }

  public double getTotalWeight() {
    return this.totalWeight;
  }

  public static int getCount() {
    return count;
  }

  public static void increaseCount(int count) {
    Basket.count += count;
  }

  public void add(String name, double price) {
    add(name, price, 1);
  }

  public void add(String name, double price, int count) {
    boolean error = false;
    if (contains(name)) {
      error = true;
    }

    if (totalPrice + count * price >= limit) {
      error = true;
    }

    if (error) {
      System.out.println("Error occured :(");
    } else {
      items = items + "\n" + name + " - " + count + " шт. - " + price;
      totalPrice += count * price;
      increaseCountOfItemsInBaskets(count);
      increaseTotalPriceOfItemsInBaskets(count, price);
    }
  }

  public void add(String name, double price, int count, double weight) {
    add(name, price, count);
    totalWeight += weight;
  }

  public void clear() {
    items = "";
    totalPrice = 0;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public boolean contains(String name) {
    return items.contains(name);
  }

  public void print(String title) {
    System.out.println(title);
    if (this.items.isEmpty()) {
      System.out.println("Корзина пуста");
    } else {
      System.out.println(items + "\nTotal weight: " + getTotalWeight() + ".");
    }

  }
}

