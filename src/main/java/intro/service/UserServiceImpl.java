package intro.service;

import intro.dao.UserDao;
import intro.model.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        userDao.add(user);
    }

    public List<User> listUsers() {
        return userDao.getAll();
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
