package com.scheduling.simple;

public class ScheduledTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from Task");
    }
}
