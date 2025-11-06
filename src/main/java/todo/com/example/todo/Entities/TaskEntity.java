package todo.com.example.todo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import todo.com.example.todo.Classes.Enums.Days;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Days day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private GroupEntity group;
}
