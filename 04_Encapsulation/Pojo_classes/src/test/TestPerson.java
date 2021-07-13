package test;

import model.Person;

public class TestPerson {

  private static final String TEST_PASSED_SUCCESSFULLY_MSG = "Test passed successfully!!!";
  private static final String TEST_FAILED_MSG = "Test failed!!!";

  public static void main(String[] args) {

    String testName = "Василий";
    String testSureName = "Златопольский";
    String testPatronymic = "Алексеевич";

    int testAge = 37;

    String testDocumentNumber = "46541988";

    personConstructorTest(testName, testSureName, testPatronymic);

    Person person = new Person("", "", "");

    setNameTest(testName, person);
    getNameTest(person, testName);
    setSureNameTest(testSureName, person);
    getSureNameTest(person, testSureName);
    setPatronymicTest(testPatronymic, person);
    getPatronymicTest(person, testPatronymic);
    setAgeTest(testAge, person);
    getAgeTest(person, testAge);
    setDocumentNumberTest(testDocumentNumber, person);
    getDocumentNumberTest(person, testDocumentNumber);


  }

  private static void personConstructorTest(String testName, String testSureName,
      String testPatronymic) {

    Person person = new Person(testName, testSureName, testPatronymic);

    if (person.getName().equals(testName) && person.getSureName().equals(testSureName)
        && person.getPatronymic().equals(testPatronymic)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {

      System.out.println(TEST_FAILED_MSG);
    }
  }

  private static void setSureNameTest(String testSureName, Person person) {

    String sureNameBefore = person.getSureName();

    if (sureNameBefore.length() > 0) {

      System.out.println("person.sureName filled! Test failed!");
    } else {

      System.out.println("person.sureName is not filled. testSureName = " + testSureName);
      person.setSureName(testSureName);
      String sureNameAfter = person.getSureName();

      if (sureNameAfter.equals(testSureName)) {

        System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
      } else {

        System.out.println(TEST_FAILED_MSG);
      }
    }
  }

  private static void getSureNameTest(Person person, String expendedSureName) {

    if (person.getSureName().equals(expendedSureName)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {
      System.out.println(TEST_FAILED_MSG);
    }
  }

  private static void setNameTest(String testName, Person person) {

    String nameBefore = person.getName();

    if (nameBefore.length() > 0) {

      System.out.println("person.name filled! Test failed!");
    } else {

      System.out.println("person.name is not filled. testName = " + testName);
      person.setName(testName);
      String nameAfter = person.getName();

      if (nameAfter.equals(testName)) {

        System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
      } else {

        System.out.println(TEST_FAILED_MSG);
      }
    }
  }

  private static void getNameTest(Person person, String expendedName) {

    if (person.getName().equals(expendedName)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {
      System.out.println(TEST_FAILED_MSG);
    }
  }

  private static void setPatronymicTest(String testPatronymic, Person person) {

    String patronymicBefore = person.getPatronymic();

    if (patronymicBefore.length() > 0) {

      System.out.println("person.patronymic filled! Test failed!");
    } else {

      System.out.println("person.patronymic is not filled. testPatronymic = " + testPatronymic);
      person.setPatronymic(testPatronymic);
      String patronymicAfter = person.getPatronymic();

      if (patronymicAfter.equals(testPatronymic)) {

        System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
      } else {

        System.out.println(TEST_FAILED_MSG);
      }
    }
  }

  private static void getPatronymicTest(Person person, String expendedPatronymic) {

    if (person.getPatronymic().equals(expendedPatronymic)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {
      System.out.println(TEST_FAILED_MSG);
    }
  }

  private static void setAgeTest(int testAge, Person person) {

    int ageBefore = person.getAge();

    if (ageBefore != 0) {

      System.out.println("person.age filled! Test failed!");
    } else {

      System.out.println("person.age is not filled. testAge = " + testAge);
      person.setAge(testAge);
      int ageAfter = person.getAge();

      if (ageAfter == testAge) {

        System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
      } else {

        System.out.println(TEST_FAILED_MSG);
      }
    }
  }

  private static void getAgeTest(Person person, int expendedAge) {

    if (person.getAge() == expendedAge) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {
      System.out.println(TEST_FAILED_MSG);
    }
  }

  private static void setDocumentNumberTest(String testDocumentNumber, Person person) {

    String documentNumberBefore = person.getDocumentNumber();

    if (documentNumberBefore != null) {

      System.out.println("person.documentNumber filled! Test failed!");
    } else {

      System.out.println(
          "person.documentNumber is not filled. testDocumentNumber = " + testDocumentNumber);
      person.setDocumentNumber(testDocumentNumber);
      String documentNumberAfter = person.getDocumentNumber();

      if (documentNumberAfter.equals(testDocumentNumber)) {

        System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
      } else {

        System.out.println(TEST_FAILED_MSG);
      }
    }
  }

  private static void getDocumentNumberTest(Person person, String expendedDocumentNumber) {

    if (person.getDocumentNumber().equals(expendedDocumentNumber)) {

      System.out.println(TEST_PASSED_SUCCESSFULLY_MSG);
    } else {
      System.out.println(TEST_FAILED_MSG);
    }
  }
}
