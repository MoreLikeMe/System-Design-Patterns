package design.mc.jobscheduler.entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JobScheduler {

    private final Map<Integer, Job> jobs;
    private final PriorityQueue<ScheduledJob> scheduledJobs;
    private boolean jobSchedulerOn;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public JobScheduler() {
        this.jobs = new HashMap<>();
        this.scheduledJobs = new PriorityQueue<>();
        this.jobSchedulerOn = true;
        executor.submit(this::start);
    }

    public void addJob(Job job){
        if(jobs.containsKey(job.getJobId())){
            return;
        }

        jobs.put(job.getJobId(), job);
        scheduledJobs.offer(new ScheduledJob(job.getJobId(), job.getStartTime()));

        System.out.println("Job Added");
    }

    public void removeJob(Job job){
        if(!jobs.containsKey(job.getJobId())){
            return;
        }
        jobs.remove(job.getJobId());
    }

    private void start(){
        ExecutorService executor = Executors.newFixedThreadPool(20);
        while(this.jobSchedulerOn){
            //check for jobs that can be run at this time
            if(!scheduledJobs.isEmpty()
                    && scheduledJobs.peek().getNextRunDateTime().isBefore(LocalDateTime.now())){
                ScheduledJob task = scheduledJobs.poll();
                if(jobs.containsKey(task.getJobId())){
                    Job job = jobs.get(task.getJobId());
                    executor.submit(job::run);
                    Optional<LocalDateTime> nextJobDateTime = job.nextJobRun(task.getNextRunDateTime());
                    nextJobDateTime.ifPresent(localDateTime -> scheduledJobs.offer(new ScheduledJob(job.getJobId(), localDateTime)));
                }
            }

            //wait for 1sec
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //Release the executor
        try {
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop(){
        try {
            this.jobSchedulerOn = false;
            this.executor.shutdown();
            this.executor.awaitTermination(2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
