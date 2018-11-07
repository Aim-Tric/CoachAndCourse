package data;

public class Consts {

    public final static String illegalStr = "[\\w!#$%&'*+/=?^_`{|}~-]+";
//            "[!@#\\$%\\^\\&\\*\\(\\)\\-\\+]+";
    public final static String mailStr =
            "[\\w!#$%&'*+/=?^_`{|}~-]+" +
            "(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@" +
            "(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w]" +
            "(?:[\\w-]*[\\w])?";

}
