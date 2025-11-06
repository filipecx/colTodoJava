package todo.com.example.todo.Classes;

import java.util.List;

public class Groups {
    private String id;
    private String name;
    private List<User> users;
    private List<Task> tasks;

    public Groups(){}

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
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

    public void changeName(String newName) {
        this.name = newName;
    }
}
