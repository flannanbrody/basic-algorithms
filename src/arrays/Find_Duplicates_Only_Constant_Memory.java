package arrays;

public class Find_Duplicates_Only_Constant_Memory {

	/**
	 * Given an array of n elements which contains elements from 0 to n-1, with
	 * any of these numbers appearing any number of times. Find these repeating
	 * numbers in O(n) and using only constant memory space.
	 * 
	 * For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer
	 * should be 1, 3 and 6.
	 * 
	 * Math.abs --> Returns the absolute value of an int value. If the argument is not 
	 *              negative, the argument is returned. If the argument is negative, the 
	 *              negation of the argument is returned.
	 * 
	 * 
	 * Algorithm:

		traverse the list for i= 0 to n-1 elements
		{
		  check for sign of A[abs(A[i])] ;
		  if positive then
		     make it negative by   A[abs(A[i])]=-A[abs(A[i])];
		  else  // i.e., A[abs(A[i])] is negative
		     this   element (ith element of list) is a repetition
		}
	
	 *
	 * Time Complexity: O(n)
     * Auxiliary Space: O(1)
	 */
	public static void main(String[] args) {
		int arr[] = {  2, 3, 1, 4, 3, 6, 6 }; //the value in array must be with range of number of elements....exception if 7 in array cause length is only 6.
		printRepeating(arr);

	}

	public static void printRepeating(int arr[]) {
		System.out.printf("The repeating elements are: \n");
		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.printf(" %d ", Math.abs(arr[i]));
		}
	}

}
