package assignment5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * 
 * @author Skyler Jayson & Cameron Pickle
 * @param <T>
 *
 */

public class SortUtil<T> 
{

	private static Random rand;
	private static int threshold = 10;
	/*
	 * Our three Pivot options:
	 * 1 Use the object located at the center of the array as the pivot (call no method)
	 * 2 Take a median of the first, middle, and last values (chooseMedianOfThreePivot method)
	 * 3 Choose a random object int the array as the pivot (chooseRandomPivot method)
	 */
	private static int pivotChoice = 1;

	/**
	 * Driver method
	 * @return 
	 */
	public static <T> void mergesort (ArrayList<T> arr, Comparator<? super T> comp)
	{
		ArrayList<T> temp = new ArrayList<T>();
		for (int i = 0; i < arr.size(); i++)
		{
			temp.add(arr.get(i));
		}
		mergesort(arr, temp,  0, arr.size() -1, comp);
	}
	
	/**
	 * Performs mergesort on the given array arr using the provieded comparator comp.
	 * @param arr
	 * @param comp
	 */
	private static <T> void mergesort(ArrayList<T> arr, ArrayList<T> temp, int lowerIndex, int lastItemIndex, Comparator<? super T> comp)
	{
		if (lastItemIndex-lowerIndex < threshold)
			insertionSort(arr, lowerIndex, lastItemIndex, comp);
		if (lowerIndex < lastItemIndex)
		{
		int middle = (lastItemIndex + lowerIndex) / 2;
		//Sort left half
		mergesort(arr, temp, lowerIndex, middle, comp);
		//Sort right half
		mergesort(arr, temp, middle+1, lastItemIndex, comp);
		//Merge them
		merge(arr, temp, lowerIndex, middle+1, lastItemIndex, comp);
		}	
	}
	
	/**
	 * Merges two sorted arrays
	 * @param arr
	 * @param temp
	 * @param lowerIndexCursor
	 * @param higherIndex
	 * @param lastItemIndex
	 * @param comp
	 */
	private static <T> void merge(ArrayList<T> arr, ArrayList<T> temp, int lowerIndexCursor, int higherIndex, int lastItemIndex, Comparator<? super T> comp)
	{	
		int tempIndex = 0;
		int lowerIndex = lowerIndexCursor;
		int midIndex = higherIndex - 1;
		int totalItems = lastItemIndex-lowerIndex+1;
		while (lowerIndex <= midIndex && higherIndex <= lastItemIndex)
		{
			if(comp.compare(arr.get(lowerIndex), arr.get(higherIndex)) <= 0)
			{
				temp.set(tempIndex, arr.get(lowerIndex));
				lowerIndex++;
			}
			else
			{
				temp.set(tempIndex, arr.get(higherIndex));
				higherIndex++;
			}
			tempIndex++;
		}
		
		//copy left over remaining variables
		while (lowerIndex <= midIndex)
		{
			temp.set(tempIndex, arr.get(lowerIndex));
			lowerIndex++;
			tempIndex++;
		}
		
		while (higherIndex <= lastItemIndex)
		{
			temp.set(tempIndex, arr.get(higherIndex));
			higherIndex++;
			tempIndex++;
		}
		
		for (int i =0; i<totalItems; i++) 
		{
			arr.set(lowerIndexCursor+i, temp.get(i));
		}
	}
	
	/**
	 * Sort bounded array with insertion sort
	 * @param arr
	 * @param lowerIndex
	 * @param lastItemIndex
	 * @param comp
	 */
	private static <T> void insertionSort (ArrayList<T> arr, int lowerIndex, int lastItemIndex, Comparator<? super T> comp)
	{
		for (int i = lowerIndex; i < lastItemIndex + 1; i++)
		{
			T next = arr.get(i);
			int j = i;
			while (j > 0 && comp.compare(arr.get(j - 1), next) > 0)
			{
				arr.set(j, arr.get(j-1));
				j--;
			}
			arr.set(j, next);
		}
	}
	
	/**
	 * Performs quicksort on the given array arr using the provided comparator comp.
	 * @param arr
	 * @param comp
	 */
	public static <T> void quicksort(ArrayList<T> arr, Comparator<? super T> comp)
	{
		int indexLower = 0;
		int indexUpper = arr.size() - 1;
		quickSort(arr, indexLower, indexUpper, comp);
	}
	
	/**
	 * The recursive call for quicksort to compare the indexes above and below the pivot
	 * @param arr
	 * @param indexLower
	 * @param indexUpper
	 * @param comp
	 */
	private static <T> void quickSort(ArrayList<T> arr, int indexLower, int indexUpper, Comparator<? super T> comp)
	{
		// arrays of size 1 are already sorted
		if(indexLower >= indexUpper)
			return;
		T pivot = pivot(arr, indexLower, indexUpper, comp);
		int partition = partition(arr, comp, indexLower, indexUpper, pivot);
		if (partition-1 != indexUpper)
		quickSort(arr, indexLower, partition, comp);
		quickSort(arr, partition+1, indexUpper, comp);
	}
	
	/**
	 * Selects the pivot for quicksort and swaps it to the right side of the array
	 * @param arr
	 * @param indexLower
	 * @param indexUpper
	 * @param comp
	 * @return
	 */
	private static <T> T pivot(ArrayList<T> arr, int indexLower, int indexUpper, Comparator<? super T> comp)
	{
		int center = (indexLower + indexUpper)/2;
		
		if (pivotChoice == 2)
			chooseMedianOfThreePivot(arr, indexLower, center, indexUpper, comp);
		if (pivotChoice == 3)
			chooseRandomPivot(arr, indexLower, center, indexUpper);
 
        swap(arr, center, indexUpper); //positions the pivot to the right of the array

		return arr.get(indexUpper);
	}
	
	/**
	 * Sorts the first, middle, and last elements and sets the middle value as the pivot
	 * @param arr
	 * @param indexLower
	 * @param center
	 * @param indexUpper
	 * @param comp
	 */
	private static <T> void chooseMedianOfThreePivot(ArrayList<T> arr, int indexLower, int center, int indexUpper, Comparator<? super T> comp)
	{
		  if(comp.compare(arr.get(indexLower), arr.get(center)) > 0)
	            swap(arr, indexLower,center);
	         
	      if(comp.compare(arr.get(indexLower), arr.get(indexUpper)) > 0)
	            swap(arr, indexLower, indexUpper);
	         
	      if(comp.compare(arr.get(center), arr.get(indexUpper)) > 0)
	            swap(arr, center, indexUpper);
	}
	
	/**
	 * Selects a random object in the array to be the pivot
	 * @param arr
	 * @param indexLower
	 * @param center
	 * @param indexUpper
	 */
	private static <T> void chooseRandomPivot(ArrayList<T> arr, int indexLower, int center, int indexUpper)
	{
		Random rand = new Random();
		//Generate a random index
		int randomIndex = rand.nextInt(indexUpper - indexLower) + indexLower;
		//Swap the random indexed item with the middle item
		swap(arr, center, randomIndex);
	}
	
	/**
	 * Partitions the array and swaps values that are on the wrong side of the pivot
	 * @param arr
	 * @param comp
	 * @param indexLower
	 * @param indexUpper
	 * @param pivot
	 * @return
	 */
	private static <T> int partition(ArrayList<T> arr, Comparator<? super T> comp, int indexLower, int indexUpper, T pivot)
	{
		int leftCursor = indexLower - 1;
		int rightCursor = indexUpper;
		while (leftCursor < rightCursor)
		{
			while (comp.compare(arr.get(++leftCursor), pivot) < 0 );
			
				while (rightCursor > 0 && comp.compare(arr.get(--rightCursor), pivot) > 0);
				
					if (leftCursor >= rightCursor)
						break;
					else
						swap(arr, leftCursor, rightCursor);
				
			
		}
		swap(arr, leftCursor, indexUpper);
		return leftCursor;
	}
	
	/**
	 * Swaps the two inputed parameter values of the inputed array
	 * @param arr
	 * @param left
	 * @param right
	 */
	private static <T> void swap(ArrayList<T> arr, int left, int right)
	{
		T temp = arr.get(left);
		arr.set(left, arr.get(right));
		arr.set(right, temp);
	}
	
	/**
	 * This method generates and returns an ArrayList of integers 1 to size in ascending order.
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateBestCase(int size)
	{	
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 1; i <= size; i++)
		{
			ints.add(i);
		}
		return ints;
	}
	
	/**
	 * This method generates and returns an ArrayList of integers 1 to size in permuted order 
	 * (i,e., randomly ordered). See lecture 10 slides and code demo for info on permuting a list.
	 * @param size
	 * 		size of the array list
	 * @return
	 * 		--An array list of random integers of size size. 
	 */
	public static ArrayList<Integer> generateAverageCase(int size)
	{
		rand = new Random();
		rand.setSeed(2420L);
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 1; i <= size; i++)
		{
			ints.add(rand.nextInt(size) + 1);
		}
		return ints;
	}
	
	
	/**
	 * This method generates and returns an ArrayList of integers 1 to size in descending order.
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateWorstCase(int size)
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = size; i > 0; i--)
		{
			ints.add(i);
		}
		return ints;
	}
	
	/**
	 * Returns threshold
	 */
	public static int getTheshold()
	{
		return threshold;
	}
	
	/**
	 * Sets the value of threshold to value
	 */
	public static void setThreshold (int value)
	{
		threshold = value;
	}
	
	/**
	 * Returns pivotChoice
	 */
	public static int getPivotChoice()
	{
		return pivotChoice;
	}
	
	/**
	 * Sets pivotChoice to value
	 */
	public static void setPivotChoice (int value)
	{
		if (value == 1 || value == 2 || value == 3)
		{
			pivotChoice = value;
		}
	}
}
