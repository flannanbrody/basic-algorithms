package arrays;

/*************************************************************************
 *  Compilation:  javac Transpose.java //transposition (rows and columns changed) 
 *  What's in the first row becomes the first column
 *  
 *  Before 					After
	------     				------
   0   1   2   3   4		0   5  10  15  20
   5   6   7   8   9		1   6  11  16  21
  10  11  12  13  14		2   7  12  17  22
  15  16  17  18  19		3   8  13  18  23
  20  21  22  23  24		4   9  14  19  24
 *  
 *  Transpose an N-by-N matrix in-place, without creating a second
 *  2D array.
 *
 *  Submitted by Christian Rubio.
 *
 *************************************************************************/


public class Matrix_Transpose {

    public static void main(String[] args) {

        // create N-by-N matrix
        int N = Integer.parseInt("5");
        int[][] a = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = N*i + j;
            }
        }

        // print out initial matrix
        System.out.println("Before");
        System.out.println("------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }

        // transpose in-place
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int temp = a[i][j];         //with extra array C[][]..do in one line C[j][i] = A[i][j];....A[][]input array
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // print out transposed matrix
        System.out.println();
        System.out.println("After");
        System.out.println("------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }

    }
}
