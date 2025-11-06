package todo.com.example.todo.Dtos.Group;

import todo.com.example.todo.Entities.TaskEntity;
import todo.com.example.todo.Entities.UserEntity;

import java.util.List;

public record GroupUpdateDTO(String id,
                             String name,
                             List<UserEntity> users,
                             List<TaskEntity> tasks) {
}
