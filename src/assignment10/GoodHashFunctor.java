package assignment10;

import java.math.BigInteger;

/**
 * 
 * @author Cameron Pickle
 * @author Daniel Avery
 */
public class GoodHashFunctor implements HashFunctor {

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
		/*
		 * the operations that we performed on the string to obtain the hash value
		 * were inspired by similar operations that we saw online while trying
		 * to understand what could make a good hash function.
		 */
		BigInteger number = new BigInteger("1");

		if (item == "")
			return 0;
		int hash = 1;
		for (int i = 0; i < item.length(); i++)
			hash *= number.nextProbablePrime().intValue()^item.charAt(i);
		
		hash = ((hash << 7) + hash^11);

		return Math.abs(hash);
	}
}
