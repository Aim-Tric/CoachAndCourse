package commons;

import java.util.HashMap;

public class DataTransferer extends Thread {

    private static DataTransferer instance = null;
    private HashMap<String, Object> data = new HashMap<String, Object>();

    public static DataTransferer getInstance() {
        if (instance == null)
            instance = new DataTransferer();
        return instance;
    }

    public void put(String name, Object data) {
        this.data.put(name, data);
    }

    public Object getData(String name) {
        instance = null;
        return data.get(name);
    }

}