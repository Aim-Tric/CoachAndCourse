package service.utils;

import net.sf.json.JSONObject;

public class UtilService {

    public static Object getBeanFromJson(String param, Class tmp) {
        JSONObject json = JSONObject.fromObject(param);
        return JSONObject.toBean(json, tmp);
    }




}
