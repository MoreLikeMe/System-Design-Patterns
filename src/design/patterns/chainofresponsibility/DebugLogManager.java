package design.patterns.chainofresponsibility;

public class DebugLogManager extends LogManager{

    DebugLogManager(LogManager nextManager){
        super(nextManager);
    }

    @Override
    protected LogLevel getLevel() {
        return LogLevel.DEBUG;
    }

    @Override
    protected void processHere(String message) {
        System.out.println("Debug: " + message);
    }
}
