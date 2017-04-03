package assignment5;
/**
 * @author Skyler Jayson & Cameron Pickle
 */

import static org.junit.Assert.*;
/**
 * @author Skyler Jayson & Cameron Pickle
 */
import java.util.ArrayList;
import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortUtilTester 
{

	@Before
	public void setUp() throws Exception 
	{
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void testGenerateBestCase1() 
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		assertEquals(ints, SortUtil.generateBestCase(0));
	}

	@Test
	public void testGenerateBestCase2() 
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			ints.add(i);
		assertEquals(ints, SortUtil.generateBestCase(10));
	}

	
	@Test
	public void testGenerateBestCase3() 
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++)
			ints.add(i);
		assertEquals(ints, SortUtil.generateBestCase(100));
	}
	
	@Test
	public void testGenerateWorstCase1() 
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		assertEquals(ints, SortUtil.generateWorstCase(0));
	}
	
	@Test
	public void testGenerateWorstCase2() 
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 10; i > 0; i--)
			ints.add(i);
		assertEquals(ints, SortUtil.generateWorstCase(10));
	}
	
	@Test
	public void testGenerateWorstCase3() 
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 100; i > 0; i--)
			ints.add(i);
		assertEquals(ints, SortUtil.generateWorstCase(100));
	}
	
	@Test
	public void testMergeSort1()
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ArrayList<Integer> ints2 = new ArrayList<Integer>();
		Comparator<Integer> comp = new IntComp();
		SortUtil.mergesort(ints, comp);
		assertEquals(ints2,ints);
	}
	
	@Test
	public void testMergeSort2()
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(8);
		ints.add(4);
		ints.add(19);
		ints.add(0);
		ints.add(55);
		ints.add(41);
		ints.add(191);
		ints.add(121);
		ints.add(112);
		ints.add(10);
		ints.add(80);
		ints.add(40);
		ints.add(190);
		ints.add(120);
		ArrayList<Integer> ints2 = new ArrayList<Integer>();
		ints2.add(0);
		ints2.add(1);
		ints2.add(4);
		ints2.add(8);
		ints2.add(10);
		ints2.add(19);
		ints2.add(40);
		ints2.add(41);
		ints2.add(55);
		ints2.add(80);
		ints2.add(112);
		ints2.add(120);
		ints2.add(121);
		ints2.add(190);
		ints2.add(191);
		Comparator<Integer> comp = new IntComp();
		SortUtil.mergesort(ints, comp);
		assertEquals(ints2,ints);
	}
	
	@Test
	public void testMergeSort3()
	{
		ArrayList<String> str1 = new ArrayList<String>();
		str1.add("delicious");
		str1.add("bubbles");
		str1.add("hi");
		str1.add("yolo");
		ArrayList<String> str2 = new ArrayList<String>();
		str2.add("hi");
		str2.add("yolo");
		str2.add("bubbles");
		str2.add("delicious");
		StringComp comp = new StringComp();
		SortUtil.mergesort(str1, comp);
		assertEquals(str2,str1);
	}
	
	@Test
	public void testQuickSort1()
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ArrayList<Integer> ints2 = new ArrayList<Integer>();
		Comparator<Integer> comp = new IntComp();
		SortUtil.quicksort(ints, comp);
		assertEquals(ints2,ints);
	}
	
	@Test
	public void testQuickSort2()
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(1000);
		ints.add(1);
		ints.add(120);
		ints.add(8);
		ints.add(4);
		ints.add(19);
		ints.add(12);
		ints.add(20);
		ints.add(0);
		ArrayList<Integer> ints2 = new ArrayList<Integer>();
		ints2.add(0);
		ints2.add(1);
		ints2.add(4);
		ints2.add(8);
		ints2.add(12);
		ints2.add(19);
		ints2.add(20);
		ints2.add(120);
		ints2.add(1000);
		Comparator<Integer> comp = new IntComp();
		SortUtil.quicksort(ints, comp);
		assertEquals(ints2,ints);
	}
	
	@Test
	public void testQuickSort3()
	{
		ArrayList<String> str1 = new ArrayList<String>();
		str1.add("delicious");
		str1.add("bubbles");
		str1.add("hi");
		str1.add("yolo");
		str1.add("hey");
		str1.add("antidisastablishamentaryism");
		str1.add("burns");
		ArrayList<String> str2 = new ArrayList<String>();
		str2.add("hi");
		str2.add("hey");
		str2.add("yolo");
		str2.add("burns");
		str2.add("bubbles");
		str2.add("delicious");
		str2.add("antidisastablishamentaryism");
		StringComp comp = new StringComp();
		SortUtil.quicksort(str1, comp);
		assertEquals(str2,str1);
	}
	
}
