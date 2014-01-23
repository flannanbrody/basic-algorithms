package extra;



public class RotateMatrix90 {

	/*
	 * A better way to do this is to implement the swap index by index. In this case, we do the
	following:
		1 for i=0 to n
		2 temp = top[i];
		3 top[i] = left[i];
		4 left[i] = bottom[i]; 
		5 bottom[i] = right[i];
		6 right[i] =temp;
		
		This algorithm is 0(N2), which is the best we can do since any algorithm must touch all N2 elements.
	 */

	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}
	
	public static void main(String[] args) {
/*		int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 4);
		AssortedMethods.printMatrix(matrix);
		rotate(matrix, 4);
		System.out.println();
		AssortedMethods.printMatrix(matrix);*/
	}
}
