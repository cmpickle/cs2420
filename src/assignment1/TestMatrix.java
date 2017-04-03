package assignment1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMatrix {
	Matrix M1 = new Matrix(new int[][]
            {{1, 2, 3},
			 {2, 5, 6}});

	Matrix M2 = new Matrix(new int[][]
             {{4, 5},
			  {3, 2},
			  {1, 1}});
	
	Matrix M3 = new Matrix(new int[][]
			{{1, 2, 3},
			 {2, 5, 6}});
	
	Matrix M4 = new Matrix(new int[][]
			{{4, 5},
			 {3, 2}});
	
	Matrix M5 = new Matrix(new int[][]
			{{17, 17},
			 {32, 28}});
	
	// this is the known correct result of multiplying M1 by M2
	Matrix referenceMultiply = new Matrix(new int[][]
			{{13, 12},
			 {29, 26}});
	
	Matrix computedMultiply;
	
	@Before
	public void setUp() throws Exception {
		computedMultiply = M1.times(M2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTimes() {
		assertEquals(referenceMultiply, computedMultiply);
	}
	
	@Test
	public void testAdd() {
		assertEquals(M5, M4.plus(referenceMultiply));
	}

}
