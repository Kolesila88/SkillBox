package com.java.computer.model.accessories.monitor;

public class Monitor {

  private final double diagonalInInches;
  private final MonitorType monitorType;
  private final int weightInGrams;

  public Monitor(double diagonalInInches, MonitorType monitorType, int weightInGrams) {
    this.diagonalInInches = diagonalInInches;
    this.monitorType = monitorType;
    this.weightInGrams = weightInGrams;
  }

  public double getDiagonalInInches() {
    return diagonalInInches;
  }

  public MonitorType getMonitorType() {
    return monitorType;
  }

  public int getWeightInGrams() {
    return weightInGrams;
  }
}
