package handle;

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
        String mailRex = "[\\w!#$%&'*+/=?^_`{|}~-]+" +
                "(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@" +
                "(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w]" +
                "(?:[\\w-]*[\\w])?";
        boolean isMail = java.util.regex.Pattern.matches(account, mailRex);
        if (isMail) {
            return impl.findUserByEmail(account);
        } else {
            return impl.findUserByUserName(account);
        }

    }
}
