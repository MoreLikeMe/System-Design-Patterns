package design.patterns.chainofresponsibility;

/**
 *
 * TODO: Now the implementation is that each message is processed by one Handler
 *       In real life, INFO should be processed by DEBUG and ERROR and so on...
 */
public abstract class LogManager {

    private LogManager nextLogManager;

    protected LogManager(LogManager nextLogManager){
        this.nextLogManager = nextLogManager;
    }

    protected abstract void processHere(String message);
    protected abstract LogLevel getLevel();

    public void processLog(LogLevel logLevel, String message) {
        if(isProcessableHere(logLevel)){
            processHere(message);
        } else {
            next(logLevel, message);
        }
    }

    protected boolean isProcessableHere(LogLevel logLevel){
        return getLevel().equals(logLevel);
    }

    private void next(LogLevel logLevel, String message){
        if(nextLogManager!=null)
            nextLogManager.processLog(logLevel, message);
    }

}
