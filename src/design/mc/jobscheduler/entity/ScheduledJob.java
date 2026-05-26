package design.mc.jobscheduler.entity;

import java.time.LocalDateTime;

public class ScheduledJob implements Comparable<ScheduledJob>{

    private final int jobId;
    private final LocalDateTime nextRunDateTime;

    public ScheduledJob(int jobId, LocalDateTime nextRunDateTime) {
        this.jobId = jobId;
        this.nextRunDateTime = nextRunDateTime;
    }

    public int getJobId() {
        return jobId;
    }

    public LocalDateTime getNextRunDateTime() {
        return nextRunDateTime;
    }

    @Override
    public int compareTo(ScheduledJob other) {
        if(this.nextRunDateTime.isBefore(other.nextRunDateTime)){
            return -1;
        }
        return 1;
    }
}
