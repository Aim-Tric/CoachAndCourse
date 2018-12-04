package service.user;

import commons.Utils;
import commons.data.Consts;
import persistent.impl.UserImpl;
import persistent.pojo.user.User;

public class RegisterService extends UserService {

    public RegisterService() {
    }

    /**
     * 进行用户注册操作
     *
     * @param user 用户注册的表单数据所构成的javabean对象
     * @return 返回注册结果，如果注册成功则返回ok，否则就是failed
     */
    public String register(User user) {
        UserImpl impl = new UserImpl();
        String ret = Consts.RESULT_FAILED;
        if ((!isLegal(user))
                || isExist(user))
            return ret;
        ret = Utils.getResult(impl.insertUser(user));
        return ret;
    }



}
