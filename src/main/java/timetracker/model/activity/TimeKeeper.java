package timetracker.model.activity;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Simple time keeper. Keeps track of duraton in minutes
 * and tracks a start time.
 * Basis for Activity.
 * @author daniel
 *
 */
public class TimeKeeper {

	//todo should timekeeper be immutable. How to solve 0 duration. Just make a new one!
	private final int durationInMinutes;
	private final LocalDateTime startTime;
	private final LocalDateTime endTime;
			
	public TimeKeeper(int duration, LocalDateTime startTime, LocalDateTime endTime) {
		this.durationInMinutes = duration;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public TimeKeeper() {
		this(0, null, null);
	}
	
	public TimeKeeper(LocalDateTime startTime) {
		this(0,startTime, null);
	}
	
	public TimeKeeper(LocalDateTime startTime, LocalDateTime endTime) {

		Duration duration = Duration.between(startTime, endTime);

		this.startTime = startTime;
		this.endTime = endTime;
		this.durationInMinutes = duration.toMinutesPart();
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

}
