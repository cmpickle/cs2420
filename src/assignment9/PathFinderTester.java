package assignment9;

/**
 * @author Gage Glenn
 * @author Cameron Pickle
 *
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PathFinderTester
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	/****************************************************************
	 * TEST General Testing
	 ****************************************************************/

	@Test
	public void testClassic()
	{
		PathFinder.solveMaze("classic.txt", "classicSolved.txt");
		File solvedMaze = new File("classicSolved.txt");

		int lineNumber = 0;

		try
		{
			Scanner checkScan = new Scanner(solvedMaze);

			while (checkScan.hasNextLine())
			{
				String checkMe = checkScan.nextLine();

				switch (lineNumber)
				{
				case (0):
					assertEquals(checkMe, "11 20");
					break;
				case (1):
					assertEquals(checkMe, "XXXXXXXXXXXXXXXXXXXX");
					break;
				case (2):
					assertEquals(checkMe, "X    X        X    X");
					break;
				case (3):
					assertEquals(checkMe, "X XX X XXXXXX X XX X");
					break;
				case (4):
					assertEquals(checkMe, "X X   ....       X X");
					break;
				case (5):
					assertEquals(checkMe, "X X XX.XX. XX XX X X");
					break;
				case (6):
					assertEquals(checkMe, "X     .XG.  X      X");
					break;
				case (7):
					assertEquals(checkMe, "X X XX.XXXXXX XX X X");
					break;
				case (8):
					assertEquals(checkMe, "X X   .          X X");
					break;
				case (9):
					assertEquals(checkMe, "X XX X.XXXXXX X XX X");
					break;
				case (10):
					assertEquals(checkMe, "X    X...S    X    X");
					break;
				case (11):
					assertEquals(checkMe, "XXXXXXXXXXXXXXXXXXXX");
					break;
				}

				lineNumber++;

			}

			checkScan.close();
		} catch (FileNotFoundException e)
		{
		}

	}

	@SuppressWarnings("resource")
	@Test
	public void testUnsolvable()
	{
		PathFinder.solveMaze("unsolvable.txt", "unsolvableSolved.txt");
		File solvedMaze = new File("unsolvableSolved.txt");

		int lineNumber = 0;

		try
		{
			Scanner checkScan = new Scanner(solvedMaze);

			while (checkScan.hasNextLine())
			{
				String checkMe = checkScan.nextLine();

				switch (lineNumber)
				{
				case (0):
					assertEquals(checkMe, "18 36");
					break;
				case (1):
					assertEquals(checkMe, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
					break;
				case (2):
					assertEquals(checkMe, "X                                 SX");
					break;
				case (3):
					assertEquals(checkMe, "X XXXXXXXXXXXXXXXXXXXXXXX XXXXXXXX X");
					break;
				case (4):
					assertEquals(checkMe, "X XX   X   X      XXXXXXX   XX     X");
					break;
				case (5):
					assertEquals(checkMe, "X XX X X X X XXXX XXXXXXXXX XX XXXXX");
					break;
				case (6):
					assertEquals(checkMe, "X XX X X X X             XX XX     X");
					break;
				case (7):
					assertEquals(checkMe, "X XX X X X X X XXXX  XXX    XXXXXX X");
					break;
				case (8):
					assertEquals(checkMe, "X X  X X X   X    XXXXXXXXXXX      X");
					break;
				case (9):
					assertEquals(checkMe, "X XX X X XXXXXXXXXXX        XX XXXXX");
					break;
				case (10):
					assertEquals(checkMe, "X XX X   XX       XXXXXXXXX XX     X");
					break;
				case (11):
					assertEquals(checkMe, "X    XXXXXX XXXXXXX      XX XXXXXX X");
					break;
				case (12):
					assertEquals(checkMe, "XXXXXX      X       XXXX XX X      X");
					break;
				case (13):
					assertEquals(checkMe, "X      XXXXXX XXXXX X    XX XX XXXXX");
					break;
				case (14):
					assertEquals(checkMe, "X XXXXXX      X       XXXXX XX     X");
					break;
				case (15):
					assertEquals(checkMe, "X        XXXXXX XXXXXXXXXXX XX  XX X");
					break;
				case (16):
					assertEquals(checkMe, "XXXXXXXXXX                  XXXXXX X");
					break;
				case (17):
					assertEquals(checkMe, "XG         XXXXXXXXXXXXXXXXXX      X");
					break;
				case (18):
					assertEquals(checkMe, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
					break;
				}

				lineNumber++;

			}
		} catch (FileNotFoundException e)
		{
			System.out.println("NO FILE FOUND!");
		}

	}

	@SuppressWarnings("resource")
	@Test
	public void testBigMaze()
	{
		PathFinder.solveMaze("bigMaze.txt", "bigMazeSolved.txt");
		File solvedMaze = new File("bigMazeSolved.txt");

		int lineNumber = 0;

		try
		{
			Scanner checkScan = new Scanner(solvedMaze);

			while (checkScan.hasNextLine())
			{
				String checkMe = checkScan.nextLine();

				switch (lineNumber)
				{
				case (0):
					assertEquals(checkMe, "37 37");
					break;
				case (1):
					assertEquals(checkMe, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
					break;
				case (2):
					assertEquals(checkMe, "X       X X X  .......  X   X     X X");
					break;
				case (3):
					assertEquals(checkMe, "X XXXXXXX X XXX.X XXX.XXX XXXXXXX X X");
					break;
				case (4):
					assertEquals(checkMe, "X       X  .....X X  .  X     X X   X");
					break;
				case (5):
					assertEquals(checkMe, "XXXXX XXXXX.XXX X X X.XXX XXXXX X XXX");
					break;
				case (6):
					assertEquals(checkMe, "X   X X X X.  X X X X.  X X   X X   X");
					break;
				case (7):
					assertEquals(checkMe, "X XXX X X X.XXX XXXXX.XXX X XXX XXX X");
					break;
				case (8):
					assertEquals(checkMe, "X       X  ...X   X  .X     X X X...X");
					break;
				case (9):
					assertEquals(checkMe, "XXX XXXXXXXXX.XXXXXXX.XXX XXX X X.X.X");
					break;
				case (10):
					assertEquals(checkMe, "X  ...........X.......X X   X.....X.X");
					break;
				case (11):
					assertEquals(checkMe, "X X.XXXXX X XXX.X X XXX X XXX.XXX X.X");
					break;
				case (12):
					assertEquals(checkMe, "X X.X     X X X.X X     X   X.X X X.X");
					break;
				case (13):
					assertEquals(checkMe, "X X.X XXXXXXX X.XXXXXXXXX XXX.X XXX.X");
					break;
				case (14):
					assertEquals(checkMe, "X X.X X     X  .X     X     X.  X  .X");
					break;
				case (15):
					assertEquals(checkMe, "XXX.XXX X XXXXX.XXXXX XXX XXX.XXXXX.X");
					break;
				case (16):
					assertEquals(checkMe, "X  .  X X X  ...X X     X X...X X X.X");
					break;
				case (17):
					assertEquals(checkMe, "X X.X X X XXX.XXX XXX XXX X.X X X X.X");
					break;
				case (18):
					assertEquals(checkMe, "X X.X X X    .............X.X X.....X");
					break;
				case (19):
					assertEquals(checkMe, "XXX.XXXXXXX X X XXXXX XXX.X.XXX.XXXXX");
					break;
				case (20):
					assertEquals(checkMe, "X  ...  X X X X     X   X...  X.X   X");
					break;
				case (21):
					assertEquals(checkMe, "XXXXX.X X XXXXXXXXX XXXXXXXXXXX.X XXX");
					break;
				case (22):
					assertEquals(checkMe, "X   X.X           X X     X...X.X   X");
					break;
				case (23):
					assertEquals(checkMe, "X XXX.XXXXX XXXXXXXXX XXXXX.X.X.XXX X");
					break;
				case (24):
					assertEquals(checkMe, "X X...X      X .......X.....X...    X");
					break;
				case (25):
					assertEquals(checkMe, "X X.X XXXXX XXX.X X X.X.XXXXXXXXXXXXX");
					break;
				case (26):
					assertEquals(checkMe, "X X.X   X     X.X X X...    X   X X X");
					break;
				case (27):
					assertEquals(checkMe, "X X.XXX XXX X X.X XXXXXXXXX XXX X X X");
					break;
				case (28):
					assertEquals(checkMe, "X X...X X   X X.X   X X   X X X     X");
					break;
				case (29):
					assertEquals(checkMe, "X XXX.XXX XXXXX.XXX X X XXXXX X XXXXX");
					break;
				case (30):
					assertEquals(checkMe, "X  ...  X   X  ...X X     X   X X   X");
					break;
				case (31):
					assertEquals(checkMe, "XXX.X XXXXX XXXXX.XXX XXX X XXX X XXX");
					break;
				case (32):
					assertEquals(checkMe, "X X.X X X X X X...  X X   X X...X X X");
					break;
				case (33):
					assertEquals(checkMe, "X X.XXX X X X X.XXXXXXXXX X X.X.X X X");
					break;
				case (34):
					assertEquals(checkMe, "X...X   X   X  ...............X.....X");
					break;
				case (35):
					assertEquals(checkMe, "X.X X X XXX XXX XXXXXXX XXX XXX XXX.X");
					break;
				case (36):
					assertEquals(checkMe, "XGX X X       X   X       X   X X  SX");
					break;
				case (37):
					assertEquals(checkMe, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
					break;
				}

				lineNumber++;

			}
		} catch (FileNotFoundException e)
		{
			System.out.println("NO FILE FOUND!");
		}


	}
}
