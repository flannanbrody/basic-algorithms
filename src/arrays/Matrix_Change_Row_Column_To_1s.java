package arrays;

public class Matrix_Change_Row_Column_To_1s {

	/**
	 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a
	 * matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row
	 * and jth column as 1.
	 * 
		Example 1
		The matrix
		1 0
		0 0
		should be changed to following
		1 1
		1 0
		
		Example 2
		The matrix
		0 0 0
		0 0 1
		should be changed to following
		0 0 1
		1 1 1
		
		Example 3
		The matrix
		1 0 0 1
		0 0 1 0
		0 0 0 0
		should be changed to following
		1 1 1 1
		1 1 1 1
		1 0 1 1
	 * 
	 * 
	 * Method 1 (Use two temporary arrays) 
	 * 1) Create two temporary arrays row[M] and col[N]. Initialize all values of row[] and col[] as 0. 
	 * 2) Traverse the input matrix mat[M][N]. If you see an entry mat[i][j] as true, then mark row[i] and col[j] as true. 
	 * 3) Traverse the input matrix mat[M][N] again. For each entry mat[i][j], check the values of row[i] and col[j].
	 *    If any of the two values (row[i] or col[j]) is true, then mark mat[i][j] as true.
	 */
	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 0, 1 }, 
				        { 0, 0, 1, 0 }, 
				        { 0, 0, 0, 0 }, };

		System.out.printf("Input Matrix \n");
		printMatrix(mat);

		modifyMatrix(mat);

		System.out.printf("Matrix after modification \n");
		printMatrix(mat);

	}

	public static void modifyMatrix(int mat[][]) {
		int R = mat.length;
		int C = mat[0].length;
		int row[] = new int[R]; //Could also do a boolean[] and set values to true or false
		int col[] = new int[C];

		int i, j;

		/*
		 * Store the rows and columns to be marked as 1 in row[] and col[]
		 * arrays respectively
		 */
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				if (mat[i][j] == 1) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		/*
		 * Modify the input matrix mat[] using the above constructed row[] and
		 * col[] arrays
		 */
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				if (row[i] == 1 || col[j] == 1) {
					mat[i][j] = 1;
				}
			}
		}
	}

	/* A utility function to print a 2D matrix */
	public static void printMatrix(int mat[][]) {
		int R = mat.length;
		int C = mat[0].length;

		int i, j;
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				System.out.printf("%d ", mat[i][j]);
			}
			System.out.printf("\n");
		}
	}

}
