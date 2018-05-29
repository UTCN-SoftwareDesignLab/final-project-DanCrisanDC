package moviesApp.service;

import moviesApp.dto.UserDto;
import moviesApp.model.User;

import java.util.List;

public interface UserService {

    boolean create(UserDto userDto, boolean key);

    List<User> getAll();

    User findByUsernameAndPassword(String username, String password);

    boolean findById(int id);

    User findByName(String name);

    User findByUsername(String username);
}
