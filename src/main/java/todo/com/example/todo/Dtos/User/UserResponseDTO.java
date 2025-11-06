package todo.com.example.todo.Dtos.User;

import todo.com.example.todo.Entities.GroupEntity;

import java.util.List;

public record UserResponseDTO(
        String id,
        String username,
        List<GroupEntity> groups
) {
}
