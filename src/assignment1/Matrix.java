package assignment1;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		numRows = d.length; 						// d.length is the number of 1D arrays in the 2D array
		if(numRows == 0)
			numColumns = 0;
		else
			numColumns = d[0].length; 				// d[0] is the first 1D array
		data = new int[numRows][numColumns]; 		// create a new matrix to hold the data
		// copy the data over
		for(int i=0; i < numRows; i++) 
			for(int j=0; j < numColumns; j++)
				data[i][j] = d[i][j];
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o) {
		Boolean isEqual = false;
		
		if(!(o instanceof Matrix)) 										 // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; 											 // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		isEqual = (m.toString().equals(this.toString()))? true : false;  //test if the matrices are equivalent
		
		return isEqual; 
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString() {
		String matrix = "";

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				matrix += (data[i][j] + " ");
			}
			matrix += "\n";
		}
		return matrix;
	}
	
	public Matrix times(Matrix m) {
		boolean compatible = false;
		
		compatible = (this.numColumns == m.numRows);			 		//Test if the matrix is compatible
		
		if (!compatible) 												//If not compatible return null
			return null;

		int multiplied[][] = new int[this.numRows][m.numColumns];		//determine dimensions of final matrix
		
		for (int rows = 0; rows < this.numRows; rows++) {				//run through the two matrices
			for (int cols = 0; cols < m.numColumns; cols++) {
				int value = 0;
				for (int i = 0; i < this.numColumns; i++) {		
					value += this.data[rows][i] * m.data[i][cols];		//multiply the numbers and sum them
				}
				multiplied[rows][cols] = value;							//apply them to the correct location in the final matrix
			}
		}
		
		Matrix result = new Matrix(multiplied);
		
		return result;
	}
	
	public Matrix plus(Matrix m) {
		boolean compatible = false;

		compatible = (this.numColumns == m.numColumns && this.numRows == m.numRows); // test compatibility

		if (!compatible)
			return null; // if not compatible return null

		int added[][] = new int[numRows][numColumns];

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				added[i][j] = this.data[i][j] + m.data[i][j];
			}
		}
		Matrix result = new Matrix(added);
		return result;

	}
}
