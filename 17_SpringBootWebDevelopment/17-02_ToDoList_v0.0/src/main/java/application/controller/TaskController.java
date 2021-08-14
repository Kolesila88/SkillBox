package application.controller;

import application.model.Task;
import application.storage.Storage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

  //Реализация метода Get, возвращает список уже объектов.
  @GetMapping("/tasks/")
  public List<Task> list() {
    return Storage.getAllTasks();
  }

  //Реализация метода Get, возвращает определенный объект соответствующий ключу(id),
  // или 404 ошибку(если объекта с указанным id не существует)
  @GetMapping("/tasks/{id}")
  public ResponseEntity get(@PathVariable int id) {
    Task task = Storage.getTask(id);
    if (task == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return new ResponseEntity(task, HttpStatus.OK);
  }

  // Реализация метода Post, создает новый объект и добавляет его в хранилище.
  @PostMapping("/tasks/")
  public int add(Task task) {
    return Storage.addTask(task);
  }

  //Реализация метода Delete, удаляет все объекты из хранилища.
  @DeleteMapping("/tasks/")
  public List<Task> clearTasks() {
    Storage.clearTasks();
    return Storage.getAllTasks();
  }

  //Реализация метода Delete, удаляет объект с указанным id из хранилища,
  //или 404 ошибку(если объекта с указанным id не существует)
  @DeleteMapping("/tasks/{id}")
  public ResponseEntity remove(@PathVariable int id) {
    Task task = Storage.getTask(id);
    if (task == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    Storage.removeTask(id);
    return new ResponseEntity(Storage.getAllTasks(), HttpStatus.OK);
  }

  //Реализация метода Put, обновляет поле Description у существующего объекта(по-указанному id),
  // или 404 ошибку(если объекта с указанным id не существует)
  @PutMapping("/tasks/{id}")
  public ResponseEntity updateTask(@PathVariable int id, Task task) {
    Task updatingTask = Storage.getTask(id);
    if (updatingTask == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    String newDescription = task.getDescription();
    Storage.updateTask(updatingTask, newDescription);
    return new ResponseEntity(updatingTask, HttpStatus.OK);
  }

  //Реализация метода Put, обновляет поле Description у всех объектов в хранилище.
  @PutMapping("/tasks/")
  public List<Task> updateAllTask(Task task) {
    Storage.updateAllTasks(task.getDescription());
    return Storage.getAllTasks();
  }
}
