package assignment8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BinarySearchTree<E> implements SortedSet
{

	ArrayList<E> treeArr;
	Node root = new Node();
	private int size = 0;

	/**
	 * A method which adds a value to the Binary Tree. Will return false if the
	 * value is null or fails to add.
	 * 
	 * @param Comparable
	 *            item - A comparable item that will be added to the tree.
	 * @return boolean - A boolean representing whether the item was
	 *         successfully added.
	 * 
	 * */

	
	@Override
	public boolean add(Comparable item)
	{
		Node traversingNode;
		Node addedItem = new Node((E) item);

		if (item == null)
		{
			return false;
		}

		if (size <= 0)
		{
			root = addedItem;
			size++;
			return true;
		}

		traversingNode = root;

		// Find a leaf location for the item

		while (!traversingNode.isLeaf())
		{
			if (((Comparable) traversingNode.data).compareTo(addedItem.data) > 0)
			{
				if (traversingNode.left == null)
				{
					traversingNode.left = addedItem;
					size++;
					return true;
				}
				traversingNode = traversingNode.left;
			} else if (((Comparable) traversingNode.data).compareTo(addedItem.data) <= 0)
			{
				if (traversingNode.right == null)
				{
					traversingNode.right = addedItem;
					size++;
					return true;
				}
				traversingNode = traversingNode.right;
			} else
			{
				return false;
			}
		}

		// Add the item to the to the found leaf location

		if (((Comparable) traversingNode.data).compareTo(addedItem.data) > 0)
		{
			traversingNode.left = addedItem;
			size++;
			return true;
		} else if (((Comparable) traversingNode.data).compareTo(addedItem.data) <= 0)
		{
			traversingNode.right = addedItem;
			size++;
			return true;
		}

		// If it fails to add the item return false

		return false;
	}

	/**
	 * A method which adds all of the items in a collection to the tree
	 * 
	 * @param items
	 *            - A Collection of objects being added.
	 * 
	 * */

	@Override
	public boolean addAll(Collection items)
	{
		boolean addFlag = false;

		for (Object element : items)
		{
			boolean checkAdd = this.add((Comparable) element);

			if (checkAdd)
			{
				addFlag = checkAdd;
			}
		}
		return addFlag;
	}

	/**
	 * A method which clears the tree of all values
	 * 
	 * */

	@Override
	public void clear()
	{
		root = null;
		size = 0;
	}

	/**
	 * A method which checks if a value is contained in the tree
	 * 
	 * @param item
	 *            - An object being searched for in the tree.
	 * 
	 * */

	@Override
	public boolean contains(Comparable item)
	{
		if (item == null)
		{
			return false;
		}

		// Find a leaf location for the item
		Node traversingNode = root;

		while (!traversingNode.isLeaf())
		{
			if (((Comparable) traversingNode.data).compareTo(item) > 0)
			{
				if (null == traversingNode.left)
				{
					return false;
				}

				traversingNode = traversingNode.left;
			} else if (((Comparable) traversingNode.data).compareTo(item) < 0)
			{
				if (null == traversingNode.right)
				{
					return false;
				}
				traversingNode = traversingNode.right;
			} else
			{
				return true;
			}
		}

		if (((Comparable) traversingNode.data).compareTo(item) == 0)
		{
			return true;
		}

		return false;
	}

	/**
	 * A method which checks if the values are contained in the tree
	 * 
	 * @param item
	 *            - A Collection of items being searched for in the tree.
	 * 
	 * */

	@Override
	public boolean containsAll(Collection items)
	{
		boolean containsFlag = true;

		for (Object element : items)
		{
			boolean checkAdd = this.contains((Comparable) element);

			if (!checkAdd)
			{
				containsFlag = checkAdd;
			}
		}
		return containsFlag;
	}

	/**
	 * A method which returns the lowest value in a tree
	 * 
	 * @return Object - Lowest Comparable object
	 * 
	 * */

	@Override
	public Comparable first() throws NoSuchElementException
	{
		if (size == 0)
			throw new NoSuchElementException("Empty Tree");

		Node traversingNode = root;

		while (null != traversingNode.left)
		{
			traversingNode = traversingNode.left;
		}

		return (Comparable) traversingNode.data;
	}

	/**
	 * A method which returns a boolean representing whether a tree is empty or
	 * not.
	 * 
	 * @return boolean - A boolean representing whether a tree is empty or not
	 * 
	 * */

	@Override
	public boolean isEmpty()
	{
		if (size == 0)
			return true;
		return false;
	}

	/**
	 * A method which returns the highest value in a tree
	 * 
	 * @return Object - Highest Comparable object
	 * 
	 * */

	@Override
	public Comparable last() throws NoSuchElementException
	{
		if (size == 0)
			throw new NoSuchElementException("Empty Tree");

		Node traversingNode = root;

		while (null != traversingNode.right)
		{
			traversingNode = traversingNode.right;
		}

		return (Comparable) traversingNode.data;
	}

	/**
	 * A method which removes a value from the Binary Tree. Will return false if
	 * the value is null or fails to remove the value.
	 * 
	 * @param Comparable
	 *            item - A comparable item that will be removed to the tree.
	 * @return boolean - A boolean representing whether the item was
	 *         successfully removed.
	 * 
	 * */

	@Override
	public boolean remove(Comparable item)
	{
		Node travNode = new Node();
		Node followNode = new Node();
		Node removeMeNode = new Node();

		travNode = root;

		if (item == null)
		{
			return false;
		}

		// Find the Node (Variant on the compare method)
		boolean foundFlag = false;

		if (((Comparable) root.data).compareTo(item) == 0)
		{
			foundFlag = true;
		}

		while (!travNode.isLeaf())
		{
			if (((Comparable) travNode.data).compareTo(item) > 0)
			{
				followNode = travNode;
				travNode = travNode.left;
			} else if (((Comparable) travNode.data).compareTo(item) < 0)
			{
				followNode = travNode;
				travNode = travNode.right;
			} else
			{
				foundFlag = true;
				break;
			}
		}

		// Node is not contained

		if (!foundFlag && ((Comparable) travNode.data).compareTo(item) != 0)
		{
			return false;
		}

		// Handle removing leafs

		if (travNode.isLeaf() && size > 1)
		{
			if (null != followNode.left && ((Comparable) followNode.left.data).compareTo(travNode.data) == 0)
			{
				followNode.left = null;
			} else
			{
				followNode.right = null;
			}

			size--;
			return true;
		}

		// Handle removing if root is leaf

		if (travNode.isLeaf() && size <= 1)
		{
			root = null;
			size--;
			return true;
		}

		// Find Succsessor on the right, if no right go left and store location
		// before moving

		removeMeNode = travNode;

		if (null != travNode.right)
		{
			travNode = travNode.right;

			// If no left is present

			if (travNode.left == null)
			{
				removeMeNode.data = travNode.data;
				removeMeNode.right = removeMeNode.right.right;

				size--;
				return true;
			} else
			{
				// Reach the smallest

				while (null != travNode.left)
				{
					followNode = travNode;
					travNode = travNode.left;
				}

				// Successor Found

				removeMeNode.data = travNode.data;
				followNode.left = followNode.left.right;

				size--;
				return true;
			}
		} else
		{
			travNode = travNode.left;

			removeMeNode.data = travNode.data;

			removeMeNode.right = removeMeNode.left.right;
			removeMeNode.left = removeMeNode.left.left;

			size--;
			return true;

		}
	}

	/**
	 * A method which removes all values in a Collection from the Binary Tree.
	 * Will return false if the value is null or fails to remove any values.
	 * 
	 * @param Comparable
	 *            items - A comparable Collection of items that will be removed
	 *            to the tree.
	 * @return boolean - A boolean representing whether the items were
	 *         successfully removed.
	 * 
	 * */

	@Override
	public boolean removeAll(Collection items)
	{
		boolean addFlag = false;

		for (Object element : items)
		{
			boolean checkAdd = this.add((Comparable) element);

			if (checkAdd)
			{
				addFlag = checkAdd;
			}
		}
		return addFlag;
	}

	/**
	 * A method which returns the size of the tree.
	 * 
	 * @return int - an integer representing the size of the tree
	 * 
	 * */

	@Override
	public int size()
	{
		return size;
	}

	/**
	 * A method which returns the tree as an ordered array
	 * 
	 * @return ArrayList - An ArrayList containing the sorted values of the tree
	 * 
	 * */

	@Override
	public ArrayList<E> toArrayList()
	{

		treeArr = new ArrayList<E>();

		recruseArr(root);

		return treeArr;
	}

	/**
	 * 
	 * A method which recursively adds values to the tree
	 * 
	 * */

	public void recruseArr(Node n)
	{
		if (n.left != null)
		{
			recruseArr(n.left);
		}

		treeArr.add(n.data);

		if (n.right != null)
		{
			recruseArr(n.right);
		}
	}

	/**
	 * This class contains information in our Tree
	 * 
	 */

	class Node
	{

		E data;
		Node left;
		Node right;

		/**
		 * Node Constructor, defaults to null if no value is selected
		 * 
		 */

		public Node()
		{
		}

		/**
		 * This method checks if the node is a leaf
		 * 
		 * @return boolean that is true of false depending on whether the node
		 *         is a leaf or not
		 * 
		 */

		public boolean isLeaf()
		{
			if (left == null && right == null)
				return true;

			return false;
		}

		/**
		 * Node Constructor
		 * 
		 * @param data
		 *            - the Object being stored in a node.
		 * 
		 */

		public Node(E _data)
		{
			data = _data;
		}
	}

}
