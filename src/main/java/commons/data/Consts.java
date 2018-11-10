package commons.data;

public class Consts {

    public final static String REGEX_ILLEGAL = "[\\w!#$%&'*+/=?^_`{|}~-]*([!#$%&'*+/=?^_`{|}~-])[\\w!#$%&'*+/=?^_`{|}~-]*";
//            "[!@#\\$%\\^\\&\\*\\(\\)\\-\\+]+";
    public final static String REGEX_MAIL =
            "[\\w!#$%&'*+/=?^_`{|}~-]+" +
            "(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@" +
            "(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w]" +
            "(?:[\\w-]*[\\w])?";
    public final static String RESULT_OK = "RESULT_OK";

    public final static String RESULT_FAILED = "RESULT_FAILED";


}
