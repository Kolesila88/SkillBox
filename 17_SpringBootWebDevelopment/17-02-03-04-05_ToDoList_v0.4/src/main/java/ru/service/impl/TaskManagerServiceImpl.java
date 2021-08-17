package ru.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.model.Task;
import ru.repository.TaskRepository;
import ru.service.TaskManagerService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskManagerServiceImpl implements TaskManagerService {

  private final TaskRepository taskRepository;

  @Override
  public void addTask(Task task) {

    taskRepository.save(task);
  }

  @Override
  public Optional<Task> getTask(Long id) {
    Optional<Task> optionalTask = taskRepository.findById(id);
    return optionalTask;
  }

  @Override
  public List<Task> getTasks() {
    return taskRepository.findAll();
  }

  @Override
  public boolean updateTask(Long id, String newDescription) {

    if (!taskRepository.findById(id).isPresent()) {
      return false;
    }
    Task updatingTask = taskRepository.findById(id).get();
    updatingTask.setDescription(newDescription);
    taskRepository.save(updatingTask);
    return true;

  }

  @Override
  public boolean removeTask(Long id) {

    if (taskRepository.findById(id).isPresent()) {
      taskRepository.delete(taskRepository.findById(id).get());
      return true;
    } else {
      return false;
    }
  }
}
