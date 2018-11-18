package persistent.dao;

import persistent.pojo.user.User;

import java.util.List;

public interface UserDAO {

    List<User> findUsers(User user, int start, int maxLimit);

    User findUser(User user);

    int insertUser(User user);

}
