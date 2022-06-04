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
	private int durationInMinutes;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
			
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
		this.startTime = startTime;
		this.endTime = endTime;
		//this.durationInMinutes = TODO learn about duration
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	
	private int calculateDurationInMinutes(LocalDateTime startTime, LocalDateTime endTime) {
		Duration duration = Duration.between(startTime, endTime);
		int minutes = duration.toMinutesPart();
		return minutes;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
}
