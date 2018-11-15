package service.user;

import commons.Utils;
import persistent.impl.UserImpl;
import persistent.pojo.user.User;
import service.pub.BaseService;

public class RegisterService extends BaseService {

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
