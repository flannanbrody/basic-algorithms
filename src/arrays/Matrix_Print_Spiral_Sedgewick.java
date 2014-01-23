package arrays;

/*************************************************************************
 *  Compilation:  javac Spiral.java
 *  Execution:    java Spiral N
 * 
 *  % java Spiral 4
 *  java Spiral 4
 *  1
 *  2
 *  3
 *  4
 *  8
 *  12
 *  16
 *  15
 *  14
 *  13
 *  9
 *  5
 *  6
 *  7
 *  11
 *  10
 *
 *************************************************************************/


public class Matrix_Print_Spiral_Sedgewick {
    public static void main(String[] args) { 
        int N = Integer.parseInt("6");

        // create N-by-N array of integers 1 through N
        int[][] a = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = 1 + N*i + j;

        printMatrix(a);
        // spiral
        for (int i = N-1, j = 0; i > 0; i--, j++) {
              for (int k = j; k < i; k++) System.out.println(a[j][k]);
              for (int k = j; k < i; k++) System.out.println(a[k][i]);
              for (int k = i; k > j; k--) System.out.println(a[i][k]);
              for (int k = i; k > j; k--) System.out.println(a[k][j]);
       }
     
       // special case for middle element if N is odd
       if (N % 2 == 1) System.out.println(a[(N-1)/2][(N-1)/2]);
    }

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
