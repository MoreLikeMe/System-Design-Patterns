package design.mc.workflow;

import design.mc.workflow.entity.Context;
import design.mc.workflow.entity.Step;

public class ProductSelectStep extends Step {

    @Override
    protected void action(Context context) {
        System.out.println("Adding product into cart...");
        context.addData("product", "Smart TV");
        context.addData("price", 100.0);
    }
}
