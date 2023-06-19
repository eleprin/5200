package timetracker.trackinglist;

/** 
 * Defines the state and behaviour requirements
 * to function as a list for tracking a resource spent on element, e.g. time.
 * Extends Iterable in order to provide all requested elements
 * without necessarily providing the datastructure.
 * 
 * @author Daniel S. Wagner
 *
 * @param <E> elements that the list will hold
 */

public interface ITrackingList<E,R> extends Iterable<E> {

	/** get all the elements that are held by the list.
	 * Iterable to hide the list.
	 * @return all elements
	 */
	Iterable<E> getElements();

	/**
	 *
	 * @return resource that's being tracked
	 */
	R getResourceTracked();

}
