package assignment11;

import java.util.Comparator;
/**
 * A comparator that that defines an ordering among Strings based on length
 * @author Cameron Pickle
 * @author Daniel Avery
 */
public class StringLengthComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2)
	{
		if (o1.length() == o2.length())
			return 0;
		else if(o1.length() < o2.length())
			return -1;
		else 
			return 1;
	}

}
