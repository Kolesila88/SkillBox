package com.java.computer.model;

import com.java.computer.model.accessories.cpu.Cpu;
import com.java.computer.model.accessories.keyboard.Keyboard;
import com.java.computer.model.accessories.monitor.Monitor;
import com.java.computer.model.accessories.ram.Ram;
import com.java.computer.model.accessories.storageDevise.StorageDevise;

public class Computer {

  private Cpu cpu;
  private Ram ram;
  private StorageDevise storageDevise;
  private Monitor monitor;
  private Keyboard keyboard;

  private final String vendor;
  private final String name;

  public Computer(Cpu cpu, Ram ram,
      StorageDevise storageDevise, Monitor monitor,
      Keyboard keyboard, String vendor, String name) {
    this.cpu = cpu;
    this.ram = ram;
    this.storageDevise = storageDevise;
    this.monitor = monitor;
    this.keyboard = keyboard;
    this.vendor = vendor;
    this.name = name;
  }

  public int getTotalComputerWeight() {
    return cpu.getWeightInGrams()
        + ram.getWeightInGrams()
        + storageDevise.getWeightInGrams()
        + monitor.getWeightInGrams()
        + keyboard.getWeightInGrams();
  }

  public Cpu getCpu() {
    return cpu;
  }

  public Ram getRam() {
    return ram;
  }

  public StorageDevise getStorageDevise() {
    return storageDevise;
  }

  public Monitor getMonitor() {
    return monitor;
  }

  public Keyboard getKeyboard() {
    return keyboard;
  }

  public String getVendor() {
    return vendor;
  }

  public String getName() {
    return name;
  }

  public void setCpu(Cpu cpu) {
    this.cpu = cpu;
  }

  public void setRam(Ram ram) {
    this.ram = ram;
  }

  public void setStorageDevise(
      StorageDevise storageDevise) {
    this.storageDevise = storageDevise;
  }

  public void setMonitor(Monitor monitor) {
    this.monitor = monitor;
  }

  public void setKeyboard(Keyboard keyboard) {
    this.keyboard = keyboard;
  }

  public String toString() {
    return String.format("\tComputer name: %s\n\tComputer vendor: %s\n\tCPU:\n\t\tFrequency: %s"
            + "\n\t\tCount of cores: %s\n\t\tCPU vendor: %s\n\t\tWeight: %s\n\tRAM:\n\t\tRAM Type: %s"
            + "\n\t\tSize: %s\n\t\tWeight: %s\n\tStorage devise:\n\t\tDrive type: %s"
            + "\n\t\tStorage capacity: %s\n\t\tWeight: %s\n\tMonitor:\n\t\tDiagonal: %s"
            + "\n\t\tMonitor type: %s\n\t\tWeight: %s\n\tKeyboard:\n\t\tKeyboard type: %s"
            + "\n\t\tIs backlight: %s\n\t\tWeight: %s",
        name, vendor, cpu.getCpuFrequencyInMhz(), cpu.getCountOfCores(), cpu.getCpuVendor(),
        cpu.getWeightInGrams(), ram.getRamType().name(), ram.getRamAmountInMegabytes(),
        ram.getWeightInGrams(),
        storageDevise.getDriveType().name(), storageDevise.getStorageCapacityInGigabytes(),
        storageDevise.getWeightInGrams(), monitor.getDiagonalInInches(),
        monitor.getMonitorType().name(),
        monitor.getWeightInGrams(), keyboard.getKeyboardType().name(), keyboard.isBacklight(),
        keyboard.getWeightInGrams());
  }
}
