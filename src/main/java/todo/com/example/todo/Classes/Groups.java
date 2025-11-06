package todo.com.example.todo.Classes;

import java.util.List;

public class Groups {
    private String id;
    private List<User> users;
    private List<Task> tasks;

    public Groups(){}

    public String getId() {
        return this.id;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void changeUsers(List<User> users) {
        this.users = users;
    }

    public void changeTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
