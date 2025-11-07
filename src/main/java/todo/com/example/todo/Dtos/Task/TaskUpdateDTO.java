package todo.com.example.todo.Dtos.Task;

import todo.com.example.todo.Classes.Enums.Days;
import todo.com.example.todo.Entities.UserEntity;

public record TaskUpdateDTO(
        String title,
        Days day,
        Boolean completed,
        UserEntity user
) {
}
