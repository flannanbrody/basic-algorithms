package dynamicProgramming;

import java.util.Arrays;

/*
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can 
 * follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Find the longest chain which can be formed 
 * from a given set of pairs.

 For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }, then the longest chain that can be formed 
 is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}

 This problem is a variation of standard Longest Increasing Subsequence problem. Following is a simple two step process.
 1) Sort given pairs in increasing order of first (or smaller) element.
 2) Now run a modified LIS process where we compare the second element of already finalized LIS with the first element of new LIS 
 being constructed.

 The following code is a slight modification of method 2 of this post.
 */
public class MaximumLengthChainOfPairs {

	public static void main(String[] args) {
		Pair[] arr = new Pair[4];

		arr[0] = new Pair(5, 24);
		arr[1] = new Pair(15, 25);
		arr[2] = new Pair(27, 40);
		arr[3] = new Pair(50, 60);

		int n = 4;
		System.out.println(maxChainLength(arr, n));
		// 3, and the chain is {{5, 24}, {27, 40}, {50, 60}}
	}

	static class Pair implements Comparable<Pair> {
		public Pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		public int a, b;

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(a, this.a);
		}
	}

	/**
	 * This is an adaptation from the best LIS code(geeksforgeeks) which finally
	 * matches with the geeksforgeeks :)
	 * 
	 */
	public static int maxChainLength(Pair[] arr, int n) {
		// 1) Sort given pairs in increasing order of first (or smaller)
		// element.
		Arrays.sort(arr);

		/*
		 * 2) Now run a modified LIS process where we compare the second element
		 * of already finalized LIS with the first element of new LIS being
		 * constructed.
		 */

		int i, j;

		int[] solutionDP = new int[n];

		// Initialize the solution with 1
		for (i = 0; i < n; i++) {
			solutionDP[i] = 1;
		}

		// Pass 1 - Find the max solution ending here(considering this element).
		// Outer loop is for solution ending here
		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				// Math a if newly calculated with b of already finalized
				if (arr[j].b < arr[i].a && solutionDP[j] + 1 > solutionDP[i]) {
					solutionDP[i] = 1 + solutionDP[j];
				}
			}
		}

		// Pass 2
		// Note the max solution may lie anywhere in 'i' ending here.
		int max = 0;
		for (i = 0; i < n; i++) {
			if (solutionDP[i] > max) {
				max = solutionDP[i];
			}
		}

		return max;
	}
}