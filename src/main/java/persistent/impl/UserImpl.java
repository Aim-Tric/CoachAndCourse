package persistent.impl;

import org.apache.ibatis.session.SqlSession;
import persistent.dao.UserDAO;
import persistent.impl.pub.BaseImpl;
import persistent.impl.utils.SessionFactory;
import persistent.pojo.user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserImpl implements UserDAO {
    private SqlSession session = null;

    @Override
    public List<User> findUsers(User user, int start, int maxLimit) {
        List<User> users = new ArrayList<User>();
        try {
            session = SessionFactory.getFactory().openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            users = mapper.findUsers(user, start, maxLimit);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public User findUser(User u) {
        User user = null;
        try {
            session = SessionFactory.getFactory().openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            user = mapper.findUser(u);
        }  catch (Exception e) {
          //  BaseImpl.catchCommunicationsException(e);
           // BaseImpl.catchNullPointerException(e);
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public int insertUser(User user) {
        int ret = -1;
        try {
            session = SessionFactory.getFactory().openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            ret = mapper.insertUser(user);
            session.commit();
        } catch (Exception e) {
            BaseImpl.catchCommunicationsException(e);
        } finally {
            session.close();
        }
        return ret;
    }

    public User findUserByEmail(String email) {
        User user = null;
        try {
            session = SessionFactory.getFactory().openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            user = mapper.findUserByEmail(email);
        } catch (Exception e) {
            BaseImpl.catchCommunicationsException(e);
        } finally {
            session.close();
        }
        return user;
    }

//    public static void main(String[] args) {
//        UserImpl imp = new UserImpl();
//        User u = new User();
//        u.setUsername("shadiao");
//        u.setEmail("123123@qq.com");
//        u.setNickname("hamapi");
//        u.setPassword("hello");
//        imp.insertUser(u);
//        System.out.println(imp.findUser(u).toString());
//    }

}
