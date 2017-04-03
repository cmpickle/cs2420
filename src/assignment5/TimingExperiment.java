package assignment5;

import java.util.ArrayList;

/**
 * 
 * @author Skyler Jayson & Cameron Pickle
 *
 */

public class TimingExperiment 
{

	public static void main(String[] args) 
	{
		long startTime, midpointTime, stopTime;
		IntComp comp = new IntComp();
		

		
		long timesToLoop = 25;
		double averageTime = 0;
		SortUtil.setThreshold(0);
		SortUtil.setPivotChoice(1);
		for (int k = 0; k < timesToLoop;k++)
		{
			ArrayList<Integer> ints = new ArrayList<Integer>();
			//ints = SortUtil.generateAverageCase(1000);
			//ints = SortUtil.generateBestCase(1000);
			ints = SortUtil.generateWorstCase(1000);
			
			// First, spin computing stuff until one second has gone by.
		    // This allows this thread to stabilize.	
		    startTime = System.nanoTime();
		    while (System.nanoTime() - startTime < 1000000000) 
		    { // empty block
		    }
	
		    // Now, run the test.
	
		    startTime = System.nanoTime();
		    
		    //SortUtil.mergesort(ints, comp);
		    SortUtil.quicksort(ints, comp);
	
		    midpointTime = System.nanoTime();
	
		    // Run an empty loop to capture the cost of running the loop.
	
		    for (long j = 0; j < timesToLoop; j++) 
		    { // empty block
		    }
	
		    stopTime = System.nanoTime();
		    
		    averageTime += ((midpointTime - startTime) - (stopTime - midpointTime));
		}
		averageTime /= timesToLoop;
	    // Compute the time, subtract the cost of running the loop
	    // from the cost of running the loop and computing square roots.
	    // Average it over the number of runs.

	    

	    System.out.println("It takes exactly " + averageTime
	        + " nanoseconds to compute the square roots of the "
	        + " numbers 1..10.");
	  }
}
