package service.user;

import commons.data.Consts;
import persistent.impl.UserImpl;
import persistent.pojo.user.User;

public class RegisterService {
    private UserImpl impl;

    public RegisterService(){ }

    public boolean register(User user){
        impl = new UserImpl();
        String userName = user.getUsername();
        if((!isLegal(userName))
                || isExist(userName))
            return false;
        impl.insertUser(user);
        return true;
    }

    private boolean isLegal(String str){
        return !java.util.regex.Pattern.matches(str, Consts.REGEX_ILLEGAL);
    }

    private boolean isExist(String str){
        User user = new User();
        user.setUsername(str);

        if(impl.findUser(user) == null)
            return false;
        return true;
    }

}
