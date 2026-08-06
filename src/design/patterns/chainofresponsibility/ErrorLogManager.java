package design.patterns.chainofresponsibility;

public class ErrorLogManager extends LogManager{

    ErrorLogManager(LogManager nextManager){
        super(nextManager);
    }

    @Override
    protected LogLevel getLevel() {
        return LogLevel.ERROR;
    }

    @Override
    protected void processHere(String message) {
        System.out.println("Error: " + message);
    }


}
