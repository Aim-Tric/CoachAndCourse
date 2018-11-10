package persistent.impl;

import persistent.dao.user.UserDAO;
import persistent.impl.util.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import persistent.pojo.user.User;

import java.util.ArrayList;
import java.util.List;


public class UserImpl implements UserDAO {
    private SqlSession session = null;

    @Override
    public List<User> findUsers() {
        List<User> users = new ArrayList<>();
        try {
            session = SessionFactory.getFactory().openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            users = mapper.findUsers();
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public void insertUser(User user) {
        try {
            session = SessionFactory.getFactory().openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            mapper.insertUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//    public static void main(String[] args) {
//        UserImpl imp = new UserImpl();
//        User u = new User();
//        u.setUsername("zhaoliu");
//        System.out.println(imp.findUser(u).toString());
//    }

}
