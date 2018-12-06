package service.user;

import com.alibaba.fastjson.JSON;
import commons.data.Consts;
import persistent.impl.UserImpl;
import persistent.pojo.user.User;

import java.util.Map;

public class LoginService extends UserService {

    public LoginService() {
    }

    /**
     * 完成登录操作
     *
     * @param json 包含表单数据的json
     */
    public static String login(String json) {
        // 验证是用户名登录还是邮箱登录
        // 如果他是用email登录，才改变用户名为email
        json = LoginService.changeToEmail(json);
        User user = JSON.parseObject(json, User.class);
        return verify(user);
    }

    /**
     * 检验用户是用户名登录还是邮箱登录
     * @param json <@link>String</@link> 如果username传过来是email，则设置username这个key变成email
     * @return
     */
    public static String changeToEmail(String json) {
        Map<String, String> map = (Map<String, String>) JSON.parse(json);
        String username = map.get("username");
        boolean isMail = username.matches(Consts.REGEX_MAIL);

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
     * 这里用了DataTransferer来作数据传输，不知道直接返回值传参还是用第三方传输好
     * @param user 需要验证的用户数据
     * @return 返回验证结果，用户不存在则返回操作取消，存在则返回验证结果
     */
    public static String verify(User user) {
        String ret = Consts.RESULT_FAILED;
        UserImpl impl = new UserImpl();
        try {
            user = impl.findUser(user);
            if (user != null) {
                ret = Consts.RESULT_OK;
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
