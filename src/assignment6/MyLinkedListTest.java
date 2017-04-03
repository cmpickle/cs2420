package assignment6;
/**
 * @author Cameron Pickle
 */
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {
	private MyLinkedList<Integer> list;
	private MyLinkedList<String> list2;
	private MyLinkedList<Integer> list3;

	@Before
	public void setUp() throws Exception 
	{
		list = new MyLinkedList<Integer>();
		list2 = new MyLinkedList<String>();
		list3 = new MyLinkedList<Integer>();
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void addFirstTest1() 
	{
		list.addFirst(1);
		assertEquals(1, (int) list.getFirst());
	}
	
	@Test
	public void addFirstTest2() 
	{
		list2.addFirst("test");
		assertEquals("test", (String) list2.getFirst());
	}
	
	@Test
	public void addFirstTest3() 
	{
		list3.addFirst(null);
		assertEquals(null, list3.getFirst());
	}
	
	@Test
	public void addFirstTest4() 
	{
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		assertEquals(3, (int) list.getFirst());
	}

	@Test
	public void addLastTest1() 
	{
		list.addFirst(2);
		list.addLast(1);
		assertEquals(1, (int) list.getLast());
	}

	@Test
	public void addLastTest2() 
	{
		list2.addLast("test");
		list2.addLast("hello");
		assertEquals("hello", list2.getLast());
	}

	@Test
	public void addLastTest3() 
	{
		list.addFirst(1);
		assertEquals(1, (int) list.getLast());
	}
	
	@Test
	public void addLastTest4() 
	{
		list3.addLast(null);
		assertEquals(null, list3.getLast());
	}
	
	@Test
	public void addTest1() 
	{
		list.addFirst(2);
		list.addLast(1);
		list.addFirst(4);
		list.addFirst(5);
		list.add(2, 11);
		assertEquals(11, (int) list.get(2));
	}
	
	@Test
	public void addTest2() 
	{
		list.add(0, 1);
		list.add(0, 2);
		assertEquals(1, (int) list.get(1));
	}
	
	@Test
	public void addTest3() 
	{
		list2.addFirst("hey");
		list2.addLast("sup");
		list2.addFirst("beach");
		list2.addFirst("ocean");
		list2.addFirst("cruise");
		assertEquals("sup", (String) list2.get(4));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void addTest4() 
	{
		list2.add(50, "haha");
		assertEquals("sup", (String) list2.get(4));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void getFirstTest1() 
	{
		list.getFirst();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void getFirstTest2() 
	{
		list.getFirst();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void getFirstTest3() 
	{
		list.getFirst();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void getLastTest1() 
	{
		list3.getLast();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void getLastTest2() 
	{
		list3.getLast();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void getLastTest3() 
	{
		list3.getLast();
	}

	@Test
	public void getTest1() 
	{
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addLast(1);
		assertEquals(1, (int) list.get(3));
	}
	
	@Test
	public void getTest2() 
	{
		list2.addLast("duh");
		list2.addFirst("hello");
		list2.addLast("what");
		list2.addLast("yo");
		list2.addLast("I");
		list2.addLast("will");
		list2.addLast("win");
		assertEquals("hello", (String) list2.get(0));
	}
	
	@Test
	public void getTest3() 
	{
		list2.addLast("duh");
		list2.addFirst("hello");
		list2.addLast("what");
		list2.addLast("yo");
		list2.addLast("I");
		list2.addLast("will");
		list2.addLast("win");
		assertEquals("win", (String) list2.get(6));
	}
	
	@Test
	public void removeFirstTest1() 
	{
		list.addFirst(2);
		list.addLast(1);
		list.removeFirst();
		assertEquals(1, (int) list.getFirst());
	}
	
	@Test
	public void removeFirstTest2() 
	{
		list2.addFirst("hey");
		list2.addLast("sup");
		list2.addLast("dude");
		list2.addLast("what");
		list2.addLast("eat");
		list2.removeFirst();
		list2.removeFirst();
		list2.removeFirst();
		assertEquals("what", (String) list2.getFirst());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void removeFirstTest3() 
	{
		list.removeFirst();
		assertEquals(1, (int) list.getLast());
	}
	
	@Test
	public void removeLastTest1() 
	{
		list.addFirst(2);
		list.addLast(1);
		list.addLast(121);
		list.addLast(12);
		list.addLast(13);
		list.removeLast();
		assertEquals(12, (int) list.getLast());
	}
	
	@Test
	public void removeLastTest2() 
	{
		list2.addFirst("hey");
		list2.addLast("dude");
		list2.removeLast();
		assertEquals("hey", (String) list2.getLast());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void removeLastTest3() 
	{
		list.removeLast();
		assertEquals(1, (int) list.getLast());
	}
	
	@Test
	public void removeTest1() 
	{
		list.addFirst(2);
		list.addLast(1);
		list.addLast(121);
		list.addLast(12);
		list.addLast(13);
		list.remove(0);
		assertEquals(1, (int) list.getFirst());
	}
	
	@Test
	public void removeTest2() 
	{
		list2.addFirst("hey");
		list2.addLast("dude");
		list2.remove(1);
		assertEquals("hey", (String) list2.getLast());
	}
	
	@Test
	public void removeTest3() 
	{
		list.addFirst(2);
		list.addLast(1);
		list.addLast(121);
		list.addLast(12);
		list.addLast(13);
		list.remove(1);
		assertEquals(121, (int) list.get(1));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void removeTest4() 
	{
		list.addFirst(2);
		list.remove(1);
		assertEquals(null, (int) list.get(1));
	}
	
	@Test
	public void indexOfTest1() 
	{
		list.addFirst(2);
		list.addLast(1);
		list.addLast(121);
		list.addLast(12);
		list.addLast(13);
		list.addFirst(24);
		list.addLast(16);
		list.addLast(91);
		assertEquals(3, list.indexOf(121));
	}
	
	@Test
	public void indexOfTest2() 
	{
		list2.addFirst("hey");
		list2.addLast("sup");
		list2.addLast("son");
		list2.addLast("what");
		list2.addLast("eat");
		list2.addFirst("hey");
		list2.addFirst("boy");
		list2.addFirst("son");
		list2.addFirst("man");
		assertEquals(1, list2.indexOf("son"));
	}
	
	@Test
	public void indexOfTest3() 
	{
		list.addFirst(2);
		list.addLast(1);
		assertEquals(-1, list.indexOf(5));
	}
	
	@Test
	public void lastIndexOfTest1() 
	{
		list.addFirst(2);
		list.addLast(1);
		list.addLast(121);
		list.addLast(12);
		list.addLast(13);
		list.addFirst(24);
		list.addLast(16);
		list.addLast(121);
		assertEquals(7, list.lastIndexOf(121));
	}
	
	@Test
	public void lastIndexOfTest2() 
	{
		list2.addFirst("hey");
		list2.addLast("sup");
		list2.addLast("dude");
		list2.addLast("son");
		list2.addLast("eat");
		list2.addFirst("hey");
		list2.addFirst("boy");
		list2.addFirst("son");
		list2.addFirst("son");
		assertEquals(7, list2.lastIndexOf("son"));
	}
	
	@Test
	public void lastIndexOfTest3() 
	{
		list.addFirst(2);
		list.addLast(1);
		assertEquals(-1, list.indexOf(5));
	}
	
	@Test
	public void sizeTest1() 
	{
		list.addFirst(2);
		list.addLast(1);
		list.addLast(1);
		list.addLast(12);
		list.addFirst(2);
		assertEquals(5, list.size());
	}
	
	@Test
	public void sizeTest2() 
	{
		list.addLast(13);
		assertEquals(1, list.size());
	}
	
	@Test
	public void sizeTest3() 
	{
		assertEquals(0, list.size());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void clearTest1() 
	{
		list.addFirst(2);
		list.addLast(41);
		list.clear();
		assertEquals(null, list.getLast());
	}
	
	@Test
	public void clearTest2() 
	{
		list.addFirst(2);
		list.addLast(11);
		list.clear();
		assertEquals(0, list.size());
	}
	
	@Test
	public void clearTest3() 
	{
		list2.addFirst("2");
		list2.addLast("12");
		list2.clear();
		assertEquals(0, list2.size());
	}
	
	@Test
	public void toArrayTest1() 
	{
		list.addFirst(2);
		list.addLast(1);
		list.addLast(1);
		list.addLast(12);
		list.addFirst(2);
		assertArrayEquals(new Object[] {2,2,1,1,12}, list.toArray());
	}
	
	@Test
	public void toArrayTest2() 
	{
		list2.addFirst("hey");
		list2.addLast("sup");
		list2.addLast("dude");
		list2.addLast("son");
		list2.addLast("eat");
		list2.addFirst("hey");
		list2.addFirst("boy");
		list2.addFirst("son");
		list2.addFirst("son");
		assertArrayEquals(new Object[] {"son","son","boy","hey","hey","sup","dude","son","eat"}, list2.toArray());
	}
	
	@Test
	public void toArrayTest3() 
	{
		assertArrayEquals(new Object[] {}, list.toArray());
	}
}
