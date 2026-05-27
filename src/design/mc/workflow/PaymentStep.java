package design.mc.workflow;

import design.mc.workflow.entity.Context;
import design.mc.workflow.entity.Step;

public class PaymentStep extends Step {

    @Override
    protected void action(Context context) {
        System.out.println("Doing Payments...");
        System.out.println("Payments Successful...");
    }
}
