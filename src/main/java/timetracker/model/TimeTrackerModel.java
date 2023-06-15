package timetracker.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import timetracker.controller.TimeTrackerControllable;
import timetracker.model.activity.Activity;
import timetracker.model.activity.ActivityCategory;
import timetracker.view.TimeTrackerViewable;

public class TimeTrackerModel implements TimeTrackerViewable, TimeTrackerControllable{

	//todo add list of categorie
	
	ActivityTrackingList fullList;
	ArrayList<Activity> viewList;

	public TimeTrackerModel(ActivityTrackingList list) {
		this.fullList = list;
	}
	
	public TimeTrackerModel() {
		this.fullList = new ActivityTrackingList();
	}
	
	@Override
	public Iterable<Activity> ActivitiesInList() {
		return this.viewList;
	}
	public boolean isAfter(LocalDateTime timeToCheck, LocalDateTime time) {
		if (timeToCheck.isAfter(time))
			return true;
		return false;
	}
	
	public boolean isBefore(LocalDateTime timetoCheck, LocalDateTime time) {
		if (timetoCheck.isBefore(time))
			return true;
		return false;
	}
	
	// get activities within timesegment
	public void setListOfActivitiesInTimeSegment(LocalDateTime start, LocalDateTime end) {
		ArrayList<Activity> listSegment = new ArrayList<Activity>();
		for (Activity element : this.fullList) {		
			LocalDateTime elementStartTime = element.getStartTime();
			if ((isAfter(elementStartTime, start)) && (isBefore(elementStartTime, end)))
				listSegment.add(element);
			
		}
		this.viewList = listSegment;
	}
	
	public int getTotalMinutesInTimeSegment(ArrayList<Activity> listSegment) {
		int minutes = 0;
		for (Activity element : listSegment) {
			int elementMinutes = element.getDurationInMinutes();
			minutes += elementMinutes;
		}
		return minutes;
	}
	
	public int getMinutesFromAnActivityInTimeSegment(Activity activity, ArrayList<Activity> listSegment) {
		int minutes = 0;
		for (Activity element : listSegment) {
			if (element.equals(activity)) {
				int elementMinutes = element.getDurationInMinutes();
				minutes += elementMinutes;
			}
		}
		return minutes;
	}
	
	//public int getMinutesFromSingleCategoryInTimeSegment(ActivityCategory category, ArrayList<Activity> listSegment) {
	//}
	public void add(Activity activity) {
		this.fullList.add(activity);
		
	}
	
	public double calculatePercentage(int activityMinutes, int totalMinutes) {
		return (double) activityMinutes / totalMinutes;
	}


}
