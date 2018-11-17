package service.user;

import commons.data.Consts;
import persistent.impl.UserImpl;
import persistent.pojo.user.User;

public class UserService {

    public static User findUser(User user) {
        return new UserImpl().findUser(user);
    }

    protected boolean isExist(User user) {
        UserImpl impl = new UserImpl();
        User u = new User();
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        if (impl.findUser(u) == null)
            return false;
        return true;
    }

    protected boolean isLegal(User user) {
        return !java.util.regex.Pattern.matches(user.getUsername(), Consts.REGEX_ILLEGAL);
    }
}
