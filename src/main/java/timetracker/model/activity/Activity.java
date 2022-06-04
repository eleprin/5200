package timetracker.model.activity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.time.Duration;
//TODO right form of time. LocalDateTime or something else?
public class Activity implements IActivity {
	private String name;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int durationInMinutes; //can be 0
	private ActivityCategory category; // can be null
	//private boolean isPlanned; //separate planned from unplanned. implement search in trackinglist. 
	private TimeKeeper timekeeper;
	
	
	
	//if durationInMinutes is 0, duration is supposed to be calculated later, when endtime is known.
	//Likewise Category can also be unknown at time of instantiation.
	
	public Activity(String name, ActivityCategory category, LocalDateTime startTime, LocalDateTime endTime) {
		this.name = name;
		this.category = category;
		this.startTime = startTime;
		this.endTime = endTime;
		
		Duration duration = Duration.between(startTime, endTime);
		this.durationInMinutes = duration.toMinutesPart();
	
	}
	
	//sets duration to 0
	public Activity(String name, ActivityCategory category, LocalDateTime startTime) {
		this(name, category, startTime, startTime);
	}
	
	public Activity(String name, LocalDateTime startTime) {
		this(name, null, startTime, startTime);
	}
	
	public Activity(String name) {
		this.name = name;
		this.startTime = LocalDateTime.now();
		this.category = null;
		this.durationInMinutes = 0;
	}
	
	//TODO planned activity constructor? 

	@Override
	public String getName() {
		return this.name;
	}


	@Override
	public ActivityCategory getCategory() {
		return this.category;
	}

	
	public LocalDateTime getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	public void setDurationInMinutes() throws NullPointerException {
		Duration duration = Duration.between(this.startTime, this.endTime);
		if (this.endTime != null)
			this.durationInMinutes = duration.toMinutesPart();
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		return Objects.equals(category, other.category) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Activity: " + name + ", duration: " + durationInMinutes;
	}

	@Override
	public TimeKeeper getTimeKeeper() {
		return this.timekeeper;
	}

}
