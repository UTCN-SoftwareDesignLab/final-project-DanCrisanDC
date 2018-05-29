package moviesApp.service;

import moviesApp.dto.UserDto;
import moviesApp.model.Role;
import moviesApp.model.User;
import moviesApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean create(UserDto userDto, boolean key) {

        User user;

        if(key) {
            user = new User(userDto.getName(), userDto.getUsername(), encoder.encode(userDto.getPassword()), Role.CRITIC);
        } else {
            user = new User(userDto.getName(), userDto.getUsername(), encoder.encode(userDto.getPassword()), Role.USER);
        }
        userRepository.save(user);
        return userRepository.findById(user.getId()).isPresent();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, encoder.encode(password));
    }

    @Override
    public boolean findById(int id) {
        return userRepository.findById(id).isPresent();
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
