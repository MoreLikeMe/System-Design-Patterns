package design.mc.workflow.entity;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private final Map<String, Object> data;

    public Context() {
        this.data = new HashMap<>();
    }

    public void addData(String key, Object value){
        data.put(key, value);
    }

    public Object getData(String key){
        return data.get(key);
    }
}
