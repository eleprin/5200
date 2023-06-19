package timetracker.model.activity;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;
import java.time.Duration;

//todo convert Activity setters to using TimeKeeper.
public class Activity implements IActivity {
	private String name;
	private ActivityCategory category; // can be null, because whe should be able to track an activity without immediately knowing how to categorize it.
	//private boolean isPlanned; //separate planned from unplanned. implement search in trackinglist.
	private TimeKeeper timekeeper;
	
	//if durationInMinutes is 0, duration is supposed to be calculated later, when endtime is known.
	//Likewise Category can also be unknown at time of instantiation.


	//all info provided for Activity
	public Activity(String name, ActivityCategory category, LocalDateTime startTime, LocalDateTime endTime) {

		Duration duration = Duration.between(startTime, endTime);
		int durationInMinutes = duration.toMinutesPart();
		TimeKeeper timeKeeper = new TimeKeeper(durationInMinutes, startTime, endTime);

		this.name = name;
		this.category = category;
		this.timekeeper = timeKeeper;
	}
	
	//Missing endTime, duration set to 0
	public Activity(String name, ActivityCategory category, LocalDateTime startTime) {
		this(name, category, startTime, startTime);
	}


	//Missing endtime and category. duration set to 0
	public Activity(String name, LocalDateTime startTime) {
		this(name, null, startTime, startTime);
	}


	//Missing endtime, duration, category. Quick way to start logging an activity that starts now!
	public Activity(String name) {

		TimeKeeper timeKeeper = new TimeKeeper(LocalDateTime.now());
		this.name = name;
		this.category = null;
		this.timekeeper = timeKeeper;
	}
	

	@Override
	public String getName() {
		return this.name;
	}


	@Override
	public ActivityCategory getCategory() {
		return this.category;
	}

	
	public LocalDateTime getEndTime() {
		return this.timekeeper.getEndTime();
	}
	
	public void setEndTime(LocalDateTime endTime) {
		LocalDateTime startTime = this.timekeeper.getStartTime();
		TimeKeeper newTimeKeeper = new TimeKeeper(startTime, endTime);
		this.timekeeper = newTimeKeeper;
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
		return "Activity: " + name + ", duration: " + this.timekeeper.getDurationInMinutes();
	}

	@Override
	public TimeKeeper getTimeKeeper() {
		return this.timekeeper;
	}

}
