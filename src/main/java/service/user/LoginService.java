package service.user;

import persistent.impl.UserImpl;
import persistent.pojo.user.User;


public class LoginService {

    public LoginService() {
    }

    /**
     * 在数据库验证从前端拿到的用户和密码是否正确
     *
     * @param user
     * @return
     */
    public boolean verify(User user) {
        boolean ret = false;
        UserImpl impl = new UserImpl();
        try {
            User u = impl.findUser(user);
            if (u != null) {
                ret = true;
            }
        } catch (NullPointerException npe) {
            // TODO: 用户不存在
        }
        return ret;
    }

}
