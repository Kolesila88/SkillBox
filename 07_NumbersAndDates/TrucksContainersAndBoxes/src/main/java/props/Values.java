package props;

public enum Values {

  CONTAINER_CAPACITY_IN_BOXES_VAL(27),
  TRUCK_CAPACITY_IN_BOXES_VAL(324),
  TRUCK_CAPACITY_IN_CONTAINERS_VAL(12);

  private int value;

  Values(int value) {

    this.value = value;
  }

  public int getValue() {

    return value;
  }
}
