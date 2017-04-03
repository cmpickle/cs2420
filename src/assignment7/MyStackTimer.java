package assignment7;

/**
 * Timing Code for MyStackTiming methods
 * 
 * @author Cameron Pickle
 * @author Gage Glenn
 *
 */

import java.util.Random;

public class MyStackTimer
{

	public static void main(String[] args)
	{
//		pushTimer();
		
//		peekTimer();
		
//		popTimer();
	}
	
	/**
	 * A method that times the push method in MyStack
	 * */

	public static void pushTimer()
	{
		long startTime, stopTime, stopTime2;
		Random rand = new Random();
		int timesToLoop = 1000;

		MyStack<Integer> iStack = new MyStack<Integer>();

		for (int q = 0; q < 100000; q++)
		{
			
			//Grow the Stack
			for(int i = 0; i < 999; i++){
				iStack.push(rand.nextInt());
			}
			
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000)
			{ // empty block
			}

			// Now, run the test.

			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++)
				iStack.push(rand.nextInt());

			stopTime = System.nanoTime();
			
			for(int i = 0; i < timesToLoop; i++)
				rand.nextInt();
			
			stopTime2 = System.nanoTime();

			// Compute the time

			double averageTime = ((stopTime - startTime - (stopTime2 - stopTime))/timesToLoop);

			System.out.println(averageTime);
			

		}
	}
	
	/**
	 * A method that times the peek method in MyStack
	 * */

	public static void peekTimer()
	{
		long startTime, stopTime, stopTime2;
		Random rand = new Random();
		int timesToLoop = 1000;

		MyStack<Integer> iStack = new MyStack<Integer>();

		for (int q = 0; q < 100000; q++)
		{

			//Grow the Stack
			for(int i = 0; i < 1000; i++){
				iStack.push(rand.nextInt());
			}

			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000)
			{ // empty block
			}

			// Now, run the test.

			startTime = System.nanoTime();

			for(int i = 0; i< timesToLoop; i++)
				iStack.peek();

			stopTime = System.nanoTime();
			
			for(int i = 0; i < timesToLoop; i++);
			
			stopTime2 = System.nanoTime();

			// Compute the time

			double averageTime = ((stopTime - startTime - (stopTime2 - stopTime))/timesToLoop);

			System.out.println(averageTime);

		}
	}
	
	/**
	 * A method that times the pop method in MyStack
	 * */
	
	public static void popTimer()
	{
		long startTime, stopTime, stopTime2;
		Random rand = new Random();
		int timesToLoop = 1000;

		MyStack<Integer> iStack = new MyStack<Integer>();

		for (int q = 0; q < 100000; q++)
		{
			
			//Grow the Stack
			for(int i = 0; i < 1000; i++){
				iStack.push(rand.nextInt());
			}
			startTime = System.nanoTime();

			while (System.nanoTime() - startTime < 1000000000)
			{ // empty block
			}

			// Now, run the test.

			startTime = System.nanoTime();

			for(int i = 0; i < timesToLoop;i++)
				iStack.pop();

			stopTime = System.nanoTime();

			for(int i = 0; i < timesToLoop; i++);
			
			stopTime2 = System.nanoTime();

			// Compute the time

			double averageTime = ((stopTime - startTime - (stopTime2 - stopTime))/timesToLoop);

			System.out.println(averageTime);
			
			// Replace the popped value to maintain size
			
			iStack.push(rand.nextInt());

		}
	}
}
