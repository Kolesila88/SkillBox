package basket;

public class TestBasket {

  public static void main(String[] args) {
    Basket basket = new Basket();
    basket.add("Milk", 40, 2, 250);
    basket.print("Milk");
  }
}
