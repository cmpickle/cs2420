package assignment10;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;

/**
 * A hash table that uses quadratic probing and a user specified hash functor.
 * 
 * @author Cameron Pickle
 * @author Daniel Avery
 */
public class QuadProbeHashTable implements Set<String> {

	private String[] storage;
	private HashFunctor functor;
	private int size;
	private int capacity;
	public int collisionCounter;

	/**
	 * Constructs a hash table of the given capacity that uses the hashing function specified by the given functor.
	 */
	public QuadProbeHashTable(int capacity, HashFunctor functor)
	{
		BigInteger number = new BigInteger(capacity+"");
		this.storage = new String[number.nextProbablePrime().intValue()];
		this.functor = functor;
		this.size = 0;
		this.capacity = number.nextProbablePrime().intValue();
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
		//Don't try to add nulls
		if (item == null)
			return false;
		
		//Find the insertion index for the item
		int index = quadProbe(item);
		
		//See if the insertion index is valid
		if (index == -1)
			return false;
		
		//Insert into the insertion index and increment size
		storage[index] = item;
		size++;
		
		//See if the table needs to be rehashed
		if (size > 0.5*capacity)
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
	@Override
	public void clear()
	{
		storage = new String[capacity];
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
		//Nulls are not cool
		if (item == null)
			return false;
		
		//Return true if the item is found in the table
		if (quadProbe(item) == -1)
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
	 * Uses quadratic probing to find the insertion index of the given item. If the item is already in the list,
	 * or is null, returns -1.
	 * 
	 * @param item
	 * 				- the item whose insertion index is to be determined
	 * 
	 * @return -1 if the item exists in the table, or the probe fails; the insertion index otherwise
	 * 
	 */
	private int quadProbe(String item)
	{		
		//Find the hash number for the item
		int index = functor.hash(item);
		
		//Quadratic probing with wrap-around
		for (int i = 0; i < capacity; i++)
		{
			//If the item is in the table, return indicator
			if (storage[(index + i*i) % capacity] == item)
				return -1;
					
			//If an empty spot is found, return that index
			if (storage[(index + i*i) % capacity] == null)
				return (index + i*i) % capacity;
			
			collisionCounter++;
		}
		return -1;//Empty index for insertion is never found
	}
	
	/**
	 * Rehashes the function to a capacity given by the next largest prime after doubling current capacity.
	 */
	private void rehash()
	{
		//Find the appropriate prime number for the new capacity
		BigInteger number = new BigInteger(2*capacity+"");
		int largerCap = number.nextProbablePrime().intValue();
		
		//New hash table to increase storage and add old elements
		QuadProbeHashTable tempTable = new QuadProbeHashTable(largerCap, functor);
		
		//Copy over old elements
		for(int i = 0; i < capacity; i++)
		{
			if (this.storage[i] != null)
			{
				//Find the hash number for the item
				int index = functor.hash(this.storage[i]);

				//Quadratic probing with wrap-around
				for (int j = 0; j < largerCap; j++)
				{
					//Place item in the first empty spot found
					if (tempTable.storage[(index + j*j) % largerCap] == null)
					{
						tempTable.storage[(index + j*j) % largerCap] = this.storage[i];
						tempTable.size++;
						break;
					}
				}
			}
		}
		
		//Save the new storage array as the current one
		this.storage = tempTable.storage;
		this.capacity = largerCap;
	}
}
