package com.java.computer.model.accessories.cpu;

public class Cpu {

  private final int cpuFrequencyInMhz;
  private final byte countOfCores;
  private final String cpuVendor;
  private final int weightInGrams;

  public Cpu(int cpuFrequencyInMhz, byte countOfCores, String cpuVendor, int weightInGrams) {
    this.cpuFrequencyInMhz = cpuFrequencyInMhz;
    this.countOfCores = countOfCores;
    this.cpuVendor = cpuVendor;
    this.weightInGrams = weightInGrams;
  }

  public int getCpuFrequencyInMhz() {
    return cpuFrequencyInMhz;
  }

  public byte getCountOfCores() {
    return countOfCores;
  }

  public String getCpuVendor() {
    return cpuVendor;
  }

  public int getWeightInGrams() {
    return weightInGrams;
  }
}
