package arrays;

public class Union_And_Intersection_Two_Sorted_Arrays {

	/**
	 * For example, if the input arrays are: 
	 * arr1[] = {1, 3, 4, 5, 7} 
	 * arr2[] = {2, 3, 5, 6} 
	 * Then your program should print Union as {1, 2, 3, 4, 5, 6, 7} and Intersection as {3, 5}.
	 * 
	 * Algorithm Union(arr1[], arr2[]): For union of two arrays, follow the
	 * following merge procedure. 
	 * 1) Use two index variables i and j, initial values i = 0, j = 0 
	 * 2) If arr1[i] is smaller than arr2[j] then print arr1[i] and increment i. 
	 * 3) If arr1[i] is greater than arr2[j] then print arr2[j] and increment j. 
	 * 4) If both are same then print any of them and increment both i and j. 
	 * 5) Print remaining elements of the larger array.
	 * 
	 * Time Complexity: O(m+n)
	 * 
	 * Algorithm Intersection(arr1[], arr2[]): For Intersection of two arrays,
	 * print the element only if the element is present in both arrays. 
	 * 1) Use two index variables i and j, initial values i = 0, j = 0 
	 * 2) If arr1[i] is smaller than arr2[j] then increment i. 
	 * 3) If arr1[i] is greater than arr2[j] then increment j. 
	 * 4) If both are same then print any of them and increment both i and j.
	 * 
	 * Time Complexity: O(m+n)
	 * 
	 */
	public static void main(String[] args) {
		int arr1[] = { 1, 2, 4, 5, 6 };
		int arr2[] = { 2, 3, 5, 7 };
		printUnion(arr1, arr2, arr1.length, arr2.length);

		System.out.println();

		int arr3[] = { 1, 2, 4, 5, 6 };
		int arr4[] = { 2, 3, 5, 7 };
		printIntersection(arr1, arr2, arr3.length, arr4.length);

	}

	/*
	 * Function prints Intersection of arr1[] and arr2[] m is the number of
	 * elements in arr1[] n is the number of elements in arr2[]
	 */
	public static int printIntersection(int arr1[], int arr2[], int m, int n) {
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (arr1[i] < arr2[j])
				i++;
			else if (arr2[j] < arr1[i])
				j++;
			else /* if arr1[i] == arr2[j] */
			{
				System.out.printf(" %d ", arr2[j++]);
				i++;
			}
		}
		return -1;
	}

	/*
	 * Function prints union of arr1[] and arr2[] m is the number of elements in
	 * arr1[] n is the number of elements in arr2[]
	 */
	public static int printUnion(int arr1[], int arr2[], int m, int n) {
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (arr1[i] < arr2[j])
				System.out.printf(" %d ", arr1[i++]);
			else if (arr2[j] < arr1[i])
				System.out.printf(" %d ", arr2[j++]);
			else {
				System.out.printf(" %d ", arr2[j++]);
				i++;
			}
		}

		/* Print remaining elements of the larger array */
		while (i < m)
			System.out.printf(" %d ", arr1[i++]);
		while (j < n)
			System.out.printf(" %d ", arr2[j++]);
		return -1;
	}
}
