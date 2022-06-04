package timetracker.view;

import java.util.ArrayList;

import timetracker.model.activity.Activity;

public interface TimeTrackerViewable {

	public Iterable<Activity> ActivitiesInList();
	
	public double calculatePercentage(int activityMinutes, int totalMinutes);
	
	public int getTotalMinutesInTimeSegment(ArrayList<Activity> listSegment);
	
	public int getMinutesFromAnActivityInTimeSegment(Activity activity, ArrayList<Activity> listSegment);

	public void add(Activity activity);


}
