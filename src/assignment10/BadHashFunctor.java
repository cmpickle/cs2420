package assignment10;
/**
 * 
 * @author Cameron Pickle
 * @author Daniel Avery
 */
public class BadHashFunctor implements HashFunctor {

    /**
     * Returns a has value for a string.
     * @param item
     * 		--The string to be hashed.
     * @return
     * 		--The hash value of the string.
     */
    @Override
    public int hash(String item)
    {
	return item.length();
    }

}
