package assignment11;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Represents a priority queue of generically-typed items. The queue is implemented as a min heap. The min heap is
 * implemented implicitly as an array.
 * 
 * @author Cameron Pickle
 * @author Daniel Avery
 */
public class PriorityQueue<AnyType> {

	private int currentSize;

	private AnyType[] array;

	private Comparator<? super AnyType> cmp;

	/**
	 * Constructs an empty priority queue. Orders elements according to their natural ordering (i.e., AnyType is
	 * expected to be Comparable) AnyType is not forced to be Comparable.
	 */
	@SuppressWarnings("unchecked")
	public PriorityQueue()
	{
		currentSize = 0;
		cmp = null;
		array = (AnyType[]) new Object[10]; // safe to ignore warning
	}

	/**
	 * Construct an empty priority queue with a specified comparator. Orders elements according to the input
	 * Comparator (i.e., AnyType need not be Comparable).
	 */
	@SuppressWarnings("unchecked")
	public PriorityQueue(Comparator<? super AnyType> c)
	{
		currentSize = 0;
		cmp = c;
		array = (AnyType[]) new Object[10]; // safe to ignore warning
	}

	/**
	 * @return the number of items in this priority queue.
	 */
	public int size()
	{
		return currentSize;
	}

	/**
	 * Makes this priority queue empty.
	 */
	public void clear()
	{
		currentSize = 0;
	}

	/**
	 * @return the minimum item in this priority queue.
	 * @throws NoSuchElementException
	 *                 if this priority queue is empty.
	 * 
	 *                 (Runs in constant time.)
	 */
	public AnyType findMin() throws NoSuchElementException
	{
		if (currentSize == 0)
			throw new NoSuchElementException();
				
		return array[0];
	}

	/**
	 * Removes and returns the minimum item in this priority queue.
	 * 
	 * @throws NoSuchElementException
	 *                 if this priority queue is empty.
	 * 
	 *                 (Runs in logarithmic time.)
	 */
	public AnyType deleteMin() throws NoSuchElementException
	{
		// if the heap is empty, throw a NoSuchElementException
		if(currentSize == 0)
			throw new NoSuchElementException();

		// store the minimum item so that it may be returned at the end
		AnyType min = array[0];
		
		// replace the item at minIndex with the last item in the tree
		array[0] = array[currentSize-1];
		
		// update size
		currentSize--;

		// percolate the item at minIndex down the tree until heap order is restored
		// It is STRONGLY recommended that you write a percolateDown helper method!
		percolateDown();

		// return the minimum item that was stored
		return min;
	}

	/**
	 * Adds an item to this priority queue.
	 * 
	 * (Runs in logarithmic time.) Can sometimes terminate early.
	 * 
	 * @param x
	 *                -- the item to be inserted
	 */
	public void add(AnyType x)
	{
		// if the array is full, double its capacity
		if(currentSize == array.length)
			array = growArray(array);
		
		// add the new item to the next available node in the tree, so that
		// complete tree structure is maintained
		array[currentSize] = x;

		// update size
		currentSize++;
		
		// percolate the new item up the levels of the tree until heap order is restored
		// It is STRONGLY recommended that you write a percolateUp helper method!
		percolateUp();
	}

	/**
	 * Generates a DOT file for visualizing the binary heap.
	 */
	public void generateDotFile(String filename)
	{
		try
		{
			PrintWriter out = new PrintWriter(filename);
			out.println("digraph Heap {\n\tnode [shape=record]\n");

			for (int i = 0; i < currentSize; i++)
			{
				out.println("\tnode" + i + " [label = \"<f0> |<f1> " + array[i]
						+ "|<f2> \"]");
				if (((i * 2) + 1) < currentSize)
					out.println("\tnode" + i + ":f0 -> node" + ((i * 2) + 1)
							+ ":f1");
				if (((i * 2) + 2) < currentSize)
					out.println("\tnode" + i + ":f2 -> node" + ((i * 2) + 2)
							+ ":f1");
			}

			out.println("}");
			out.close();
		} catch (IOException e)
		{
			System.out.println(e);
		}
	}

	/**
	 * Internal method for comparing lhs and rhs using Comparator if provided by the user at construction time, or
	 * Comparable, if no Comparator was provided.
	 */
	@SuppressWarnings("unchecked")
	private int compare(AnyType lhs, AnyType rhs)
	{
		if (cmp == null)
			return ((Comparable<? super AnyType>) lhs).compareTo(rhs); // safe to ignore warning
		// We won't test your code on non-Comparable types if we didn't supply a Comparator

		return cmp.compare(lhs, rhs);
	}

	// LEAVE IN for grading purposes
	public Object[] toArray()
	{
		Object[] ret = new Object[currentSize];
		for (int i = 0; i < currentSize; i++)
			ret[i] = array[i];
		return ret;
	}

	/**
	 * Percolates a given node up to the appropriate height in the tree to meet the order requirement of a min-heap.
	 */
	private void percolateUp()
	{
		int currentPos = currentSize - 1; //Begin at the last position
		
		//Loop as long as the node has a parent, and it is less than that parent
		while(currentPos > 0 && compare(array[currentPos], array[(currentPos-1)/2]) < 0)
		{
			swap(currentPos,(currentPos-1)/2);
			currentPos = (currentPos-1)/2;
		}
		
	}

	/**
	 * Percolates a given node down to the appropriate height in the tree to meet the order requirement of a min-heap.
	 */
	private void percolateDown()
	{
		int currentPos = 0; //Begin at the root
		int childPos = 0; //Placeholder
		
		//Keep looping until a return is hit within the loop
		while(true)
		{
			//If there are no children to compare with, return
			if (currentPos*2 + 1 > currentSize-1)
				return;
			
			//If there is a left child but no right child, see if parent should swap with left child
			if (currentPos*2 + 2 > currentSize-1)
				if(compare(array[currentPos], array[currentPos*2 + 1]) > 0)
					{
						swap(currentPos, currentPos*2 + 1);
						return;
					}
			
			//Now we know there are two children; find out which is smaller
			if (compare(array[currentPos*2 + 1], array[currentPos*2 + 2]) <= 0)
				childPos = currentPos*2 + 1;
			else
				childPos = currentPos*2 + 2;
			
			//See if parent should swap with its smaller child
			if(compare(array[currentPos], array[childPos]) > 0)
			{
				swap(currentPos, childPos);
				currentPos = childPos;
			}			
			else
				return;
		}
	}
	
	/**
	 * Doubles the size of the given array.
	 */
	@SuppressWarnings("unchecked")
	private AnyType[] growArray(AnyType[] list){
		//Copy the values of the current array into a new one with double the capacity
		AnyType[] bigger = (AnyType[]) new Object[2*list.length];
		for(int i = 0; i < list.length; i++)
			bigger[i] = list[i];
		return bigger;
	}
	
	/**
	 * Swaps the two given elements in the array
	 */
	private void swap(int a, int b)
	{
		AnyType temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}