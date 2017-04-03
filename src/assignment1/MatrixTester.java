package assignment1;

public class MatrixTester {
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{			
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
		
		// this is the known correct result of multiplying M1 by M2
		Matrix referenceMultiply = new Matrix(new int[][]
		                                                {{13, 12},
														 {29, 26}});
		
		//Print out the matrices
		System.out.println("This is M1");
		System.out.println(M1.toString());
		System.out.println("This is M2");
		System.out.println(M2.toString());
		System.out.println("This is M3");
		System.out.println(M3.toString());
		System.out.println("This is M4");
		System.out.println(M4.toString());
		System.out.println("This is referenceMultiply (the product of M1 and M2)");
		System.out.println(referenceMultiply.toString());
		System.out.println("Is M1 the same and M3?");
		System.out.println(M1.equals(M3));
		System.out.println("Is M2 the same and M3?");
		System.out.println(M2.equals(M3));
		
		// get the matrix computed by your times method
		Matrix computedMultiply = M1.times(M2);
		
		// exercises your toString method
		System.out.println("Computed result for M1 * M2:\n" + computedMultiply); 
		
		// exercises your .equals method, and makes sure that your computed result is the same as the known correct result
		if(!referenceMultiply.equals(computedMultiply)) 
			System.out.println("Should be:\n" + referenceMultiply);
		
		Matrix addition = M4.plus(referenceMultiply);
		addition = M4.plus(referenceMultiply);
		System.out.println("This matrix comes from adding M4 to referenceMultiply");
		System.out.println(addition.toString());
		System.out.println("This is what happens when you try to multiply incompatible matrices (M1 times M4)");
		System.out.println(M1.times(M4));
		System.out.println("This is what happens when you try to add incompatible matrices (M1 plus M4)");
		System.out.println(M1.plus(M4));
	}
}