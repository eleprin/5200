package timetracker.model.activity;

import java.time.LocalDateTime;
//TODO right form of time. LocalDateTime or something else?
public class Activity implements IActivity {
	private String name;
	private LocalDateTime startTime;
	private int durationInMinutes;
	private ActivityCategory category;
	private boolean isPlanned; //separate planned activities from tracked activities. maybe separate list? TODO
	
	//static int totalMinutes per activity. Or maybe implement in the list.
	
	public Activity(String name, ActivityCategory category, LocalDateTime startTime, int durationInMinutes) {
		this.name = name;
		this.category = category;
		this.startTime = startTime;
		this.durationInMinutes = durationInMinutes;
	}
	
	public Activity(String name, ActivityCategory category, LocalDateTime startTime) {
		this(name, category, startTime, 0);
	}
	
	public Activity(String name, LocalDateTime startTime) {
		this(name, null, startTime, 0);
	}
	
	public Activity(String name) {
		this.name = name;
		this.startTime = LocalDateTime.now();
		this.durationInMinutes = 0;
	}
	

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getDurationInMinutes() {
		return this.durationInMinutes;
	}

	@Override
	public ActivityCategory getCategory() {
		return this.category;
	}

	@Override
	public LocalDateTime getStartTime() {
		return this.startTime;
	}

}
