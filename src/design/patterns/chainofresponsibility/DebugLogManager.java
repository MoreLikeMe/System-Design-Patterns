package design.patterns.chainofresponsibility;

public class DebugLogManager extends LogManager{
    private final LogLevel LEVEL = LogLevel.DEBUG;

    DebugLogManager(LogManager nextManager){
        this.nextLogManager = nextManager;
    }

    @Override
    boolean isProcessableHere(LogLevel logLevel) {
        return LEVEL.equals(logLevel);
    }

    @Override
    void processHere(String message) {
        System.out.println("Debug: " + message);
    }
}
