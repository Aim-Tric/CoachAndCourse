package persistent.mapper;

import persistent.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> findUsers(User user, int start, int maxLimit);

    User findUser(User user);

    int insertUser(User user);

    User findUserByEmail(String email);

}
