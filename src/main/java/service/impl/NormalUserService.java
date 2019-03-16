package service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import persistent.mapper.UserMapper;
import persistent.pojo.User;
import service.UserService;
import utils.MybatisUtils;
import utils.Utils;
import utils.data.Consts;

public class NormalUserService implements UserService {
    @Override
    public User login(User user) {
        SqlSession session = MybatisUtils.getFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        user = mapper.findUser(user);
        session.close();
        return user;
    }

    @Override
    public String register(User user) {
        SqlSession session = MybatisUtils.getFactory().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        String ret = Consts.RESULT_OK;
        mapper.insertUser(user);
        session.commit();
        mapper.findUser(user);
        session.close();
        if(user == null) {
            ret = Consts.RESULT_FAILED;
        }
        return ret;
    }
}
