package assignment6;
/**
 * @author Cameron Pickle
 */

import java.util.NoSuchElementException;


public class MyLinkedList<E> implements List<E> {
	private int size = 0;
	private MyNode<? super E> head = null;
	private MyNode<? super E> tail = null;
	
	/**
	 * Creates a linked list
	 */
	public MyLinkedList() 
	{
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Inserts the specified element at the beginning of the list.
	 * O(1) for a doubly-linked list.
	 */
	public void addFirst(E element) {
		MyNode temp = new MyNode(element, head);
		temp.setPrevious(null);
		if(head != null)
			head.setPrevious(temp);
		head = temp;
		if(tail == null)
			tail = temp;
		size++;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Inserts the specified element at the end of the list.
	 * O(1) for a doubly-linked list.
	 */
	public void addLast(E o) {
		MyNode temp = new MyNode(o, null);
		temp.setPrevious(tail);
		if(tail != null)
			tail.setNext(temp);
		tail=temp;
		if(head==null)
			head=temp;
		size++;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    /**
	 * Inserts the specified element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range (index < 0 || index > size())
	 * O(N) for a doubly-linked list.
	 */
	public void add(int index, E element) throws IndexOutOfBoundsException {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException();
		else if (size == 0)
		{
			this.addFirst(element);
			return;
		}
		
		int count = 0;
		MyNode<? super E> nextNode = head;
		while (index > count)
		{
			nextNode = nextNode.getNext();
			count++;
		}
		MyNode temp = new MyNode(element, nextNode);
		temp.setPrevious(nextNode.getPrevious());
		if(index != 0)
			nextNode.getPrevious().setNext(temp);
		if(index < size - 1)
			nextNode.getNext().setPrevious(temp);
		if(head != null && index == 0)
			head.setPrevious(temp);
		if(index == 0)
			head = temp;
		if(tail == null)
			tail = temp;
		size++;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Returns the first element in the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 */
	public E getFirst() throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException();
		return (E) head.getElement();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Returns the last element in the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 */
	public E getLast() throws NoSuchElementException {
		if (tail == null)
			throw new NoSuchElementException();
		return (E) tail.getElement();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Returns the element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 * O(N) for a doubly-linked list.
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		if (index > size)
			throw new IndexOutOfBoundsException();
		int count = 0;
		MyNode<? super E> temp = head;
		while (index > count)
		{
			count++;
			temp = temp.getNext();			
		}
		return (E) temp.getElement();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Removes and returns the first element from the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 */
	public E removeFirst() throws NoSuchElementException {
		if(size == 0)
			throw new NoSuchElementException();
		MyNode temp = new MyNode(head, null);
		head = head.getNext();
		size--;
		return (E) temp.getElement();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Removes and returns the last element from the list.
	 * Throws NoSuchElementException if the list is empty.
	 * O(1) for a doubly-linked list.
	 */
	public E removeLast() throws NoSuchElementException {
		if(size == 0)
			throw new NoSuchElementException();
		MyNode temp = new MyNode(tail, null);
		tail = tail.getPrevious();
		size--;
		return (E) temp.getElement();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	/**
	 * Removes and returns the element at the specified position in the list.
	 * Throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 * O(N) for a doubly-linked list.
	 */
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException();
		
		int count = 0;
		MyNode<? super E> nextNode = head;
		while (index > count)
		{
			nextNode = nextNode.getNext();
			count++;
		}
		MyNode tempNext = nextNode.getNext();
		MyNode tempPrevious = nextNode.getPrevious();
		if(index != 0)
			nextNode.getPrevious().setNext(tempNext);
		if(index < size - 1)
			nextNode.getNext().setPrevious(tempPrevious);
		
		if(head != null && index == 0)
			head=tempNext;
		if(tail != null && index == size-1)
			tail = tempPrevious;
		size--;
		return (E) nextNode.getElement();
	}

	@Override
	/**
	 * Returns the index of the first occurrence of the specified element in the list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a doubly-linked list.
	 */
	public int indexOf(E element) {
		int count = 0;
		MyNode<? super E> temp = head;
		if(temp.getElement().equals(element))
			return count;
		while (count<size-1)
		{
			count++;
			temp = temp.getNext();		
			if(temp.getElement().equals(element))
				break;
		}
		if(count>=size-1)
			return -1;
		else
			return count;
	}

	@Override
	/**
	 * Returns the index of the last occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a doubly-linked list.
	 */
	public int lastIndexOf(E element) {
		int count = 0;
		MyNode<? super E> temp = tail;
		if(temp.getElement().equals(element))
			return size-1 - count;
		while (count<size-1)
		{
			count++;
			temp = temp.getPrevious();		
			if(temp.getElement().equals(element))
				break;
		}
		if(count>=size-1)
			return -1;
		else
			return size-1 - count;
	}

	@Override
	/**
	 * Returns the number of elements in this list.
	 * O(1) for a doubly-linked list.
	 */
	public int size() {
		return size;
	}

	@Override
	/**
	 * Returns true if this collection contains no elements.
	 * O(1) for a doubly-linked list.
	 */
	public boolean isEmpty() {
		if(head == null && tail == null)
			return true;
		return false;
	}

	@Override
	/**
	 * Removes all of the elements from this list.
	 * O(1) for a doubly-linked list.
	 */
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	/**
	 * Returns an array containing all of the elements in this list in proper sequence 
	 * (from first to last element).
	 * O(N) for a doubly-linked list.
	 */
	public Object[] toArray() {
		Object[] tempArray = new Object[size];
		MyNode<? super E> temp = head;
		int count = 0;
		while (count<size)
		{
			tempArray[count] = temp.getElement();
			count++;
			temp = temp.getNext();		
		}
		return tempArray;
	}
}

/**
 * A helper class that creates nodes to form a linked list
 * @param <E>
 */
class MyNode<E>
{
	private E data;
	private MyNode<? super E> next;
	private MyNode<? super E> previous;
	
	/**
	 * creates a node with a reference to a previous and following node
	 * @param element
	 *      -- data stored in the node
	 * @param _next
	 * 		-- the next node in the linked list
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MyNode(E element, MyNode _next)
	{
		this.data = element;
		this.next = _next;
	}
	
	/**
	 * set the node that should follow this node
	 * @param _next
	 */
	public void setNext(MyNode<? super E> _next)
	{
		this.next = _next;
		//this.next = _next;
	}
	
	/**
	 * set the node that should be before this one
	 * @param _previous
	 */
	public void setPrevious(MyNode<? super E> _previous)
	{
		this.previous = _previous;
		//this.previous = _previous;
	}
	
	/**
	 * set the data value for the node
	 * @param element
	 */
	public void setElement(E element)
	{
		this.data = element;
	}
	
	/**
	 * get the next node in the linked list
	 * @return
	 */
	public MyNode<? super E> getNext()
	{
		return this.next;
	}
	
	/**
	 * get the previous node in the linked list
	 * @return
	 */
	public MyNode<? super E> getPrevious()
	{
		return this.previous;
	}
	
	/**
	 * return the data of this node
	 * @return
	 */
	public E getElement()
	{
		return this.data;
	}
}