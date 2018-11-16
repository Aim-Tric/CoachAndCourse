package commons;

import commons.data.Consts;

import java.util.IdentityHashMap;
import java.util.Map;

public class Utils {

    private static final Map<Integer, String> resultMap = null;


    static {
        resultMap.put(-1, Consts.RESULT_CANCEL);
        resultMap.put(0, Consts.RESULT_FAILED);
        resultMap.put(1, Consts.RESULT_OK);
    }

    public static String getResult(int key) {
        if (key > 0)
            return resultMap.get(1);
        return resultMap.get(key);
    }
}
