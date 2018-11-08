package dao.user;

import pojo.user.User;

import java.util.List;

public interface UserDAO {

    List<User> findUsers();

    User findUser(User user);

    void insertUser(User user);

}
