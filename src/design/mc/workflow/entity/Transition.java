package design.mc.workflow.entity;

public final class Transition {

    private final Condition condition;
    private final Step nextStep;

    public Transition(Condition condition, Step nextStep) {
        this.condition = condition;
        this.nextStep = nextStep;
    }

    public void apply(Context context){
        if(condition.matches(context)){
            nextStep.process(context);
        }
    }
}
