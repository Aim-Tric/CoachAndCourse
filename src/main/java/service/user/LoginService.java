package service.user;

import commons.data.Consts;
import org.mortbay.util.ajax.JSON;
import persistent.impl.UserImpl;
import persistent.pojo.user.User;
import service.pub.BaseService;

import java.util.Map;

public class LoginService extends BaseService {

    public LoginService() {
    }

    /**
     * 在数据库验证从前端拿到的用户和密码是否正确
     *
     * @param json <@link>String</@link> 如果username传过来是email，则设置username这个key变成email
     * @return
     */
    public static String ifIsEmail(String json) {
        Map<String, String> map = (Map) JSON.parse(json);
        boolean isMail = map.get("username").matches(Consts.REGEX_MAIL);
        if (!isMail)
            return json;
        // 如果是请求登录用的是邮箱地址，则设置为邮箱来查询数据库
        String email = map.get("username");
        map.remove("username");
        map.put("email", email);
        return map.toString();
    }

    public static String verify(User user) {
        String ret = Consts.RESULT_FAILED;
        UserImpl impl = new UserImpl();
        try {
            User u = impl.findUser(user);
            if (u != null) {
                ret = Consts.RESULT_OK;
            }
        } catch (NullPointerException npe) {
            // 用户不存在
            ret = Consts.RESULT_CANCEL;
        }

        return ret;
    }

    public static User findUser(User user) {
        return new UserImpl().findUser(user);
    }

//    public static void main(String[] args) {
//        String json = "{\"username\" : \"231235@126.com\", \"password\": \"223344\"}";
//        System.out.println("json = " + json);
//        ifIsEmail(json);
//    }
}
