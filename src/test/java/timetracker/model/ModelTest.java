package timetracker.model;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import timetracker.model.activity.Activity;
import java.util.ArrayList;

public class ModelTest {

	@Test
	public void getActivitiesInTimeSegmentTest() {
		ActivityTrackingList list = new ActivityTrackingList();
		LocalDateTime beforeListSegment = LocalDateTime.now().minusDays(1);
		LocalDateTime afterListSegment = LocalDateTime.now().plusDays(1);
		LocalDateTime twoDaysAgo = LocalDateTime.now().minusDays(2);
		LocalDateTime timeOfActivity1 = LocalDateTime.now();
		LocalDateTime timeOfActivity2 = timeOfActivity1.plusMinutes(10);
		LocalDateTime timeOfActivity3 = timeOfActivity2.plusMinutes(10);
		
		Activity act0 = new Activity("Activity 0", null, twoDaysAgo, twoDaysAgo.plusMinutes(10));
		Activity act1 = new Activity("Activity 1", null, timeOfActivity1, timeOfActivity1.plusMinutes(10));
		Activity act2 = new Activity("Activity 2", null, timeOfActivity2, timeOfActivity2.plusMinutes(10));
		Activity act3 = new Activity("Activity 3", null, timeOfActivity3, timeOfActivity3.plusMinutes(10));
		
		list.add(act0);
		list.add(act1);
		list.add(act2);
		list.add(act3);
		
		
		int listSize = list.getListOfActivitiesInTimeSegment(beforeListSegment, afterListSegment).size();
		assertEquals(listSize, 3);
		
		

	}

	@Test
	public void getMinutesFromAllActivitiesInTimeSegmentTest() {
		
	ActivityTrackingList list = new ActivityTrackingList();
	LocalDateTime beforeListSegment = LocalDateTime.now().minusDays(1);
	LocalDateTime afterListSegment = LocalDateTime.now().plusDays(1);

	LocalDateTime timeOfActivity1 = LocalDateTime.now();
	LocalDateTime timeOfActivity2 = timeOfActivity1.plusMinutes(10);
	LocalDateTime timeOfActivity3 = timeOfActivity2.plusMinutes(10);
	
	Activity act1 = new Activity("Activity 1", null, timeOfActivity1, timeOfActivity1.plusMinutes(10));
	Activity act2 = new Activity("Activity 2", null, timeOfActivity2, timeOfActivity2.plusMinutes(10));
	Activity act3 = new Activity("Activity 3", null, timeOfActivity3, timeOfActivity3.plusMinutes(10));
	
	list.add(act1);
	list.add(act2);
	list.add(act3);
	
	int totalMinutesInSegment = 30;
	ArrayList<Activity> listSegment = list.getListOfActivitiesInTimeSegment(beforeListSegment, afterListSegment);
	assertEquals(list.getTotalMinutesInTimeSegment(listSegment), totalMinutesInSegment);
	
	}
}
