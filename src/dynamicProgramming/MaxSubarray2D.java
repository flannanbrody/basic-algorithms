package dynamicProgramming;

/*
 * The naive solution for this problem is to check every possible rectangle in given 2D array. This solution requires 4 nested 
 * loops and time complexity of this solution would be O(n^4).

   Kadane’s algorithm for 1D array can be used to reduce the time complexity to O(n^3). The idea is to fix the left and right 
   columns one by one and find the maximum sum contiguous rows for every left and right column pair. We basically find top and 
   bottom row numbers (which have maximum sum) for every fixed left and right column pair. To find the top and bottom row numbers, 
   calculate sun of elements in every row from left to right and store these sums in an array say temp[]. So temp[i] indicates sum 
   of elements from left to right in row i. If we apply Kadane’s 1D algorithm on temp[], and get the maximum sum subarray of temp, 
   this maximum sum would be the maximum possible sum with left and right as boundary columns. To get the overall maximum sum, we 
   compare this sum with the maximum sum so far.
 * 
 * It's been a while since I've looked at this stuff, so bear with me if my explanation doesn't line up with your source.

 The idea behind the 2D algorithm is that we use brute force on one coordinate and the 1D algorithm on the other. The rows are

 r0 = [1, 2, -1]
 r1 = [-3, -1, -4]
 r2 = [1, -5, 2]

 and conceptually, we form all of the sums

 r01 = r0 + r1 = [1 + (-3), 2 + (-1), (-1) + (-4)] = [-2, 1, -5]
 r02 = r0 + r1 + r2 = [1 + (-3) + 1, 2 + (-1) + (-5), (-1) + (-4) + 2] = [-1, -4, -3]
 r12 = r1 + r2 = [(-3) + 1, (-1) + (-5), (-4) + 2] = [-2, -6, -2]

 as well. In general, if there are n rows, there will be (n + 1) n / 2 = O(n^2) of these sums.

 Now, what's going on here is that the k'th entry of rij is the sum of the k'th column of rows i through j. Thus, if we add up 
 the k'th through l'th entries of rij, we get the sum of the subarray of rows from i to j and columns from k to l. We can use the 
 1D algorithm now to find the sublist of rij with maximum sum, which is in fact the subarray spanning rows i to j of the original 

 matrix with maximum sum. We then maximize over all choices of rij, for a running time of O(n^3).

 r0 = [1, 2, -1] has maximum sum 3 for 1 + 2
 r1 = [-3, -1, -4] has maximum sum 0
 r2 = [1, -5, 2] has maximum sum 2
 r01 = [-2, 1, -5] has maximum sum 1
 r02 = [-1, -4, -3] has maximum sum 0
 r12 = [-2, -6, -2] has maximum sum 0

 and we find that the maximum subarray has sum 3.

 The conceptual algorithm I outlined requires a lot of space: O(n^3) to be exact. We can reduce the space requirement to O(n^2) 
 by storing rij implicitly.

 Starting with the original array

 r0 = [1, 2, -1]
 r1 = [-3, -1, -4]
 r2 = [1, -5, 2]

 we compute a new array with the partial sums down each column:

 s0 = [0, 0, 0]
 s1 = s0 + r0 = [0 + 1, 0 + 2, 0 + (-1)] = [1, 2, -1]
 s2 = s1 + r1 = [1 + (-3), 2 + (-1), (-1) + (-4)] = [-2, 1, -5]
 s3 = s2 + r2 = [(-2) + 1, 1 + (-5), (-5) + 2] = [-1, -4, -3].

 Now, whenever we need to lookup the k'th element of rij, we just take the k'th element of s(j+1) and subtract the k'th element 
 of si. For example, to compute r12, we take

 s3 = [-1, -4, -3]

 minus

 s1 = [1, 2, -1]

 and get r12 = [(-1) - 1, (-4) - 2, (-3) - (-1)] = [-2, -6, -2] as needed. This lookup process is O(1), so it does not impact the 
 asymptotic running time. I believe this is basically Kadane's 2D algorithm.
 */
public class MaxSubarray2D {

	static int LENGTH;
	final static int MAX_VAL = 10;

	public static void main(String[] args) {

		for (int i = 10; i <= 70; i += 10) {
			LENGTH = i;

			int[][] a = new int[LENGTH][LENGTH];

			for (int row = 0; row < LENGTH; row++) {
				for (int col = 0; col < LENGTH; col++) {
					a[row][col] = (int) (Math.random() * (MAX_VAL + 1));
					if (Math.random() > 0.5D) {
						a[row][col] = -a[row][col];
					}
					// System.out.printf("%4d", a[row][col]);
				}
				// System.out.println();
			}
			System.out.println("N = " + LENGTH);
			System.out.println("-------");

			long start, end;
			start = System.currentTimeMillis();
			naiveSolution(a);
			end = System.currentTimeMillis();
			System.out.println("   run time: " + (end - start)
					+ " ms   no auxiliary space requirements");
			start = System.currentTimeMillis();
			dynamicProgammingSolution(a);
			end = System.currentTimeMillis();
			System.out.println("   run time: " + (end - start)
					+ " ms   requires auxiliary space for "
					+ ((int) Math.pow(LENGTH, 4)) + " integers");
			start = System.currentTimeMillis();
			kadane2D(a);
			end = System.currentTimeMillis();
			System.out.println("   run time: " + (end - start)
					+ " ms   requires auxiliary space for "
					+ +((int) Math.pow(LENGTH, 2)) + " integers");
			System.out.println();
			System.out.println();
		}
	}

	// O(N^2) !!!
	public static void kadane2D(int[][] a) {
		int[][] s = new int[LENGTH + 1][LENGTH]; // [ending row][sum from row
													// zero to ending row] (rows
													// 1-indexed!)
		for (int r = 0; r < LENGTH + 1; r++) {
			for (int c = 0; c < LENGTH; c++) {
				s[r][c] = 0;
			}
		}
		for (int r = 1; r < LENGTH + 1; r++) {
			for (int c = 0; c < LENGTH; c++) {
				s[r][c] = s[r - 1][c] + a[r - 1][c];
			}
		}
		int maxSum = Integer.MIN_VALUE;
		int maxRowStart = -1;
		int maxColStart = -1;
		int maxRowEnd = -1;
		int maxColEnd = -1;
		for (int r1 = 1; r1 < LENGTH + 1; r1++) { // rows 1-indexed!
			for (int r2 = r1; r2 < LENGTH + 1; r2++) { // rows 1-indexed!
				int[] s1 = new int[LENGTH];
				for (int c = 0; c < LENGTH; c++) {
					s1[c] = s[r2][c] - s[r1 - 1][c];
				}
				int max = 0;
				int c1 = 0;
				for (int c = 0; c < LENGTH; c++) {
					max = s1[c] + max;
					if (max <= 0) {
						max = 0;
						c1 = c + 1;
					}
					if (max > maxSum) {
						maxSum = max;
						maxRowStart = r1 - 1;
						maxColStart = c1;
						maxRowEnd = r2 - 1;
						maxColEnd = c;
					}
				}
			}
		}

		System.out.print("KADANE SOLUTION |   Max sum: " + maxSum);
		System.out.print("   Start: (" + maxRowStart + ", " + maxColStart
				+ ")   End: (" + maxRowEnd + ", " + maxColEnd + ")");
	}

	// O(N^4) !!!
	public static void dynamicProgammingSolution(int[][] a) {
		int[][][][] dynTable = new int[LENGTH][LENGTH][LENGTH + 1][LENGTH + 1]; // [row][col][height][width]
		int maxSum = Integer.MIN_VALUE;
		int maxRowStart = -1;
		int maxColStart = -1;
		int maxRowEnd = -1;
		int maxColEnd = -1;

		for (int r = 0; r < LENGTH; r++) {
			for (int c = 0; c < LENGTH; c++) {
				for (int h = 0; h < LENGTH + 1; h++) {
					for (int w = 0; w < LENGTH + 1; w++) {
						dynTable[r][c][h][w] = 0;
					}
				}
			}
		}

		for (int r = 0; r < LENGTH; r++) {
			for (int c = 0; c < LENGTH; c++) {
				for (int h = 1; h <= LENGTH - r; h++) {
					int rowTotal = 0;
					for (int w = 1; w <= LENGTH - c; w++) {
						rowTotal += a[r + h - 1][c + w - 1];
						dynTable[r][c][h][w] = rowTotal
								+ dynTable[r][c][h - 1][w];
					}
				}
			}
		}

		for (int r = 0; r < LENGTH; r++) {
			for (int c = 0; c < LENGTH; c++) {
				for (int h = 0; h < LENGTH + 1; h++) {
					for (int w = 0; w < LENGTH + 1; w++) {
						if (dynTable[r][c][h][w] > maxSum) {
							maxSum = dynTable[r][c][h][w];
							maxRowStart = r;
							maxColStart = c;
							maxRowEnd = r + h - 1;
							maxColEnd = c + w - 1;
						}
					}
				}
			}
		}

		System.out.print("    DP SOLUTION |   Max sum: " + maxSum);
		System.out.print("   Start: (" + maxRowStart + ", " + maxColStart
				+ ")   End: (" + maxRowEnd + ", " + maxColEnd + ")");
	}

	// O(N^6) !!!
	public static void naiveSolution(int[][] a) {
		int maxSum = Integer.MIN_VALUE;
		int maxRowStart = -1;
		int maxColStart = -1;
		int maxRowEnd = -1;
		int maxColEnd = -1;

		for (int rowStart = 0; rowStart < LENGTH; rowStart++) {
			for (int colStart = 0; colStart < LENGTH; colStart++) {
				for (int rowEnd = 0; rowEnd < LENGTH; rowEnd++) {
					for (int colEnd = 0; colEnd < LENGTH; colEnd++) {
						int sum = 0;
						for (int row = rowStart; row <= rowEnd; row++) {
							for (int col = colStart; col <= colEnd; col++) {
								sum += a[row][col];
							}
						}
						if (sum > maxSum) {
							maxSum = sum;
							maxRowStart = rowStart;
							maxColStart = colStart;
							maxRowEnd = rowEnd;
							maxColEnd = colEnd;
						}
					}
				}
			}
		}

		System.out.print(" NAIVE SOLUTION |   Max sum: " + maxSum);
		System.out.print("   Start: (" + maxRowStart + ", " + maxColStart
				+ ")   End: (" + maxRowEnd + ", " + maxColEnd + ")");
	}

}
