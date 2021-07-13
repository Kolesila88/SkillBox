package model;

public class CargoDescription {

  private final Dimensions dimensions;
  private final double weightInKilograms;
  private final String deliveryAddress;
  private final boolean doNotTorn;
  private final String registrationNumber;
  private final boolean fragile;

  public CargoDescription(Dimensions dimensions,
      double weightInKilograms,
      String deliveryAddress,
      boolean doNotTorn,
      String registrationNumber,
      boolean fragile) {

    this.dimensions = dimensions;
    this.weightInKilograms = weightInKilograms;
    this.deliveryAddress = deliveryAddress;
    this.doNotTorn = doNotTorn;
    this.registrationNumber = registrationNumber;
    this.fragile = fragile;
  }

  public Dimensions getDimensions() {
    return dimensions;
  }

  public double getWeightInKilograms() {
    return weightInKilograms;
  }

  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  public boolean isDoNotTorn() {
    return doNotTorn;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public boolean isFragile() {
    return fragile;
  }

  public static CargoDescription copyCargoDescriptionAndSetDimensions(
      CargoDescription copiedCargoDescription,
      Dimensions newDimensions) {

    return new CargoDescription(newDimensions,
        copiedCargoDescription.getWeightInKilograms(),
        copiedCargoDescription.getDeliveryAddress(),
        copiedCargoDescription.isDoNotTorn(),
        copiedCargoDescription.getRegistrationNumber(),
        copiedCargoDescription.isFragile());
  }

  public static CargoDescription copyCargoDescriptionAndSetWeightInKilograms(
      CargoDescription copiedCargoDescription,
      double newWeightInKilograms) {

    return new CargoDescription(copiedCargoDescription.getDimensions(),
        newWeightInKilograms,
        copiedCargoDescription.getDeliveryAddress(),
        copiedCargoDescription.isDoNotTorn(),
        copiedCargoDescription.getRegistrationNumber(),
        copiedCargoDescription.isFragile());
  }

  public static CargoDescription copyCargoDescriptionAndSetDeliveryAddress(
      CargoDescription copiedCargoDescription,
      String newDeliveryAddress) {

    return new CargoDescription(copiedCargoDescription.getDimensions(),
        copiedCargoDescription.getWeightInKilograms(),
        newDeliveryAddress,
        copiedCargoDescription.isDoNotTorn(),
        copiedCargoDescription.getRegistrationNumber(),
        copiedCargoDescription.isFragile());
  }

  public static CargoDescription copyCargoDescriptionAndSetDoNotTorn(
      CargoDescription copiedCargoDescription,
      boolean newDoNotTornStatus) {

    return new CargoDescription(copiedCargoDescription.getDimensions(),
        copiedCargoDescription.getWeightInKilograms(),
        copiedCargoDescription.getDeliveryAddress(),
        newDoNotTornStatus,
        copiedCargoDescription.getRegistrationNumber(),
        copiedCargoDescription.isFragile());
  }

  public static CargoDescription copyCargoDescriptionAndSetRegistrationNumber(
      CargoDescription copiedCargoDescription,
      String newRegistrationNumber) {

    return new CargoDescription(copiedCargoDescription.getDimensions(),
        copiedCargoDescription.getWeightInKilograms(),
        copiedCargoDescription.getDeliveryAddress(),
        copiedCargoDescription.isDoNotTorn(),
        newRegistrationNumber,
        copiedCargoDescription.isFragile());
  }

  public static CargoDescription copyCargoDescriptionAndSetFragile(
      CargoDescription copiedCargoDescription,
      boolean newFragileStatus) {

    return new CargoDescription(copiedCargoDescription.getDimensions(),
        copiedCargoDescription.getWeightInKilograms(),
        copiedCargoDescription.getDeliveryAddress(),
        copiedCargoDescription.isDoNotTorn(),
        copiedCargoDescription.getRegistrationNumber(),
        newFragileStatus);
  }
}
