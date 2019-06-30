package lab9;

import java.util.LinkedList;

public class Queue {
	
	private static final int QUEUE_LIMIT = 10;
	
	private LinkedList<Integer> arr;

	public Queue() {
		this.arr = new LinkedList<>();
	}
	
	/**
	 * adds an object to the queue, only if the queue is not full.
	 * @param obj
	 * @return true if the object was added to the queue successfully, false otherwise.
	 */
	public boolean addToQueue(Integer obj) {
		if(!(arr.size() >= QUEUE_LIMIT))
		{
			arr.addLast(obj);
			return true;
		}
		return false;
	}
	
	/**
	 * return the first element in the queue and removes it from the queue
	 * @return
	 */
	public Integer getElement() {
		Integer toReturn = isEmpty() ? null : arr.getFirst();
		arr.removeFirst();
		return toReturn;
	}
	
	/**
	 * returns the first element in the queue WITHOUT removing it from the queue
	 * @return
	 */
	public Integer peek() {
		return isEmpty() ? null : arr.getFirst();
	}
	
	/**
	 * return true if the queue is empty
	 * @return return true if queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return arr.size() == 0; //same as "return arr.isEmpty()"
	}
	
	/**
	 * prints all the elements in the queue
	 */
	public void printElements() {
		for(Integer t : arr)
			System.out.print(t + ", ");
		System.out.println();
	}
}
