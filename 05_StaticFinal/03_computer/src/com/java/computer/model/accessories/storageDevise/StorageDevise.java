package com.java.computer.model.accessories.storageDevise;

public class StorageDevise {

  private final DriveType driveType;
  private final int storageCapacityInGigabytes;
  private final int weightInGrams;

  public StorageDevise(DriveType driveType, int storageCapacityInGigabytes, int weightInGrams) {
    this.driveType = driveType;
    this.storageCapacityInGigabytes = storageCapacityInGigabytes;
    this.weightInGrams = weightInGrams;
  }

  public DriveType getDriveType() {
    return driveType;
  }

  public int getStorageCapacityInGigabytes() {
    return storageCapacityInGigabytes;
  }

  public int getWeightInGrams() {
    return weightInGrams;
  }
}
