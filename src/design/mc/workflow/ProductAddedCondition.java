package design.mc.workflow;

import design.mc.workflow.entity.Condition;
import design.mc.workflow.entity.Context;

public class ProductAddedCondition implements Condition {

    @Override
    public boolean matches(Context context) {
        return context.getData("product") != null && context.getData("price") !=null;
    }
}
