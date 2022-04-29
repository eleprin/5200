package timetracker.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import timetracker.model.activity.Activity;
import timetracker.trackinglist.TrackingListWithTime;

public class ActivityTrackingList extends TrackingListWithTime<Activity> {
	
	public ActivityTrackingList() {
		super();
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
	public ArrayList<Activity> getActivitiesInTimeSegment(LocalDateTime start, LocalDateTime end) {
		ArrayList<Activity> listSegment = new ArrayList<Activity>();
		for (Activity element : super.trackingList) {		
			LocalDateTime elementStartTime = element.getStartTime();
			if ((isAfter(elementStartTime, start)) && (isBefore(elementStartTime, end)))
				listSegment.add(element);
			
		}
		return listSegment;
	}
	
	public int getMinutesInTimeSegment(ArrayList<Activity> listSegment) {
		int minutes = 0;
		for (Activity element : listSegment) {
			int elementMinutes = element.getDurationInMinutes();
			minutes += elementMinutes;
		}
		return minutes;
	}
	
	@Override
	public void add(Activity activity) {
		int minutesToAdd = activity.getDurationInMinutes();
		super.trackingList.add(activity);
		super.setResourceSpent(minutesToAdd);
		
	}
	
}
