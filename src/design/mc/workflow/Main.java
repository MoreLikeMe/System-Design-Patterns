package design.mc.workflow;


import design.mc.workflow.entity.*;

public class Main {
    public static void main(String[] args) {
        Condition isProductAdded = new ProductAddedCondition();
        Condition isQuantityAdded = new QuantityAddedCondition();

        Step productSelectStep = new ProductSelectStep();
        Step quantitySelectStep = new QuantitySelectStep();
        Step paymentStep = new PaymentStep();

        productSelectStep.addTransition(new Transition(isProductAdded, quantitySelectStep));
        quantitySelectStep.addTransition(new Transition(isQuantityAdded, paymentStep));

        Workflow workflow = new Workflow("Cart Flow", productSelectStep);
        Context context =  new Context();
        workflow.run(context);
    }
}
