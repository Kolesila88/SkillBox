package model;

public class Person {

  private String name;
  private String sureName;
  private String patronymic;

  private int age;

  private String documentNumber;

  public Person(String name, String sureName, String patronymic) {

    this.name = name;
    this.sureName = sureName;
    this.patronymic = patronymic;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSureName() {
    return sureName;
  }

  public void setSureName(String sureName) {
    this.sureName = sureName;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }
}
