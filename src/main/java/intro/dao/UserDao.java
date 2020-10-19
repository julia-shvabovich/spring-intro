package intro.dao;

import intro.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAll();

}
