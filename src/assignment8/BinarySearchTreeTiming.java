package assignment8;

import java.util.Random;
import java.util.TreeSet;

/**
 * A class which performs various timing experiments on the BinarySearchTree
 * 
 * @author Cameron Pickle and Gage Glenn
 * 
 * */

public class BinarySearchTreeTiming {
	public static void main(String[] args)
	{
		 SortedOrderAddTimer();

		// RandomOrderAddTimer();

//		JavaRandomOrderAddTimer();
	}

	/**
	 * A method that times the add method in BinarySearchTree using ordered inputs
	 * */

	public static void SortedOrderAddTimer()
	{
		long startTime, midTime, endTime;

		BinarySearchTree<Integer> iTree = new BinarySearchTree<Integer>();

		for (int q = 1; q < 100000; q++)
		{

			// Grow the Tree
			for (int i = 0; i < 999; i++)
			{
				iTree.add(i + (q * 999));
			}

			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
			{ // empty block
			}

			// Now, run the test.

			startTime = System.nanoTime();

			for (int i = 0; i < 100; i++)
			{
				iTree.add(1000 + 1000 * q * q);
			}

			midTime = System.nanoTime();

			for (int i = 0; i < 100; i++);

			endTime = System.nanoTime();

			// Compute the time

			double averageTime = (((midTime - startTime) - (endTime - midTime)) / 100);

			System.out.println(averageTime);

		}
	}

	/**
	 * A method that times the add method in BinarySearchTree using random inputs
	 * */
	public static void RandomOrderAddTimer()
	{
		long startTime, midTime, endTime;
		Random rand = new Random(1337);

		BinarySearchTree<Integer> iTree = new BinarySearchTree<Integer>();

		for (int q = 1; q < 100000; q++)
		{

			// Grow the Tree
			for (int i = 0; i < 999; i++)
			{
				iTree.add(rand.nextInt());
			}

			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
			{ // empty block
			}

			// Now, run the test.

			startTime = System.nanoTime();

			for (int i = 0; i < 100; i++)
			{
				iTree.add(rand.nextInt());
			}

			midTime = System.nanoTime();

			for (int i = 0; i < 100; i++)
				rand.nextInt();

			endTime = System.nanoTime();

			// Compute the time

			double averageTime = (((midTime - startTime) - (endTime - midTime)) / 100);

			System.out.println(averageTime);

		}
	}

	/**
	 * A method that times the add method in Java's tree set using random inputs
	 * */

	public static void JavaRandomOrderAddTimer()
	{
		long startTime, midTime, endTime;
		Random rand = new Random(1337);

		TreeSet<Integer> iTree = new TreeSet<Integer>();

		for (int q = 1; q < 100000; q++)
		{

			// Grow the Tree
			for (int i = 0; i < 999; i++)
			{
				iTree.add(rand.nextInt());
			}

			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
			{ // empty block
			}

			// Now, run the test.

			startTime = System.nanoTime();

			for (int i = 0; i < 100; i++)
			{
				iTree.add(rand.nextInt());
			}

			midTime = System.nanoTime();

			for (int i = 0; i < 100; i++)
				rand.nextInt();

			endTime = System.nanoTime();

			// Compute the time

			double averageTime = (((midTime - startTime) - (endTime - midTime)) / 100);

			System.out.println(averageTime);

		}
	}
}
