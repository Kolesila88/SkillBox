package test;

import elevator.Elevator;

import java.util.Scanner;

public class TestElevator {

  public static void main(String[] args) {

    Elevator elevator = new Elevator(-3, 26);

    while (true) {

      System.out.print("Введите номер этажа: ");

      int floor = new Scanner(System.in).nextInt();

      elevator.move(floor);

    }
  }
}
