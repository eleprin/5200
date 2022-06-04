package timetracker.model.activity;

import java.time.LocalDateTime;

/**
 * Defines the essential featues of an Activity,
 * which can be tracked via an ITrackingList.
 * Activity is a supertype for many different kinds
 * of activities that will be defined by the user.
 * Defined here will be commonalities of the different activities.
 * 
 * @author daniel
 *
 */

public interface IActivity {

	/**
	 * Get name of activity.
	 * Name will serve to differentiate the different types
	 * of activities.
	 * @return name of activity as String
	 */
	public String getName();
	
	/**
	 * get the TimeKeeper,
	 * which handles the time aspect of the activity.
	 * Duration in minutes, start and end time.
	 * @return TimeKeeper, which holds the relevant time information.
	 */
	public TimeKeeper getTimeKeeper();
	
	/**
	 * Get the ActivityCategory of the Activity.
	 * 
	 * @return ActivityCategory of activity.
	 */
	public ActivityCategory getCategory();
	
	
}

