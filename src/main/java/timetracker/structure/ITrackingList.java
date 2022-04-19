package timetracker.structure;

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

public interface ITrackingList<E> extends Iterable<E> {
	/**
	 * add a new element to end of list
	 * @param element to be added
	 */
	void add(E element);
	
	/**
	 * remove specified element
	 * @param index of element to remove
	 */
	void remove(int index);
	
	/**
	 * clear all elements
	 */
	void clear();
	
	/**
	 * set activity. 
	 * 
	 * @param element to edit
	 * @param index of element
	 * @throws IndexOutOfBoundsException
	 */
	void set(int index, E element) throws IndexOutOfBoundsException;
	
	/**
	 * get element at index location
	 * @param index of list element
	 * @return list element at location
	 * @throws IndexOutOfBoundsException
	 */
	E get(int index) throws IndexOutOfBoundsException;
	
	/**
	 * total amount of resource spent, e.g. minutes, money.
	 * 
	 * @return int representation of resource spent.
	 */
	int getResourceSpent();

}
