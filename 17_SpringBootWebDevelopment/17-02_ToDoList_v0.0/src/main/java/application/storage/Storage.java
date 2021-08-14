package application.storage;

import application.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {

  // Переменная для хранения значения id для следующего созданного и помещенного в структуру данных объекта.
  private static int currentId = 1;
  // Потокобезопасная коллекция данных, для хранения созданных объектов, где ключем является уникальный id объекта,
  //а значением сам объект.
  private static ConcurrentHashMap<Integer, Task> tasks = new ConcurrentHashMap<Integer, Task>();

  //Метод для добавления нового объекта в коллекцию.
  //Принимает на вход объект класса Task, устанавливает, возвращает и инкрементирует его id.
  public static int addTask(Task task) {
    int id = currentId++;
    task.setId(id);
    tasks.put(id, task);
    return id;
  }

  // Метод возвращающий все существующие в памяти обьекты, в виде списка.
  public static List<Task> getAllTasks() {
    ArrayList<Task> taskList = new ArrayList<Task>();
    taskList.addAll(tasks.values());
    return taskList;
  }

  // Метод возвращает значение Task соответствующее полученному на вход ключу(id) или, возвращает null, если
  // элемента с таким id нет в коллекции.
  public static Task getTask(int taskId) {
    if (tasks.containsKey(taskId)) {
      return tasks.get(taskId);
    }
    return null;
  }

  // Метод удаляет все данные из коллекции и сбрасывает значение переменной currentId до 1.
  public static void clearTasks() {
    currentId = 1;
    tasks.clear();
  }

  // Метод удаляет из коллекции элемент соответствующий ключу полученному на вход(taskId).
  public static void removeTask(int taskId) {
    tasks.remove(taskId);
  }

  // Метод меняет значение поля description на значение newDescription у поступившего на вход обьекта класса Task,
  // возвращает измененный обьект в качестве результата своего выполнения.
  public static Task updateTask(Task task, String newDescription) {
    task.setDescription(newDescription);
    return task;
  }

  // Метод принимает на вход значение newDescription, и устанавливает его как значение поля description,
  // у всех элементов коллекции.
  public static void updateAllTasks(String newDescription) {
    tasks.keySet().forEach(k -> tasks.get(k).setDescription(newDescription));
  }
}
