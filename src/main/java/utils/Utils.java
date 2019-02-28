package utils;

import utils.data.Consts;

import java.util.HashMap;

public class Utils {

    private static final Utils instance = new Utils();
    private HashMap<Integer, String> resultMap = new HashMap<Integer, String>();

    private Utils() {
        resultMap.put(-1, Consts.RESULT_CANCEL);
        resultMap.put(0, Consts.RESULT_FAILED);
        resultMap.put(1, Consts.RESULT_OK);
    }

    public static String getResult(int key) {
        if (key > 0)
            return instance.resultMap.get(1);
        return instance.resultMap.get(key);
    }


}

