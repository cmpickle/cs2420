package assignment10;

import java.util.Random;

/**
 * A class which performs various timing experiments on the BinarySearchTree
 * 
 * @author Cameron Pickle
 * @author Daniel Avery
 * 
 * */

public class HashTableTiming {

	static GoodHashFunctor good;
	static MediocreHashFunctor mediocre;
	static BadHashFunctor bad;

	static QuadProbeHashTable quadHashGood;
	static QuadProbeHashTable quadHashMediocre;
	static QuadProbeHashTable quadHashBad;

	static ChainingHashTable chainingGood;
	static ChainingHashTable chainingMediocre;
	static ChainingHashTable chainingBad;

	static Random rand;

	static int timesToLoop = 10000;

	public static void main(String[] args)
	{
		/*
		 * The parameter in the timing tests determine if it will test the run time or the collisions
		 * 1 = timing
		 * 2 = collisions
		 */
//		 BadHashFunctorPerformanceTimerQuad(1);

		 MediocreHashFunctorPerformanceTimerQuad(1);

//		 GoodHashFunctorPerformanceTimerQuad(1);
		 
//		 GoodHashFunctorPerformanceTimerChaining(1);
	}

	/**
	 * A method that times the BadHashFunctor performance time
	 * */
	public static void BadHashFunctorPerformanceTimerQuad(int state)
	{
		long startTime, midTime, endTime;

		bad = new BadHashFunctor();

		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000)
		{ // empty block
		}

		for (int arraySize = 400; arraySize < 100000; arraySize *= 2)
		{

			double averageTime = 0;
			int totalCollisionCount = 0;
			
			for (int j = 0; j < timesToLoop; j++)
			{
				quadHashBad = new QuadProbeHashTable(arraySize, bad);
				// Now, run the test.

				startTime = System.nanoTime();

				for (int i = 0; i < 100; i++)
				{
					quadHashBad.add(randomString(i % 10 + 1));
				}

				midTime = System.nanoTime();

				for (int i = 0; i < 100; i++)
					randomString(i % 10 + 1);

				endTime = System.nanoTime();

				totalCollisionCount += quadHashBad.collisionCounter;
				averageTime += (midTime - startTime) - (endTime - midTime);
			}

			if (state == 1)
			{
				// Compute the time
				averageTime /= timesToLoop;
				System.out.println(averageTime);
				
			} else
				System.out.println(totalCollisionCount/timesToLoop);

		}
	}

	/**
	 * A method that times the MediocreHashFunctor performance time
	 * */
	public static void MediocreHashFunctorPerformanceTimerQuad(int state)
	{
		long startTime, midTime, endTime;

		mediocre = new MediocreHashFunctor();

		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000)
		{ // empty block
		}

		for (int arraySize = 400; arraySize < 100000; arraySize *= 2)
		{

			double averageTime = 0;
			int totalCollisionCount = 0;
			
			for (int j = 0; j < timesToLoop; j++)
			{
				quadHashMediocre = new QuadProbeHashTable(arraySize, mediocre);
				// Now, run the test.

				startTime = System.nanoTime();

				for (int i = 0; i < 100; i++)
				{
					quadHashMediocre.add(randomString(i % 10 + 1));
				}

				midTime = System.nanoTime();

				for (int i = 0; i < 100; i++)
					randomString(i % 10 + 1);

				endTime = System.nanoTime();

				totalCollisionCount += quadHashMediocre.collisionCounter;
				averageTime += (midTime - startTime) - (endTime - midTime);
			}

			if (state == 1)
			{
				// Compute the time
				averageTime /= timesToLoop;
				System.out.println(averageTime);
				
			} else
				System.out.println(totalCollisionCount/timesToLoop);

		}
	}

	/**
	 * A method that times the GoodHashFunctor performance time
	 * */
	public static void GoodHashFunctorPerformanceTimerQuad(int state)
	{
		long startTime, midTime, endTime;

		good = new GoodHashFunctor();

		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000)
		{ // empty block
		}

		for (int arraySize = 400; arraySize < 100000; arraySize *= 2)
		{

			double averageTime = 0;
			int totalCollisionCount = 0;
			
			for (int j = 0; j < timesToLoop; j++)
			{
				quadHashGood = new QuadProbeHashTable(arraySize, good);
				// Now, run the test.

				startTime = System.nanoTime();

				for (int i = 0; i < 100; i++)
				{
					quadHashGood.add(randomString(i % 10 + 1));
				}

				midTime = System.nanoTime();

				for (int i = 0; i < 100; i++)
					randomString(i % 10 + 1);

				endTime = System.nanoTime();

				totalCollisionCount += quadHashGood.collisionCounter;
				averageTime += (midTime - startTime) - (endTime - midTime);
			}

			if (state == 1)
			{
				// Compute the time
				averageTime /= timesToLoop;
				System.out.println(averageTime);
				
			} else
				System.out.println(totalCollisionCount/timesToLoop);

		}
	}
	
	/**
	 * A method that times the GoodHashFunctor performance time
	 * */
	public static void GoodHashFunctorPerformanceTimerChaining(int state)
	{
		long startTime, midTime, endTime;

		good = new GoodHashFunctor();

		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000)
		{ // empty block
		}

		for (int arraySize = 400; arraySize < 100000; arraySize *= 2)
		{

			double averageTime = 0;
			int totalCollisionCount = 0;
			
			for (int j = 0; j < timesToLoop; j++)
			{
				chainingGood = new ChainingHashTable(arraySize, good);
				// Now, run the test.

				startTime = System.nanoTime();

				for (int i = 0; i < 100; i++)
				{
					chainingGood.add(randomString(i % 10 + 1));
				}

				midTime = System.nanoTime();

				for (int i = 0; i < 100; i++)
					randomString(i % 10 + 1);

				endTime = System.nanoTime();

				totalCollisionCount += chainingGood.collisionCounter;
				averageTime += (midTime - startTime) - (endTime - midTime);
			}

			if (state == 1)
			{
				// Compute the time
				averageTime /= timesToLoop;
				System.out.println(averageTime);
				
			} else
				System.out.println(totalCollisionCount/timesToLoop);

		}
	}

	// Create a random string [a-z] of specified length
	public static String randomString(int length)
	{
		rand = new Random();
		String retval = "";
		for (int i = 0; i < length; i++)
		{
			// ASCII values a-z,A-Z are contiguous (52 characters)
			retval += (char) ('a' + (rand.nextInt(26)));
		}
		return retval;
	}
}
