package todo.com.example.todo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.com.example.todo.Entities.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity, String> {
}
