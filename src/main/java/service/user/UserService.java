package service.user;

import commons.data.Consts;
import persistent.impl.UserImpl;
import persistent.pojo.user.User;

public class UserService {

    public static User findUser(User user) {
        return new UserImpl().findUser(user);
    }

    /**
     * 用户是否存在
     *
     * @param user 用户的部分数据
     * @return 存在就真，否则就假
     */
    protected boolean isExist(User user) {
        UserImpl impl = new UserImpl();
        User u = new User();
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        if (impl.findUser(u) == null)
            return false;
        return true;
    }

    /**
     * 判断用户名的合法性
     * @param user 用户数据
     * @return 存在非法字符则返回false
     */
    protected boolean isLegal(User user) {
        return !java.util.regex.Pattern.matches(user.getUsername(), Consts.REGEX_ILLEGAL);
    }
}
