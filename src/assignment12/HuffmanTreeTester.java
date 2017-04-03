package assignment12;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A tester class for the HuffmanTree class.
 * 
 * @author Cameron Pickle
 * @author Daniel Avery
 */
public class HuffmanTreeTester {

	HuffmanTree t;

	@Before
	public void setUp() throws Exception
	{
		t = new HuffmanTree();
	}

	@After
	public void tearDown() throws Exception
	{
		t = null;
	}

	/****************************************************************
	 * TEST text files
	 * 
	 * @throws IOException
	 ****************************************************************/
	@Test
	public void testIAmLegentTxt() throws IOException
	{
		t.compressFile(new File("I Am Legend.txt"), new File("IALCompressed.txt"));
		t.decompressFile(new File("IALCompressed.txt"), new File("IAmLegendDecompressed.txt"));

		File f1 = new File("I Am Legend.txt");
		File f2 = new File("IAmLegendDecompressed.txt");
		FileInputStream fi1 = new FileInputStream(f1);
		FileInputStream fi2 = new FileInputStream(f2);
		Scanner sc1 = new Scanner(fi1);
		Scanner sc2 = new Scanner(fi2);
		String str1, str2;
		while (sc1.hasNext() && sc2.hasNext())
		{
			str1 = sc1.next();
			str2 = sc2.next();
			
			assertEquals(str1, str2);
		}
		sc1.close();
		sc2.close();
	}

	@Test
	public void testOriginalTxt() throws FileNotFoundException
	{
		t.compressFile(new File("original.txt"), new File("compressed.txt"));
		t.decompressFile(new File("compressed.txt"), new File("decompressed.txt"));

		File f1 = new File("original.txt");
		File f2 = new File("decompressed.txt");
		FileInputStream fi1 = new FileInputStream(f1);
		FileInputStream fi2 = new FileInputStream(f2);
		Scanner sc1 = new Scanner(fi1);
		Scanner sc2 = new Scanner(fi2);
		String str1, str2;
		while (sc1.hasNext() && sc2.hasNext())
		{
			str1 = sc1.next();
			str2 = sc2.next();
			
			assertEquals(str1, str2);
		}
		sc1.close();
		sc2.close();
	}

	@Test
	public void testDeathTroopersTxt() throws FileNotFoundException
	{
		t.compressFile(new File("Death Troopers.txt"), new File("DTCompressed.txt"));
		t.decompressFile(new File("DTCompressed.txt"), new File("DTDecompressed.txt"));

		File f1 = new File("Death Troopers.txt");
		File f2 = new File("DTDecompressed.txt");
		FileInputStream fi1 = new FileInputStream(f1);
		FileInputStream fi2 = new FileInputStream(f2);
		Scanner sc1 = new Scanner(fi1);
		Scanner sc2 = new Scanner(fi2);
		String str1, str2;
		while (sc1.hasNext() && sc2.hasNext())
		{
			str1 = sc1.next();
			str2 = sc2.next();
			
			assertEquals(str1, str2);
		}
		sc1.close();
		sc2.close();
	}
	
	@Test
	public void testDTxt() throws FileNotFoundException
	{
		t.compressFile(new File("d.txt"), new File("DCompressed.txt"));
		t.decompressFile(new File("DCompressed.txt"), new File("DDecompressed.txt"));

		File f1 = new File("d.txt");
		File f2 = new File("DDecompressed.txt");
		FileInputStream fi1 = new FileInputStream(f1);
		FileInputStream fi2 = new FileInputStream(f2);
		Scanner sc1 = new Scanner(fi1);
		Scanner sc2 = new Scanner(fi2);
		String str1, str2;
		while (sc1.hasNext() && sc2.hasNext())
		{
			str1 = sc1.next();
			str2 = sc2.next();
			
			assertEquals(str1, str2);
		}
		sc1.close();
		sc2.close();
	}
	
	@Test
	public void testBlankTxt() throws FileNotFoundException
	{
		t.compressFile(new File("Blank.txt"), new File("BlankCompressed.txt"));
		t.decompressFile(new File("BlankCompressed.txt"), new File("BlankDecompressed.txt"));

		File f1 = new File("Blank.txt");
		File f2 = new File("BlankDecompressed.txt");
		FileInputStream fi1 = new FileInputStream(f1);
		FileInputStream fi2 = new FileInputStream(f2);
		Scanner sc1 = new Scanner(fi1);
		Scanner sc2 = new Scanner(fi2);
		String str1, str2;
		while (sc1.hasNext() && sc2.hasNext())
		{
			str1 = sc1.next();
			str2 = sc2.next();
			
			assertEquals(str1, str2);
		}
		sc1.close();
		sc2.close();
	}
}
