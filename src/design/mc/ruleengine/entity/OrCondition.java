package design.mc.ruleengine.entity;

import java.util.List;

public class OrCondition implements Condition{

    private final List<Condition> conditions;

    public OrCondition(Condition... conditions) {
        this.conditions = List.of(conditions);
    }

    @Override
    public final boolean evaluate(Context context) {
        for(Condition condition: conditions){
            if(condition.evaluate(context)){
                return true;
            }
        }
        return false;
    }
}
