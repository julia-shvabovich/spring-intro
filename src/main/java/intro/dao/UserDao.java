package intro.dao;

import intro.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    void add(User user);

    List<User> getAll();

    Optional<User> getById(Long id);
}
