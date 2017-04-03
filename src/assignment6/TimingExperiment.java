package assignment6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * 
 * @author Cameron Pickle
 *
 */

public class TimingExperiment 
{
//	private static MyLinkedList<Integer> list;
	private static LinkedList<Integer> list;
	private static ArrayList<Integer> arrayList;

	public static void main(String[] args) 
	{
		long startTime, midpointTime, stopTime;
		list = new LinkedList<Integer>();
//		list = new MyLinkedList<Integer>();
//		list.addFirst(1);
//		list.addFirst(12);
//		list.addFirst(41);
//		list.addFirst(13);
//		list.addFirst(51);
//		list.addFirst(71);
//		list.addFirst(61);
//		list.addFirst(81);
//		list.addFirst(91);
//		list.addFirst(19);
//		list.addFirst(41);
		arrayList = new ArrayList<Integer>();
//		arrayList.add(41);
//		arrayList.add(19);
//		arrayList.add(91);
//		arrayList.add(81);
//		arrayList.add(61);
//		arrayList.add(71);
//		arrayList.add(51);
//		arrayList.add(13);
//		arrayList.add(41);
//		arrayList.add(12);
//		arrayList.add(1);
		Random rand = new Random();
		rand.setSeed(28749581L);
		int nsize = 1000;
		
		
		// First, spin computing stuff until one second has gone by.
	    // This allows this thread to stabilize.
		long timesToLoop = 100000;
		
			
			// First, spin computing stuff until one second has gone by.
		    // This allows this thread to stabilize.	
		    startTime = System.nanoTime();
		    while (System.nanoTime() - startTime < 1000000000) 
		    { // empty block
		    }
	
		    // Now, run the test.
		    
		    double averageTime = 0;
			for (int k = 0; k < timesToLoop;k++)
			{
				list = new LinkedList<Integer>();
				for(int i = 0; i<nsize; i++)
					list.addFirst(rand.nextInt());
				
				arrayList = new ArrayList<Integer>();
				for(int i = 0; i <nsize;i++)
					arrayList.add(rand.nextInt());
				
	
		    startTime = System.nanoTime();


//		    list.get(rand.nextInt(nsize));
		    list.remove(rand.nextInt(nsize));
//		    arrayList.remove(rand.nextInt(nsize));
//		    arrayList.get(rand.nextInt(nsize));
//		    list.addFirst(rand.nextInt(nsize));
//		    arrayList.add(0,rand.nextInt(nsize));
	
		    midpointTime = System.nanoTime();
		    
		    stopTime = System.nanoTime();
		    
		    averageTime += ((midpointTime - startTime) - (stopTime - midpointTime));
		}
	
		    // Run an empty loop to capture the cost of running the loop.
	
		    for (long j = 0; j < timesToLoop; j++) 
		    { // empty block
		    }
	
		    
		averageTime /= timesToLoop;
		System.out.println("It takes exactly " + averageTime
		        + " nanoseconds to compute the square roots of the "
		        + " numbers 1..10.");
//	    startTime = System.nanoTime();
//	    while (System.nanoTime() - startTime < 1000000000) 
//	    { // empty block
//	    }
//
//	    // Now, run the test.
//
//	    long timesToLoop = 100000;
//
//	    startTime = System.nanoTime();
//
//	    for (long i = 0; i < timesToLoop; i++)
//	    	//list.addFirst(rand.nextInt(10));
//	    	//list.get(rand.nextInt(10));
//	    	//arrayList.add(0, rand.nextInt(10));
//	    	arrayList.get(rand.nextInt(10));
//
//	    midpointTime = System.nanoTime();
//
//	    // Run an empty loop to capture the cost of running the loop.
//
//	    for (long i = 0; i < timesToLoop; i++) 
//	    { // empty block
//	    }
//
//	    stopTime = System.nanoTime();
//
//	    // Compute the time, subtract the cost of running the loop
//	    // from the cost of running the loop and computing square roots.
//	    // Average it over the number of runs.
//
//	    double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
//	        / timesToLoop;
//
//	    System.out.println("It takes exactly " + averageTime
//	        + " nanoseconds to compute the square roots of the "
//	        + " numbers 1..10.");
	  }
}
