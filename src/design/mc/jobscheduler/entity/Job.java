package design.mc.jobscheduler.entity;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Another approach could be
 * 1. Job includes strategy for scheduling
 * 2. Job includes a Task (Runnable)
 *
 * User creates strategy and task separately
 * and use them together, in this manner we can
 * decouple more the logic and scheduling frequency
 */
public abstract class Job {

    private final SchedulingStrategy strategy;
    private final int jobId;

    protected Job(SchedulingStrategy strategy) {
        this.strategy = strategy;
        this.jobId = ThreadLocalRandom.current().nextInt(1, 10000);
    }

    public abstract void run();

    public int getJobId(){
        return jobId;
    }

    public LocalDateTime getStartTime(){
        return strategy.getStartTime();
    }

    public final Optional<LocalDateTime> nextJobRun(LocalDateTime currentDateTime){
        return strategy.nextRunDateTime(currentDateTime);
    }
}
