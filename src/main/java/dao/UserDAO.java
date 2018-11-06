package dao;

import pojo.User;

public interface UserDAO {

    User findUserByUserName(String userName);

    User findUserByEmail(String email);

    void insertUser(User user);

}
