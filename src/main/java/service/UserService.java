package service;

import persistent.pojo.User;

/**
 * 用户服务接口
 */
public interface UserService {

    User login(User user);

    String register(User user);

}
