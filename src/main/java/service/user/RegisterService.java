package service.user;

import persistent.impl.UserImpl;
import persistent.pojo.user.User;

public class RegisterService extends UserService {

    public RegisterService() {
    }

    public int register(User user) {
        UserImpl impl = new UserImpl();
        int ret = -1;
        if ((!isLegal(user))
                || isExist(user))
            return ret;
        ret = impl.insertUser(user);
        return ret;
    }



}
