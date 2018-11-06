package dao;

import pojo.User;

public interface UserDAO {

    User findUserById(int id);

    User findUserByName(String name);

    void insertUser(User user);

}
