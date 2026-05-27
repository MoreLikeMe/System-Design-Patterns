package design.mc.workflow;

import design.mc.workflow.entity.Context;
import design.mc.workflow.entity.Step;

public class QuantitySelectStep extends Step {

    @Override
    protected void action(Context context) {
        System.out.println("Adding quantity...");
        context.addData("quantity", 3);
        context.addData("total", (double) context.getData("price") * (int) context.getData("quantity"));
    }
}
