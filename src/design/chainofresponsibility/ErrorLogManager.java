package design.chainofresponsibility;

public class ErrorLogManager extends LogManager{
    private final LogLevel LEVEL = LogLevel.ERROR;

    ErrorLogManager(LogManager nextManager){
        this.nextLogManager = nextManager;
    }

    @Override
    boolean isProcessableHere(LogLevel logLevel) {
        return LEVEL.equals(logLevel);
    }

    @Override
    void processHere(String message) {
        System.out.println("Error: " + message);
    }
}
