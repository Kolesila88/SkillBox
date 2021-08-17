package ru.service;

import ru.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskManagerService {

  void addTask(Task task);

  Optional getTask(Long id);

  List<Task> getTasks();

  boolean updateTask(Long id, String newDescription);

  boolean removeTask(Long id);
}
