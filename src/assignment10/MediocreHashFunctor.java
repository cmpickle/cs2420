package assignment10;

/**
 * 
 * @author Cameron Pickle
 * @author Daniel Avery
 */
public class MediocreHashFunctor implements HashFunctor {

	/**
	 * Returns a has value for a string.
	 * 
	 * @param item
	 *                --The string to be hashed.
	 * @return --The hash value of the string.
	 */
	@Override
	public int hash(String item)
	{
		if (item == "")
			return 0;
		int hash = 1;
		hash *= item.charAt(0);
		hash *= item.length();
		hash *= item.charAt(item.length() - 1);
		return hash;
	}

}
