package design.mc.ruleengine.entity;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private final Map<String, Object> data;

    public Context() {
        this.data = new HashMap<>();
    }

    public void addData(String objectKey, Object object){
        data.put(objectKey, object);
    }

    public Object getData(String objectKey){
        return data.get(objectKey);
    }

    @Override
    public String toString() {
        return "Context{" +
                "data=" + data +
                '}';
    }
}
