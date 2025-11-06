package todo.com.example.todo.Classes.Exceptions;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException(String message) {
        super(message);
    }
}
