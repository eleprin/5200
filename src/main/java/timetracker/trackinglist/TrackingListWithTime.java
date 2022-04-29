package timetracker.trackinglist;

import java.util.Iterator;
import java.time.LocalDateTime;
import java.util.ArrayList;

//TODO add time
//TODO add equals so that I can sum up all the minutes per activity.

public class TrackingListWithTime<E> implements ITrackingList<E>{
	protected ArrayList<E> trackingList;
	private int totalMinutesLogged;
	
	public TrackingListWithTime() {
		trackingList = new ArrayList<E>();
		totalMinutesLogged = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new TrackingListIterator(this);
	}

	@Override
	public void add(E element) {
		trackingList.add(element);
		
	}

	@Override
	public void remove(int index) {
		trackingList.remove(index);
		
	}
	
	public void clear() {
		trackingList.clear();
	}

	//TODO clear within time segment
	
	@Override
	public void set(int index, E element) throws IndexOutOfBoundsException {
		
		if (withinBounds(index)) {
			trackingList.set(index, element);
		}
		else throw new IndexOutOfBoundsException("Out of Bounds in TrackingListWithTime.set");
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		E element = null;
		if (withinBounds(index)) {
			element = trackingList.get(index);
		}
		else {
			throw new IndexOutOfBoundsException("Out of bounds in TrackingListWithTime.get");
		}
		return element;
	}
	
	public boolean withinBounds(int index) {
		int size = trackingList.size();
		boolean condition = (index >= 0 && index < size);
		return condition;
	}

	@Override
	public int getResourceSpent() {
		return totalMinutesLogged;
	}
	
	public void setResourceSpent(int amount) {
		this.totalMinutesLogged += amount;
	}
		
	class TrackingListIterator implements Iterator<E> {
			private int currentIndex;
			private int lastIndex;
			private ArrayList<E> listToIterate;
			
			
			public TrackingListIterator(TrackingListWithTime<E> list) {
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
