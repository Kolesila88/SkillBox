package com.java.computer.model.accessories.keyboard;

public class Keyboard {

  private final KeyboardType keyboardType;
  private final boolean backlight;
  private final int weightInGrams;

  public Keyboard(KeyboardType keyboardType, boolean backlight, int weightInGrams) {
    this.keyboardType = keyboardType;
    this.backlight = backlight;
    this.weightInGrams = weightInGrams;
  }

  public KeyboardType getKeyboardType() {
    return keyboardType;
  }

  public boolean isBacklight() {
    return backlight;
  }

  public int getWeightInGrams() {
    return weightInGrams;
  }
}
