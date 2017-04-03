package assignment4;
/**
 * @author Kyuho Ji & Cameron Pickle
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnagramUtilTest 
{
	private String t1, t2, t3, t4, t5;
	private AnagramComp comp;
	private String[] str, str2;

	@Before
	public void setUp() throws Exception 
	{
		t1 = "Eye";
		t2 = "yee";
		t3 = "caller";
		t4 = "cellar";
		t5 = "eey";
		comp = new AnagramComp();
		str = new String[5];
		str[0] = "Eye";
		str[1] = "yee";
		str[2] = "caller";
		str[3] = "cellar";
		str[4] = "eey";
		str2 = new String[5];
		str2[0] = "caller";
		str2[1] = "Eye";
		str2[2]	= "cellar";
		str2[3] = "yee";
		str2[4] = "eey";
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void testAnagramComp1() 
	{
		assertEquals(1, comp.compare(t1, t2));
	}
	
	@Test
	public void testAnagramComp2() 
	{
		assertEquals(1, comp.compare(t3, t4));
	}
	
	@Test
	public void testAnagramCom3() 
	{
		assertEquals(-1, comp.compare(t1, t4));
	}
	
	@Test
	public void testAnagramCom4() 
	{
		assertEquals(1, comp.compare(t1, t5));
	}
	
	@Test
	public void testSort1() 
	{
		assertEquals("acellr", AnagramUtil.sort(t3));
	}
	
	@Test
	public void testSort2() 
	{
		assertEquals("acellr", AnagramUtil.sort(t4));
	}
	
	@Test
	public void testSort3() 
	{
		assertEquals("Eey", AnagramUtil.sort(t1));
	}
	
	@Test
	public void testInsertionSort1()
	{
		String[] temp = new String[5];
		temp[0] = "Eye";
		temp[1] = "yee";
		temp[2]	= "eey";
		temp[3] = "caller";
		temp[4] = "cellar";
		AnagramUtil.insertionSort(str, comp);
		System.out.println(str[0]);
		System.out.println(str[1]);
		System.out.println(str[2]);
		System.out.println(str[3]);
		System.out.println(str[4]);
		assertArrayEquals(temp, str);
	}
	
	@Test
	public void testInsertionSort2()
	{
		
	}
	
	@Test
	public void testInsertionSort3()
	{
		
	}
	
	@Test
	public void testAreAnagrams1()
	{
		assertTrue(AnagramUtil.areAnagrams(t1, t2));
	}

	@Test
	public void testAreAnagrams2()
	{
		assertTrue(AnagramUtil.areAnagrams(t3, t4));
	}
	
	@Test
	public void testAreAnagrams3()
	{
		assertFalse(AnagramUtil.areAnagrams(t1, t4));
	}
	
	@Test
	public void testGetLargestAnagramGroup1()
	{
		String[] temp = new String[3];
		temp[0] = "Eye";
		temp[1] = "yee";
		temp[2] = "eey";
		System.out.println(AnagramUtil.getLargestAnagramGroup(str)[0]);
		System.out.println(AnagramUtil.getLargestAnagramGroup(str)[1]);
		System.out.println(AnagramUtil.getLargestAnagramGroup(str)[2]);
		assertArrayEquals(temp, AnagramUtil.getLargestAnagramGroup(str));
		
	}
}
