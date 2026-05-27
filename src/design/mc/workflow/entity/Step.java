package design.mc.workflow.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Step {

    private final List<Transition> transitions;

    public Step() {
        this.transitions = new ArrayList<>();
    }

    public final void addTransition(Transition transition){
        this.transitions.add(transition);
    }

    public final void process(Context context){
        action(context);
        for(Transition transition: transitions){
            transition.apply(context);
        }
    }

    abstract protected void action(Context context);
}
