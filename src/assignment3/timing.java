package assignment3;

import java.util.Random;

public class timing {

	
	  @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) 
	  {
	    long startTime, midpointTime, stopTime;
	    MySortedSet s1 = new MySortedSet<Integer>();
	    Random number = new Random();

	    for (int i = 0; i < 100000; i++)
	    {
	    	s1.add(number.nextInt());
	    }
	    for (int i = 0; i < 100000; i++)
	    {
	    	
	    }
	    // First, spin computing stuff until one second has gone by.
	    // This allows this thread to stabilize.

	    startTime = System.nanoTime();
	    while (System.nanoTime() - startTime < 1000000000) { // empty block
	    }

	    // Now, run the test.

	    long timesToLoop = 2000000;

	    startTime = System.nanoTime();

	    for (long i = 0; i < timesToLoop; i++)
	        s1.contains(number.nextInt());

	    midpointTime = System.nanoTime();

	    // Run an empty loop to capture the cost of running the loop.

	    for (long i = 0; i < timesToLoop; i++) { // empty block
	    }

	    stopTime = System.nanoTime();

	    // Compute the time, subtract the cost of running the loop
	    // from the cost of running the loop and computing square roots.
	    // Average it over the number of runs.

	    double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
	        / timesToLoop;

	    System.out.println("It takes exactly " + averageTime
	        + " nanoseconds to compute the square roots of the "
	        + " numbers 1..10.");
	  }
	}
