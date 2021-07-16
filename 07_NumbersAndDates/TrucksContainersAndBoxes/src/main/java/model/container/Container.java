package model.container;

import model.box.Box;
import props.Values;

import java.math.BigInteger;

public class Container {

  private static int containersCount;
  private int number;
  private boolean full;
  private Box[] boxes;

  public Container(Integer number) {
    this.number = number;
    containersCount++;
    full = false;
    boxes = new Box[Values.CONTAINER_CAPACITY_IN_BOXES_VAL.getValue()];
  }

  public static int getContainersCount() {

    return containersCount;
  }

  public static void resetContainerCount() {

    containersCount = BigInteger.ZERO.intValue();
  }

  public boolean isFull() {

    return full;
  }

  public void setFull(boolean full) {

    this.full = full;
  }

  public Box[] getBoxes() {

    return boxes;
  }

  public int getNumber() {

    return number;
  }

  public void putBoxInContainer(Box box) {

    for (int i = BigInteger.ZERO.intValue(); i < boxes.length; i++) {

      if (boxes[i] == null) {
        boxes[i] = box;
        break;
      }
    }
  }
}
