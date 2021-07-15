package com.java.computer.test;

import com.java.computer.model.Computer;
import com.java.computer.model.accessories.cpu.Cpu;
import com.java.computer.model.accessories.keyboard.Keyboard;
import com.java.computer.model.accessories.monitor.Monitor;
import com.java.computer.model.accessories.ram.Ram;
import com.java.computer.model.accessories.storageDevise.StorageDevise;

public class ComputerTest {

  //Тестовые данные
  private static final DataTest DATA_TEST = DataTest.INSTANSE;

  public static void main(String[] args) {

    //Инициализация Тестируемого объекта и его компонентов
    Cpu testCpu = new Cpu(DATA_TEST.getTestCpuFrequencyInMhz(), DATA_TEST.getTestCountOfCores(),
        DATA_TEST.getTestCpuVendor(), DATA_TEST.getTestCpuWeightInGrams());
    Ram testRam = new Ram(DATA_TEST.getTestRamType(), DATA_TEST.getTestRamAmountInMegabytes(),
        DATA_TEST.getTestRamWeightInGrams());
    StorageDevise testStorageDevise = new StorageDevise(DATA_TEST.getTestDriveType(),
        DATA_TEST.getTestStorageCapacityInGb(), DATA_TEST.getTestStorageDeviseWeightInGrams());
    Monitor testMonitor = new Monitor(DATA_TEST.getTestDiagonal(), DATA_TEST.getTestMonitorType(),
        DATA_TEST.getTestMonitorWeightInGrams());
    Keyboard testKeyboard = new Keyboard(DATA_TEST.getTestKeyboardType(),
        DATA_TEST.isTestBacklight(), DATA_TEST.getTestKeyboardWeightInGrams());
    Computer testComputer = new Computer(testCpu, testRam, testStorageDevise, testMonitor,
        testKeyboard, DATA_TEST.getTestComputerVendor(), DATA_TEST.getTestComputerName());

    //Вызываем тестовые методы
    getTotalComputerWeightTest(testComputer);
    toStringTest(testComputer);

  }

  //Тестовые методы
  private static void getTotalComputerWeightTest(Computer testComputer) {

    int expendedValue = DATA_TEST.getTestCpuWeightInGrams() + DATA_TEST.getTestRamWeightInGrams()
        + DATA_TEST.getTestStorageDeviseWeightInGrams() + DATA_TEST.getTestMonitorWeightInGrams()
        + DATA_TEST.getTestKeyboardWeightInGrams();

    if (expendedValue == testComputer.getTotalComputerWeight()) {

      System.out.println(String
          .format(Messages.TEST_PASSED_SUCCESSFULLY_MSG.getMessage(), expendedValue,
              testComputer.getTotalComputerWeight()));
    } else {

      System.out.println(String.format(Messages.TEST_FAILED_MSG.getMessage(), expendedValue,
          testComputer.getTotalComputerWeight()));
    }
  }

  private static void toStringTest(Computer testComputer) {

    String expendedString = "\tComputer name: " + DATA_TEST.getTestComputerName()
        + "\n\tComputer vendor: " + DATA_TEST.getTestComputerVendor() + "\n\tCPU:\n\t\tFrequency: "
        + DATA_TEST.getTestCpuFrequencyInMhz() + "\n\t\tCount of cores: "
        + DATA_TEST.getTestCountOfCores() + "\n\t\tCPU vendor: " + DATA_TEST.getTestCpuVendor()
        + "\n\t\tWeight: " + DATA_TEST.getTestCpuWeightInGrams() + "\n\tRAM:\n\t\tRAM Type: "
        + DATA_TEST.getTestRamType().name() + "\n\t\tSize: " + DATA_TEST
        .getTestRamAmountInMegabytes()
        + "\n\t\tWeight: " + DATA_TEST.getTestRamWeightInGrams()
        + "\n\tStorage devise:\n\t\tDrive type: " + DATA_TEST.getTestDriveType().name()
        + "\n\t\tStorage capacity: " + DATA_TEST.getTestStorageCapacityInGb() + "\n\t\tWeight: "
        + DATA_TEST.getTestStorageDeviseWeightInGrams() + "\n\tMonitor:\n\t\tDiagonal: "
        + DATA_TEST.getTestDiagonal() + "\n\t\tMonitor type: " + DATA_TEST.getTestMonitorType()
        + "\n\t\tWeight: " + DATA_TEST.getTestMonitorWeightInGrams()
        + "\n\tKeyboard:\n\t\tKeyboard type: "
        + DATA_TEST.getTestKeyboardType() + "\n\t\tIs backlight: " + DATA_TEST.isTestBacklight() +
        "\n\t\tWeight: " + DATA_TEST.getTestKeyboardWeightInGrams();

    if (expendedString.equals(testComputer.toString())) {

      System.out.println(String
          .format(Messages.TEST_PASSED_SUCCESSFULLY_MSG.getMessage(), expendedString,
              testComputer.toString()));
    }else {

      System.out.println(String.format(Messages.TEST_FAILED_MSG.getMessage(), expendedString,
          testComputer.toString()));
    }
  }
}
