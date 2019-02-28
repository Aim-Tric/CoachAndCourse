package service;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import persistent.mapper.UserMapper;
import utils.MybatisUtils;
import utils.Utils;
import utils.data.Consts;
import persistent.pojo.User;

import java.util.Map;

public class UserService {

    private SqlSession session;

    /**
     * 完成登录操作
     *
     * @param json 包含表单数据的json
     */
    public String login(String json) {
        // 验证是用户名登录还是邮箱登录
        // 如果他是用email登录，才改变用户名为email
        session = MybatisUtils.getFactory().openSession();
        json = changeToEmail(json);
        User user = JSON.parseObject(json, User.class);
        String ret = verify(user);
        session.close();
        return ret;
    }

    /**
     * 进行用户注册操作
     *
     * @param user 用户注册的表单数据所构成的javabean对象
     * @return 返回注册结果，如果注册成功则返回ok，否则就是failed
     */
    public String register(User user) {
        session = MybatisUtils.getFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        String ret = Consts.RESULT_FAILED;
        if ((!isLegal(user))
                || isExist(user))
            return ret;
        ret = Utils.getResult(mapper.insertUser(user));
        session.close();
        return ret;
    }

    public User findUser(User user) {
        session = MybatisUtils.getFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = mapper.findUser(user);
        session.close();
        return u;
    }

    /**
     * 验证传入的user数据是否对应
     * 这里用了DataTransferer来作数据传输，不知道直接返回值传参还是用第三方传输好
     * @param user 需要验证的用户数据
     * @return 返回验证结果，用户不存在则返回操作取消，存在则返回验证结果
     */
    private String verify(User user) {
        String ret;
        UserMapper impl = session.getMapper(UserMapper.class);
        user = impl.findUser(user);
        if (user != null) {
            ret = Consts.RESULT_OK;
        }else{
            ret = Consts.RESULT_FAILED;
        }
        return ret;
    }

    /**
     * 检验用户是用户名登录还是邮箱登录
     * @param json <@link>String</@link> 如果username传过来是email，则设置username这个key变成email
     * @return map
     */
    private String changeToEmail(String json) {
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
     * 用户是否存在
     *
     * @param user 用户的部分数据
     * @return 存在就真，否则就假
     */
    private boolean isExist(User user) {
        UserMapper impl = session.getMapper(UserMapper.class);
        User u = new User();
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        return impl.findUser(u) == null;
    }

    /**
     * 判断用户名的合法性
     * @param user 用户数据
     * @return 存在非法字符则返回false
     */
    private boolean isLegal(User user) {
        return !java.util.regex.Pattern.matches(user.getUsername(), Consts.REGEX_ILLEGAL);
    }

}
