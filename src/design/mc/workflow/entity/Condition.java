package design.mc.workflow.entity;

public interface Condition {
    boolean matches(Context context);
}