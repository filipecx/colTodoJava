package todo.com.example.todo.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.com.example.todo.Dtos.Task.TaskCreateDTO;
import todo.com.example.todo.Dtos.Task.TaskResponseDTO;
import todo.com.example.todo.Dtos.Task.TaskUpdateDTO;
import todo.com.example.todo.Entities.TaskEntity;
import todo.com.example.todo.Repositories.JpaTaskRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
public class TaskController {

    private final JpaTaskRepository repository;
    public TaskController(JpaTaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskCreateDTO taskCreateDTO){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(taskCreateDTO.title());
        taskEntity.setCompleted(false);
        taskEntity.setDay(taskCreateDTO.day());
        taskEntity.setUser(taskCreateDTO.user());

        TaskEntity persistedTask = this.repository.save(taskEntity);

        TaskResponseDTO response = new TaskResponseDTO(
                persistedTask.getId(),
                persistedTask.getTitle(),
                persistedTask.getCompleted(),
                persistedTask.getDay(),
                persistedTask.getUser()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        List<TaskEntity> list = this.repository.findAll();

        List<TaskResponseDTO> responseDTOS = list.stream().map(task -> {
            return new TaskResponseDTO(
                    task.getId(),
                    task.getTitle(),
                    task.getCompleted(),
                    task.getDay(),
                    task.getUser()
            );
        }).toList();

        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTask(@PathVariable String id) {
        Optional<TaskEntity> taskEntity = this.repository.findById(id);

        if (taskEntity.isEmpty()) {
            throw new RuntimeException("Nenhuma task encontrada");
        }

        TaskResponseDTO taskResponseDTO = new TaskResponseDTO(
                taskEntity.get().getId(),
                taskEntity.get().getTitle(),
                taskEntity.get().getCompleted(),
                taskEntity.get().getDay(),
                taskEntity.get().getUser()
        );

        return ResponseEntity.status(HttpStatus.OK).body(taskResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable String id, @RequestBody TaskUpdateDTO taskUpdateDTO) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(id);
        taskEntity.setTitle(taskUpdateDTO.title());
        taskEntity.setDay(taskUpdateDTO.day());
        taskEntity.setCompleted(taskUpdateDTO.completed());
        taskEntity.setUser(taskUpdateDTO.user());

        TaskEntity persistedTask = this.repository.save(taskEntity);

        TaskResponseDTO responseDTO = new TaskResponseDTO(
                persistedTask.getId(),
                persistedTask.getTitle(),
                persistedTask.getCompleted(),
                persistedTask.getDay(),
                persistedTask.getUser()
        );

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        this.repository.deleteById(id);

    }
}
