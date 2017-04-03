package assignment4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Kyuho Ji & Cameron Pickle
 *
 */
public class AnagramUtilTester 
{
	private String t1, t2, t3, t4, t5;
	private AnagramComp comp;
	private InvertedIntComp invComp;
	private String[] str, str2, str3;
	private Integer[] int4;

	@Before
	public void setUp() throws Exception 
	{
		t1 = "Eye";
		t2 = "yee";
		t3 = "caller";
		t4 = "cellar";
		t5 = "eey";
		comp = new AnagramComp();
		invComp = new InvertedIntComp();
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
		str3 = new String[3];
		str3[0] = "\"\"";
		str3[1] = "a";
		str3[2] = "\"\"";
		int4  = new Integer[6];
		int4[0] = 2;
		int4[1] = 4;
		int4[2]	= 0;
		int4[3] = 1;
		int4[4] = 3;
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
		assertArrayEquals(temp, str);
	}
	
	@Test
	public void testInsertionSort2()
	{
		String[] temp = new String[10];
		temp[0] = "carets";
		temp[1] = "hello";
		temp[2] = "Caters";
		temp[3] = "olleh";
		temp[4]	= "caster";
		temp[5] = "hi";
		temp[6] = "Reacts";
		temp[7] = "Batman";
		temp[8] = "recast";
		temp[9] = "manbat";
		AnagramUtil.insertionSort(temp, comp);
		String[] unordered = new String[10];
		unordered[0] = "carets";
		unordered[1] = "Caters";
		unordered[2] = "caster";
		unordered[3] = "Reacts";
		unordered[4] = "recast";
		unordered[5] = "hello";
		unordered[6] = "olleh";
		unordered[7] = "hi";
		unordered[8] = "Batman";
		unordered[9] = "manbat";
		assertArrayEquals(temp, unordered);
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
		String[] temp = new String[0];
		String[] blah = new String[2];
		blah[0] = "yo";
		blah[1] = "lie";
		blah = AnagramUtil.getLargestAnagramGroup(blah);
		assertArrayEquals(temp, blah);
		
	}
	
	@Test
	public void testGetLargestAnagramGroup2()
	{
		String[] temp = new String[7];
		temp[0] = "carets";
		temp[1] = "Caters";
		temp[2]	= "caster";
		temp[3] = "crates";
		temp[4] = "Reacts";
		temp[5] = "recast";
		temp[6] = "traces";
		assertArrayEquals(temp, AnagramUtil.getLargestAnagramGroup("sample_word_list.txt"));
		
	}
	
	@Test
	public void testGetLargestAnagramGroup3()
	{
		String[] temp = new String[2];
		temp[0] = "act";
		temp[1] = "cat";
		assertArrayEquals(temp, AnagramUtil.getLargestAnagramGroup("moderate_word_list.txt"));
		
	}
	
	@Test
	public void testGetLargestAnagramGroup4()
	{
		String[] temp = new String[2];
		temp[0] = "\"\"";
		temp[1] = "\"\"";
		assertArrayEquals(temp, AnagramUtil.getLargestAnagramGroup(str3));
		
	}
	
	@Test
	public void testGetLargestAnagramGroup5()
	{
		String[] temp = new String[2];
		temp[0] = "Iwonthearthis";
		temp[1] = "withinearshot";
		AnagramUtil.getLargestAnagramGroup("GraderTesting.txt");
		assertArrayEquals(temp, AnagramUtil.getLargestAnagramGroup("GraderTesting.txt"));
	}
	
	@Test
	public void testGetLargestAnagramGroup6()
	{
		String[] temp = new String[7];
		temp[0] = "abcd";
		temp[1] = "acbd";
		temp[2]	= "acbd";
		temp[3] = "adbc";
		temp[4] = "bcad";
		temp[5] = "bacd";
		temp[6] = "bdca";
		AnagramUtil.getLargestAnagramGroup("GraderTesting2.txt");
		assertArrayEquals(temp, AnagramUtil.getLargestAnagramGroup("GraderTesting2.txt"));
	}
	
	@Test
	public void testAreAnagrams5()
	{
		assertTrue(AnagramUtil.areAnagrams("", ""));
	}
	
	@Test
	public void testAreAnagrams4()
	{
		assertTrue(AnagramUtil.areAnagrams("Iwonthearthis", "withinearshot"));
	}
	
	@Test
	public void testAreAnagrams6()
	{
		assertTrue(AnagramUtil.areAnagrams("AbCdEf", "FeDcBa"));
	}

	@Test
	public void testInsertionSort3()
	{
		Integer[] temp  = new Integer[6];
		temp[0] = 5;
		temp[1] = 4;
		temp[2]	= 3;
		temp[3] = 2;
		temp[4] = 1;
		temp[5] = 0;
		AnagramUtil.insertionSort(int4, invComp);
	}
}
