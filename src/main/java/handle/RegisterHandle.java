package handle;

import data.Consts;
import impl.UserImpl;
import pojo.User;

public class RegisterHandle {
    private UserImpl impl;

    public RegisterHandle(){
        impl = new UserImpl();
    }

    public boolean register(User user){
        String userName = user.getUsername();
        if((!isLegal(userName))
                || isExist(userName))
            return false;
        impl.insertUser(user);
        return true;
    }

    private boolean isLegal(String str){
        return !java.util.regex.Pattern.matches(str, Consts.illegalStr);
    }

    private boolean isExist(String str){
        if(impl.findUserByUserName(str) == null)
            return false;
        return true;
    }

}
