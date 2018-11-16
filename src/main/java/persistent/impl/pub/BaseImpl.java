package persistent.impl.pub;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class BaseImpl {

    public static void catchNullPointerException(Exception e) {
        if (e instanceof NullPointerException)
            System.out.println("空指针异常");
    }

    public static void catchCommunicationsException(Exception e) {
        if (e instanceof CommunicationsException)
            System.out.println("无法连接到数据库");
    }
}
