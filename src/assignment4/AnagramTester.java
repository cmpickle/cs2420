package assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Kyuho Ji & Cameron Pickle
 *
 */
public class AnagramTester 
{

	private static Random rand;
	//private static AnagramComp comp = new AnagramComp(); 
	
	public static void main(String[] args) 
	{
		// Set up the random number generator for the randomString function
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
				
		 //Reads a text file with a single word per line, returns them as an array of Strings
//		String[] words = readFile("sample_word_list.txt");
//		
//		String[] wordsLargestGroup = AnagramUtil.getLargestAnagramGroup(words);
//		
//		for (int i = 0; i < wordsLargestGroup.length; i++)
//		{
//			System.out.println(wordsLargestGroup[i]);
//		}
		
		// Reads a text file with a single word per line, returns them as an array of Strings
		//String[] words2 = readFile("moderate_word_list.txt");
				
//		String[] wordsLargestGroup2 = AnagramUtil.getLargestAnagramGroup("moderate_word_list.txt");
//				
//		for (int i = 0; i < wordsLargestGroup2.length; i++)
//		{
//			System.out.println(wordsLargestGroup2[i]);
//		}
		
		String[] words3 = readFile("sample_word_list.txt");
		
		String[] wordsLargestGroup3 = AnagramUtil.getLargestAnagramGroup(words3);
		
		for (int i = 0; i < wordsLargestGroup3.length; i++)
		{
			System.out.println(wordsLargestGroup3[i]);
		}
				
	}

	// Create a random string [a-z] of specified length
	public static String randomString(int length)
	{
		rand = new Random();
		String retval = "";
		for(int i = 0; i < length; i++)
		{
			// ASCII values a-z,A-Z are contiguous (52 characters)
			retval += (char)('a' + (rand.nextInt(26)));
		}
		return retval;
	}
	
	// Reads words from a file (assumed to contain one word per line)
	// Returns the words as an array of strings.
	public static String[] readFile(String filename)
	{
		ArrayList<String> results = new ArrayList<String>();
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(filename));
			while(input.ready())
			{
				results.add(input.readLine());
			}
			input.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
		String[] retval = new String[1];
		return results.toArray(retval);
	}
}
