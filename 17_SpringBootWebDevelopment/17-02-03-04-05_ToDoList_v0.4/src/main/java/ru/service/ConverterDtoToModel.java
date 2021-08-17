package ru.service;

import ru.dto.TaskRequestDTO;
import ru.model.Task;

public class ConverterDtoToModel {

  public static Task convertDtoToModel(TaskRequestDTO taskRequestDTO) {
    return Task.builder()
        .name(taskRequestDTO.getName())
        .description(taskRequestDTO.getDescription())
        .build();
  }
}
