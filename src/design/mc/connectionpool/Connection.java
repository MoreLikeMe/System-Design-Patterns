package design.mc.connectionpool;

import java.util.concurrent.ThreadLocalRandom;

public class Connection {

    private final int connectionId;

    public Connection() {
        this.connectionId = ThreadLocalRandom.current().nextInt(1, 10000);
    }

    public void action(){
        //Do the Action
        System.out.println("Doing Action from Connection : " + connectionId + "  ...");
    }

    public int getConnectionId() {
        return connectionId;
    }
}
