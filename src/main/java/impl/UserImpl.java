package impl;

import dao.UserDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import java.io.InputStream;

public class UserImpl implements UserDAO {
    SqlSession session = null;
    User user = null;
    InputStream stream = null;
    SqlSessionFactory factory = null;

    public UserImpl(){
        try{
            stream = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(stream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User findUserByUserName(String userName) {
        try{
            session = factory.openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            user = mapper.findUserByUserName(userName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        try{
            session = factory.openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            user = mapper.findUserByEmail(email);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    @Override
    public void insertUser(User user) {
        try{
            session = factory.openSession();
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
//
//    }

}
