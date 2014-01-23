package arrays;

public class Matrix_Print_Diagonially {

	/**
	 * 
		Given matrix is 					Diagonal printing of matrix is 
		    1     2     3     4 			    1 
		    5     6     7     8 			    5     2 
		    9    10    11    12 				9     6     3 
		   13    14    15    16 			   13    10     7     4 
		   17    18    19    20 			   17    14    11     8 
		   									   18    15    12 
		   									   19    16 
		   									   20 
   
	 */
	public static void main(String[] args) {
		int M[][] = {{ 1,  2,  3,  4},
                	 { 5,  6,  7,  8},
                	 { 9, 10, 11, 12},
                	 {13, 14, 15, 16},
                	 {17, 18, 19, 20},
               };
		System.out.printf ("Given matrix is \n");
		printMatrix(M);
		
		System.out.printf ("\nDiagonal printing of matrix is \n");
		diagonalOrder(M);
	}

	// A utility function to find min of two integers
	public static int min(int a, int b){ 
		return (a < b)? a: b; 
	}
	 
	// A utility function to find min of three integers
	public static int min(int a, int b, int c){ 
		return min(min(a, b), c);
	}
	 
	// A utility function to find max of two integers
	public static int max(int a, int b){ 
		return (a > b)? a: b; 
	}
	 
	// The main function that prints given matrix in diagonal order
	public static void diagonalOrder(int matrix[][])
	{
		int ROW = matrix.length;
		int COL = matrix[0].length;
	    // There will be ROW+COL-1 lines in the output
	    for (int line = 1; line <= (matrix.length + matrix[0].length -1); line++){
	        /* Get column index of the first element in this line of output.
	           The index is 0 for first ROW lines and line - ROW for remaining
	           lines  
	           eg...1st time is ROW = 5, COL = 4 and line = 1
	                start_col = 0
	           */
	        int start_col =  max(0, line-ROW);
	 
	        /* Get count of elements in this line. The count of elements is
	           equal to minimum of line number, COL-start_col and ROW */
	         int count = min(line, (COL-start_col), ROW);
	 
	        /* Print elements of this line */
	        for (int j=0; j<count; j++)
	        	System.out.printf("%5d ", matrix[min(ROW, line)-j-1][start_col+j]);
	 
	        /* Ptint elements of next diagonal on next line */
	        System.out.printf("\n");
	    }
	}
	 
	// Utility function to print a matrix
	public static void printMatrix(int matrix[][])
	{
	    for (int i=0; i < matrix.length; i++)
	    {
	        for (int j=0; j < matrix[0].length; j++)
	            System.out.printf("%5d ", matrix[i][j]);
	        System.out.printf("\n");
	    }
	}
}
