package design.patterns.chainofresponsibility;

public class InfoLogManager extends LogManager{

    InfoLogManager(LogManager nextManager){
        super(nextManager);
    }

    @Override
    protected LogLevel getLevel() {
        return LogLevel.INFO;
    }

    @Override
    protected void processHere(String message) {
        System.out.println("INFO: " + message);
    }
}
