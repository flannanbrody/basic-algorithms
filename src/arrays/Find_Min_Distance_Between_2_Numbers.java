package arrays;

public class Find_Min_Distance_Between_2_Numbers {

	/**
	 * Given an unsorted array arr[] and two numbers x and y, find the minimum
	 * distance between x and y in arr[]. The array might also contain
	 * duplicates. You may assume that both x and y are different and present in
	 * arr[].
	 * 
	 * Examples: Input: arr[] = {1, 2}, x = 1, y = 2 
	 * Output: Minimum distance between 1 and 2 is 1.
	 * 
	 * Input: arr[] = {3, 4, 5}, x = 3, y = 5 
	 * Output: Minimum distance between 3 and 5 is 2.
	 * 
	 * Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6 
	 * Output: Minimum distance between 3 and 6 is 4.
	 * 
	 * Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2 
	 * Output: Minimum distance between 3 and 2 is 1.
	 * 
	 * Method 1 (Simple) Use two loops: The outer loop picks all the elements of
	 * arr[] one by one. The inner loop picks all the elements after the element
	 * picked by outer loop. If the elements picked by outer and inner loops
	 * have same values as x or y then if needed update the minimum distance
	 * calculated so far.
	 */
	public static void main(String[] args) {
		int arr[] = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
		int x = 3;
		int y = 6;

		System.out.printf("Minimum distance between %d and %d is %d\n", x, y, minDist(arr, x, y));

	}

	public static int minDist(int arr[], int x, int y) {
		int n = arr.length;
		int i, j;
		int min_dist = Integer.MAX_VALUE;
		for (i = 0; i < n; i++) {
			for (j = i + 1; j < n; j++) {
				if ((x == arr[i] && y == arr[j] || y == arr[i] && x == arr[j]) && min_dist > Math.abs(i - j)) {
					min_dist = Math.abs(i - j);
				}
			}
		}
		return min_dist;
	}

}
