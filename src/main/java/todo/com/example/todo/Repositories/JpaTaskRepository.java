package todo.com.example.todo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.com.example.todo.Entities.TaskEntity;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, String> {
}
