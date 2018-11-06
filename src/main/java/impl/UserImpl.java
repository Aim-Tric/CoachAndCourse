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
    public User findUserById(int id) {
        try{
            session = factory.openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            user = mapper.findUserById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    @Override
    public User findUserByName(String name) {
        try{
            session = factory.openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            user = mapper.findUserByName(name);
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

    public static void main(String[] args) {
        UserImpl impl = new UserImpl();
        impl.insertUser(new User(7, "BK", "女", "shasdf"));
        User user = impl.findUserById(7);
        System.out.println(user.toString());
    }

}
