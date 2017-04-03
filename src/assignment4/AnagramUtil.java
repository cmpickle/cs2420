package assignment4;

import java.util.Comparator;

/**
 * 
 * @author Kyuho Ji & Cameron Pickle
 *
 */
public class AnagramUtil 
{	
	/**
	 * Returns the sorted version of the input string.
	 */
	public static String sort(String s)
	{
		char[] new1 = new char[s.length()];
		if(s.length() == 0)
			return s;
		new1[0] = s.charAt(0);
		int filled1 = 1;
		
		//Goes through every letter in String
		for (int i = 1;  i < s.length(); i++)
		{
			//Goes through the new1 array
			boolean valueInserted = false;
			for(int j = 0; j < new1.length - 1; j++)
			{
				//If the next letter in the word goes before
				if(s.charAt(i) < new1[j])
				{
					//Sort new1 array
					for (int k = filled1; k > j; k--)
						new1[k] = new1[k - 1];
					new1[j] = s.charAt(i);
					filled1++;
					valueInserted = true;
					break;
				}
			}
			if(!valueInserted)
			{
				new1[filled1] = s.charAt(i);
				filled1++;
			}
				
		}
		String newS = "";
		for (int i = 0; i < new1.length; i++)
		{
			newS += new1[i];
		}
		s = newS;
		return s;		
	}
	
	/**
	 * Sorts the input array using an insertion sort and the input Comparator object
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> comp)
	{
		for (int i = 1; i < arr.length; i++)
		{
			T indexValue = arr[i];
			int j = i;
			//if the value in arr should go before the value in temp
			while (j > 0)
			{
				if (comp.compare(arr[j -1], indexValue) > 0)
				{
					for (int k = i; k>j; k--)
					{
						arr[k] = arr[k-1];
					}
					arr[j] = indexValue;
					break;
				}
				j--;
			}
		}
	}
	
	
	/**
	 * Returns true if the two input strings are anagrams of each other, otherwise
	 * returns false
	 */
	public static boolean areAnagrams(String s1, String s2)
	{
		if(sort(s1.toLowerCase()).equals(sort(s2.toLowerCase())))
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the largest group of anagrams in arr, in no particular
	 * order. It returns an empty array if there are no anagrams in arr.
	 */
	public static String[] getLargestAnagramGroup(String[] arr)
	{
		int largestAnagramGroup = 0;
		int tempGroupSize = 1;
		int indexOfTheAnagram = 0;
		int tempIndexOfTheAnagram = 0;
		
		AnagramComp comp = new AnagramComp();
		AnagramUtil.insertionSort(arr, comp);
		//Used for timing experiment
		//Arrays.sort(arr, comp);
		
		for (int i = 0; i < arr.length - 1; i++)
		{
			//Are anagrams of each other
			if (comp.compare(arr[i], arr[i + 1]) > 0)
			{
				tempGroupSize++;
			}
			else
			{
				if (tempGroupSize > largestAnagramGroup)
				{
					largestAnagramGroup = tempGroupSize;
					indexOfTheAnagram = tempIndexOfTheAnagram;
				}
				tempIndexOfTheAnagram = i + 1;
				tempGroupSize = 1;
			}
		}
		if (largestAnagramGroup == 0)
			largestAnagramGroup = tempGroupSize;
		
		String[] temp = new String[largestAnagramGroup];
		for (int i = 0; i < largestAnagramGroup; i++)
		{
			temp[i] = arr[i + indexOfTheAnagram];
		}
		
		//If there are no anagrams returns an empty array size 0
		if (temp.length <= 1)
		{
			return new String[0];
		}
		return temp;
	}
	
	/**
	 * Returns the largest group of anagrams in the file. If the file does
	 * no exist or is empty, returns an empty array.
	 * @param filename: Assumed to have at least one word per line
	 */
	public static String[] getLargestAnagramGroup(String filename)
	{
		String[] file = AnagramTester.readFile(filename);
		file = AnagramUtil.getLargestAnagramGroup(file);
		return file;
	}

}
