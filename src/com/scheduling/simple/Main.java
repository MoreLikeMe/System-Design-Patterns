package com.scheduling.simple;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleWithFixedDelay(new ScheduledTask(), 2,2,TimeUnit.SECONDS);
        /*Thread.sleep(10000);
        scheduler.shutdown();*/
    }
}
