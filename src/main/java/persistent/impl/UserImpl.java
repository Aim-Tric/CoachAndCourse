package persistent.impl;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import commons.data.Consts;
import org.apache.ibatis.session.SqlSession;
import persistent.dao.user.UserDAO;
import persistent.impl.util.SessionFactory;
import persistent.pojo.user.User;

import java.io.IOException;
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            catchCommunicationsException(e);
        } finally {
            session.close();
        }
        return user;
    }

    private boolean catchCommunicationsException(Exception e) {
        return e instanceof CommunicationsException;
    }

    @Override
    public String insertUser(User user) {
        try {
            session = SessionFactory.getFactory().openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            mapper.insertUser(user);
            session.commit();
        } catch (Exception e) {
            if (catchCommunicationsException(e))
                return Consts.RESULT_CANCEL;
        } finally {
            session.close();
        }
        return Consts.RESULT_OK;
    }

//    public static void main(String[] args) {
//        UserImpl imp = new UserImpl();
//        user u = new user();
//        u.setUsername("zhaoliu");
//        System.out.println(imp.findUser(u).toString());
//    }

}
