package com.java.computer.model.accessories.ram;

public class Ram {

  private final RamType ramType;
  private final int ramAmountInMegabytes;
  private final int weightInGrams;

  public Ram(RamType ramType, int ramAmountInMegabytes, int weightInGrams) {
    this.ramType = ramType;
    this.ramAmountInMegabytes = ramAmountInMegabytes;
    this.weightInGrams = weightInGrams;
  }

  public RamType getRamType() {
    return ramType;
  }

  public int getRamAmountInMegabytes() {
    return ramAmountInMegabytes;
  }

  public int getWeightInGrams() {
    return weightInGrams;
  }
}
