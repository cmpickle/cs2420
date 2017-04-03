package assignment7;

import java.util.NoSuchElementException;

/**
 * A class representing a linked list.
 * 
 * @author Gage Glenn
 * @author Cameron
 * 
 * */

public class MyLinkedList<E> implements List<E> {
	
	private int size = 0;
	Node head = new Node();
	Node tail = new Node();
	
	/**
	 * A constructor for the MyLinkedList class
	 * */
	
	public MyLinkedList()
	{
		head.next = tail;
		tail.prev = head;
		
	}
	
	/**
	 * A method which adds an element to the beginning of the linked list
	 * 
	 * @param Object element - The element being added
	 * */
	
	@SuppressWarnings("unchecked")
	@Override
	public void addFirst(Object element) 
	{
		
		Node addNode = new Node((E) element);
		
		size++;
		
		addNode.prev = head;
		addNode.next = head.next;
		head.next.prev = addNode;
		head.next = addNode;
		
		
	}
	
	/**
	 *  A method which adds an element to the end of the linked list
	 * 
	 * @param Object element - The element being added
	 * */

	@SuppressWarnings("unchecked")
	@Override
	public void addLast(Object element) 
	{	
		
		Node addNode = new Node((E) element);
		
		size++;
		
		addNode.next = tail;
		addNode.prev = tail.prev;
		tail.prev.next = addNode;
		tail.prev = addNode;
		
	}
	
	/**
	 *  A method which adds an element to the index specified of the linked list
	 * 
	 * @param Object element - The element being added
	 * @param int index - the index where we will add the element
	 * 
	 * */

	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, Object element) throws IndexOutOfBoundsException {
				
		if(size == 0 && index == 0){
			addFirst(element);
			return;
		}
		if(size == index){
			addLast(element);
			return;
		}
		if(size < index)
		{
			throw new IndexOutOfBoundsException("Index outside list");
		}
		
		// If the index is past the halfway point, start at the end and go backwards. 
		// Otherwise start at the beginning and go forwards.
		
		if(index < (size - 1) / 2)
		{
			//If the index is in the lower half, start at the bottom (at head) and go up
			Node addIndex = head;
			Node addNode = new Node((E) element);
		
			for(int i = 0; i <= index; i++)
				addIndex = addIndex.next;
		
			//Give our new node some links so it fits with the rest
			addNode.next = addIndex;
			addNode.prev = addIndex.prev;
			
			/*
			 * Update the old nodes just before and after it so that they
			 * point to the new node instead of pointing to each other
			 */
			addIndex.prev.next = addNode;
			addIndex.prev = addNode;
		
		}
		else
		{
			Node addIndex = head;
			Node addData = new Node((E) element);
			
			for(int i = size - 1; i >= index; i--)
				addIndex = addIndex.prev;
			
			addData.next = addIndex;
			addData.prev = addIndex.prev;
			addIndex.prev.next = addData;
			addIndex.prev = addData;
		}
		
		size++;
		
	}
	
	/**
	 * A method which returns the first element in the linked list.
	 * 
	 * @return E Object
	 * */

	@Override
	public E getFirst() throws NoSuchElementException 
	{
		if(size == 0)
		{
			throw new NoSuchElementException("Empty Linked List");
		}
		
		return head.next.data;
	}
	
	/**
	 * A method which returns the last element in the linked list.
	 * 
	 * @return E Object
	 * */

	@Override
	public E getLast() throws NoSuchElementException 
	{
		if(size == 0)
		{
			throw new NoSuchElementException("Empty Linked List");
		}
		
		return tail.prev.data;
	}
	
	/**
	 * A method which returns the element at the index specified in the linked list.
	 * 
	 * @param int index
	 * 		The index of the Object being retrieved
	 * 
	 * @return E nodeData
	 * */

	@Override
	public E get(int index) throws IndexOutOfBoundsException 
	{
		if(size <= index || index < 0)
		{
			throw new IndexOutOfBoundsException("Index outside list");
		}
		
		Node indexNode = head;
		
		for(int i = 0; i <= index; i++ )
			indexNode = indexNode.next;
		
		return indexNode.data;
	}
	
	/**
	 * A method which removes the first element of the linked list and 
	 * returns the value of the removed item.
	 * 
	 * @return E nodeData
	 * */

	@Override
	public E removeFirst() throws NoSuchElementException 
	{

		if(size == 0)
		{
			throw new NoSuchElementException("Empty Linked List");
		}
		
		Node removedNode = head.next;
		
		/*
		 * If there's only one item left, act like we're clearing, only
		 * return the removed node's data as well
		 */
		if(size == 1){
			clear();
			return removedNode.data;
		}
		
		head.next.prev = head;
		head.next = head.next.next;
		
		size--;
		
		return removedNode.data;
	}
	
	/**
	 * A method which removes the last element in the linked list and returns the value of the removed item.
	 * 
	 * @return E nodeData
	 * */

	@Override
	public E removeLast() throws NoSuchElementException {
		if(size == 0)
		{
			throw new NoSuchElementException("Empty Linked List");
		}
		
		//The last node in the set is tail's previous
		Node removedNode = tail.prev;
		
		/*
		 * If there's only one item left, do the same thing as if we 
		 * were clearing, only return the removed node's data as well
		 */
		if(size == 1){
			clear();
			return removedNode.data;
		}
		
		//Replace the links for the last element
		tail.prev.next = tail;
		tail.prev = tail.prev.prev;
		
		//Decrement the size so we track that the set has changed
		size--;
		
		return removedNode.data;
	}
	
	/**
	 * A method which removes the object at the specified index and returns the value of the removed item.
	 * 
	 * @param int index
	 * 		- The index of the item being removed
	 * 
	 * @return E nodeData
	 * 
	 * */

	@Override
	public E remove(int index) throws IndexOutOfBoundsException 
	{
		if(index == 0){
			return removeFirst();
		}
		if(size <= index || index < 0)
		{
			throw new IndexOutOfBoundsException("Index outside list");
		}
		
		// If the index is past the halfway point, start at the end and go backwards. 
		// Otherwise start at the beginning and go forwards.
		
		if(index < (size - 1) / 2)
		{
			//Start from the beginning
			Node removeIndex = head;
			
			//Iterate until we find the item at index
			for(int i = 0; i <= index; i++)
				removeIndex = removeIndex.next;
			
			/*
			 * Found it! Save a reference to this item so that we still return 
			 * the right item without messing up its links to next and prev
			 */
			E returnData = removeIndex.data;
		
			removeIndex.prev = removeIndex.prev.next.next;
			removeIndex.next = removeIndex. next.prev.prev;
		
			size--;
		
			return returnData;
		
		} 
		//If the index is in the upper half, start from tail and work your way down
		else 
		{
			//Start from the end
			Node removeIndex = tail;
			
			//Decrement until we get to index
			for(int i = (size - 1); i >= index; i--)
				removeIndex = removeIndex.prev;
			
			/*
			 * Found it! Save a reference to this item so that we still return 
			 * the right item without messing up its links to next and prev
			 */
			E returnData = removeIndex.data;
			
			
			//Update links.
			removeIndex.next.prev = removeIndex.prev;
			removeIndex.prev.next = removeIndex.next;
			
			size--;
			
			return returnData;	
		}
	}
	
	/**
	 * A method which gets the index of element when it first occurs after the head.
	 * 
	 * @return int index of the element
	 * 
	 * */

	@Override
	public int indexOf(Object element) 
	{
		
		//Start at the node just after head and move forward
		Node indexNode = head.next;
		int index = 0;
		
		while(indexNode.data != null  && !indexNode.data.equals(element))
		{
			indexNode = indexNode.next;
			index++;
		}
		
		/*
		 * If we've gotten this far and the element still has not
		 * been found, we'll know because we incremented all the
		 * way to the end of the set, i.e. index == size 
		 */
		if(index == size) return -1;
		
		return index;
	}

	/**
	 * A method which gets the index of element when it first occurs before the tail.
	 * 
	 * @return int index of the element
	 * 
	 * */
	@Override
	public int lastIndexOf(Object element) 
	{
		
		//Start at the item right before tail (since we have no data to look for in tail)
		Node indexNode = tail.prev;
		int index = size - 1;
		
		/*
		 * Keep traversing backwards from tail until we find a 
		 * node with the data we're looking for. Make sure we check
		 * for null data or it'll throw a NullPointerException
		 */
		while(indexNode.data != null && !indexNode.data.equals(element))
		{
			indexNode = indexNode.prev;
			index--;
		}
		
		//Didn't find it, return -1
		if(index < 0) return -1;
		
		return index;
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * A method which returns a boolean representing whether the linked list is empty.
	 * 
	 * @return boolean
	 * 
	 * */
	@Override
	public boolean isEmpty() {
		return head.next == tail && tail.prev == head;
	}

	/**
	 * A method which resets the linked list
	 *  
	 * */
	@Override
	public void clear()
	{
		head.next = tail;
		tail.prev = head;
		
		size = 0;	
	}

	/**
	 * Loop through each element in the linked list and
	 * put it in an array, starting at head + 1;
	 * 
	 * @return returnArr - An array representation of our
	 * data set.
	 */
	@Override
	public Object[] toArray() 
	{
		Object[] returnArr = new Object[size];
		Node indexNode = head;
		
		for(int i = 0; i < size; i++ )
		{
			indexNode = indexNode.next;
			returnArr[i] = indexNode.data;
		}
			
		return returnArr;
	}
	
	/**
	 * This class just holds the data members in our 
	 * LinkedList implementation  
	 */
	private class Node
	{
		
		E data;
		Node next;
		Node prev;
		
		public Node(){}
		
		public Node(E _data)
		{
			data = _data;
		}
	}

}
