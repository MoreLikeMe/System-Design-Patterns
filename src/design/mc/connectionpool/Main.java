package design.mc.connectionpool;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final ConnectionPool pool = new ConnectionPool(5);

        ExecutorService executor = Executors.newFixedThreadPool(100);

        for(int i=0;i<100;i++){
            executor.submit(() -> {
                final Optional<Connection> opCon = pool.acquire();
                if(opCon.isPresent()){
                    Connection con = opCon.get();
                    con.action();
                    pool.release(con);
                    return;
                }
                System.out.println("Connection Not granted");
            });
        }

        // Shutdown executor
        executor.shutdown();

        // Wait for all tasks to finish
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("All Tasks Completed...");
    }
}
