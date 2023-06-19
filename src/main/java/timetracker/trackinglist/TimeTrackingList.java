package timetracker.trackinglist;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

//TODO add time
//TODO add equals so that I can sum up all the minutes per activity.

public class TimeTrackingList<E> implements ITrackingList<E,Integer>{

	private final List trackingList;
	private Integer timeInMinutes;


	public TimeTrackingList() {
		this.trackingList = new ArrayList();
		this.timeInMinutes = 0;
	}
	@Override
	public Iterable<E> getElements() {
		return this.trackingList;
	}

	@Override
	public Integer getResourceTracked() {
		return this.timeInMinutes;
	}

	@Override
	public Iterator<E> iterator() {
		return new TimeTrackingListIterator(this);
	}

	class TimeTrackingListIterator implements Iterator<E> {
			private int currentIndex;
			private int lastIndex;
			private List<E> listToIterate;
			
			
			public TimeTrackingListIterator(TimeTrackingList<E> list) {
				currentIndex = 0;
				listToIterate = list.trackingList;
				lastIndex = listToIterate.size() - 1;

				
			}
		
			@Override
			public boolean hasNext() {
				if ((currentIndex) <= lastIndex)
					return true;
				
				return false;
			}
		
			@Override
			public E next() {
				E element = listToIterate.get(currentIndex);
				currentIndex++;
				return element;
					
			}
			
			
	}

}
