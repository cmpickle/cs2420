package assignment8;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Gage Glenn
 * @author Cameron Pickle
 *
 */

public class BinarySearchTreeTester
{
	BinarySearchTree<Integer> testTree;
	ArrayList<Integer> testCollection;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		testTree = new BinarySearchTree<Integer>();
		testCollection = new ArrayList<Integer>();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		testTree = null;
		testCollection = null;
	}

	/****************************************************************
	 * TEST add()
	 ****************************************************************/

	/**
	 * Test add by constructing a tree and verifying correct location
	 */
	@Test
	public void testAddRoot()
	{

		testTree.add(5);

		try
		{
			assertEquals(testTree.root.data, (Integer) 5);

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately create Tree");
		}
	}

	@Test
	public void testAddBalancedTree()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);
		testTree.add(4);
		testTree.add(2);
		testTree.add(6);
		testTree.add(8);

		try
		{
			assertEquals(testTree.root.data, (Integer) 5);
			// left Side
			assertEquals(testTree.root.left.data, (Integer) 3);
			assertEquals(testTree.root.left.right.data, (Integer) 4);
			assertEquals(testTree.root.left.left.data, (Integer) 2);
			// Right Side
			assertEquals(testTree.root.right.data, (Integer) 7);
			assertEquals(testTree.root.right.left.data, (Integer) 6);
			assertEquals(testTree.root.right.right.data, (Integer) 8);

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately create Tree");
		}
	}

	@Test
	public void testAddLeftHeavy()
	{

		testTree.add(8);
		testTree.add(7);
		testTree.add(6);
		testTree.add(5);
		testTree.add(4);

		try
		{
			assertEquals(testTree.root.data, (Integer) 8);
			assertEquals(testTree.root.left.data, (Integer) 7);
			assertEquals(testTree.root.left.left.data, (Integer) 6);
			assertEquals(testTree.root.left.left.left.data, (Integer) 5);
			assertEquals(testTree.root.left.left.left.left.data, (Integer) 4);

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately create Tree");
		}
	}

	@Test
	public void testAddRightHeavy()
	{

		testTree.add(4);
		testTree.add(5);
		testTree.add(6);
		testTree.add(7);
		testTree.add(8);

		try
		{
			assertEquals(testTree.root.data, (Integer) 4);
			assertEquals(testTree.root.right.data, (Integer) 5);
			assertEquals(testTree.root.right.right.data, (Integer) 6);
			assertEquals(testTree.root.right.right.right.data, (Integer) 7);
			assertEquals(testTree.root.right.right.right.right.data, (Integer) 8);

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately create Tree");
		}
	}

	@Test
	public void testAddRepeatedVal()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);
		testTree.add(4);
		testTree.add(2);
		testTree.add(6);
		testTree.add(8);

		try
		{
			assertTrue(testTree.add(5));
			assertTrue(testTree.add(3));
			assertTrue(testTree.add(7));
			assertTrue(testTree.add(4));
			assertTrue(testTree.add(2));
			assertTrue(testTree.add(6));
			assertTrue(testTree.add(8));

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately create Tree");
		}
	}

	@Test
	public void testAddReturnTrue()
	{
		try
		{
			assertTrue(testTree.add(5));
			assertTrue(testTree.add(3));
			assertTrue(testTree.add(7));
			assertTrue(testTree.add(4));
			assertTrue(testTree.add(2));
			assertTrue(testTree.add(6));
			assertTrue(testTree.add(8));

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately create Tree");
		}
	}

	@Test
	public void testAddNull()
	{
		try
		{
			assertFalse(testTree.add(null));

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately add Null");
		}
	}

	/****************************************************************
	 * TEST size() (testing for clear() included)
	 ****************************************************************/

	/**
	 * Test size on the tree previously created
	 */

	@Test
	public void testAddRightHeavySize()
	{

		testTree.add(4);
		testTree.add(5);
		testTree.add(6);
		testTree.add(7);
		testTree.add(8);

		try
		{
			assertEquals((Integer) testTree.size(), (Integer) 5);

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately remember tree size");
		}
	}

	@Test
	public void testAddLeftHeavySize()
	{

		testTree.add(8);
		testTree.add(7);
		testTree.add(6);
		testTree.add(5);
		testTree.add(4);

		try
		{
			assertEquals((Integer) testTree.size(), (Integer) 5);

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately remember tree size");
		}
	}

	@Test
	public void testSizeBalancedTree()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);
		testTree.add(4);
		testTree.add(2);
		testTree.add(6);
		testTree.add(8);

		try
		{
			assertEquals((Integer) testTree.size(), (Integer) 7);

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately remember tree size");
		}
	}

	@Test
	public void testClear()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);
		testTree.add(4);
		testTree.add(2);
		testTree.add(6);
		testTree.add(8);

		try
		{
			testTree.clear();
			assertEquals((Integer) testTree.size(), (Integer) 0);

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately remember tree size");
		}
	}

	@Test
	public void testClearOnEmptyTree()
	{

		try
		{
			testTree.clear();
			assertEquals((Integer) testTree.size(), (Integer) 0);

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately remember tree size");
		}
	}

	/****************************************************************
	 * TEST addAll()
	 ****************************************************************/

	/**
	 * Test addAll on a tree previously created
	 */

	@Test
	public void testAddAllBoolean()
	{

		testCollection.add(5);
		testCollection.add(3);
		testCollection.add(7);
		testCollection.add(4);
		testCollection.add(2);
		testCollection.add(6);
		testCollection.add(8);

		try
		{
			assertTrue(testTree.addAll(testCollection));

			testCollection = new ArrayList<Integer>();

			assertFalse(testTree.addAll(testCollection));

			assertEquals(testTree.root.data, (Integer) 5);
			// left Side
			assertEquals(testTree.root.left.data, (Integer) 3);
			assertEquals(testTree.root.left.right.data, (Integer) 4);
			assertEquals(testTree.root.left.left.data, (Integer) 2);
			// Right Side
			assertEquals(testTree.root.right.data, (Integer) 7);
			assertEquals(testTree.root.right.left.data, (Integer) 6);
			assertEquals(testTree.root.right.right.data, (Integer) 8);

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}

	@Test
	public void testAddAllPartial()
	{

		testCollection.add(5);
		testCollection.add(3);
		testCollection.add(7);
		testCollection.add(4);
		testCollection.add(2);
		testCollection.add(6);
		testCollection.add(8);

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);

		try
		{
			assertTrue(testTree.addAll(testCollection));
			testCollection = new ArrayList<Integer>();
			assertFalse(testTree.addAll(testCollection));

			assertEquals(testTree.root.data, (Integer) 5);
			// left Side
			assertEquals(testTree.root.left.data, (Integer) 3);
			assertEquals(testTree.root.left.right.data, (Integer) 3);
			assertEquals(testTree.root.left.right.right.data, (Integer) 4);
			assertEquals(testTree.root.left.left.data, (Integer) 2);
			// Right Side
			assertEquals(testTree.root.right.data, (Integer) 7);
			assertEquals(testTree.root.right.left.data, (Integer) 5);
			assertEquals(testTree.root.right.left.right.data, (Integer) 6);
			assertEquals(testTree.root.right.right.data, (Integer) 7);
			assertEquals(testTree.root.right.right.right.data, (Integer) 8);

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}

	@Test
	public void testAddAllDuplicated()
	{

		testCollection.add(5);
		testCollection.add(3);
		testCollection.add(7);

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);

		try
		{
			assertTrue(testTree.addAll(testCollection));

			assertEquals(testTree.root.data, (Integer) 5);
			// left Side
			assertEquals(testTree.root.left.data, (Integer) 3);
			assertEquals(testTree.root.left.right.data, (Integer) 3);
			// Right Side
			assertEquals(testTree.root.right.data, (Integer) 7);
			assertEquals(testTree.root.right.left.data, (Integer) 5);
			assertEquals(testTree.root.right.right.data, (Integer) 7);

		} catch (NullPointerException e)
		{
			fail("Failure to add Collection");
		}
	}

	/****************************************************************
	 * TEST contains()
	 ****************************************************************/

	@Test
	public void testContains()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);

		try
		{

			assertTrue(testTree.contains(5));
			assertTrue(testTree.contains(3));
			assertTrue(testTree.contains(7));

		} catch (NullPointerException e)
		{
			fail("Failure to find value");
		}
	}

	@Test
	public void testContainsOnNonPresentValues()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);

		try
		{

			assertFalse(testTree.contains(1));
			assertFalse(testTree.contains(2));
			assertFalse(testTree.contains(4));

		} catch (NullPointerException e)
		{
			fail("Failure to find value");
		}
	}

	@Test
	public void testContainsNull()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);

		try
		{

			assertFalse(testTree.contains(null));

		} catch (NullPointerException e)
		{
			fail("Failure to find value");
		}
	}

	@Test
	public void testContainsRemovedValue()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);

		try
		{

			assertTrue(testTree.contains(3));
			assertTrue(testTree.remove(3));
			assertFalse(testTree.contains(3));

		} catch (NullPointerException e)
		{
			fail("Failure to find value");
		}
	}

	/****************************************************************
	 * TEST containsAll()
	 ****************************************************************/

	@Test
	public void testContainsAll()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);

		testCollection.add(5);
		testCollection.add(3);
		testCollection.add(7);

		try
		{

			assertTrue(testTree.containsAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to find value");
		}
	}

	@Test
	public void testContainsAllOutOfOrder()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);

		testCollection.add(7);
		testCollection.add(3);
		testCollection.add(5);

		try
		{

			assertTrue(testTree.containsAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to find value");
		}
	}

	@Test
	public void testContainsAllCollectionDuplicates()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);

		testCollection.add(7);
		testCollection.add(3);
		testCollection.add(7);

		try
		{

			assertTrue(testTree.containsAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to find value");
		}
	}

	@Test
	public void testContainsAllPartialCollection()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);

		testCollection.add(7);
		testCollection.add(3);

		try
		{

			assertTrue(testTree.containsAll(testCollection));

		} catch (NullPointerException e)
		{
			fail("Failure to find value");
		}
	}

	/****************************************************************
	 * TEST first()
	 ****************************************************************/

	@Test
	public void testFirstBalancedTree()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);
		testTree.add(4);
		testTree.add(2);
		testTree.add(6);
		testTree.add(8);

		try
		{
			assertEquals(testTree.first(), (Integer) 2);

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	@Test
	public void testFirstLeftHeavy()
	{

		testTree.add(5);
		testTree.add(4);
		testTree.add(3);
		testTree.add(2);

		try
		{
			assertEquals(testTree.first(), (Integer) 2);

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	@Test
	public void testFirstRightHeavy()
	{

		testTree.add(2);
		testTree.add(3);
		testTree.add(4);
		testTree.add(5);

		try
		{
			assertEquals(testTree.first(), (Integer) 2);

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	/****************************************************************
	 * TEST Last()
	 ****************************************************************/

	@Test
	public void testLastBalancedTree()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);
		testTree.add(4);
		testTree.add(2);
		testTree.add(6);
		testTree.add(8);

		try
		{
			assertEquals(testTree.last(), (Integer) 8);

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	@Test
	public void testLastLeftHeavy()
	{

		testTree.add(5);
		testTree.add(4);
		testTree.add(3);
		testTree.add(2);

		try
		{
			assertEquals(testTree.last(), (Integer) 5);

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	@Test
	public void testlastRightHeavy()
	{

		testTree.add(2);
		testTree.add(3);
		testTree.add(4);
		testTree.add(5);

		try
		{
			assertEquals(testTree.last(), (Integer) 5);

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	/****************************************************************
	 * TEST isEmpty()
	 ****************************************************************/

	@Test
	public void testNonEmptyTree()
	{

		testTree.add(5);
		testTree.add(3);
		testTree.add(7);
		testTree.add(4);
		testTree.add(2);
		testTree.add(6);
		testTree.add(8);

		try
		{
			assertFalse(testTree.isEmpty());

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	@Test
	public void testEmptyTree()
	{

		try
		{
			assertTrue(testTree.isEmpty());

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	@Test
	public void testEmptyRemovedRoot()
	{
		testTree.add(5);
		testTree.remove(5);
		try
		{
			assertTrue(testTree.isEmpty());

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	@Test
	public void testNonEmptyRemoval()
	{
		testTree.add(5);
		testTree.add(4);
		testTree.remove(5);
		try
		{
			assertFalse(testTree.isEmpty());

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	@Test
	public void testNonEmptyLeftRemoval()
	{
		testTree.add(5);
		testTree.add(4);
		testTree.remove(4);
		try
		{
			assertFalse(testTree.isEmpty());

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	@Test
	public void testNonEmptyRightRemoval()
	{
		testTree.add(5);
		testTree.add(6);
		testTree.remove(6);
		try
		{
			assertFalse(testTree.isEmpty());

		} catch (NullPointerException e)
		{
			fail("Failure to find First");
		}
	}

	/****************************************************************
	 * TEST remove()
	 ****************************************************************/

	@Test
	public void testBSTremove()
	{
		testTree.add(5);
		testTree.add(3);
		testTree.add(7);
		testTree.add(4);
		testTree.add(2);
		testTree.add(6);
		testTree.add(8);

		try
		{
			assertEquals(testTree.size(), 7);
			assertTrue(testTree.remove(3));

			// Check Change

			assertEquals(testTree.size(), 6);
			assertEquals((Integer) testTree.root.left.data, (Integer) 4);
			assertEquals((Integer) testTree.root.left.left.data, (Integer) 2);

			// Remove Again

			assertTrue(testTree.remove(7));

			// Check Second Change

			assertEquals(testTree.size(), 5);
			assertEquals((Integer) testTree.root.right.data, (Integer) 8);
			assertEquals((Integer) testTree.root.right.left.data, (Integer) 6);

		} catch (NullPointerException e)
		{
			fail("Failure to remove properly");
		}
	}

	@Test
	public void testRightBSTRemove()
	{
		testTree.add(1);
		testTree.add(3);
		testTree.add(4);
		testTree.add(6);
		testTree.add(7);
		testTree.add(8);
		testTree.add(8);

		try
		{
			assertEquals(testTree.size(), 7);
			assertTrue(testTree.remove(6));

			// Check Change

			assertEquals((Integer) testTree.root.right.right.right.data, (Integer) 7);
			assertEquals((Integer) testTree.root.right.right.right.right.data, (Integer) 8);

			// Remove Root

			assertTrue(testTree.remove(1));

			// Check Change

			assertEquals((Integer) testTree.root.data, (Integer) 3);
		} catch (NullPointerException e)
		{
			fail("Failure to remove properly.");
		}
	}

	@Test
	public void testLeftBSTRemove()
	{
		testTree.add(112);
		testTree.add(93);
		testTree.add(74);
		testTree.add(66);
		testTree.add(57);
		testTree.add(58);
		testTree.add(48);
		testTree.add(8);

		try
		{
			assertEquals(testTree.size(), 8);
			assertTrue(testTree.remove(66));

			// Check Change

			assertEquals((Integer) testTree.root.left.left.left.data, (Integer) 57);
			assertEquals((Integer) testTree.root.left.left.left.left.data, (Integer) 48);
			assertEquals((Integer) testTree.root.left.left.left.right.data, (Integer) 58);
		} catch (NullPointerException e)
		{
			fail("Failure to remove properly.");
		}
	}

	@Test
	public void testBSTRootremove()
	{
		testTree.add(5);
		testTree.add(3);
		testTree.add(7);
		testTree.add(4);
		testTree.add(2);
		testTree.add(6);
		testTree.add(8);

		try
		{
			assertEquals(testTree.size(), 7);
			assertTrue(testTree.remove(5));

			// Check Change

			assertEquals(testTree.size(), 6);
			assertEquals((Integer) testTree.root.data, (Integer) 6);
			assertEquals((Integer) testTree.root.left.data, (Integer) 3);
			assertEquals((Integer) testTree.root.right.data, (Integer) 7);

			assertNull(testTree.root.right.left);

		} catch (NullPointerException e)
		{
			fail("Failure to remove properly");
		}
	}

	@Test
	public void testLeftSideremove()
	{
		testTree.add(6);
		testTree.add(5);
		testTree.add(3);
		testTree.add(2);
		testTree.add(4);

		try
		{
			assertEquals(testTree.size(), 5);
			assertTrue(testTree.remove(5));

			// Check Change

			assertEquals(testTree.size(), 4);
			assertEquals((Integer) testTree.root.data, (Integer) 6);
			assertEquals((Integer) testTree.root.left.data, (Integer) 3);
			assertEquals((Integer) testTree.root.left.left.data, (Integer) 2);
			assertEquals((Integer) testTree.root.left.right.data, (Integer) 4);

		} catch (NullPointerException e)
		{
			fail("Failure to remove properly");
		}
	}

	@Test
	public void testRemoveNull()
	{
		try
		{
			assertFalse(testTree.remove(null));

		} catch (NullPointerException e)
		{
			fail("Failure to appropriately remove Null");
		}
	}

	/****************************************************************
	 * TEST toArrayList()
	 ****************************************************************/

	@Test
	public void testBSTToArr()
	{
		testTree.add(5);
		testTree.add(3);
		testTree.add(7);
		testTree.add(4);
		testTree.add(2);
		testTree.add(6);
		testTree.add(8);

		try
		{
			ArrayList<Integer> testList = testTree.toArrayList();

			for (int i = 2; i <= 8; i++)
			{
				assertEquals((Integer) i, (Integer) testList.get(i - 2));
			}

		} catch (NullPointerException e)
		{
			fail("Failure to remove properly");
		}
	}

	@Test
	public void testLeftBSTToArr()
	{
		testTree.add(112);
		testTree.add(93);
		testTree.add(74);
		testTree.add(66);
		testTree.add(57);
		testTree.add(58);
		testTree.add(48);
		testTree.add(8);

		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(8);
		testList.add(48);
		testList.add(57);
		testList.add(58);
		testList.add(66);
		testList.add(74);
		testList.add(93);
		testList.add(112);

		try
		{
			assertEquals(testTree.size(), 8);
			assertEquals(testTree.toArrayList(), testList);

		} catch (NullPointerException e)
		{
			fail("Failure to remove properly.");
		}
	}

	/****************************************************************
	 * END BinaryTree Testing
	 ****************************************************************/

	/****************************************************************
	 * SpellCheckUtil Testing
	 ****************************************************************/
	@Test
	public void testSpellCheckAdd()
	{
		SpellChecker mySC = new SpellChecker(new File("dictionary.txt"));

		run_spell_check(mySC, "hello_world.txt");

		mySC.removeFromDictionary("world");

		run_spell_check(mySC, "hello_world.txt");

		mySC.addToDictionary("world");

		run_spell_check(mySC, "hello_world.txt");
	}

	@Test
	public void testSpellCheckRemove()
	{
		SpellChecker mySC = new SpellChecker(new File("dictionary.txt"));

		run_spell_check(mySC, "hello_world.txt");

		mySC.removeFromDictionary("world");

		run_spell_check(mySC, "hello_world.txt");

		mySC.addToDictionary("world");

		run_spell_check(mySC, "hello_world.txt");
	}

	private static void run_spell_check(SpellChecker sc, String documentFilename)
	{

		File doc = new File(documentFilename);
		List<String> misspelledWords = sc.spellCheck(doc);
		if (misspelledWords.size() == 0)
		{
			System.out.println("There are no misspelled words in file " + doc + ".");
		} else
		{
			System.out.println("The misspelled words in file " + doc + " are:");
			for (String w : misspelledWords)
			{
				System.out.println("\t" + w);
			}
		}
	}
}
