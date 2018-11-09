package handle.user;

import data.Consts;
import impl.UserImpl;
import pojo.user.User;


public class LoginHandle {

    public LoginHandle() {
    }

    public boolean confirm(User user) {
        UserImpl impl = new UserImpl();
        try{
            User u = impl.findUser(user);
            if (u == null) {
                return false;
            }
        }catch (NullPointerException npe){
            return false;
        }
        return true;
    }

//    public static void main(String[] args) {
//        LoginHandle l = new LoginHandle();
//        l.getUser("1231231");
//    }
}
