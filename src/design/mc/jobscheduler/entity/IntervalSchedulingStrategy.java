package design.mc.jobscheduler.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

public class IntervalSchedulingStrategy implements SchedulingStrategy{

    private final LocalDateTime start;
    private final LocalDateTime end;
    private final Duration interval;

    public IntervalSchedulingStrategy(LocalDateTime start, LocalDateTime end, Duration interval) {
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Duration getInterval() {
        return interval;
    }

    @Override
    public LocalDateTime getStartTime() {
        return this.start;
    }

    @Override
    public Optional<LocalDateTime> nextRunDateTime(LocalDateTime currentDateTime) {
        LocalDateTime nextRunDateTime = currentDateTime.plus(this.interval);
        if(nextRunDateTime.isBefore(this.end) && nextRunDateTime.isAfter(this.start)){
            return Optional.of(nextRunDateTime);
        }
        return Optional.empty();
    }
}
