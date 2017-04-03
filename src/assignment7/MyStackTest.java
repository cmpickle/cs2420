package assignment7;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Gage Glenn
 * @author Cameron Pickle
 *
 */

@SuppressWarnings("static-access")
public class MyStackTest
{
	MyStack<Integer> testStack;
	BalancedSymbolChecker balanceTest;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		testStack = new MyStack<Integer>();
		balanceTest = new BalancedSymbolChecker();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		testStack = null;
		balanceTest = null;
	}

	/****************************************************************
	 * TEST isEmpty()
	 ****************************************************************/

	/**
	 * Test method for MyStack, using an empty unedited Stack.
	 */
	@Test
	public void testIsEmptyOnNewStack()
	{

		try
		{
			assertTrue(testStack.isEmpty());
		} catch (NullPointerException e)
		{
			fail("Stack isn't empty");
		}
	}

	/**
	 * Test method for MyStack, using an empty unedited Stack that has had an
	 * item added and removed.
	 */
	@Test
	public void testIsEmptyOnEmptiedStack()
	{

		testStack.push(1);
		testStack.pop();

		try
		{

			assertTrue(testStack.isEmpty());
		} catch (NullPointerException e)
		{
			fail("Stack isn't empty");
		}
	}

	/**
	 * Test method for MyStack, using an empty unedited Stack that has had an
	 * item added and removed.
	 */
	@Test
	public void testIsEmptyOnClearedStack()
	{
		for (int i = 0; i < 100; i++)
			testStack.push(1);

		testStack.clear();

		try
		{

			assertTrue(testStack.isEmpty());
		} catch (NullPointerException e)
		{
			fail("Stack isn't empty");
		}
	}

	/****************************************************************
	 * TEST clear
	 ****************************************************************/
	@Test
	public void testClearOnStack()
	{
		for (int i = 0; i < 100; i++)
			testStack.push(1);

		try
		{
			assertFalse(testStack.isEmpty());
			testStack.clear();
			assertTrue(testStack.isEmpty());
		} catch (NullPointerException e)
		{
			fail("Stack isn't empty");
		}
	}

	@Test
	public void testClearOnEmptyStack()
	{

		try
		{
			assertTrue(testStack.isEmpty());
			testStack.clear();
			assertTrue(testStack.isEmpty());
		} catch (NullPointerException e)
		{
			fail("Stack isn't empty");
		}
	}

	@Test
	public void testClearOnStackContainingNulls()
	{

		for (int i = 0; i < 100; i++)
			testStack.push(null);

		try
		{
			assertFalse(testStack.isEmpty());
			testStack.clear();
			assertTrue(testStack.isEmpty());
		} catch (NullPointerException e)
		{
			fail("Stack isn't empty");
		}
	}

	/****************************************************************
	 * TEST Peek
	 ****************************************************************/
	@Test
	public void testPeekAsElementsAreAdded()
	{

		for (int i = 0; i < 100; i++)
		{
			testStack.push(i);

			try
			{
				assertEquals((Integer) testStack.peek(), (Integer) i);
			} catch (NullPointerException e)
			{
				fail("Stack isn't empty");
			}
		}
	}

	@Test
	public void testPeekOnEmptyStack()
	{

		try
		{
			assertNull((Integer) testStack.peek());
		} catch (NoSuchElementException e)
		{

		}

	}

	/****************************************************************
	 * TEST Pop
	 ****************************************************************/
	@Test
	public void testPopAsElementsAreAdded()
	{

		for (int i = 0; i < 100; i++)
		{
			testStack.push(i);

			try
			{
				assertEquals((Integer) testStack.pop(), (Integer) i);
			} catch (NullPointerException e)
			{
				fail("Stack isn't empty");
			}
		}
	}

	@Test
	public void testPopAfterElementsAreAdded()
	{

		for (int i = 0; i < 100; i++)
		{
			testStack.push(i);
		}

		for (int i = 99; i >= 0; i--)
		{

			try
			{
				assertEquals((Integer) testStack.pop(), (Integer) i);
			} catch (NullPointerException e)
			{
				fail("Stack isn't empty");
			}
		}
	}

	@Test
	public void testPopOnEmptyStack()
	{

		try
		{
			assertNull((Integer) testStack.pop());
		} catch (NoSuchElementException e)
		{

		}
	}

	/****************************************************************
	 * TEST Push
	 ****************************************************************/
	@Test
	public void testPushOnEmptyStack()
	{

		testStack.push(1);

		try
		{
			assertEquals((Integer) testStack.peek(), (Integer) 1);
		} catch (NoSuchElementException e)
		{

		}
	}

	@Test
	public void testPushOnSmallStack()
	{

		testStack.push(1);
		testStack.push(2);
		testStack.push(3);

		try
		{
			assertEquals((Integer) testStack.peek(), (Integer) 3);
		} catch (NoSuchElementException e)
		{

		}
	}

	@Test
	public void testPushOnMediumStack()
	{
		for (int i = 0; i < 1000; i++)
			testStack.push(i);

		try
		{
			assertEquals((Integer) testStack.peek(), (Integer) 999);
		} catch (NoSuchElementException e)
		{

		}
	}

	@Test
	public void testPushOnLargeStack()
	{
		for (int i = 0; i < 1000000; i++)
			testStack.push(i);

		try
		{
			assertEquals((Integer) testStack.peek(), (Integer) 999999);
		} catch (NoSuchElementException e)
		{

		}
	}

	/****************************************************************
	 * TEST Size
	 ****************************************************************/
	@Test
	public void testSizeOnEmptyStack()
	{

		try
		{
			assertEquals(testStack.size(), 0);
		} catch (NoSuchElementException e)
		{

		}
	}

	@Test
	public void testSizeOnSmallStack()
	{

		for (int i = 0; i < 10; i++)
			testStack.push(i);

		try
		{
			assertEquals(testStack.size(), 10);
		} catch (NoSuchElementException e)
		{

		}
	}

	@Test
	public void testSizeOnMediumStack()
	{

		for (int i = 0; i < 1000; i++)
			testStack.push(i);

		try
		{
			assertEquals(testStack.size(), 1000);
		} catch (NoSuchElementException e)
		{

		}
	}

	@Test
	public void testSizeOnLargeStack()
	{

		for (int i = 0; i < 1000000; i++)
			testStack.push(i);

		try
		{
			assertEquals(testStack.size(), 1000000);
		} catch (NoSuchElementException e)
		{

		}
	}

	@Test
	public void testSizeOnLargePoppedStack()
	{

		for (int i = 0; i < 1000000; i++)
			testStack.push(i);
		for (int i = 0; i < 1000000; i++)
			testStack.pop();

		try
		{
			assertEquals(testStack.size(), 0);
		} catch (NoSuchElementException e)
		{

		}
	}

	@Test
	public void testSizeOnMediumPoppedStack()
	{

		for (int i = 0; i < 10000; i++)
			testStack.push(i);
		for (int i = 0; i < 10000; i++)
			testStack.pop();

		try
		{
			assertEquals(testStack.size(), 0);
		} catch (NoSuchElementException e)
		{

		}
	}

	@Test
	public void testSizeOnSmallPoppedStack()
	{

		for (int i = 0; i < 100; i++)
			testStack.push(i);
		for (int i = 0; i < 100; i++)
			testStack.pop();

		try
		{
			assertEquals(testStack.size(), 0);
		} catch (NoSuchElementException e)
		{

		}
	}

	@Test
	public void testSizeOnPartiallyPoppedStack()
	{

		for (int i = 0; i < 100; i++)
			testStack.push(i);
		for (int i = 0; i < 50; i++)
			testStack.pop();

		try
		{
			assertEquals(testStack.size(), 50);
		} catch (NoSuchElementException e)
		{

		}
	}

	/****************************************************************
	 * End MyStack Testing
	 ****************************************************************/

	/****************************************************************
	 * Start BalancedSymbolChecker Testing - Using Provided files
	 ****************************************************************/

	@Test
	public void testA7Example1()
	{

		try
		{
			assertEquals("ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.",
					balanceTest.checkFile("A7_examples/Class1.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	
	@Test
	public void testA7Example2()
	{

		try
		{
			assertEquals("ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.",
					balanceTest.checkFile("A7_examples/Class2.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example3()
	{

		try
		{
			assertEquals("No errors found. All symbols match.",
					balanceTest.checkFile("A7_examples/Class3.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example4()
	{

		try
		{
			assertEquals("ERROR: File ended before closing comment.",
					balanceTest.checkFile("A7_examples/Class4.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example5()
	{

		try
		{
			assertEquals("ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.",
					balanceTest.checkFile("A7_examples/Class5.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example6()
	{

		try
		{
			assertEquals("No errors found. All symbols match.",
					balanceTest.checkFile("A7_examples/Class6.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example7()
	{

		try
		{
			assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.",
					balanceTest.checkFile("A7_examples/Class7.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example8()
	{

		try
		{
			assertEquals("ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.",
					balanceTest.checkFile("A7_examples/Class8.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example9()
	{

		try
		{
			assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.",
					balanceTest.checkFile("A7_examples/Class9.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example10()
	{

		try
		{
			assertEquals("ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.",
					balanceTest.checkFile("A7_examples/Class10.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example11()
	{

		try
		{
			assertEquals("ERROR: Unmatched symbol at the end of file. Expected }.",
					balanceTest.checkFile("A7_examples/Class11.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example12()
	{

		try
		{
			assertEquals("No errors found. All symbols match.",
					balanceTest.checkFile("A7_examples/Class12.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example13()
	{

		try
		{
			assertEquals("No errors found. All symbols match.",
					balanceTest.checkFile("A7_examples/Class13.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	@Test
	public void testA7Example14()
	{

		try
		{
			assertEquals("No errors found. All symbols match.",
					balanceTest.checkFile("A7_examples/Class14.java"));
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

	}
	


}
