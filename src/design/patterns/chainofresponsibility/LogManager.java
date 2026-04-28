package design.patterns.chainofresponsibility;

public abstract class LogManager {

    LogManager nextLogManager;

    abstract boolean isProcessableHere(LogLevel logLevel);
    abstract void processHere(String message);

    void processLog(LogLevel logLevel, String message) {
        if(isProcessableHere(logLevel)){
            processHere(message);
        } else {
            next(logLevel, message);
        }
    }

    void next(LogLevel logLevel, String message){
        if(nextLogManager!=null)
            nextLogManager.processLog(logLevel, message);
    }

}
