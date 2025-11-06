package todo.com.example.todo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.com.example.todo.Entities.GroupEntity;

public interface GroupRepository extends JpaRepository<GroupEntity, String> {
}
