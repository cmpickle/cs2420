package assignment11;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class which performs various timing experiments on the PriorityQueue
 * 
 * @author Cameron Pickle
 * @author Daniel Avery
 * 
 * */

public class PriorityQueueTiming {

	static PriorityQueue<Integer> ints;

	static ArrayList<PriorityQueue<Integer>> list;

	static int timesToLoop = 1000;

	public static void main(String[] args) {
		 findMinTimer();

//		 deleteMinTimer();

//		 addTimer();
	}

	/**
	 * A method that times the findMin() method
	 * */
	public static void findMinTimer() {
		long startTime, midTime, endTime;

		Random rand = new Random(10);

		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}

		for (int size = 250; size < 1000000; size *= 2) {
			list = new ArrayList<PriorityQueue<Integer>>();

			for (int i = 0; i < timesToLoop; i++) {
				list.add(new PriorityQueue<Integer>());
				for (int j = 0; j < size; j++)
					list.get(i).add(rand.nextInt());
			}

			double averageTime = 0;

			startTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++)
				list.get(i).findMin();

			midTime = System.nanoTime();

			for (int j = 0; j < timesToLoop; j++)
				list.get(j);

			endTime = System.nanoTime();

			averageTime = ((midTime - startTime) - (endTime - midTime))
					/ timesToLoop;

			if (size > 500)
				System.out.println(averageTime);
		}
	}

	/**
	 * A method that times the deleteMin() method
	 * */
	public static void deleteMinTimer() {
		long startTime, midTime, endTime;

		Random rand = new Random(10);

		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}

		for (int size = 250; size < 1000000; size *= 2) {
			list = new ArrayList<PriorityQueue<Integer>>();

			for (int i = 0; i < timesToLoop; i++) {
				list.add(new PriorityQueue<Integer>());
				for (int j = 0; j < size; j++)
					list.get(i).add(rand.nextInt());
			}

			double averageTime = 0;

			startTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++)
				list.get(i).deleteMin();

			midTime = System.nanoTime();

			for (int j = 0; j < timesToLoop; j++)
				list.get(j);

			endTime = System.nanoTime();

			averageTime = ((midTime - startTime) - (endTime - midTime))
					/ timesToLoop;

			if (size > 500)
				System.out.println(averageTime);
		}
	}

	/**
	 * A method that times the add() method
	 * */
	public static void addTimer() {
		long startTime, midTime, endTime;

		Random rand1 = new Random(10);
		Random rand2 = new Random(10);
		Random rand3 = new Random(10);

		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}

		for (int size = 250; size < 1000000; size *= 2) {
			list = new ArrayList<PriorityQueue<Integer>>();

			for (int i = 0; i < timesToLoop; i++) {
				list.add(new PriorityQueue<Integer>());
				for (int j = 0; j < size; j++)
					list.get(i).add(rand1.nextInt());
			}

			double averageTime = 0;

			startTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++)
				list.get(i).add(rand2.nextInt());

			midTime = System.nanoTime();

			for (int j = 0; j < timesToLoop; j++)
				rand3.nextInt();

			endTime = System.nanoTime();

			averageTime = ((midTime - startTime) - (endTime - midTime))
					/ timesToLoop;

			if (size > 500)
				System.out.println(averageTime);
		}
	}
}