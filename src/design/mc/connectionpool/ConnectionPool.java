package design.mc.connectionpool;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {
    public final int MAX_LIMIT;
    private final ConcurrentHashMap<Integer, Connection> connections;
    private final BlockingQueue<Integer> availableConnections;
    private final AtomicInteger counter;

    public ConnectionPool(int maxLimit) {
        MAX_LIMIT = maxLimit;
        this.connections = new ConcurrentHashMap<>();
        this.availableConnections = new LinkedBlockingQueue<>();
        this.counter = new AtomicInteger(0);
        /**
         * Use ScheduledExecutorService to have a cron job
         * flavour into the stale/leak connections retrieval
         */
        scheduleCleanUp();
    }

    private void scheduleCleanUp(){
        /*
        ExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.submit(() -> {
            while(true){
                System.out.println("Cleaning up");
            }
        });
        */
    }

    public Optional<Connection> acquire(){
        Integer conId  = availableConnections.poll();
        if(conId != null){
            return Optional.of(connections.get(conId));
        }

        //create connection in case of non-availability
        if(counter.get() < MAX_LIMIT){
            if(counter.incrementAndGet()<=MAX_LIMIT){
                Connection con = createConnection();
                connections.put(con.getConnectionId(), con);
                return Optional.of(con);
            }
        }

        //wait for sometime in case of MAX_Limit reached
        try {
            conId = availableConnections.poll(100, TimeUnit.MILLISECONDS);
            if(conId != null){
                connections.get(conId);
            }
        } catch (InterruptedException e) {
            //This is to set the Interrupt flag back to true
            Thread.currentThread().interrupt();
        }

        return Optional.empty();
    }

    public void release(Connection con){
        if(connections.containsKey(con.getConnectionId())) {
            availableConnections.offer(con.getConnectionId());
        }
    }

    private Connection createConnection(){
        return new Connection();
    }
}
