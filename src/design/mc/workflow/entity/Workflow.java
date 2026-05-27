package design.mc.workflow.entity;

public final class Workflow {

    private final String name;
    private final Step startStep;

    public Workflow(String name, Step startStep) {
        this.name = name;
        this.startStep = startStep;
    }

    public final void run(Context context){
        startStep.process(context);
    }
}
