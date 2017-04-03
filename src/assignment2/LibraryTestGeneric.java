package assignment2;
/**
 * @author Kyuho Ji, Cameron Pickle
 */
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.event.RowSorterEvent.Type;

/**
 * Testing class for Library.
 * 
 * 
 */
public class LibraryTestGeneric {

  @SuppressWarnings("unchecked")
public static void main(String[] args) {
    // test an empty library
    @SuppressWarnings("rawtypes")
	LibraryGeneric lib = new LibraryGeneric();

    if (lib.lookup(978037429279L) != null)
      System.err.println("TEST FAILED -- empty library: lookup(isbn)");
    @SuppressWarnings({ "rawtypes" })
	ArrayList<LibraryBookGeneric> booksCheckedOut = lib.lookup("Jane Doe");
    if (booksCheckedOut == null || booksCheckedOut.size() != 0)
      System.err.println("TEST FAILED -- empty library: lookup(holder)");
    if (lib.checkout(978037429279L, "Jane Doe", 1, 1, 2008))
      System.err.println("TEST FAILED -- empty library: checkout");
    if (lib.checkin(978037429279L))
      System.err.println("TEST FAILED -- empty library: checkin(isbn)");
    if (lib.checkin("Jane Doe"))
      System.err.println("TEST FAILED -- empty library: checkin(holder)");

    // test a small library
    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib.add(9780446580342L, "David Baldacci", "Simple Genius");
    lib.add(9781843193320L, "Christopher Paolini", "Eragon");
    
    

    if (lib.lookup(9780330351690L) != null)
      System.err.println("TEST FAILED -- small library: lookup(isbn)");
    if (!lib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008))
      System.err.println("TEST FAILED -- small library: checkout");
    booksCheckedOut = lib.lookup("Jane Doe");
    if ( booksCheckedOut == null
        || booksCheckedOut.size() != 1
        || !booksCheckedOut.get(0).equals(
            new Book(9780330351690L, "Jon Krakauer", "Into the Wild"))
        || !booksCheckedOut.get(0).getHolder().equals("Jane Doe")
        || !booksCheckedOut.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED -- small library: lookup(holder)");
    if (!lib.checkin(9780330351690L))
      System.err.println("TEST FAILED -- small library: checkin(isbn)");
    if (lib.checkin("Jane Doe"))
      System.err.println("TEST FAILED -- small library: checkin(holder)");

    // test a medium library
    lib.addAll("Mushroom_Publishing.txt");
    

    // FILL IN
    lib.checkout(9781843192039L, "Pickle", 2, 15, 0012);		//check out book
    lib.checkout(9781843193320L, "8016948594", 1, 29, 1015);	//check out book
    lib.checkout(9781843193320L, "Q", 2, 29, 0012);				//check if you can check out book twice
    ArrayList<LibraryBookGeneric<Type>> list = lib.getOverdueList(6, 30, 2015);	
    System.out.println(list);									//Print overdue list

    System.out.println("Testing done.");
  }

  /**
   * Returns a library of "dummy" books (random ISBN and placeholders for author
   * and title).
   * 
   * Useful for collecting running times for operations on libraries of varying
   * size.
   * 
   * @param size --
   *          size of the library to be generated
   */
  @SuppressWarnings("rawtypes")
public static ArrayList<LibraryBookGeneric> generateLibrary(int size) {
    ArrayList<LibraryBookGeneric> result = new ArrayList<LibraryBookGeneric>();

    for (int i = 0; i < size; i++) {
      // generate random ISBN
      Random randomNumGen = new Random();
      String isbn = "";
      for (int j = 0; j < 13; j++)
        isbn += randomNumGen.nextInt(10);

      result.add(new LibraryBookGeneric(Long.parseLong(isbn), "An author", "A title"));
    }

    return result;
  }

  /**
   * Returns a randomly-generated ISBN (a long with 13 digits).
   * 
   * Useful for collecting running times for operations on libraries of varying
   * size.
   */
  public static long generateIsbn() {
    Random randomNumGen = new Random();

    String isbn = "";
    for (int j = 0; j < 13; j++)
      isbn += randomNumGen.nextInt(10);

    return Long.parseLong(isbn);
  }
  
  
}