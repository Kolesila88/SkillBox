package model;

import java.math.BigDecimal;

public class Dimensions {

  private final BigDecimal widthInCentimeters;
  private final BigDecimal heightInCentimeters;
  private final BigDecimal lengthInCentimeters;

  public Dimensions(BigDecimal widthInCentimeters, BigDecimal heightInCentimeters,
      BigDecimal lengthInCentimeters) {
    this.widthInCentimeters = widthInCentimeters;
    this.heightInCentimeters = heightInCentimeters;
    this.lengthInCentimeters = lengthInCentimeters;
  }

  public BigDecimal getWidthInCentimeters() {
    return widthInCentimeters;
  }

  public BigDecimal getHeightInCentimeters() {
    return heightInCentimeters;
  }

  public BigDecimal getLengthInCentimeters() {
    return lengthInCentimeters;
  }

  public BigDecimal calculateAndGetTheVolumeOfCargo() {

    return new BigDecimal(String.valueOf(
        getWidthInCentimeters().multiply(getHeightInCentimeters())
            .multiply(getLengthInCentimeters())));
  }

  public boolean equals(Dimensions comparableDimensions) {

    return getWidthInCentimeters().equals(comparableDimensions.getWidthInCentimeters()) &&
        getHeightInCentimeters().equals(comparableDimensions.getHeightInCentimeters()) &&
        getLengthInCentimeters().equals(comparableDimensions.getLengthInCentimeters());
  }
}
