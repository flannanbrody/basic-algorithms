package arrays;

/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the 
 * image by 90 degrees. Can you do this in place?
 */
public class Rotate_Matrix {

	public static void main(String args[]){
		int[][] matrix = { {1, 2, 3, 4},
				           {5, 6, 7, 8},
				           {9,10,11,12},
				           {13,14,15,16}};
		
		printMatrix(matrix);
		rotate(matrix, 4);
		System.out.println("after rotate:");
		printMatrix(matrix);
	}
	
	public static void printMatrix(int[][] data){
		int row = data.length;
		int column = data[0].length;
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++)
				System.out.printf("%3d", data[i][j]);
			System.out.println();
		}
	}
	
	/* 
	 * Before:		    After:
		  1  2  3  4		13  9  5  1
		  5  6  7  8		14 10  6  2
		  9 10 11 12		15 11  7  3
		 13 14 15 16		16 12  8  4
		
		layer 0
			step 0
				backup --> 1
				1 --> 13
				13 --> 16
				16 --> 4
				4 --> backup
		
			step 1
				backup --> 5
				5 --> 14
				14 --> 12
				12 --> 3
		
			step 2
				backup --> 9
				9 --> 15
				15 --> 8		
				8 --> 2
		
		layer 1
			step 0
				backup --> 6
				6 --> 10
				10 --> 11	
				11 --> 7
	 */
	public static void rotate(int[][] data, int n){
		int step;
		int layer;
		for(layer = 0; layer < n/2; layer++){
			int last = n - 1 - layer;

			for(step = 0; step < last - layer ; step++){
				int backup = data[step + layer][layer];               // backup is data[0][0] (1)
				data[step + layer][layer] = data[last][step + layer]; // data[0][0] = data[4][0] (13)
				data[last][step + layer] = data[last - step][last];   // data[4][0] = data[4][4] (16)
				data[last-step][last] = data[layer][last - step];     // data[4][4] = data[0][4] (4)
				data[layer][last-step] = backup;					  // data[0][4] = backup (1)
			}
		}
	}
}
