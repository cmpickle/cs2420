package assignment10;

/**
 *  A hash table that uses chaining in linked lists when collisions occur and a user specified hash functor.
 * @author Cameron Pickle
 * @author Daniel Avery
 */
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class ChainingHashTable implements Set<String> {

	public LinkedList<String>[] storage;
	private HashFunctor functor;
	private int size;
	private int capacity;
	public int collisionCounter;

	@SuppressWarnings("unchecked")
	public ChainingHashTable(int capacity, HashFunctor functor)
	{
		//Make the array of linked lists and initialize each list
		storage = (LinkedList<String>[]) new LinkedList[capacity];
		for (int i = 0; i < capacity; i++)
			storage[i] = new LinkedList<String>();
		
		this.functor = functor;
		this.size = 0;
		this.capacity = capacity;
		this.collisionCounter = 0;
	}

	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item
	 *                - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if the input item was actually
	 *         inserted); otherwise, returns false
	 */
	@Override
	public boolean add(String item)
	{
		int index = functor.hash(item) % capacity;

		//Increment the collision counter if there is something in the linked list already
		if(!storage[index].isEmpty())
			collisionCounter++;
		
		//Check the linked list at this hash number for the item
		if(storage[index].contains(item))
			return false;

		//If we got here, add the item to the linked list at its hash number
		storage[index].addLast(item);
		size++;
		
		//See if the table needs to be rehashed
		if(size > 0.75*capacity)
			rehash();
		
		return true;
	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items
	 *                - the collection of items whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if any item in the input
	 *         collection was actually inserted); otherwise, returns false
	 */
	@Override
	public boolean addAll(Collection<? extends String> items)
	{
		//Obtain size before attempted adding
		int temp = size;
				
		//Use the collection iterator to try adding each of its elements
		Iterator<? extends String> iterator = items.iterator();
				
		while(iterator.hasNext())
			this.add(iterator.next());
				
		//If size has increased, data was added
		if(size > temp)
			return true;
		return false;
	}

	/**
	 * Removes all items from this set. The set will be empty after this method call.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear()
	{
		storage = (LinkedList<String>[]) new LinkedList[capacity];
		size = 0;
	}

	/**
	 * Determines if there is an item in this set that is equal to the specified item.
	 * 
	 * @param item
	 *                - the item sought in this set
	 * @return true if there is an item in this set that is equal to the input item; otherwise, returns false
	 */
	@Override
	public boolean contains(String item)
	{
		int index = functor.hash(item) % capacity;

		//Check the linked list at this hash number for the item
		if (storage[index].contains(item))
			return true;

		return false;
	}

	/**
	 * Determines if for each item in the specified collection, there is an item in this set that is equal to it.
	 * 
	 * @param items
	 *                - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an item in this set that is equal to it;
	 *         otherwise, returns false
	 */
	@Override
	public boolean containsAll(Collection<? extends String> items)
	{
		//Use the collection iterator to check the table for each of its elements; if any are missing, return false
		Iterator<? extends String> iterator = items.iterator();
				
		while(iterator.hasNext())
			if(!this.contains(iterator.next()))
				return false;
				
		return true;
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty()
	{
		return this.size == 0;
	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size()
	{
		return this.size;
	}

	/**
	 * Rehashes the function and increases the size to the next largest prime.
	 */
	 private void rehash()
	 {
		BigInteger number = new BigInteger(2*capacity+"");
			
		int largerCap = number.nextProbablePrime().intValue();
			
			//New hash table to increase storage and add old elements
			ChainingHashTable tempTable = new ChainingHashTable(largerCap, functor);
			
			//Copy over old elements
			for(int i = 0; i < capacity; i++)
			{
				if (!this.storage[i].isEmpty())
				{
					for(int j = 0; j < storage[i].size(); j++)
					{
						//Find the hash number for the item
						int index = functor.hash(this.storage[i].get(j)) % largerCap;

						tempTable.storage[index].addLast(this.storage[i].get(j));
						tempTable.size++;
					}
				}
			}
			
			//Save the new storage array as the current one
			this.storage = tempTable.storage;
			this.capacity = largerCap;
	 }
}
