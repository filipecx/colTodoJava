package todo.com.example.todo.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.com.example.todo.Dtos.User.UserCreateDTO;
import todo.com.example.todo.Dtos.User.UserResponseDTO;
import todo.com.example.todo.Dtos.User.UserUpdateDTO;
import todo.com.example.todo.Entities.GroupEntity;
import todo.com.example.todo.Entities.UserEntity;
import todo.com.example.todo.Repositories.JpaUserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final JpaUserRepository repository;

    public UserController(JpaUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserEntity> userEntityList = this.repository.findAll();
        List<UserResponseDTO> responseDTOS = userEntityList.stream().map(user -> {
            return new UserResponseDTO(user.getId(), user.getUsername(), user.getGroupsIds());
        }).toList();

        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable String id) {
        Optional<UserEntity> user = this.repository.findById(id);
        if (user.isPresent()) {
            UserResponseDTO userResponseDTO = new UserResponseDTO(
                    user.get().getId(),
                    user.get().getUsername(),
                    user.get().getGroupsIds()
            );

            return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
        }

        return ResponseEntity.notFound().build();


    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO newUser) {
        UserEntity user = new UserEntity();
        user.setUsername(newUser.username());
        user.setPassword(newUser.password());

        UserEntity persistedUser = this.repository.save(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                persistedUser.getGroupsIds()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable String id, @RequestBody UserUpdateDTO userUpdateDTO) {
       List<GroupEntity> groups = userUpdateDTO.groups().stream().map(group -> {
           return new GroupEntity(
                   group.getId(),
                   group.getName(),
                   group.getUsers(),
                   group.getTasks()
           );
       }).toList();




        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userUpdateDTO.username());
        userEntity.setPassword(userUpdateDTO.password());
        userEntity.setGroupsIds(groups);

        UserEntity persistedUser = this.repository.save(userEntity);

        UserResponseDTO responseDTO = new UserResponseDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                persistedUser.getGroupsIds()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        this.repository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário removido");
    }


}
