package arrays;

public class Replace_Every_Element_With_The_Next_Greatest {

	/**
	 * Given an array of integers, replace every element with the next greatest
	 * element (greatest element on the right side) in the array. Since there is
	 * no element next to the last element, replace it with -1. For example, if
	 * the array is {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5,
	 * 5, 5, 2, -1}.
	 * 
	 * 
	 * A naive method is to run two loops. The outer loop will one by one pick
	 * array elements from left to right. The inner loop will find the greatest
	 * element present after the picked element. Finally the outer loop will
	 * replace the picked element with the greatest element found by inner loop.
	 * The time complexity of this method will be O(n*n). 
	 * 
	 * IMPLEMENTED BELOW
	 * A tricky method is to
	 * replace all elements using one traversal of the array. The idea is to
	 * start from the rightmost element, move to the left side one by one, and
	 * keep track of the maximum element. Replace every element with the maximum
	 * element.
	 * 
	 * Output:
	 * 	The modified array is: 17 5 5 5 2 -1
	 * 	Time Complexity: O(n) where n is the number of elements in array.
	 * 
	 */
	public static void main(String[] args) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		nextGreatest(arr);
		System.out.printf("The modified array is: \n");
		printArray(arr);
	}

	/*
	 * Function to replace every element with the next greatest element
	 */
	public static void nextGreatest(int arr[]) {
		int size = arr.length;
		// Initialize the next greatest element
		int max_from_right = arr[size - 1];

		// The next greatest element for the rightmost element
		// is always -1
		arr[size - 1] = -1;

		// Replace all other elements with the next greatest
		for (int i = size - 2; i >= 0; i--) {
			// Store the current element (needed later for updating
			// the next greatest element)
			int temp = arr[i];

			// Replace current element with the next greatest
			arr[i] = max_from_right;

			// Update the greatest element, if needed
			if (max_from_right < temp)
				max_from_right = temp;
		}
	}

	/* A utility Function that prints an array */
	public static void printArray(int arr[]) {
		int i;
		for (i = 0; i < arr.length; i++)
			System.out.printf("%d ", arr[i]);
		System.out.printf("\n");
	}

}
