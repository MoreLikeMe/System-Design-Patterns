package design.mc.jobscheduler.entity;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SchedulingStrategy {

    LocalDateTime getStartTime();
    Optional<LocalDateTime> nextRunDateTime(LocalDateTime currentDateTime);
}
