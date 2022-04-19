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
	 * get amount of minutes spent on actitivy.
	 * Minutes because that's the smallest time unit
	 * used in this project. 
	 * @return minutes spend on activity.
	 */
	public int getDurationInMinutes();
	
	/**
	 * Get the ActivityCategory of the Activity.
	 * 
	 * @return ActivityCategory of activity.
	 */
	public ActivityCategory getCategory();
	
	/**
	 * get start of activity. End time can be unknown at time of creation.
	 * But there has to be some notion of when the activity starts.
	 * * @return start time. Does not have to be specific to minute.
	 */
	public LocalDateTime getStartTime();
}
