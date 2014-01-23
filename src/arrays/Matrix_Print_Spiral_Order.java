package arrays;

/*        Right -->
 *  ^   2   4   6   8
 *  |   5   9  12  16 Down
 *  |   2  11   5   9  |
 *  Up  3   2   1   8  |
 *                     V 
 *        <-- Left
 *   
 *   Spiral order --> 2 4 6 8 16 9 8 1 2 3 2 5 9 12 5 11
 *   
 *   Two different methods below..
 */
public class Matrix_Print_Spiral_Order {

	public static void main(String[] args) {

		int a[][] = { { 1, 2, 3, 4 }, 
					  { 5, 6, 7, 8 }, 
					  { 9, 10, 11, 12 },
					  { 13, 14, 15, 16 } };
		spiral(a, 0, 4);
		/*
		 * Might be implemented without the 0 on an afterthought, all arrays
		 * will start at 0 anyways. The second parameter will be the dimension
		 * of the array
		 */
		System.out.println();
		spiralPrint(a);

	}

	static void spiral(int a[][], int x, int y) {

		// If the x and y co-ordinate collide, break off from the function

		if (x == y)
			return;
		int i;

		// Top-left to top-right

		for (i = x; i < y; i++)
			System.out.println(a[x][i]);

		// Top-right to bottom-right

		for (i = x + 1; i < y; i++)
			System.out.println(a[i][y - 1]);

		// Bottom-right to bottom-left

		for (i = y - 2; i >= x; i--)
			System.out.println(a[y - 1][i]);

		// Bottom left to top-left

		for (i = y - 2; i > x; i--)
			System.out.println(a[i][x]);

		// Recursively call spiral

		spiral(a, x + 1, y - 1);

	}

	/*
	 * Different version.
	 * 
	 * Time Complexity: Time complexity of the above solution is O(mn).
	 */
	public static void spiralPrint(int a[][]) {
		int m = a.length;
		int n = a[0].length;
		int i, startRowIndex = 0, startColIndex = 0;

		/*
		 * k - starting row index m - ending row index l - starting column index
		 * n - ending column index i - iterator
		 */

		while (startRowIndex < m && startColIndex < n) {
			/* Print the first row from the remaining rows */
			for (i = startColIndex; i < n; ++i) {
				System.out.printf("%d ", a[startRowIndex][i]);
			}
			startRowIndex++;

			/* Print the last column from the remaining columns */
			for (i = startRowIndex; i < m; ++i) {
				System.out.printf("%d ", a[i][n - 1]);
			}
			n--;

			/* Print the last row from the remaining rows */
			if (startRowIndex < m) {
				for (i = n - 1; i >= startColIndex; --i) {
					System.out.printf("%d ", a[m - 1][i]);
				}
				m--;
			}

			/* Print the first column from the remaining columns */
			if (startColIndex < n) {
				for (i = m - 1; i >= startRowIndex; --i) {
					System.out.printf("%d ", a[i][startColIndex]);
				}
				startColIndex++;
			}
		}
	}
}
