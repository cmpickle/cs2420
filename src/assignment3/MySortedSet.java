package assignment3;
/**
 * A set that provides a total ordering on its elements. The elements are
 * ordered using their natural ordering, or by a Comparator provided at sorted
 * set creation time. Thus, all elements inserted into a sorted set must
 * implement the Comparable interface or be accepted by the specified
 * Comparator. The set's iterator will traverse the set in ascending element
 * order.
 * 
 * @author Kyuho Ji & Cameron Pickle
 * 
 * @param <E>
 *            -- the type of elements maintained by this set
 */
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySortedSet<E> implements assignment3.SortedSet<E>{
	
	private Object[] list;
	private int currentPosition;
	private Comparator<? super E> comparator;
	
	/**
	 * Creates a set that already has a natural ordering
	 */
	public MySortedSet() 
	{
		list = new Object[10];
		currentPosition = 0;
		comparator = null;
	}
	
	/**
	 * Creates a set that uses a user specified comparator
	 * 
	 * @param _comparator
	 * 			-- The comparator for the set
	 */
	public MySortedSet(Comparator<? super E> _comparator) 
	{
		list = new Object[10];
		comparator = _comparator;
		currentPosition = 0;
	}
	
	/**
	 * Returns the currentPosition
	 */
	public int getCurrentPosition()
	{
		return currentPosition;
	}
	
	/**
	 * Returns the comparator
	 */
	public Comparator<? super E> getComparator()
	{
		return comparator;
	}

	@Override
	/**
	 * @return The comparator used to order the elements in this set, or null if
	 *         this set uses the natural ordering of its elements (i.e., uses
	 *         Comparable).
	 */
	public Comparator<? super E> comparator() 
	{
		return this.comparator;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * @return the first (lowest, smallest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	public E first() throws NoSuchElementException 
	{
		if (currentPosition == 0)
			throw new NoSuchElementException();
		else
			return (E) list[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * @return the last (highest, largest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	public E last() throws NoSuchElementException 
	{
		if (currentPosition == 0)
			throw new NoSuchElementException();
		else 
			return (E) list[currentPosition - 1];
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Adds the specified element to this set if it is not already present and
	 * not set to null.
	 * 
	 * @param o
	 *            -- element to be added to this set
	 * @return true if this set did not already contain the specified element
	 */
	public boolean add(E o) 
	{
		if (this.contains(o) || o == null)
			return false;
		else 
		{
			
			if (this.list.length == currentPosition) 
			{						//Grows the array if it is too small
				Object[] tempArray = new Object[this.list.length * 2];
				for (int j = 0; j < currentPosition; j++) 
				{
					tempArray[j] = this.list[j];
				}
				this.list = tempArray;
			}
			if (comparator == null) 
			{										//if the set has a natural order:
				Comparable<E> temp = (Comparable<E>) o;
				Object[] newArray = new Object[this.list.length];
				int low = 0;
				int mid = 0;
				int high = currentPosition;
				while(low < high)
				{
					mid = (low + high) / 2;
					if(temp.compareTo((E) this.list[mid]) > 0)
							low = mid + 1;
					else
						high = mid;
				}		
				int inserted = 0;
				for (int i = 0; i <= currentPosition; i++) 
				{
					if(i < low)
						newArray[i] = this.list[i];
					if (i == low)
					{
						newArray[i] = temp;
						inserted = 1;
					}
					
					if(i > low)
					{
						newArray[i] = this.list[i - inserted];		//when new object inserted original list stays on correct number by subtracting 1
					}
				}
				currentPosition++;
				this.list = newArray;
			}
			//comparator is not null
			else
			{
				
				Object[] newArray = new Object[this.list.length];
				int low = 0;
				int mid = 0;
				int high = currentPosition;
				while(low < high)
				{
					mid = (low + high) / 2;
					if(comparator.compare(o, (E) this.list[mid]) > 0)
							low = mid + 1;
					else
						high = mid;
				}		
				int inserted = 0;
				for (int i = 0; i <= currentPosition; i++) 
				{
					if(i < low)
						newArray[i] = this.list[i];
					if (i == low)
					{
						newArray[i] = o;
						currentPosition++;
						inserted = 1;
					}
					
					if(i > low && i < currentPosition)
					{
						newArray[i] = this.list[i - inserted];		//when new object inserted original list stays on correct number by subtracting 1
					}
				}
				this.list = newArray;
			}
			return true;
		}
			
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Adds all of the elements in the specified collection to this set if they
	 * are not already present and not set to null.
	 * 
	 * @param c
	 *            -- collection containing elements to be added to this set
	 * @return true if this set changed as a result of the call
	 */
	public boolean addAll(Collection<? extends E> c) 
	{
		boolean added = false;
		Object[] cArray = c.toArray();
		for (int i = 0; i < c.size(); i++)
		{
			if(added == false)
			{
				added = this.add((E) cArray[i]);
			}
			else
			{
				this.add((E) cArray[i]);
			}
		}
		return added;
	}

	@Override
	/**
	 * Removes all of the elements from this set. The set will be empty after
	 * this call returns.
	 */
	public void clear() 
	{
		for (int i = 0; i < currentPosition; i++) 
		{
			list[i] = null;
		}		
		currentPosition = 0;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * @param o
	 *            -- element whose presence in this set is to be tested
	 * @return true if this set contains the specified element
	 */
	public boolean contains(Object o) 
	{
		int low = 0;
		int mid = 0;
		int high = currentPosition;
		Comparator cmp = this.comparator();
		while(low < high)
		{
			mid = (low + high) / 2;
			if(comparator == null)
			{
				if(((Comparable<E>) o).compareTo((E) this.list[mid]) > 0)
						low = mid + 1;
				else if (((Comparable<E>) o).compareTo((E) this.list[mid]) == 0)
					return true;
				else
					high = mid;
			}
			else
			{
				if (cmp.compare(o, this.list[mid]) > 0)
					low = mid + 1;
				else if (cmp.compare(o, this.list[mid]) == 0)
					return true;
				else
					high = mid;
			}
		}
		return false;
	}

	@Override
	/**
	 * @param c
	 *            -- collection to be checked for containment in this set
	 * @return true if this set contains all of the elements of the specified
	 *         collection
	 */
	public boolean containsAll(Collection<?> c) 
	{
		Object[] temp = c.toArray();
		for (int i = 0; i < c.size(); i++) 
		{
			if (!this.contains(temp[i])) 
			{
				return false;
			}
		}
		return true;		
	}

	@Override
	/**
	 * @return true if this set contains no elements
	 */
	public boolean isEmpty() 
	{
		if (this.currentPosition == 0)
			return true;
		else
			return false;
	}

	@Override
	/**
	 * @return an iterator over the elements in this set, where the elements are
	 *         returned in sorted (ascending) order
	 */
	public Iterator<E> iterator() 
	{
		return new MyIterator(); 
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Removes the specified element from this set if it is present.
	 * 
	 * @param o
	 *            -- object to be removed from this set, if present
	 * @return true if this set contained the specified element
	 */
	public boolean remove(Object o) 
	{
		if (!this.contains(o))
			return false;
		else 
		{
			if (comparator == null) 
			{										//if the set has a natural order:
				Comparable<E> temp = (Comparable<E>) o;
				Object[] newArray = new Object[this.list.length];
				int low = 0;
				int mid = 0;
				int high = currentPosition;
				while(low < high)
				{
					mid = (low + high) / 2;
					if(temp.compareTo((E) this.list[mid]) > 0)
							low = mid + 1;
					else
						high = mid;
				}		
				int removed = 0;
				for (int i = 0; i <= currentPosition; i++) 
				{
					if(i < low)
						newArray[i] = this.list[i];
					if (i == low)
					{
						currentPosition--;
						removed = 1;
						newArray[i] = this.list[i + removed];
					}
					
					if(i > low)
					{
						newArray[i] = this.list[i + removed];		//when new object inserted original list stays on correct number by subtracting 1
					}
				}
				this.list = newArray;
			}
			//comparator is not null
			else
			{
				
				Object[] newArray = new Object[this.list.length];
				int low = 0;
				int mid = 0;
				int high = currentPosition;
				while(low < high)
				{
					mid = (low + high) / 2;
					if(comparator.compare((E) o,(E) this.list[mid]) > 0)
							low = mid + 1;
					else
						high = mid;
				}		
				int removed = 0;
				for (int i = 0; i <= currentPosition; i++) 
				{
					if(i < high)
						newArray[i] = this.list[i];
					if (i == high)
					{
						currentPosition--;
						removed = 1;
						newArray[i] = this.list[i + removed];
					}
					
					if(i > high)
					{
						newArray[i] = this.list[i + removed];		//when new object inserted original list stays on correct number by subtracting 1
					}
				}
				this.list = newArray;
			}
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Removes from this set all of its elements that are contained in the
	 * specified collection.
	 * 
	 * @param c
	 *            -- collection containing elements to be removed from this set
	 * @return true if this set changed as a result of the call
	 */
	public boolean removeAll(Collection<?> c) 
	{
		boolean removed = false;
		Object[] cArray = c.toArray();
		for (int i = 0; i < c.size(); i++)
		{
			if(removed == false)
			{
				removed = this.remove((E) cArray[i]);
			}
			else
			{
				this.remove((E) cArray[i]);
			}
		}
		return removed;
	}

	@Override
	/**
	 * @return the number of elements in this set
	 */
	public int size() 
	{
		return this.currentPosition;
	}

	@Override
	/**
	 * @return an array containing all of the elements in this set, in sorted
	 *         (ascending) order.
	 */
	public Object[] toArray() 
	{
		return this.list;
	}
	
	/**
	 * An iterator to move through the sorted set and remove items
	 * 
	 *
	 */
	public class MyIterator implements Iterator<E>
	{
		int index;
		boolean gotNext;
		
		public MyIterator()
		{
			index = -1;
			gotNext = false;
		}

		@Override
		/**
		 * Returns a boolean stating if there is a next element
		 */
		public boolean hasNext() 
		{
			if (index + 1 < currentPosition) 
			{
				return true;
			}
			else
				return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		/**
		 * Returns the next element
		 */
		public E next() 
		{
			index++;
			if (index >= currentPosition)
				throw new NoSuchElementException();
			else
			{
				gotNext = true;
				return (E) list[index];
			}
		}

		@Override
		/**
		 * Removes the last item that was iterated by the iterator
		 */
		public void remove() 
		{
			if(gotNext)
			{
				MySortedSet.this.remove(list[index]);
				gotNext = false;
				index--;
			}
			else
				throw new IllegalStateException();
		}
	}

}
