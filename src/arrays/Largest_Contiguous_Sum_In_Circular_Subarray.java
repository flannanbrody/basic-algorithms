package arrays;

public class Largest_Contiguous_Sum_In_Circular_Subarray {

	/**
	 * Given n numbers (both +ve and -ve), arranged in a circle, find the maximum
	 * sum of consecutive number.
	 * 
	 * Examples:
	 * 
	 * Input: a[] = {8, -8, 9, -9, 10, -11, 12} 
	 * Output: 22 (12 + 8 - 8 + 9 - 9 + 10)
	 * 
	 * Input: a[] = {10, -3, -4, 7, 6, 5, -4, -1} 
	 * Output: 23 (7 + 6 + 5 - 4 -1 + 10)
	 * 
	 * Input: a[] = {-1, 40, -14, 7, 6, 5, -4, -1} 
	 * Output: 52 (7 + 6 + 5 - 4 - 1 - 1 + 40)
	 * 
	 * There can be two cases for the maximum sum:
	 * 
	 * Case 1: The elements that contribute to the maximum sum are arranged such
	 * that no wrapping is there. Examples: {-10, 2, -1, 5}, {-2, 4, -1, 4, -1}.
	 * In this case, Kadane’s algorithm will produce the result.
	 * 
	 * Case 2: The elements which contribute to the maximum sum are arranged
	 * such that wrapping is there. Examples: {10, -12, 11}, {12, -5, 4, -8,
	 * 11}. In this case, we change wrapping to non-wrapping. Let us see how.
	 * Wrapping of contributing elements implies non wrapping of non
	 * contributing elements, so find out the sum of non contributing elements
	 * and subtract this sum from the total sum. To find out the sum of non
	 * contributing, invert sign of each element and then run Kadane’s
	 * algorithm. Our array is like a ring and we have to eliminate the maximum
	 * continuous negative that implies maximum continuous positive in the
	 * inverted arrays.
	 * 
	 * Finally we compare the sum obtained by both cases, and return the maximum
	 * of the two sums.
	 * 
	 * Time Complexity: O(n) where n is the number of elements in input array.
	 * 
	 * Note that the above algorithm doesn’t work if all numbers are negative e.g., {-1, -2, -3}. It returns 0 in this case. 
	 * This case can be handled by adding a pre-check to see if all the numbers are negative before running the above algorithm.
	 */
	public static void main(String[] args) {
		int a[] = { 11, 10, -20, 5, -3, -5, 8, -13, 10 };
		System.out.printf("Maximum circular sum is %d\n", maxCircularSum(a));
	}

	// The function returns maximum circular contiguous sum in a[]
	public static int maxCircularSum(int a[]) {
		int N = a.length;
		// Case 1: get the maximum sum using standard kadane's algorithm
		int max_kadane = kadane(a, N);

		// Case 2: Now find the maximum sum that includes corner elements.
		int max_wrap = 0, i;
		for (i = 0; i < N; i++) {
			max_wrap += a[i]; // Calculate array-sum
			a[i] = -a[i]; // invert the array (change sign)
		}

		// max sum with corner elements will be:
		// array - sum - (-max subarray sum of inverted array)
		max_wrap = max_wrap + kadane(a, N);

		// The maximum circular sum will be maximum of two sums
		return (max_wrap > max_kadane) ? max_wrap : max_kadane;
	}

	// Standard Kadane's algorithm to find maximum subarray sum
	// See http://www.geeksforgeeks.org/archives/576 for details
	public static int kadane(int a[], int n) {
		int max_so_far = 0, max_ending_here = 0;
		int i;
		for (i = 0; i < n; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_ending_here < 0)
				max_ending_here = 0;
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}
}
