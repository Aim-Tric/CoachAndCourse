package handle;

import data.Consts;
import impl.UserImpl;
import pojo.User;


public class LoginHandle {

    public LoginHandle() {
    }

    public boolean confirm(String account, String password) {

        User user = getUser(account);
        try{
            if (!password.equals(user.getPassword())) {
                return false;
            }
        }catch (NullPointerException npe){
            return false;
        }
        return true;
    }

    private User getUser(String account) {
        UserImpl impl = new UserImpl();
        boolean isMail = java.util.regex.Pattern.matches(account, Consts.mailStr);
        if (isMail) {
            return impl.findUserByEmail(account);
        } else {
            return impl.findUserByUserName(account);
        }
    }

//    public static void main(String[] args) {
//        LoginHandle l = new LoginHandle();
//        l.getUser("1231231");
//    }
}
