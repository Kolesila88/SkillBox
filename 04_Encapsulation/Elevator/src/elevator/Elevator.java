package elevator;

public class Elevator {

  private final String ELEVATOR_DESCENT_ERROR_MSG =
      "Elevator cannot go below the %sth floor.\nMin floor = %s";
  private final String ELEVATOR_LIFT_ERROR_MSG =
      "Elevator cannot go up to the %sth floor.\n Max floor = %s";
  private final String FLOOR_ENTRY_ERROR_MSG = "Incorrect floor. Specify the floor in the range from %s to %s.";
  private final String THE_ELEVATOR_IS_ALREADY_ON_THE_RIGHT_FLOOR_MSG = "Elevator is located on the %sth floor.";

  private int currentFloor;
  private int minFloor;
  private int maxFloor;

  public Elevator(int minFloor, int maxFloor) {

    this.currentFloor = 1;
    this.maxFloor = maxFloor;
    this.minFloor = minFloor;
  }

  public int getCurrentFloor() {

    return currentFloor;
  }

  private int getMinFloor() {

    return minFloor;
  }

  private int getMaxFloor() {

    return maxFloor;
  }

  public void moveDown() {

    if (getCurrentFloor() > getMinFloor()) {

      currentFloor--;
      System.out.printf("The elevator went down to the %sth floor.\n", getCurrentFloor());
    } else {

      try {

        throw new IllegalArgumentException(String.format(ELEVATOR_DESCENT_ERROR_MSG,
            getCurrentFloor() - 1, getMinFloor()));
      } catch (IllegalArgumentException e) {

        System.out.println(e.getMessage());
      }
    }
  }

  public void moveUp() {

    if (getCurrentFloor() < getMaxFloor()) {

      currentFloor++;
      System.out.printf("The elevator went up to the %sth floor.\n", getCurrentFloor());
    } else {

      try {

        throw new IllegalArgumentException(String.format(ELEVATOR_LIFT_ERROR_MSG,
            getCurrentFloor() + 1, getMaxFloor()));
      } catch (IllegalArgumentException e) {

        System.out.println(e.getMessage());
      }
    }
  }

  public void move(int floor) {

    if (floor >= minFloor && floor <= maxFloor) {

      try {
        moveTheElevatorAcrossFloors(floor);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else {
      try {

        throw new IllegalArgumentException(
            String.format(FLOOR_ENTRY_ERROR_MSG, getMinFloor(), getMaxFloor()));
      } catch (IllegalArgumentException e) {

        System.out.println(e.getMessage());
      }
    }
  }

  private void moveTheElevatorAcrossFloors(int floor) throws InterruptedException {

    if (getCurrentFloor() < floor) {

      while (getCurrentFloor() < floor) {
        moveUp();
        Thread.sleep(1000);
      }
    } else if (getCurrentFloor() > floor) {

      while (getCurrentFloor() > floor) {
        moveDown();
        Thread.sleep(1000);
      }
    }
  }
}
