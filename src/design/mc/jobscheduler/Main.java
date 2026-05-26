package design.mc.jobscheduler;

import design.mc.jobscheduler.entity.IntervalSchedulingStrategy;
import design.mc.jobscheduler.entity.Job;
import design.mc.jobscheduler.entity.JobScheduler;
import design.mc.jobscheduler.entity.SchedulingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JobScheduler scheduler = new JobScheduler();
        System.out.println("Scheduler started");

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusMinutes(2);
        Duration interval = Duration.ofSeconds(5);
        SchedulingStrategy interval5secs_for2mins = new IntervalSchedulingStrategy(start, end, interval);
        Job printingJobWith_interval5secs_for2mins = new PrintingJob(interval5secs_for2mins);

        scheduler.addJob(printingJobWith_interval5secs_for2mins);

        //Simulating real scenario before stopping the scheduler
        Thread.sleep(120000);


        System.out.println("Stopping scheduler");
        scheduler.stop();
        System.out.println("Stppped scheduler");
    }
}
