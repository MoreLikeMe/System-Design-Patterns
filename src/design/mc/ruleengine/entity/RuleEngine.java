package design.mc.ruleengine.entity;

import java.util.HashMap;
import java.util.Map;

public class RuleEngine {
    private Map<String, Rule> rules;

    public RuleEngine() {
        this.rules = new HashMap<>();
    }

    public void addRule(Rule rule){
        rules.put(rule.getName(), rule);
    }

    public Context start(Context context){
        rules.forEach((key,rule) -> rule.apply(context));
        return context;
    }
}
