package persistent.dao.user;

import persistent.pojo.user.User;

import java.util.List;

public interface UserDAO {

    List<User> findUsers();

    User findUser(User user);

    String insertUser(User user);

}
