package design.mc.jobscheduler;

import design.mc.jobscheduler.entity.Job;
import design.mc.jobscheduler.entity.SchedulingStrategy;

public class PrintingJob extends Job {

    public PrintingJob(SchedulingStrategy strategy) {
        super(strategy);
    }

    @Override
    public void run() {
        System.out.println("I am printing my Name");
    }
}
