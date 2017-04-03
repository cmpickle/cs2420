package assignment9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * The Pathfinder class builds a maze from a file and then finds the shortest
 * path from the start to the finish.
 * 
 * @author Gage Glenn
 * @author Cameron Pickle
 *
 */

public class PathFinder
{
	public static void solveMaze(String inputFile, String outputFile)
	{

		// *************************************************
		// Build Maze
		// *************************************************

		File mazeBuild = new File(inputFile);
		Node[][] mazeMatrix;
		Node startNode = null;
		boolean foundEnd = false;
		int row = 0;
		int col = 0;

		try
		{
			Scanner s = new Scanner(mazeBuild);
			String tempStr;

			tempStr = s.next();

			row = Integer.parseInt(tempStr);

			if (row <= 0)
			{
				System.out.println("Failed to get row value");
				s.close();
				return;
			}

			tempStr = s.next();

			col = Integer.parseInt(tempStr);

			if (col <= 0)
			{
				System.out.println("Failed to get column value");
				s.close();
				return;
			}

			mazeMatrix = new Node[row][col];

			int trackRow = 0;
			int trackCol = 0;

			tempStr = s.nextLine();

			while (s.hasNextLine())
			{

				tempStr = s.nextLine();

				for (int i = 0; i < col; i++)
				{

					char addingType = tempStr.charAt(i);

					mazeMatrix[trackRow][trackCol] = new Node(addingType);

					if (addingType == 'S')
						startNode = mazeMatrix[trackRow][trackCol];
					
					// *************************************************
					// Set Pointers
					// *************************************************
					
					if (trackCol > 0)
					{
						mazeMatrix[trackRow][trackCol].left = mazeMatrix[trackRow][trackCol - 1];
						mazeMatrix[trackRow][trackCol - 1].right = mazeMatrix[trackRow][trackCol];
					}
					if (trackRow > 0)
					{
						mazeMatrix[trackRow][trackCol].up = mazeMatrix[trackRow - 1][trackCol];
						mazeMatrix[trackRow - 1][trackCol].down = mazeMatrix[trackRow][trackCol];
					}
					trackCol++;
				}
				trackCol = 0;
				trackRow++;

			}

			s.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("No File Found!");
			return;
		}

		// *************************************************
		// Find Path using a Breadth first search
		// *************************************************

		if (null == startNode)
		{
			System.out.println("No start found.");
		}

		Queue<Node> bfsQueue = new LinkedList<Node>();

		bfsQueue.add(startNode);
		Node curNode = startNode;

		while (!bfsQueue.isEmpty())
		{
			curNode = bfsQueue.remove();
			curNode.beenVisited = true;

			if (null != curNode.left && curNode.left.nodeData() != 'X' && !curNode.left.beenVisited)
			{
				bfsQueue.add(curNode.left);
				curNode.left.cameFrom = curNode;
			}
			if (null != curNode.right && curNode.right.nodeData() != 'X' && !curNode.right.beenVisited)
			{
				bfsQueue.add(curNode.right);
				curNode.right.cameFrom = curNode;
			}
			if (null != curNode.up && curNode.up.nodeData() != 'X' && !curNode.up.beenVisited)
			{
				bfsQueue.add(curNode.up);
				curNode.up.cameFrom = curNode;
			}
			if (null != curNode.down && curNode.down.nodeData() != 'X' && !curNode.down.beenVisited)
			{
				bfsQueue.add(curNode.down);
				curNode.down.cameFrom = curNode;

			}

			if (curNode.nodeData() == 'G')
			{
				foundEnd = true;
				bfsQueue.clear();
			}
		}

		// *************************************************
		// traverse back with path
		// *************************************************

		if (foundEnd)
		{

			while (curNode.cameFrom != null)
			{
				if (curNode.nodeType == ' ')
				{
					curNode.nodeType = '.';
				}

				curNode = curNode.cameFrom;
			}
		}

		// *************************************************
		// Create Result
		// *************************************************

		File resultFile = new File(outputFile);

		try
		{
			resultFile.createNewFile();

			FileWriter writer = new FileWriter(resultFile);
			writer.write(row + " " + col + "\n");
			for (int i = 0; i < row; i++)
			{
				for (int j = 0; j < col; j++)
				{
					writer.write(mazeMatrix[i][j].nodeType);
				}
				writer.write("\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e)
		{
			System.out.println("Failed to Create File!");
		}
	}

}

/**
 * Node Class for the graph.
 * 
 * This node has a four directional pointers, a pointer to it's previous Node, a
 * boolean to represent if it has been visted, and a character storage variable
 * 
 * */

class Node
{

	char nodeType = ' ';
	boolean beenVisited = false;

	Node cameFrom;

	Node left;
	Node right;
	Node down;
	Node up;

	public Node(char _nodeType)
	{
		nodeType = _nodeType;
	}

	public Node()
	{
	}

	public void setType(char _nodeType)
	{
		nodeType = _nodeType;
	}

	public char nodeData()
	{
		return nodeType;
	}
}
