package moviesApp.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {

    public int id;
    @Size(min = 1, message = "Please type in your name")
    public String name;
    @Size(min = 6, message = "Username must be at least 6 characters long")
    public String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9@$!%*#?&]+$", message = "Password must contain at least 1 letter, 1 number, and 1 special character")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    public String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
