package moviesApp.repository;

import moviesApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);

    User findByName(String name);

    User findByUsername(String username);
}
