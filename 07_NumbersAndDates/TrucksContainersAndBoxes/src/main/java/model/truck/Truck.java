package model.truck;

import model.container.Container;
import props.Values;

import java.math.BigInteger;

public class Truck {

  private static int truckCount;
  private int truckNumber;
  private Container[] containers;
  private boolean fool;

  public Truck(Integer number) {

    truckNumber = number;
    truckCount++;
    containers = new Container[Values.TRUCK_CAPACITY_IN_CONTAINERS_VAL.getValue()];
  }

  public static int getTruckCount() {

    return truckCount;
  }

  public static void resetTruckCount() {

    truckCount = BigInteger.ZERO.intValue();
  }

  public int getTruckNumber() {

    return truckNumber;
  }

  public Container[] getContainers() {

    return containers;
  }

  public void putContainerInTruck(Container container) {

    for (int i = BigInteger.ZERO.intValue(); i < containers.length; i++) {

      if (containers[i] == null) {
        containers[i] = container;
        break;
      }
    }
  }

  public void setFool(boolean fool) {

    this.fool = fool;
  }
}
