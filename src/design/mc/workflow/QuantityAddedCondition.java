package design.mc.workflow;

import design.mc.workflow.entity.Condition;
import design.mc.workflow.entity.Context;

public class QuantityAddedCondition implements Condition {

    @Override
    public boolean matches(Context context) {
        return context.getData("quantity") != null && context.getData("total") != null;
    }
}
