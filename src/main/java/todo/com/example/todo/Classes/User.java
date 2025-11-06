package todo.com.example.todo.Classes;

import todo.com.example.todo.Classes.Exceptions.InvalidValueException;

import java.util.List;

public class User {
    private String id;
    private String username;
    private String password;
    private List<Groups> groups;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String id, String username, String password, List<Groups> groups) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.groups = groups;
    }

    public String getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Groups> getGroups() {
        return this.groups;
    }


    private void validateUsername(String username) {
        if (username.isBlank()) {
            throw new InvalidValueException("Você deve inserir um username");
        }
    }

    private void validatePassword(String password) {
        if (password.length() < 4) {
            throw new InvalidValueException("A senha deve ter pelo menos quatro caracteres");
        }
    }
    public void changeUsername(String newUsername) {
        validateUsername(newUsername);
        this.username = newUsername;
    }

    public void changePassword(String newPassword) {
        validatePassword(newPassword);
        this.password = newPassword;
    }

    public void changeGroups(List<Groups> newGroups) {
        this.groups = newGroups;
    }

}
