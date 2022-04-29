package timetracker.model.activity;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Test;

public class ActivityTest {

	@Test
	public void calculateDurationWhenAssignedUsingConstructorTest() {
		Activity act = new Activity("testing", null, LocalDateTime.now(), LocalDateTime.now().plusMinutes(10));
		int minutes = 10;
		int activityDuration = act.getDurationInMinutes();
		assertEquals(minutes, activityDuration);
		
	}
	
	@Test
	public void setDurationInMinutesTest() {
		Activity act = new Activity("testing");
		LocalDateTime time = LocalDateTime.now().plusMinutes(10);
		act.setEndTime(time);
		act.setDurationInMinutes();
		assertFalse(act.getDurationInMinutes() == 0);
	}

}
