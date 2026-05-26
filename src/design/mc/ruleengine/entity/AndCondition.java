package design.mc.ruleengine.entity;

import java.util.List;

public class AndCondition implements Condition{

    private final List<Condition> conditions;

    public AndCondition(Condition... conditions) {
        this.conditions = List.of(conditions);
    }

    @Override
    public boolean evaluate(Context context) {
        for(Condition condition: conditions){
            if(!condition.evaluate(context)){
                return false;
            }
        }
        return true;
    }
}
