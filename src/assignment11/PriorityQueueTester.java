package assignment11;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A tester class for the PriorityQueue class.
 * 
 * @author Cameron Pickle
 * @author Daniel Avery
 */
public class PriorityQueueTester {

	StringLengthComp comp;
	
	PriorityQueue<Integer> ints;
	PriorityQueue<String> strings;
	
	@Before
	public void setUp() throws Exception
	{
		comp = new StringLengthComp();
		
		ints = new PriorityQueue<Integer>();
		strings = new PriorityQueue<String>(comp);
	}

	@After
	public void tearDown() throws Exception
	{
		ints = null;
		strings = null;
	}

	/****************************************************************
	 * TEST size()
	 ****************************************************************/
	@Test
	public void testSize1()
	{
		ints.add(9);
		ints.add(5);
		ints.add(3);
		ints.add(1);
		ints.add(6);
		ints.add(8);
		assertEquals(6, ints.size());
	}
	
	@Test
	public void testSize2()
	{
		strings.add("hi");
		strings.add("hey");
		strings.add("sup");
		strings.add("dude");
		strings.add("what");
		strings.add("who");
		strings.add("yo");
		assertEquals(7, strings.size());
	}

	/****************************************************************
	 * TEST clear()
	 ****************************************************************/
	@Test
	public void testClear1()
	{
		ints.add(9);
		ints.add(5);
		ints.add(3);
		ints.add(1);
		ints.add(6);
		ints.add(8);
		ints.clear();
		assertEquals(0, ints.size());
	}
	
	@Test
	public void testClear2()
	{
		ints.add(9);
		ints.add(5);
		ints.add(3);
		ints.add(1);
		ints.add(6);
		ints.add(8);
		ints.clear();
		ints.add(3);
		ints.add(1);
		ints.add(6);
		ints.add(8);
		assertEquals(4, ints.size());
	}
	
	@Test
	public void testClear3()
	{
		strings.add("hi");
		strings.add("hey");
		strings.add("sup");
		strings.add("dude");
		strings.add("what");
		strings.add("who");
		strings.add("yo");
		strings.clear();
		assertEquals(0, strings.size());
	}

	/****************************************************************
	 * TEST findMin()
	 ****************************************************************/
	@Test
	public void testFindMin1()
	{
		ints.add(21);
		ints.add(273);
		ints.add(51);
		ints.add(52);
		ints.add(79);
		ints.add(19);
		ints.add(22);
		ints.add(35);
		ints.add(20);
		ints.add(40);
		assertEquals((Integer)19, ints.findMin());
	}
	
	@Test
	public void testFindMin2()
	{
		ints.add(21);
		ints.add(273);
		ints.add(51);
		ints.add(52);
		ints.add(79);
		ints.add(19);
		ints.add(22);
		ints.add(35);
		ints.add(20);
		ints.add(40);
		ints.deleteMin();
		assertEquals((Integer)20, ints.findMin());
	}
	
	@Test
	public void testFindMin3()
	{
		ints.add(21);
		ints.add(273);
		ints.add(51);
		ints.add(52);
		assertEquals(21, (int) ints.findMin());
		ints.clear();
		ints.add(79);
		ints.add(19);
		assertEquals(19, (int) ints.findMin());
		ints.clear();
		ints.add(-22);
		ints.add(-35);
		ints.add(20);
		ints.add(40);
		ints.deleteMin();
		assertEquals(-22, (int) ints.findMin());
	}
	
	@Test
	public void testFindMin4()
	{
		strings.add("pickles");
		strings.add("pickles");
		strings.add("pickles");
		strings.add("pickles");
		strings.add("pickles");
		strings.add("pickles");
		strings.add("pickles");
		strings.add("pickles");
		strings.add("pickles");
		strings.add("pickles");
		strings.add("pickles");
		strings.add("pickles");
		assertEquals("pickles", strings.findMin());
		assertEquals("pickles", strings.deleteMin());
		assertEquals("pickles", strings.findMin());
	}

	@Test (expected = NoSuchElementException.class)
	public void testFindMinException()
	{
		ints.findMin();
	}
	
	/****************************************************************
	 * TEST deleteMin()
	 ****************************************************************/
	@Test
	public void testDeleteMin1()
	{
		ints.add(9);
		ints.add(5);
		ints.add(3);
		ints.add(1);
		ints.add(6);
		ints.add(8);
		assertEquals(1, (int) ints.deleteMin());
		assertEquals(5, ints.size());
		assertEquals(3, (int) ints.findMin());
	}
	
	@Test
	public void testDeleteMin2()
	{
		ints.add(9);
		ints.add(5);
		ints.add(3);
		ints.add(1);
		ints.add(6);
		ints.add(8);
		assertEquals(1, (int) ints.deleteMin());
		assertEquals(3, (int) ints.deleteMin());
		assertEquals(5, (int) ints.deleteMin());
		assertEquals(6, (int) ints.deleteMin());
		assertEquals(2, ints.size());
		assertEquals(8, (int) ints.findMin());
	}
	
	@Test
	public void testDeleteMin3()
	{
		strings.add("a");
		strings.add("hey");
		strings.add("sup");
		strings.add("dude");
		strings.add("what");
		strings.add("who");
		strings.add("yo");
		assertEquals("a", (String) strings.deleteMin());
		assertEquals("yo", (String) strings.deleteMin());
		assertEquals("who", (String) strings.deleteMin());
		assertEquals("hey", (String) strings.deleteMin());
		assertEquals(3, strings.size());
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testDeleteMinException()
	{
		ints.deleteMin();
	}

	/****************************************************************
	 * TEST add()
	 ****************************************************************/
	@Test
	public void testAdd1()
	{
		Integer[] arr = {5, 8, 6, 9};
		
		ints.add(9);
		ints.add(5);
		ints.add(3);
		ints.add(1);
		ints.add(6);
		ints.add(8);
		assertEquals(1, (int) ints.deleteMin());
		assertEquals(5, ints.size());
		assertEquals(3, (int) ints.findMin());
		ints.clear();
		ints.add(9);
		ints.add(5);
		ints.add(6);
		ints.add(8);
		assertEquals(4, ints.size());
		assertArrayEquals(arr, ints.toArray());
		
	}
	
	@Test
	public void testAdd2()
	{
		Integer[] arr = {-9, -8, -6, -5};
		
		ints.add(900);
		ints.add(500000);
		ints.add(23);
		ints.add(-16);
		ints.add(68);
		ints.add(-1);
		assertEquals(-16, (int) ints.deleteMin());
		assertEquals(5, ints.size());
		assertEquals(-1, (int) ints.findMin());
		ints.clear();
		ints.add(-9);
		ints.add(-5);
		ints.add(-6);
		ints.add(-8);
		assertEquals(4, ints.size());
		assertArrayEquals(arr, ints.toArray());
	}
	
	@Test
	public void testAdd3()
	{
		strings.add("hi");
		strings.add("hey");
		strings.add("sup");
		strings.add("dude");
		strings.add("what");
		strings.add("who");
		strings.add("yo");
		strings.clear();
		strings.add("59");
		strings.add("hey");
		strings.add("99999");
		strings.add("dude");
		strings.add("this is it");
		strings.add("who_are_you?_why_are_you_here?");
		strings.add("");
		strings.add(";");
		assertEquals(8, strings.size());
		assertEquals("", (String) strings.deleteMin());
		assertEquals(";", (String) strings.deleteMin());
		assertEquals("59", (String) strings.deleteMin());
		assertEquals("hey", (String) strings.findMin());
	}
}
