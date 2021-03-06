package intro.service;

import intro.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getById(Long id);
}
