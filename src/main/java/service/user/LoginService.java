package service.user;

import commons.DataTransferer;
import commons.data.Consts;
import org.mortbay.util.ajax.JSON;
import persistent.impl.UserImpl;
import persistent.pojo.user.User;
import service.utils.UtilService;

import java.util.Map;

public class LoginService extends UserService {

    public LoginService() {
    }

    public static void login(String json) {
        // 验证是用户名登录还是邮箱登录
        // 如果他是用email登录，才改变用户名为email
        json = LoginService.changeToEmail(json);
        User user = (User) UtilService.getBeanFromJson(json, User.class);
        DataTransferer.getInstance().put("result", verify(user));
    }

    /**
     * 检验用户是用户名登录还是邮箱登录
     * @param json <@link>String</@link> 如果username传过来是email，则设置username这个key变成email
     * @return
     */
    public static String changeToEmail(String json) {
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

    /**
     * 验证传入的user数据是否对应
     *
     * @param user
     * @return
     */
    public static String verify(User user) {
        String ret = Consts.RESULT_FAILED;
        UserImpl impl = new UserImpl();
        try {
            user = impl.findUser(user);
            if (user != null) {
                ret = Consts.RESULT_OK;
                DataTransferer.getInstance().put("user", user);
            }
        } catch (NullPointerException npe) {
            // 用户不存在
            ret = Consts.RESULT_CANCEL;
        }
        return ret;
    }

//    public static void main(String[] args) {
//        String json = "{\"username\" : \"231235@126.com\", \"password\": \"223344\"}";
//        System.out.println("json = " + json);
//        changeToEmail(json);
//    }
}
