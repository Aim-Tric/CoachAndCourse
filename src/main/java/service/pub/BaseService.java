package service.pub;

import commons.data.Consts;
import net.sf.json.JSONObject;
import persistent.impl.UserImpl;
import persistent.pojo.user.User;

public class BaseService {
    public static Object getBeanFromJson(String param, Class tmp) {
        JSONObject json = JSONObject.fromObject(param);
        return JSONObject.toBean(json, tmp);
    }

    public static User findUser(User user) {
        return new UserImpl().findUser(user);
    }

    protected boolean isLegal(User user) {
        return !java.util.regex.Pattern.matches(user.getUsername(), Consts.REGEX_ILLEGAL);
    }

    protected boolean isExist(User user) {
        UserImpl impl = new UserImpl();
        User u = new User();
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        if (impl.findUser(u) == null)
            return false;
        return true;
    }

}
