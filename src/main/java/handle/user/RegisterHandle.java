package handle.user;

import data.Consts;
import impl.UserImpl;
import pojo.user.User;

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
        User user = new User();
        user.setUsername(str);

        if(impl.findUser(user) == null)
            return false;
        return true;
    }

}
