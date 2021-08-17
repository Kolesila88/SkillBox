package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
