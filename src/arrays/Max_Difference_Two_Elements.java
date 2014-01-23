package arrays;

public class Max_Difference_Two_Elements {

	/**
	 * Given an array arr[] of integers, find out the difference between any two
	 * elements such that larger element appears after the smaller number in
	 * arr[].
	 * 
	 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should
	 * be 8 (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then
	 * returned value should be 2 (Diff between 7 and 9)
	 * 
	 * IMPLEMENTE BELOW
	 * Method 1 (Simple) Use two loops. In the outer loop, pick elements one by
	 * one and in the inner loop calculate the difference of the picked element
	 * with every other element in the array and compare the difference with the
	 * maximum difference calculated so far.
	 * 
	 * Time Complexity: O(n^2) Auxiliary Space: O(1)
	 * 
	 * Method 2 (Tricky and Efficient) In this method, instead of taking
	 * difference of the picked element with every other element, we take the
	 * difference with the minimum element found so far. So we need to keep
	 * track of 2 things: 
	 * 1) Maximum difference found so far (max_diff).
	 * 2) Minimum number visited so far (min_element).
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 90, 10, 110 };
		System.out.printf("Maximum difference is %d", maxDiff(arr));

	}

	/*
	 * The function assumes that there are at least two elements in array. The
	 * function returns a negative value if the array is sorted in decreasing
	 * order. Returns 0 if elements are equal
	 */
	public static int maxDiff(int arr[]) {
		int arr_size = arr.length;
		int max_diff = arr[1] - arr[0];
		int i, j;
		for (i = 0; i < arr_size; i++) {
			for (j = i + 1; j < arr_size; j++) {
				if (arr[j] - arr[i] > max_diff)
					max_diff = arr[j] - arr[i];
			}
		}
		return max_diff;
	}

}
