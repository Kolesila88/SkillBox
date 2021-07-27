package ru.lakeev.companyandstaff.random;

import java.util.Random;

public class ValuesGenerator {

  private static Random instance;

  public static Random getInstance() {

    if (instance == null) {
      instance = new Random();
    }
    return instance;
  }

}
