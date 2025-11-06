package todo.com.example.todo.Classes;

import todo.com.example.todo.Classes.Enums.Days;

public class Task {
    private String id;
    private String title;
    private Days day;
    private final User user;


    public Task(String title, Days day, User user) {
        this.title = title;
        this.user = user;
        this.day = day;
    }

    public Task(String id, String title, Days day, User user) {
        this.id = id;
        this.title = title;
        this.day = day;
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

    public User getUser() {
        return this.user;
    }

    public void changeTitle(String newTitle) {
        this.title = newTitle;
    }

    public void changeDay(Days newDay) {
        this.day = newDay;
    }
}
