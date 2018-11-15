package persistent.impl.pub;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class BaseImpl {

    public static boolean catchNullPointerException(Exception e) {
        return e instanceof NullPointerException;
    }

    public static boolean catchCommunicationsException(Exception e) {
        e.printStackTrace();
        return e instanceof CommunicationsException;
    }
}
