package todo.com.example.todo.Classes;

import todo.com.example.todo.Classes.Enums.Days;

public class Task {
    private String id;
    private String title;
    private Days day;
    private Boolean completed;
    private final User user;


    public Task(String title, Days day, Boolean completed, User user) {
        this.title = title;
        this.day = day;
        this.completed = completed;
        this.user = user;

    }

    public Task(String id, String title, Days day, Boolean completed, User user) {
        this.id = id;
        this.title = title;
        this.day = day;
        this.completed = completed;
        this.user = user;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Days getDay() {
        return this.day;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    public User getUser() {
        return this.user;
    }

    public void changeTitle(String newTitle) {
        this.title = newTitle;
    }

    public void changeDay(Days newDay) {
        this.day = newDay;
    }

    public Boolean changeCompleted() {
        this.completed = !completed;
        return this.completed;
    }
}
