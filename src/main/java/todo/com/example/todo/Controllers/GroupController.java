package todo.com.example.todo.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.com.example.todo.Dtos.Group.GroupCreateDTO;
import todo.com.example.todo.Dtos.Group.GroupResponseDTO;
import todo.com.example.todo.Dtos.Group.GroupUpdateDTO;
import todo.com.example.todo.Entities.GroupEntity;
import todo.com.example.todo.Repositories.GroupRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupRepository repository;

    public GroupController(GroupRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<GroupResponseDTO> createGroup(@RequestBody GroupCreateDTO groupCreateDTO) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setName(groupCreateDTO.name());

        GroupEntity persistedUser = this.repository.save(groupEntity);

        GroupResponseDTO response = new GroupResponseDTO(
                persistedUser.getId(),
                persistedUser.getName(),
                persistedUser.getUsers(),
                persistedUser.getTasks()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<GroupResponseDTO>> getAllGroups() {
        List<GroupEntity> groupEntities = this.repository.findAll();
        List<GroupResponseDTO> groupResponseDTOS = groupEntities.stream().map(group -> {
            return new GroupResponseDTO(group.getId(), group.getName(), group.getUsers(), group.getTasks());
        }).toList();

        return ResponseEntity.status(HttpStatus.OK).body(groupResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupResponseDTO> getGroup(@PathVariable String id) {
        Optional<GroupEntity> group = this.repository.findById(id);

        if (group.isEmpty()) {
            throw new RuntimeException("Nenhum grupo encontrado");
        }

        GroupResponseDTO response = new GroupResponseDTO(
                group.get().getId(),
                group.get().getName(),
                group.get().getUsers(),
                group.get().getTasks()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupEntity> updateGroup(@PathVariable String id, @RequestBody GroupUpdateDTO groupUpdateDTO) {
        GroupEntity groupEntity = new GroupEntity(id, groupUpdateDTO.name(), groupUpdateDTO.users(), groupUpdateDTO.tasks());

        GroupEntity updatedGroup = this.repository.save(groupEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(updatedGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable String id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
