package service.utils;

import net.sf.json.JSONObject;

public class UtilService {

    /**
     * 将json转换成Javabean对象
     *
     * @param param 对象的数据键值对
     * @param tmp   Javabean的class模板
     * @return 返回一个tmp类型的Javabean对象
     */
    public static Object getBeanFromJson(String param, Class tmp) {
        JSONObject json = JSONObject.fromObject(param);
        return JSONObject.toBean(json, tmp);
    }




}
