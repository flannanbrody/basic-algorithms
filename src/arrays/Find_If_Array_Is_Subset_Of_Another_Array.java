package arrays;

public class Find_If_Array_Is_Subset_Of_Another_Array {

	/**
	 * Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a
	 * subset of arr1[] or not. Both the arrays are not in sorted order.
	 * 
	 * Examples: Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
	 * Output: arr2[] is a subset of arr1[]
	 * 
	 * Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4} 
	 * Output: arr2[] is a subset of arr1[]
	 * 
	 * Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3} 
	 * Output: arr2[] is not a subset of arr1[]
	 * 
	 * Method 1 
	 * (Simple) Use two loops: The outer loop picks all the elements of
	 * arr2[] one by one. The inner loop linearly searches for the element
	 * picked by outer loop. If all elements are found then return 1, else
	 * return 0. 
	 * 
	 * Method 2 (Use Sorting and Binary Search)
	 * 1) Sort arr1[] O(mLogm) 
	 * 2) For each element of arr2[], do binary search for it in sorted arr1[]. 
	 * 		a) If the element is not found then return 0. 
	 * 3)If all elements are present then return 1.
	 * 
	 * Method 3 (See below)
	 * (Use Sorting and Merging ) 
	 * 1) Sort both arrays: arr1[] and arr2[] O(mLogm + nLogn) 2) Use Merge type 
	 *    of process to see if all elements of sorted arr2[] are present in sorted arr1[].
	 * 
	 * Time Complexity: O(mLogm + nLogn) which is better than method 2. Please
	 * note that this will be the complexity if an nLogn algorithm is used for
	 * sorting both arrays which is not the case in above code. In above code
	 * Quick Sort is sued and worst case time complexity of Quick Sort is O(n^2)
	 * 
	 * Method 4 
	 * (Use Hashing) 
	 * 1) Create a Hash Table for all the elements of arr1[]. 
	 * 2) Traverse arr2[] and search for each element of arr2[] in the Hash Table. 
	 *    If element is not found then return 0. 
	 * 3) If all elements are found then return 1.
	 * 
	 * Note that method 1, method 2 and method 4 don’t handle the cases when we
	 * have duplicates in arr2[]. For example, {1, 4, 4, 2} is not a subset of
	 * {1, 4, 2}, but these methods will print it as a subset.
	 */
	
	
	//Using Quicksort....and merge
	public static void main(String[] args) {
		int arr1[] = { 11, 1, 13, 21, 3, 7 };
		int arr2[] = { 11, 3, 7, 1 };

		if (isSubset(arr1, arr2, arr1.length, arr2.length))
			System.out.printf("arr2[] is subset of arr1[] ");
		else
			System.out.printf("arr2[] is not a subset of arr1[]");

	}

	/* Return 1 if arr2[] is a subset of arr1[] */
	public static boolean isSubset(int arr1[], int arr2[], int m, int n) {
		int i = 0, j = 0;

		if (m < n)
			return false;

		sort(arr1, 0, m - 1);
		sort(arr2, 0, n - 1);
		while (i < n && j < m) {
			if (arr1[j] < arr2[i])
				j++;
			else if (arr1[j] == arr2[i]) {
				j++;
				i++;
			} else if (arr1[j] > arr2[i])
				return false;
		}

		if (i < n)
			return false;
		else
			return true;
	}

	/*
	 * QuickSort
	 */
	// quicksort the subarray from a[lo] to a[hi]
	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	// partition the subarray a[lo .. hi] by returning an index j
	// so that a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int v = a[lo];
		while (true) {

			// find item on lo to swap
			while (less(a[++i], v))
				if (i == hi)
					break;

			// find item on hi to swap
			while (less(v, a[--j]))
				if (j == lo)
					break; // redundant since a[lo] acts as sentinel

			// check if pointers cross
			if (i >= j)
				break;

			exch(a, i, j);
		}

		// put v = a[j] into position
		exch(a, lo, j);

		// with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}

	/***********************************************************************
	 * Helper sorting functions
	 ***********************************************************************/

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	// exchange a[i] and a[j]
	private static void exch(int[] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}
