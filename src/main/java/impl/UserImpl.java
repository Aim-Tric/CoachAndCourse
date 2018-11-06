package impl;

import dao.UserDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import java.io.InputStream;

public class UserImpl implements UserDAO {

    @Override
    public User selectUser(int id) {
        SqlSession session = null;
        User user = null;
        try{
            InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
            session = factory.openSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            user = mapper.selectUser(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    public static void main(String[] args) {
        UserImpl imp = new UserImpl();
        User user = imp.selectUser(1);
        System.out.println(user.toString());
    }
}
