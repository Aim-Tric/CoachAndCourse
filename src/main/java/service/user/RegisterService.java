package service.user;

import commons.data.Consts;
import persistent.impl.UserImpl;
import persistent.pojo.user.User;

public class RegisterService {
    private UserImpl impl;

    public RegisterService() {
    }

    public boolean register(User user){
        impl = new UserImpl();
        if ((!isLegal(user))
                || isExist(user))
            return false;
        impl.insertUser(user);
        return true;
    }

    private boolean isLegal(User user) {
        return !java.util.regex.Pattern.matches(user.getUsername(), Consts.REGEX_ILLEGAL);
    }

    private boolean isExist(User user) {
        User u = new User();
        u.setUsername(user.getUsername());
        if (impl.findUser(u) == null)
            return false;
        return true;
    }


}
