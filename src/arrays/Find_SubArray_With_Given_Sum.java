package arrays;

public class Find_SubArray_With_Given_Sum {

	/**
	 * Given an unsorted array of nonnegative integers, find a continous
	 * subarray which adds to a given number.
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33 
	 * Ouptut: Sum found between indexes 2 and 4
	 * 
	 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7 
	 * Ouptut: Sum found between indexes 1 and 4
	 * 
	 * Input: arr[] = {1, 4}, sum = 0 
	 * Output: No subarray found There may be
	 * more than one subarrays with sum as the given sum. The following
	 * solutions print first such subarray.
	 * 
	 * Method 1 (Simple) A simple solution is to consider all subarrays one by
	 * one and check the sum of every subarray. Following program implements the
	 * simple solution. We run two loops: the outer loop picks a starting point
	 * i and the inner loop tries all subarrays starting from i.
	 * 
	 * 
	 * IMPLEMENTED BELOW
	 * Method 2 (Efficient) Initialize a variable curr_sum as first element.
	 * curr_sum indicates the sum of current subarray. Start from the second
	 * element and add all elements one by one to the curr_sum. If curr_sum
	 * becomes equal to sum, then print the solution. If curr_sum exceeds the
	 * sum, then remove trailing elements while curr_sum is greater than sum.
	 * 
	 * Time complexity of method 2 looks more than O(n), but if we take a closer
	 * look at the program, then we can figure out the time complexity is O(n).
	 * We can prove it by counting the number of operations performed on every
	 * element of arr[] in worst case. There are at most 2 operations performed
	 * on every element: (a) the element is added to the curr_sum (b) the
	 * element is subtracted from curr_sum. So the upper bound on number of
	 * operations is 2n which is O(n).
	 */
	public static void main(String[] args) {
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int sum = 23;
		subArraySum(arr, sum);
	}

	/*
	 * Returns true if the there is a subarray of arr[] with sum equal to 'sum'
	 * otherwise returns false. Also, prints the result
	 * 
	 * If we change the return too void....it will print out all such subarrays....need formate this.
	 * "Sum found between indexes 1 and 4Sum found between indexes 7 and 7No subarray found"
	 */
	public static int subArraySum(int arr[], int sum) {
		int n = arr.length;
		/*
		 * Initialize curr_sum as value of first element and starting point as 0
		 */
		int curr_sum = arr[0], start = 0, i;

		/*
		 * Add elements one by one to curr_sum and if the curr_sum exceeds the
		 * sum, then remove starting element
		 */
		for (i = 1; i <= n; i++) {
			// If curr_sum exceeds the sum, then remove the starting elements
			while (curr_sum > sum && start < i - 1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			// If curr_sum becomes equal to sum, then return true
			if (curr_sum == sum) {
				System.out.printf("Sum found between indexes %d and %d", start, i - 1);
				return 1;
			}

			// Add this element to curr_sum
			if (i < n)
				curr_sum = curr_sum + arr[i];
		}

		// If we reach here, then no subarray
		System.out.printf("No subarray found");
		return 0;
	}
}
