package assignment3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import assignment3.MySortedSet.MyIterator;

/**
 * @author Kyuho Ji & Cameron Pickle
 *
 */
public class MySortedSetTest 
{
	@SuppressWarnings({ "rawtypes", "unused" })
	private MySortedSet s1, s2, s2a, s3;
	@SuppressWarnings("rawtypes")
	private Collection c1, c2, c3;
	

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception 
	{
		s1 = new MySortedSet<Integer>();
		s2 = new MySortedSet<String>();
		s2.add("Hi");
		s2.add("blah");
		s2.add("banana");
		s2.add("hamburger");
		s2.add("blue");
		s2a = new MySortedSet<String>();
		s2.add("Hi");
		s2.add("blah");
		s2.add("banana");
		s2.add("hamburger");
		s2.add("blue");
		s3 = new MySortedSet<String>(new MyComp());
		s3.add("yessir");
		s3.add("no");
		s3.add("why");
		s3.add("does");
		s3.add("loves");
		s3.add("?");
		c1 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			c1.add(i);
		}
		c2 = new ArrayList<String>();
		String[] words = new String[] {"Q", "Pickle", "this", "is","taking", "forever"};
		for (int i = 0; i < 6; i++)	
			{
				c2.add(words[i]);
			}
		c3 = new ArrayList<String>();
		c3.add("yessir");
		c3.add("no");
		c3.add("why");
		c3.add("does");
		c3.add("loves");
		c3.add("?");
		

	  }

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testMySortedSet1() 
	{
		assertEquals(0, s1.getCurrentPosition());
	}
	
	@Test
	public void testMySortedSet2() 
	{
		assertEquals(5, s2.getCurrentPosition());
	}
	
	@Test
	public void testMySortedSet3() 
	{
		assertEquals(6, s3.getCurrentPosition());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testFirst1() 
	{
		s1.first();
	}
	
	@Test
	public void testFirst2() 
	{
		assertEquals("Hi", s2.first());
	}
	
	@Test
	public void testFirst3() 
	{
		assertEquals(s3.first(), "?");
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testLast1() 
	{
		s1.last();
	}
	
	@Test
	public void testLast2() 
	{
		assertEquals(s2.last(), "hamburger");
	}
	
	@Test
	public void testLast3() 
	{
		assertEquals("yessir", s3.last());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAdd1() 
	{
		s1.add(-1);
		assertEquals(-1, s1.first());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAdd2() 
	{
		assertEquals(false, s2.add("hamburger"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAdd3() 
	{
		assertEquals(s3.add("sophisticated"), true);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAddAll1() 
	{
		assertEquals(s1.addAll(c1),true);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAddAll2() 
	{
		assertEquals(true,s2.addAll(c2));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAddAll3() 
	{
		assertEquals(s3.addAll(c3),false);
	}
	
	@Test
	public void testClear1() 
	{
		s1.clear();
		assertEquals(true, s1.isEmpty());
	}
	
	@Test
	public void testClear2() 
	{
		s2.clear();
		assertEquals(true, s2.isEmpty());
	}
	
	@Test
	public void testClear3() 
	{
		s3.clear();
		assertEquals(true,s3.isEmpty());
	}
	
	@Test
	public void testContains1() 
	{
		assertEquals(false, s1.contains("random"));
	}
	
	@Test
	public void testContains2() 
	{
		assertEquals(false, s2.contains("neigh"));
	}
	
	@Test
	public void testContains3() 
	{
		assertEquals(true, s3.contains("loves"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testContainsAll1() 
	{
		assertEquals(false, s1.containsAll(c1));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testContainsAll2() 
	{
		s2.addAll(c2);
		assertEquals(true, s2.containsAll(c2));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testContainsAll3() 
	{
		assertEquals(true, s3.containsAll(c3));
	}

	@Test
	public void testIsEmpty1() 
	{
		assertEquals(true, s1.isEmpty());
	}

	@Test
	public void testIsEmpty2() 
	{
		assertEquals(false, s2.isEmpty());
	}

	@Test
	public void testIsEmpty3() 
	{
		assertEquals(false, s3.isEmpty());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testIterator1() 
	{
		MyIterator iterator = (MyIterator) s1.iterator();
		assertEquals(false, iterator.hasNext());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testIterator2() 
	{
		MyIterator iterator = (MyIterator) s2.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		assertEquals(false, iterator.hasNext());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testIterator3() 
	{
		MyIterator iterator = (MyIterator) s3.iterator();
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testSetRemove1() 
	{
		assertEquals(false, s1.remove(1));
	}

	@Test
	public void testSetRemove2() 
	{
		s2.remove("Hi");
		assertEquals("banana", s2.first());
	}

	@Test
	public void testSetRemove3() 
	{
		assertEquals(true, s3.remove("yessir"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRemoveAll1() 
	{
		assertEquals(false, s1.removeAll(c1));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRemoveAll2() 
	{
		assertEquals(false, s2.removeAll(c2));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRemoveAll3() 
	{
		assertEquals(true, s3.removeAll(c3));
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testMyIterator() 
	{
		MyIterator iterator = (MyIterator) s1.iterator();
		assertEquals(-1, iterator.index);
		assertEquals(false, iterator.gotNext);
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testHasNext1() 
	{
		MyIterator iterator = (MyIterator) s1.iterator();
		assertEquals(false, iterator.hasNext());
		
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testHasNext2() 
	{
		MyIterator iterator = (MyIterator) s2.iterator();
		assertEquals(true, iterator.hasNext());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testHasNext3() 
	{
		MyIterator iterator = (MyIterator) s3.iterator();
		assertEquals(true, iterator.hasNext());
	}
	
	@SuppressWarnings("rawtypes")
	@Test(expected = NoSuchElementException.class)
	public void testNext1() 
	{
		MyIterator iterator = (MyIterator) s1.iterator();
		iterator.next();
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testNext2() 
	{
		MyIterator iterator = (MyIterator) s2.iterator();
		assertEquals("Hi", iterator.next());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testNext3() 
	{
		MyIterator iterator = (MyIterator) s3.iterator();
		assertEquals("?", iterator.next());
	}
	
	@SuppressWarnings("rawtypes")
	@Test(expected = IllegalStateException.class)
	public void testIteratorRemove1() 
	{
		MyIterator iterator = (MyIterator) s1.iterator();
		iterator.remove();
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testIteratorRemove2() 
	{
		MyIterator iterator = (MyIterator) s2.iterator();
		iterator.next();
		iterator.remove();
		assertEquals("banana", s2.first());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testIteratorRemove3() 
	{
		MyIterator iterator = (MyIterator) s3.iterator();
		iterator.next();
		iterator.remove();
		assertEquals("no", s3.first());
	}
	
	@Test
	public void timing()
	{
		
	}
}
