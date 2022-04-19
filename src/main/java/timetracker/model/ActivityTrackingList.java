package timetracker.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import timetracker.model.activity.Activity;
import timetracker.trackinglist.TrackingListWithTime;

public class ActivityTrackingList extends TrackingListWithTime<Activity> {
	
	
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
	
	//TODO create a more concrete activity tracking list
	
	public ArrayList<Activity> getElementsBetween(LocalDateTime start, LocalDateTime end) {
		ArrayList<Activity> listSegment = new ArrayList<Activity>();
		for (Activity element : super.trackingList) {		
			LocalDateTime elementStartTime = element.getStartTime();
			if (isAfter(elementStartTime, start) && isBefore(elementStartTime, end))
				listSegment.add(element);
			
		}
		return listSegment;
	}
	


}
