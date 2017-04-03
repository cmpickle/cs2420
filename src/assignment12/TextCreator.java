package assignment12;

/**
 * A class to auto-generate text files of chars for testing purposes.
 * 
 * @author Cameron Pickle
 * @author Daniel Avery
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextCreator {
	
	public static int size = 10000;

	public static void main(String[] args)
	{
		//Prints out ten text documents that change the number of unique chars outputted while maintaining frequency of 10000 chars each
		char[] chars = {'a','b','c','d','e','f','g','h','i','j'};
		//Write ten files; first will have 10000 a's, next will have 10000 a's and 10000 b's, and so on
		for (int i = 0; i < 10; i++)
		{
			String characters = "";
			for (int j = 0; j < size + (size * i); j++)
				characters += chars[j%(i+1)];
			writeFile(i+"TestFile.txt", characters);
		}
		
		//Prints out six text documents that change the frequency of the outputted chars while maintaing file size
		char[] chars2 = {'a','b'};
		//Write six files, ranging from an even split of the two characters to all one character
		// -- First file will have 5000 a's 5000 b's, then 6000 a's 4000 b's, and so on
		for (int i = 5; i >= 0; i--)
		{
			int cap = size - (1000*i);
			String characters = "";
			for (int j = 0; j < cap; j++)
				characters += chars2[0];
			for (int j = 0; j < size - cap; j++)
				characters += chars2[1];
			writeFile(i+10+"TestFile.txt", characters);
		}
				
	}
	
	/**
	 * Writes a text file named @param filename with the String content @param output.
	 * 
	 * @param filename
	 * @param output
	 */
	public static void writeFile(String filename, String output)
	{
		try
		{
			File fileOut = new File(filename);

			// if file doesn't exists, then create it
			if (!fileOut.exists())
			{
				fileOut.createNewFile();
			}

			FileWriter fw = new FileWriter(fileOut.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(output);
			bw.close();

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("Done");
	}
}
