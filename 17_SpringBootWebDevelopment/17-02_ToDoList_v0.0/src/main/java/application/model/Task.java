package application.model;

public class Task {

  // Переменная для хранения значения уникального ключа.
  private int id;
  // Заголовок.
  private String name;
  // Описание.
  private String description;


  //Геттеры и Сеттеры.
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}

