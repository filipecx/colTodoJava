package todo.com.example.todo.Dtos.User;

import todo.com.example.todo.Classes.Groups;
import todo.com.example.todo.Entities.GroupEntity;

import java.util.List;

public record UserUpdateDTO(
        String id,
        String username,
        String password,
        List<GroupEntity> groups
) {
}
