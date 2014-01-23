package arrays;

/*
 * Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.
 * 
 * A simple method is to do a row wise traversal of the matrix, count the number of 1s in each row and compare the count with max. 
 * Finally, return the index of row with maximum 1s. The time complexity of this method is O(m*n) where m is number of rows and n 
 * is number of columns in matrix. 
 * 
 * We can do better. Since each row is sorted, we can use Binary Search to count of 1s in each row. We find the index of first instance 
 * of 1 in each row. The count of 1s will be equal to total number of columns minus the index of first 1.
 */
public class Matrix_Find_Row_Max_Number_Of_1s {

	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 0, 1 }, 
						{ 0, 1, 1, 1 }, 
						{ 1, 1, 1, 1 },
						{ 0, 0, 0, 0 }, };

		System.out.printf("Index of row with maximum 1s is %d \n", rowWithMax1s(mat));

	}
	
	// The main function that returns index of row with maximum number of 1s.
	public static int rowWithMax1s(int[][] mat) {
		int max_row_index = 0, max = -1; // Initialize max values
		int row = mat.length;
		int column = mat[0].length;

		// Traverse for each row and count number of 1s by finding the index of first 1
		int i, index;
		for (i = 0; i < row; i++) {
			index = first(mat[i], 0, column - 1);
			if (index != -1 && column - index > max) {
				max = column - index;
				max_row_index = i;
			}
		}

		return max_row_index;
	}

	/* A function to find the index of first index of 1 in a boolean array arr[] */
	public static int first(int[] arr, int low, int high) {
		if (high >= low) {
			// get the middle index
			int mid = low + (high - low) / 2;

			// check if the element at middle index is first 1
			if ((mid == 0 || arr[mid - 1] == 0) && arr[mid] == 1)
				return mid;

			// if the element is 0, recur for right side
			else if (arr[mid] == 0)
				return first(arr, (mid + 1), high);

			else
				// If element is not first 1, recur for left side
				return first(arr, low, (mid - 1));
		}
		return -1;
	}
}
