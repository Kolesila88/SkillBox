package test;

import model.Country;

public class TestCountry {

  public static void main(String[] args) {

    String testCountryName = "England";
    String testCapitalName = "London";

    int testPopulation = 55_980_000;
    int testAreaInSquareKilometers = 130_279;

    boolean testAccessToTheSea = true;

    Country country = new Country(testCountryName);

    System.out.println(
        "testCountryName = " + testCountryName + ". country.name = " + country.getCountryName()
            + "\ntestCountryName = country.name: " + testCountryName
            .equals(country.getCountryName()));
    System.out.println("capitalName is not initialized: " + (country.getCapitalName() == null));
    country.setCapitalName(testCapitalName);
    System.out.println("capitalName = " + testCapitalName + ": " + country.getCapitalName()
        .equals(testCapitalName));

    System.out.println("country.population = " + country.getPopulation());
    System.out.println("testPopulation = " + testPopulation);
    country.setPopulation(testPopulation);
    System.out.println(
        "country.population = testPopulation: " + (testPopulation == country.getPopulation())
            + "\ncountry.population = " + country.getPopulation());

    System.out.println("country.areaInSquareKilometers = " + country.getAreaInSquareKilometers());
    System.out.println("testAreaInSquareKilometers = " + testAreaInSquareKilometers);
    country.setAreaInSquareKilometers(testAreaInSquareKilometers);
    System.out.println("country.areaInSquareKilometers = testAreaInSquareKilometers: "
        + (testAreaInSquareKilometers == country.getAreaInSquareKilometers())
        + "\ncountry.areaInSquareKilometers = " + country.getAreaInSquareKilometers());

    System.out.println("country.accessToTheSea = " + country.getAccessToTheSea()
        + "\ntestAccessToTheSea = " + testAccessToTheSea);
    country.setAccessToTheSea(testAccessToTheSea);
    System.out.println("country.accessToTheSea = testAccessToTheSea: "
        + (country.getAccessToTheSea() == testAccessToTheSea)
        + "\ncountry.accessToTheSea = " + country.getAccessToTheSea());
  }

}
