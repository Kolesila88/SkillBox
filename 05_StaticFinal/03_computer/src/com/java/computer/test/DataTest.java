package com.java.computer.test;

import com.java.computer.model.accessories.keyboard.KeyboardType;
import com.java.computer.model.accessories.monitor.MonitorType;
import com.java.computer.model.accessories.ram.RamType;
import com.java.computer.model.accessories.storageDevise.DriveType;

enum DataTest {

  INSTANSE;

  private final String testComputerName = "Some name.";
  private final String testComputerVendor = "Some computer vendor.";

  private final byte testCountOfCores = 8;
  private final int testCpuFrequencyInMhz = 3000;
  private final String testCpuVendor = "Some CPU vendor.";
  private final int testCpuWeightInGrams = 250;

  private final RamType testRamType = RamType.DDR3;
  private final int testRamAmountInMegabytes = 32_000;
  private final int testRamWeightInGrams = 190;

  private final DriveType testDriveType = DriveType.SSD;
  private final int testStorageCapacityInGb = 2500;
  private final int testStorageDeviseWeightInGrams = 2000;

  private final double testDiagonal = 20.5;
  private final MonitorType testMonitorType = MonitorType.IPS;
  private final int testMonitorWeightInGrams = 2900;

  private final boolean testBacklight = true;
  private final KeyboardType testKeyboardType = KeyboardType.PROJECTION;
  private final int testKeyboardWeightInGrams = 700;

  public String getTestComputerName() {
    return testComputerName;
  }

  public String getTestComputerVendor() {
    return testComputerVendor;
  }

  public byte getTestCountOfCores() {
    return testCountOfCores;
  }

  public int getTestCpuFrequencyInMhz() {
    return testCpuFrequencyInMhz;
  }

  public String getTestCpuVendor() {
    return testCpuVendor;
  }

  public int getTestCpuWeightInGrams() {
    return testCpuWeightInGrams;
  }

  public RamType getTestRamType() {
    return testRamType;
  }

  public int getTestRamAmountInMegabytes() {
    return testRamAmountInMegabytes;
  }

  public int getTestRamWeightInGrams() {
    return testRamWeightInGrams;
  }

  public DriveType getTestDriveType() {
    return testDriveType;
  }

  public int getTestStorageCapacityInGb() {
    return testStorageCapacityInGb;
  }

  public int getTestStorageDeviseWeightInGrams() {
    return testStorageDeviseWeightInGrams;
  }

  public double getTestDiagonal() {
    return testDiagonal;
  }

  public MonitorType getTestMonitorType() {
    return testMonitorType;
  }

  public int getTestMonitorWeightInGrams() {
    return testMonitorWeightInGrams;
  }

  public boolean isTestBacklight() {
    return testBacklight;
  }

  public KeyboardType getTestKeyboardType() {
    return testKeyboardType;
  }

  public int getTestKeyboardWeightInGrams() {
    return testKeyboardWeightInGrams;
  }
}
