package assignment2;
/**
 * @author Kyuho Ji, Cameron Pickle
 */
import java.util.GregorianCalendar;

/**
 * Class representation of a library book. The ISBN, author, and title can never change
 * once the book is created.
 * 
 * Note that ISBNs are unique.
 * 
 * Has a set-able holder and due date
 *
 */
public class LibraryBookGeneric<Type> extends Book {
	
	private Type holder;
	private GregorianCalendar dueDate;

	public LibraryBookGeneric(long _isbn, String _author, String _title) {
		super(_isbn, _author, _title);		
	}
	
/**
 * Returns the holder
 * @return
 */
	public Type getHolder() {
		return this.holder;
	}

	/**
	 * Returns the due date
	 * @return
	 */
	public GregorianCalendar getDueDate() {
		return this.dueDate;
	}
	
	/**
	 * Checks in a LibraryBook
	 * 
	 * sets the holder and due date to null
	 */
	public void checkIn() {
		this.holder = null;
		this.dueDate = null;
	}
	
	/**
	 * Checks out a LibraryBook
	 * 
	 * sets the current holder and due date
	 * 
	 * @param renter
	 * 			--ID of person that checked out the book
	 * @param month, day, year
	 * 			--the month, day, and year of the due date
	 */
	public void checkOut(Type renter, int month, int day, int year) {
		this.holder = renter;
		this.dueDate = new GregorianCalendar(year, month, day);
	}
	
	
}
