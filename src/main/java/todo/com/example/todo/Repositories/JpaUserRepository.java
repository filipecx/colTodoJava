package todo.com.example.todo.Repositories;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.com.example.todo.Classes.User;

public interface JpaUserRepository extends JpaRepository<User, String> {
}
