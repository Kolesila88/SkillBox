package model;

public class Country {

  private String countryName;
  private String capitalName;

  private int population;
  private int areaInSquareKilometers;

  private boolean accessToTheSea;

  public Country(String countryName) {

    this.countryName = countryName;
  }

  public String getCountryName() {

    return countryName;
  }

  public void setCountryName(String countryName) {

    this.countryName = countryName;
  }

  public String getCapitalName() {

    return capitalName;
  }

  public void setCapitalName(String capitalName) {

    this.capitalName = capitalName;
  }

  public int getPopulation() {

    return population;
  }

  public void setPopulation(int population) {

    this.population = population;
  }

  public int getAreaInSquareKilometers() {

    return areaInSquareKilometers;
  }

  public void setAreaInSquareKilometers(int areaInSquareKilometers) {

    this.areaInSquareKilometers = areaInSquareKilometers;
  }

  public boolean getAccessToTheSea() {

    return accessToTheSea;
  }

  public void setAccessToTheSea(boolean accessToTheSeaStatus) {

    this.accessToTheSea = accessToTheSeaStatus;
  }
}
