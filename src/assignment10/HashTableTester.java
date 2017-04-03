package assignment10;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HashTableTester {

	GoodHashFunctor good;
	MediocreHashFunctor mediocre;
	BadHashFunctor bad;

	QuadProbeHashTable quadHashGood;
	QuadProbeHashTable quadHashMediocre;
	QuadProbeHashTable quadHashBad;

	ChainingHashTable chainingGood;
	ChainingHashTable chainingMediocre;
	ChainingHashTable chainingBad;

	ArrayList<String> testCollection;

	@Before
	public void setUp() throws Exception
	{
		good = new GoodHashFunctor();
		mediocre = new MediocreHashFunctor();
		bad = new BadHashFunctor();

		quadHashGood = new QuadProbeHashTable(10, good);
		quadHashMediocre = new QuadProbeHashTable(10, mediocre);
		quadHashBad = new QuadProbeHashTable(10, bad);

		chainingGood = new ChainingHashTable(10, good);
		chainingMediocre = new ChainingHashTable(10, mediocre);
		chainingBad = new ChainingHashTable(10, bad);

		testCollection = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception
	{
		quadHashGood = null;
		quadHashMediocre = null;
		quadHashBad = null;
		
		chainingGood = null;
		chainingMediocre = null;
		chainingBad = null;

		testCollection = null;
	}

	/*************************************************************************************************************************************
	 * TEST ChainingHashTable
	 *************************************************************************************************************************************/

	/****************************************************************
	 * TEST add()
	 ****************************************************************/

	@Test
	public void testAddChainingHashTable1()
	{
		String test = "hello";
		chainingGood.add("hello");
		try
		{
			assertTrue(chainingGood.contains(test));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	@Test
	public void testAddChainingHashTable2()
	{
		chainingGood.add("hello");
		chainingGood.add("world");
		try
		{
			assertTrue(chainingGood.contains("world"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	/*
	 * Test space char and empty string
	 */
	@Test
	public void testAddChainingHashTable3()
	{
		chainingGood.add(" ");
		chainingGood.add("");
		try
		{
			assertTrue(chainingGood.contains(" "));
			assertTrue(chainingGood.contains(""));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	/*
	 * Test symbols and numbers
	 */
	@Test
	public void testAddChainingHashTable4()
	{
		chainingGood.add(";");
		chainingGood.add("985");
		try
		{
			assertTrue(chainingGood.contains(";"));
			assertTrue(chainingGood.contains("985"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	/*
	 * Test anagram
	 */
	@Test
	public void testAddChainingHashTable5()
	{
		chainingGood.add("hey");
		chainingGood.add("yeh");
		try
		{
			assertTrue(chainingGood.contains("hey"));
			assertTrue(chainingGood.contains("yeh"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	/*
	 * Test anagram
	 */
	@Test
	public void testAddChainingHashTable6()
	{
		chainingGood.add("hey");
		chainingGood.add("hello");
		try
		{
			assertFalse(chainingGood.contains("what"));
			assertFalse(chainingGood.contains("no"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}
	
	@Test
	public void testAddChainingHashTable7()
	{
		String test = "hello";
		chainingMediocre.add("hello");
		try
		{
			assertTrue(chainingMediocre.contains(test));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}
	
	@Test
	public void testAddChainingHashTable8()
	{
		String test = "hello";
		chainingBad.add("hello");
		try
		{
			assertTrue(chainingBad.contains(test));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	/****************************************************************
	 * TEST addAll()
	 ****************************************************************/

	@Test
	public void testAddAllChainingHashTable1()
	{
		testCollection.add("hey");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");

		try
		{
			assertTrue(chainingGood.addAll(testCollection));

			assertFalse(chainingGood.addAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(chainingGood.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}

	@Test
	public void testAddAllChainingHashTable2()
	{
		testCollection.add(" ");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");

		try
		{
			assertTrue(chainingGood.addAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(chainingGood.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}
	
	@Test
	public void testAddAllChainingHashTable3()
	{
		testCollection.add("hey");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");

		try
		{
			assertTrue(chainingMediocre.addAll(testCollection));

			assertFalse(chainingMediocre.addAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(chainingMediocre.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}
	
	@Test
	public void testAddAllChainingHashTable4()
	{
		testCollection.add("hey");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");

		try
		{
			assertTrue(chainingBad.addAll(testCollection));

			assertFalse(chainingBad.addAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(chainingBad.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}

	/****************************************************************
	 * TEST clear()
	 ****************************************************************/

	@Test
	public void testClearChainingHashTable1()
	{
		chainingGood.add("sup");
		chainingGood.add("hey");
		chainingGood.add("hello");
		chainingGood.clear();
		assertTrue(chainingGood.isEmpty());
	}
	
	@Test
	public void testClearChainingHashTable2()
	{
		chainingMediocre.add("sup");
		chainingMediocre.add("hey");
		chainingMediocre.add("hello");
		chainingMediocre.clear();
		assertTrue(chainingMediocre.isEmpty());
	}
	
	@Test
	public void testClearChainingHashTable3()
	{
		chainingBad.add("sup");
		chainingBad.add("hey");
		chainingBad.add("hello");
		chainingBad.clear();
		assertTrue(chainingBad.isEmpty());
	}

	/****************************************************************
	 * TEST contains()
	 ****************************************************************/

	@Test
	public void testContainsChainingHashTable1()
	{
		chainingGood.add("hello");
		chainingGood.add("world");
		try
		{
			assertTrue(chainingGood.contains("world"));
			assertTrue(chainingGood.contains("hello"));
			assertFalse(chainingGood.contains("yes"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}
	
	@Test
	public void testContainsChainingHashTable2()
	{
		chainingMediocre.add("hello");
		chainingMediocre.add("world");
		try
		{
			assertTrue(chainingMediocre.contains("world"));
			assertTrue(chainingMediocre.contains("hello"));
			assertFalse(chainingMediocre.contains("yes"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}
	
	@Test
	public void testContainsChainingHashTable3()
	{
		chainingBad.add("hello");
		chainingBad.add("world");
		try
		{
			assertTrue(chainingBad.contains("world"));
			assertTrue(chainingBad.contains("hello"));
			assertFalse(chainingBad.contains("yes"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	/****************************************************************
	 * TEST containsAll()
	 ****************************************************************/

	@Test
	public void testContainsAllChainingHashTable1()
	{
		testCollection.add(" ");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");
		chainingGood.addAll(testCollection);

		try
		{
			assertTrue(chainingGood.containsAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(chainingGood.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}
	
	@Test
	public void testContainsAllChainingHashTable2()
	{
		testCollection.add(" ");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");
		chainingMediocre.addAll(testCollection);

		try
		{
			assertTrue(chainingMediocre.containsAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(chainingMediocre.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}
	
	@Test
	public void testContainsAllChainingHashTable3()
	{
		testCollection.add(" ");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");
		chainingBad.addAll(testCollection);

		try
		{
			assertTrue(chainingBad.containsAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(chainingBad.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}

	/****************************************************************
	 * TEST isEmpty()
	 ****************************************************************/

	@Test
	public void testIsEmptyChainingHashTable1()
	{
		chainingGood.add("sup");
		chainingGood.add("hey");
		chainingGood.add("hello");
		chainingGood.clear();
		assertTrue(chainingGood.isEmpty());
	}

	@Test
	public void testIsEmptyChainingHashTable2()
	{
		chainingGood.add("sup");
		chainingGood.add("hey");
		chainingGood.add("hello");
		assertFalse(chainingGood.isEmpty());
	}
	
	@Test
	public void testIsEmptyChainingHashTable3()
	{
		chainingMediocre.add("sup");
		chainingMediocre.add("hey");
		chainingMediocre.add("hello");
		chainingMediocre.clear();
		assertTrue(chainingMediocre.isEmpty());
	}
	
	@Test
	public void testIsEmptyChainingHashTable4()
	{
		chainingBad.add("sup");
		chainingBad.add("hey");
		chainingBad.add("hello");
		chainingBad.clear();
		assertTrue(chainingBad.isEmpty());
	}

	/****************************************************************
	 * TEST size()
	 ****************************************************************/

	@Test
	public void testSizeChainingHashTable1()
	{
		chainingGood.add("sup");
		chainingGood.add("hey");
		chainingGood.add("hello");
		assertEquals(3, chainingGood.size());
	}

	@Test
	public void testSizeChainingHashTable2()
	{
		chainingGood.add("sup");
		chainingGood.add("hey");
		chainingGood.add("hello");
		chainingGood.add("what");
		chainingGood.add("dat");
		chainingGood.add("yo");
		chainingGood.add("ho");
		assertEquals(7, chainingGood.size());
	}
	
	@Test
	public void testSizeChainingHashTable3()
	{
		chainingMediocre.add("sup");
		chainingMediocre.add("hey");
		chainingMediocre.add("hello");
		assertEquals(3, chainingMediocre.size());
	}
	
	@Test
	public void testSizeChainingHashTable4()
	{
		chainingBad.add("sup");
		chainingBad.add("hey");
		chainingBad.add("hello");
		assertEquals(3, chainingBad.size());
	}

	/***********************************************************************************************************************************
	 * TEST QuadProbeHashTable
	 ***********************************************************************************************************************************/

	/****************************************************************
	 * TEST add()
	 ****************************************************************/

	@Test
	public void testAddQuadProbeHashTable1()
	{
		String test = "hello";
		quadHashGood.add("hello");
		try
		{
			assertTrue(quadHashGood.contains(test));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}

	}

	@Test
	public void testAddQuadProbeHashTable2()
	{
		quadHashGood.add("hello");
		quadHashGood.add("world");
		try
		{
			assertTrue(quadHashGood.contains("world"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	/*
	 * Test space char and empty string
	 */
	@Test
	public void testAddQuadProbeHashTable3()
	{
		quadHashGood.add(" ");
		quadHashGood.add("");
		try
		{
			assertTrue(quadHashGood.contains(" "));
			assertTrue(quadHashGood.contains(""));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	/*
	 * Test symbols and numbers
	 */
	@Test
	public void testAddQuadProbeHashTable4()
	{
		quadHashGood.add(";");
		quadHashGood.add("985");
		try
		{
			assertTrue(quadHashGood.contains(";"));
			assertTrue(quadHashGood.contains("985"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	/*
	 * Test anagram
	 */
	@Test
	public void testAddQuadProbeHashTable5()
	{
		quadHashGood.add("hey");
		quadHashGood.add("yeh");
		try
		{
			assertTrue(quadHashGood.contains("hey"));
			assertTrue(quadHashGood.contains("yeh"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	/*
	 * Test anagram
	 */
	@Test
	public void testAddQuadProbeHashTable6()
	{
		quadHashGood.add("hey");
		quadHashGood.add("hello");
		try
		{
			assertFalse(quadHashGood.contains("what"));
			assertFalse(quadHashGood.contains("no"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}
	
	@Test
	public void testAddQuadProbeHashTable7()
	{
		String test = "hello";
		quadHashMediocre.add("hello");
		try
		{
			assertTrue(quadHashMediocre.contains(test));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}

	}
	
	@Test
	public void testAddQuadProbeHashTable8()
	{
		String test = "hello";
		quadHashBad.add("hello");
		try
		{
			assertTrue(quadHashBad.contains(test));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}

	}

	/****************************************************************
	 * TEST addAll()
	 ****************************************************************/

	@Test
	public void testAddAllQuadProbeHashTable1()
	{
		testCollection.add("hey");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");

		try
		{
			assertTrue(quadHashGood.addAll(testCollection));

			assertFalse(quadHashGood.addAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(quadHashGood.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}

	@Test
	public void testAddAllQuadProbeHashTable2()
	{
		testCollection.add(" ");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");

		try
		{
			assertTrue(quadHashGood.addAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(quadHashGood.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}
	
	@Test
	public void testAddAllQuadProbeHashTable3()
	{
		testCollection.add("hey");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");

		try
		{
			assertTrue(quadHashMediocre.addAll(testCollection));

			assertFalse(quadHashMediocre.addAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(quadHashMediocre.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}
	
	@Test
	public void testAddAllQuadProbeHashTable4()
	{
		testCollection.add("hey");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");

		try
		{
			assertTrue(quadHashBad.addAll(testCollection));

			assertFalse(quadHashBad.addAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(quadHashBad.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}

	/****************************************************************
	 * TEST clear()
	 ****************************************************************/

	@Test
	public void testClearQuadProbeHashTable1()
	{
		quadHashGood.add("sup");
		quadHashGood.add("hey");
		quadHashGood.add("hello");
		quadHashGood.clear();
		assertTrue(quadHashGood.isEmpty());
	}
	
	@Test
	public void testClearQuadProbeHashTable2()
	{
		quadHashMediocre.add("sup");
		quadHashMediocre.add("hey");
		quadHashMediocre.add("hello");
		quadHashMediocre.clear();
		assertTrue(quadHashMediocre.isEmpty());
	}
	
	@Test
	public void testClearQuadProbeHashTable3()
	{
		quadHashBad.add("sup");
		quadHashBad.add("hey");
		quadHashBad.add("hello");
		quadHashBad.clear();
		assertTrue(quadHashBad.isEmpty());
	}

	/****************************************************************
	 * TEST contains()
	 ****************************************************************/

	@Test
	public void testContainsQuadProbeHashTable1()
	{
		quadHashGood.add("hello");
		quadHashGood.add("world");
		try
		{
			assertTrue(quadHashGood.contains("world"));
			assertTrue(quadHashGood.contains("hello"));
			assertFalse(quadHashGood.contains("yes"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}
	
	@Test
	public void testContainsQuadProbeHashTable2()
	{
		quadHashMediocre.add("hello");
		quadHashMediocre.add("world");
		try
		{
			assertTrue(quadHashMediocre.contains("world"));
			assertTrue(quadHashMediocre.contains("hello"));
			assertFalse(quadHashMediocre.contains("yes"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}
	
	@Test
	public void testContainsQuadProbeHashTable3()
	{
		quadHashBad.add("hello");
		quadHashBad.add("world");
		try
		{
			assertTrue(quadHashBad.contains("world"));
			assertTrue(quadHashBad.contains("hello"));
			assertFalse(quadHashBad.contains("yes"));
		} catch (IndexOutOfBoundsException e)
		{
			fail("Adding to value out of array bounds.");
		}
	}

	/****************************************************************
	 * TEST containsAll()
	 ****************************************************************/

	@Test
	public void testContainsAllQuadProbeHashTable1()
	{
		testCollection.add(" ");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");
		quadHashGood.addAll(testCollection);

		try
		{
			assertTrue(quadHashGood.containsAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(quadHashGood.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}
	
	@Test
	public void testContainsAllQuadProbeHashTable2()
	{
		testCollection.add(" ");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");
		quadHashMediocre.addAll(testCollection);

		try
		{
			assertTrue(quadHashMediocre.containsAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(quadHashMediocre.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}
	
	@Test
	public void testContainsAllQuadProbeHashTable3()
	{
		testCollection.add(" ");
		testCollection.add("what");
		testCollection.add("is");
		testCollection.add("up");
		testCollection.add("how's");
		testCollection.add("it");
		testCollection.add("going");
		quadHashBad.addAll(testCollection);

		try
		{
			assertTrue(quadHashBad.containsAll(testCollection));

			testCollection = new ArrayList<String>();

			assertFalse(quadHashBad.addAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}

	/****************************************************************
	 * TEST isEmpty()
	 ****************************************************************/

	@Test
	public void testIsEmptyQuadProbeHashTable1()
	{
		quadHashGood.add("sup");
		quadHashGood.add("hey");
		quadHashGood.add("hello");
		quadHashGood.clear();
		assertTrue(quadHashGood.isEmpty());
	}
	
	@Test
	public void testIsEmptyQuadProbeHashTable2()
	{
		quadHashMediocre.add("sup");
		quadHashMediocre.add("hey");
		quadHashMediocre.add("hello");
		quadHashMediocre.clear();
		assertTrue(quadHashMediocre.isEmpty());
	}
	
	@Test
	public void testIsEmptyQuadProbeHashTable3()
	{
		quadHashBad.add("sup");
		quadHashBad.add("hey");
		quadHashBad.add("hello");
		quadHashBad.clear();
		assertTrue(quadHashBad.isEmpty());
	}

	/****************************************************************
	 * TEST size()
	 ****************************************************************/

	@Test
	public void testSizeQuadProbeHashTable1()
	{
		quadHashGood.add("sup");
		quadHashGood.add("hey");
		quadHashGood.add("hello");
		assertEquals(3, quadHashGood.size());
	}

	@Test
	public void testSizeQuadProbeHashTable2()
	{
		quadHashGood.add("sup");
		quadHashGood.add("hey");
		quadHashGood.add("hello");
		quadHashGood.add("what");
		quadHashGood.add("yo");
		quadHashGood.add("ho");
		assertEquals(6, quadHashGood.size());
	}
	
	@Test
	public void testSizeQuadProbeHashTable3()
	{
		quadHashMediocre.add("sup");
		quadHashMediocre.add("hey");
		quadHashMediocre.add("hello");
		assertEquals(3, quadHashMediocre.size());
	}
	
	@Test
	public void testSizeQuadProbeHashTable4()
	{
		quadHashBad.add("sup");
		quadHashBad.add("hey");
		quadHashBad.add("hello");
		assertEquals(3, quadHashBad.size());
	}
}
