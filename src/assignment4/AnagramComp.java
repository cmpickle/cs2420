package assignment4;

import java.util.Comparator;

/**
 * 
 * @author Kyuho Ji & Cameron Pickle
 *
 */
public class AnagramComp implements Comparator<String>
{

	/**
	 * Compares two strings based on anagram preference.
	 * Returns a negative number if they are not an anagram, positive if they are.
	 */
	@Override
	public int compare(String s1, String s2) 
	{
		if((s1.length() == 0 && s2.length() != 0) || (s1.length() != 0 && s2.length() == 0))
			return -1;
		if(s1.length() == 0 && s2.length() == 0)
			return 1;
		String temp1 = s1.toLowerCase();
		String temp2 = s2.toLowerCase();
		char[] new1 = new char[temp1.length()];
		char[] new2 = new char[temp2.length()];
		new1[0] = temp1.charAt(0);
		new2[0] = temp2.charAt(0);
		int filled1 = 1;
		int filled2 = 1;
		
		//Goes through temp1 letters
		for (int i = 1;  i < temp1.length(); i++)
		{
			//Goes through the new1 array
			boolean valueInserted = false;
			for(int j = 0; j < new1.length - 1; j++)
			{
				//If the next letter in the word goes before
				if(temp1.charAt(i) < new1[j])
				{
					//Sort new1 array
					for (int k = filled1; k > j; k--)
						new1[k] = new1[k - 1];
					new1[j] = temp1.charAt(i);
					filled1++;
					valueInserted = true;
					break;
				}
			}
			if(!valueInserted)
			{
				new1[filled1] = temp1.charAt(i);
				filled1++;
			}
				
		}
		//For the second word
		
		for (int i = 1;  i < temp2.length(); i++)
		{
			boolean valueInserted = false;
			for(int j = 0; j < new2.length - 1; j++)
			{
				if(temp2.charAt(i) < new2[j])
				{
					for (int k = filled2; k > j; k--)
						new2[k] = new2[k - 1];
					new2[j] = temp2.charAt(i);
					filled2++;
					valueInserted = true;
					break;
				}
				
			}
			if(!valueInserted)
			{
				new2[filled2] = temp2.charAt(i);
				filled2++;
			}
			
		}
		//Turn the arrays back into strings to compare each other
		String ana1 = "";
		String ana2 = "";
		for (int i = 0; i < new1.length; i++)
		{
			ana1 += new1[i];
		}
		for (int i = 0; i < new2.length; i++)
		{
			ana2 += new2[i];
		}
		if (ana1.equals(ana2))
			return 1;
		else
			return -1;
	}

}
