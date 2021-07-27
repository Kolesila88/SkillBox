package ru.lakeev.companyandstaff.name;

import ru.lakeev.companyandstaff.gender.Gender;

public class FullName {

  public static String createAndGetFullName(Gender gender) {

    String employeeFullName;

    switch (gender) {

      case MALE:

        employeeFullName = Surname.getSurname()
            .concat(" ")
            .concat(MaleName.getMaleName())
            .concat(" ")
            .concat(MaleMiddleName.getMaleMiddleName());
        break;
      case FEMALE:

        employeeFullName = Surname.getSurname()
            .concat("а ")
            .concat(FemaleName.getFemaleName())
            .concat(" ")
            .concat(FemaleMiddleName.getFemaleMiddleName());
        break;
      default:

        throw new IllegalStateException("Unexpected value: " + gender);
    }
    return employeeFullName;
  }
}
