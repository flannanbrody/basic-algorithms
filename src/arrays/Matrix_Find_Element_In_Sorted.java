package arrays;

public class Matrix_Find_Element_In_Sorted {

	/*
	 * (1) Linear Search - O(n^2) 
	 * (2) Binary Search - O(n log n) 
	 * (3) Diagonal Binary Search - O(log n!) 
	 * (4) Left and down strategy - O(n) idea is to start at the first row and last column and simply check the 
	 *     value, if it's bigger go down and if it's smaller than go left and keep doing so until the value is found 
	 *     or until the indexes are out of bounds (in case the value does not exist).
	 */
	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 },
						{ 27, 29, 37, 48 }, 
						{ 32, 33, 39, 50 }, };
		search(mat, 29);
	}

	/*
	 * Searches the element x in mat[][]. If the element is found, then prints
	 * its position and returns true, otherwise prints "not found" and returns
	 * false
	 */
	private static boolean search(int m[][], int x) {
		int i = 0;
		int j = m[0].length - 1; // set indexes for top right element
		while (i < m[0].length && j >= 0) {
			if (m[i][j] == x) {
				System.out.printf("\n Found at %d, %d", i, j);
				return true;
			}else if (m[i][j] > x){
				j--;
			}else{ // if mat[i][j] < x
				i++;
			}
		}

		System.out.printf("\n Element not found");
		return false; // if ( i==n || j== -1 )
	}

}
