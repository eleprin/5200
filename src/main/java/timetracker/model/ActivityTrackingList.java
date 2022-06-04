package timetracker.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import timetracker.model.activity.Activity;
import timetracker.trackinglist.TrackingListWithTime;
import timetracker.view.TimeTrackerViewable;

public class ActivityTrackingList extends TrackingListWithTime<Activity> {
	
	public ActivityTrackingList() {
		super();
	}

}
