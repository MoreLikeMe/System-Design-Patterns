package design.mc.ruleengine.entity;

public class Rule {
    private final String name;
    private final Condition condition;
    private final Action action;

    public Rule(String name, Condition condition, Action action) {
        this.name = name;
        this.condition = condition;
        this.action = action;
    }

    public String getName(){
        return name;
    }

    public void apply(Context context){
        if(condition.evaluate(context)){
            action.execute(context);
        }
    }
}
