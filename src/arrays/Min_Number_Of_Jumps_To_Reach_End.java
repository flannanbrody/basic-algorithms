package arrays;

public class Min_Number_Of_Jumps_To_Reach_End {

	/**
	 * Given an array of integers where each element represents the max number
	 * of steps that can be made forward from that element. Write a function to
	 * return the minimum number of jumps to reach the end of the array
	 * (starting from the first element). If an element is 0, then cannot move
	 * through that element.
	 * 
	 * Example:
	 * 
	 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} 
	 * Output: 3 (1-> 3 -> 8 ->9) First element is 1, so can only go to 3. Second element is 3, so can
	 * make at most 3 steps eg to 5 or 8 or 9.
	 * 
	 * Method 1 (Naive Recursive Approach) A naive approach is to start from the
	 * first element and recursively call for all the elements reachable from
	 * first element. The minimum number of jumps to reach end from first can be
	 * calculated using minimum number of jumps needed to reach end from the
	 * elements reachable from first.
	 * 
	 * minJumps(start, end) = Min ( minJumps(k, end) ) for all k reachable from
	 * start
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.printf("Minimum number of jumps to reach end is %d ", minJumps(arr, 0, arr.length - 1));

	}

	// Returns minimum number of jumps to reach arr[h] from arr[l]
	public static int minJumps(int arr[], int start, int end) {
		// Base case: when source and destination are same
		if (end == start)
			return 0;

		// When nothing is reachable from the given source
		if (arr[start] == 0)
			return Integer.MAX_VALUE;

		// Traverse through all the points reachable from arr[start]. Recursively
		// get the minimum number of jumps needed to reach arr[end] from these
		// reachable points.
		int min = Integer.MAX_VALUE;
		for (int i = start + 1; i <= end && i <= start + arr[start]; i++) {
			int jumps = minJumps(arr, i, end);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
				min = jumps + 1;
		}

		return min;
	}

}
