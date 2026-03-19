package design.chainofresponsibility;

public class InfoLogManager extends LogManager{
    private final LogLevel LEVEL = LogLevel.INFO;

    InfoLogManager(LogManager nextManager){
        this.nextLogManager = nextManager;
    }

    @Override
    boolean isProcessableHere(LogLevel logLevel) {
        return LEVEL.equals(logLevel);
    }

    @Override
    void processHere(String message) {
        System.out.println("INFO: " + message);
    }
}
