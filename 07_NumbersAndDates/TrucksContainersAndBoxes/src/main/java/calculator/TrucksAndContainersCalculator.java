package calculator;

import message.Messages;
import model.box.Box;
import model.container.Container;
import model.truck.Truck;
import props.Values;

import java.math.BigInteger;

public class TrucksAndContainersCalculator {

  public static StringBuilder arrangeBoxesIntoContainersAndTrucks(int boxCount) {

    StringBuilder builder = new StringBuilder();
    int trucksCount = boxCount / Values.TRUCK_CAPACITY_IN_BOXES_VAL.getValue();

    if (boxCount % Values.TRUCK_CAPACITY_IN_BOXES_VAL.getValue() > BigInteger.ZERO.intValue()) {

      trucksCount++;
    }
    Truck[] trucks = new Truck[trucksCount];
    Container container = null;

    if (boxCount > BigInteger.ZERO.intValue()) {

      for (int i = BigInteger.ZERO.intValue(); i < boxCount; i++) {

        Box processedBox = new Box(i + BigInteger.ONE.intValue());

        if (i % Values.CONTAINER_CAPACITY_IN_BOXES_VAL.getValue() == BigInteger.ZERO.intValue()) {

          container = loadAndGetNextContainer(builder, trucks, container, i);
        }
        builder.append(String
            .format(Messages.BOX_INFO_MSG.getMessage(), processedBox.getBoxNumber(),
                System.lineSeparator()));
        assert container != null;
        putBoxInContainerAndCheckContainerIsFull(trucks, container, processedBox, boxCount, i);
      }
    }
    builder.append(String
        .format(Messages.RESULT_INFO_MSG.getMessage(),
            System.lineSeparator(),
            Truck.getTruckCount(),
            System.lineSeparator(),
            Container.getContainersCount()));
    Container.resetContainerCount();
    Truck.resetTruckCount();
    return builder;
  }

  private static void putBoxInContainerAndCheckContainerIsFull(
      Truck[] trucks, Container container, Box processedBox, int boxCount, int i) {

    if (container.getBoxes()[Values.CONTAINER_CAPACITY_IN_BOXES_VAL.getValue() - BigInteger.ONE
        .intValue()] == null) {
      container.putBoxInContainer(processedBox);
      if (container.getBoxes()[Values.CONTAINER_CAPACITY_IN_BOXES_VAL.getValue() - BigInteger.ONE
          .intValue()] != null) {
        container.setFull(true);
      }
    }
    if (container.isFull()) {

      trucks[i / Values.TRUCK_CAPACITY_IN_BOXES_VAL.getValue()].putContainerInTruck(container);
      if (trucks[i / Values.TRUCK_CAPACITY_IN_BOXES_VAL.getValue()].getContainers()[
          Values.TRUCK_CAPACITY_IN_CONTAINERS_VAL.getValue() - BigInteger.ONE.intValue()] != null) {

        trucks[i / Values.TRUCK_CAPACITY_IN_BOXES_VAL.getValue()].setFool(true);
      }

    } else if (i == boxCount - BigInteger.ONE.intValue()) {

      trucks[i / Values.TRUCK_CAPACITY_IN_BOXES_VAL.getValue()].putContainerInTruck(container);
    }
  }

  private static void loadNextTruck(Truck[] trucks, StringBuilder outputString,
      String lineSeparator) {

    Truck truck = new Truck(Truck.getTruckCount() + BigInteger.ONE.intValue());
    trucks[truck.getTruckNumber() - BigInteger.ONE.intValue()] = truck;
    outputString.append(String
        .format(Messages.TRUCK_INFO_MSG.getMessage(), truck.getTruckNumber(), lineSeparator));
  }

  private static Container loadAndGetNextContainer(StringBuilder outputString, Truck[] trucks,
      Container container, int i) {

    container = new Container(
        i / Values.CONTAINER_CAPACITY_IN_BOXES_VAL.getValue() + BigInteger.ONE.intValue());

    if (i % Values.TRUCK_CAPACITY_IN_BOXES_VAL.getValue() == BigInteger.ZERO.intValue()) {

      loadNextTruck(trucks, outputString, System.lineSeparator());
    }
    outputString.append(String
        .format(Messages.CONTAINER_INFO_MSG.getMessage(), container.getNumber(),
            System.lineSeparator()));
    return container;
  }


}

