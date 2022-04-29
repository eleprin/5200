package timetracker.trackinglist;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrackingListTest {

	//test for each loop
	@Test
	public void iteratorTest() {
		TrackingListWithTime<Integer> integerList = new TrackingListWithTime<>();
		for (int i = 1; i <= 3; i++) {
			integerList.add(i);
		}
		Integer j = 1;
		for (Integer number : integerList) {
			assertEquals(j, number);
			j++;
		}
			
			
	}
	
    @Test
    public void throwsExceptionWhenOutOfBounds() {
        TrackingListWithTime<Integer> list = new TrackingListWithTime<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        try {
            Integer x = list.get(4);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // Test passed
        }
        
        try {
        	list.set(4, null);
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
