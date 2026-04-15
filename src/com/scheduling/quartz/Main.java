package com.scheduling.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledTask.class).build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("FiveSeconds-for-Forever")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
        // scheduler.shutdown();
    }
}
