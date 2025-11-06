package todo.com.example.todo.Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import todo.com.example.todo.Classes.Exceptions.InvalidValueException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User validUser;

    @Test
    @DisplayName("It should be able to create a new user")
    void shouldCreateUser() {
        User newUser = new User("username", "1234");

        assertNotNull(newUser);
        assertEquals("username", newUser.getUsername());
        assertEquals("1234", newUser.getPassword());
    }


    @Test
    @DisplayName("It should not be able to create a user without a username")
    void shouldNotCreateUsernamelessUser() {
        assertThrows(InvalidValueException.class, () -> {
            new User("", "1234");
        });
    }

    @Test
    @DisplayName("It should not be able to create a user with a password too small")
    void shouldNotCreateUserWithSmallPassword() {
        assertThrows(InvalidValueException.class, () -> {
            new User("username", "123");
        });
    }

    @BeforeEach
    void setup() {
        this.validUser = new User("username", "1234");
    }

    @Test
    @DisplayName("It should be able to change username")
    void changeUsername() {
        validUser.changeUsername("newUsername");
        assertEquals("newUsername", validUser.getUsername());
    }

    @Test
    @DisplayName("It should be able to change password")
    void changePassword() {
        validUser.changePassword("newPassword");
        assertEquals("newPassword", validUser.getPassword());
    }
}