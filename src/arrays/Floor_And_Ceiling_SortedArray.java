package arrays;

public class Floor_And_Ceiling_SortedArray {

	/**
	 * Given a sorted array and a value x, the ceiling of x is the smallest
	 * element in array greater than or equal to x, and the floor is the
	 * greatest element smaller than or equal to x. Assume than the array is
	 * sorted in non-decreasing order. Write efficient functions to find floor
	 * and ceiling of x.
	 * 
	 * For example, let the input array be {1, 2, 8, 10, 10, 12, 19} For x = 0: floor doesn't exist in array, ceil = 1 
	 * For x = 1: floor = 1, ceil = 1 
	 * For x = 5: floor = 2, ceil = 8 
	 * For x = 20: floor = 19, ceil doesn't exist in array 
	 * 
	 * In below methods, we have implemented only ceiling search functions.
	 * Floor search can be implemented in the same way.
	 * 
	 * Method 1 (Linear Search) Algorithm to search ceiling of x: 
	 * 1) If x is smaller than or equal to the first element in array then return 0(index of first element) 
	 * 2) Else Linearly search for an index i such that x lies between arr[i] and arr[i+1]. 
	 * 3) If we do not find an index i in step 2, then return -1
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Method 2 (Binary Search) Instead of using linear search, binary search is
	 * used here to find out the index. Binary search reduces time complexity to
	 * O(Logn).
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
		int x = 3;
		int index = ceilSearch(arr, 0, arr.length - 1, x);
		if (index == -1)
			System.out.printf("Ceiling of %d doesn't exist in array ", x);
		else
			System.out.printf("ceiling of %d is %d", x, arr[index]);

		System.out.println();
		int arr2[] = { 1, 2, 8, 10, 10, 12, 19 };
		int x2 = 20;
		int index2 = ceilBinarySearch(arr2, 0, arr2.length - 1, x2);
		if (index2 == -1)
			System.out.printf("Ceiling of %d doesn't exist in array ", x);
		else
			System.out.printf("ceiling of %d is %d", x, arr[index2]);
	}
	
	/* Function to get index of ceiling of x in arr[low..high] */
	public static int ceilBinarySearch(int arr[], int low, int high, int x) {
		int mid;

		/*
		 * If x is smaller than or equal to the first element, then return the
		 * first element
		 */
		if (x <= arr[low])
			return low;

		/* If x is greater than the last element, then return -1 */
		if (x > arr[high])
			return -1;

		/* get the index of middle element of arr[low..high] */
		mid = (low + high) / 2; /* low + (high - low)/2 */

		/* If x is same as middle element, then return mid */
		if (arr[mid] == x)
			return mid;

		/*
		 * If x is greater than arr[mid], then either arr[mid + 1] is ceiling of
		 * x or ceiling lies in arr[mid+1...high]
		 */
		else if (arr[mid] < x) {
			if (mid + 1 <= high && x <= arr[mid + 1])
				return mid + 1;
			else
				return ceilSearch(arr, mid + 1, high, x);
		}

		/*
		 * If x is smaller than arr[mid], then either arr[mid] is ceiling of x
		 * or ceiling lies in arr[mid-1...high]
		 */
		else {
			if (mid - 1 >= low && x > arr[mid - 1])
				return mid;
			else
				return ceilSearch(arr, low, mid - 1, x);
		}
	}

	/* Function to get index of ceiling of x in arr[low..high] */
	public static int ceilSearch(int arr[], int low, int high, int x) {
		int i;

		/*
		 * If x is smaller than or equal to first element, then return the first
		 * element
		 */
		if (x <= arr[low])
			return low;

		/* Otherwise, linearly search for ceil value */
		for (i = low; i < high; i++) {
			if (arr[i] == x)
				return i;

			/*
			 * if x lies between arr[i] and arr[i+1] including arr[i+1], then
			 * return arr[i+1]
			 */
			if (arr[i] < x && arr[i + 1] >= x)
				return i + 1;
		}

		/*
		 * If we reach here then x is greater than the last element of the
		 * array, return -1 in this case
		 */
		return -1;
	}
}
