package arrays;

public class Largest_Subarray_With_Equal_Number_Of_0s_And_1s {

	/**
	 * Given an array containing only 0s and 1s, find the largest subarray which
	 * contain equal no of 0s and 1s. Expected time complexity is O(n).
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = {1, 0, 1, 1, 1, 0, 0} Output: 1 to 6 (Starting and Ending
	 * indexes of output subarray)
	 * 
	 * Input: arr[] = {1, 1, 1, 1} Output: No such subarray
	 * 
	 * Input: arr[] = {0, 0, 1, 1, 0} Output: 0 to 3 Or 1 to 4 Source: Largest
	 * subarray with equal number of 0s and 1s
	 * 
	 * IMPLEMENTED BELOW
	 * Method 1 (Simple) A simple method is to use two nested loops. The outer
	 * loop picks a starting point i. The inner loop considers all subarrays
	 * starting from i. If size of a subarray is greater than maximum size so
	 * far, then update the maximum size. In the below code, 0s are considered
	 * as -1 and sum of all values from i to j is calculated. If sum becomes 0,
	 * then size of this subarray is compared with largest size so far.
	 * 
	 * Time Complexity: O(n^2) Auxiliary Space: O(1)
	 * 
	 * This is not used below....
	 * Method 2 (Tricky) Following is a solution that uses O(n) extra space and
	 * solves the problem in O(n) time complexity. Let input array be arr[] of
	 * size n and maxsize be the size of output subarray. 
	 * 1) Consider all 0 values as -1. The problem now reduces to find out the maximum length
	 *    subarray with sum = 0. 
	 * 2) Create a temporary array sumleft[] of size n. Store the sum of all elements from 
	 *    arr[0] to arr[i] in sumleft[i]. This can be done in O(n) time. 
	 * 3) There are two cases, the output subarray may start from 0th index or may start from 
	 *    some other index. We will return the max of the values obtained by two cases. 
	 * 4) To find the maximum length subarray starting from 0th index, scan the sumleft[] and 
	 *    find the maximum i where sumleft[i] = 0. 
	 * 5) Now, we need to find the subarray where subarray sum is 0 and start index is not 0. 
	 *    This problem is equivalent to finding two indexes i & j in sumleft[] such that 
	 *    sumleft[i] = sumleft[j] and j-i is maximum. To solve this, we can create a hash
	 *    table with size = max-min+1 where min is the minimum value in the
	 *    sumleft[] and max is the maximum value in the sumleft[]. The idea is to
	 *    hash the leftmost occurrences of all different values in sumleft[]. The
	 *    size of hash is chosen as max-min+1 because there can be these many
	 *    different possible values in sumleft[]. Initialize all values in hash as -1 
	 * 6) To fill and use hash[], traverse sumleft[] from 0 to n-1. If a value is not present in 
	 *    hash[], then store its index in hash. If the value is present, then calculate the difference 
	 *    of current index of sumleft[] and previously stored value in hash[]. If this difference is
	 *    more than maxsize, then update the maxsize. 7) To handle corner cases (all 1s and all 0s), we 
	 *    initialize maxsize as -1. If the maxsize remains -1, then print there is no such subarray.
	 * 
	 * http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 0, 0, 1, 0, 1, 1 };

		findSubArray(arr);

	}

	// This function Prints the starting and ending indexes of the largest subarray
	// with equal number of 0s and 1s. Also returns the size of such subarray.
	public static int findSubArray(int arr[]) {
		int n = arr.length;
		int sum = 0;
		int maxsize = -1, startindex = 0;

		// Pick a starting point as i
		for (int i = 0; i < n - 1; i++) {
			sum = (arr[i] == 0) ? -1 : 1;

			// Consider all subarrays starting from i
			for (int j = i + 1; j < n; j++) {

				if (arr[j] == 0) {
					sum += -1;
				} else {
					sum += 1;
				}

				// If this is a 0 sum subarray, then compare it with
				// maximum size subarray calculated so far
				if (sum == 0 && maxsize < j - i + 1) {
					maxsize = j - i + 1;
					startindex = i;
				}
			}
		}
		if (maxsize == -1)
			System.out.printf("No such subarray");
		else
			System.out.printf("%d to %d", startindex, startindex + maxsize - 1);

		return maxsize;
	}
}
