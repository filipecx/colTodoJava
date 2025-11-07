package todo.com.example.todo.Dtos.Task;

import todo.com.example.todo.Classes.Enums.Days;
import todo.com.example.todo.Entities.UserEntity;

public record TaskCreateDTO(
        String title,
        Days day,
        UserEntity user
) {
}
