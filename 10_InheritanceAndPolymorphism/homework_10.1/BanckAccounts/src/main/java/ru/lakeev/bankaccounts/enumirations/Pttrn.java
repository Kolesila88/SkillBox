package ru.lakeev.bankaccounts.enumirations;

public enum Pttrn {

  DATE_PATTERN("dd.MM.yyyy - E"),
  ACC_NUM_PATTERN("4081781057000[\\d]{7}");

  private String pattern;

  Pttrn(String pattern) {

    this.pattern = pattern;
  }

  public String getPattern() {

    return pattern;
  }
}
