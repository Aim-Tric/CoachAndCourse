package impl;

import dao.user.UserDAO;
import impl.util.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import pojo.user.User;

import java.util.ArrayList;
import java.util.List;


public class UserImpl implements UserDAO {
    private SqlSession session = null;
    private User user = null;
    List<User> users = new ArrayList<>();

    @Override
    public List<User> findUsers() {

        return users;
    }

    @Override
    public User findUser(User user) {
        try{
            session = SessionFactory.getFactory().openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            this.user = mapper.findUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return this.user;
    }

    @Override
    public void insertUser(User user) {
        try{
            session = SessionFactory.getFactory().openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            mapper.insertUser(user);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
