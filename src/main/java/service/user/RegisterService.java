package service.user;

import com.sun.istack.internal.NotNull;
import commons.data.Consts;
import persistent.impl.UserImpl;
import persistent.pojo.user.User;
import service.pub.BaseService;

public class RegisterService extends BaseService {

    public RegisterService() {
    }

    public String register(User user) {
        UserImpl impl = new UserImpl();
        if ((!isLegal(user))
                || isExist(user))
            return Consts.RESULT_FAILED;
        return impl.insertUser(user);
    }



}
