package arrays;

public class Find_Max_Element_Array_First_Increasing_Then_Decreasing {

	/**
	 * Given an array of integers which is initially increasing and then
	 * decreasing, find the maximum value in the array.
	 * 
	 * Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1} 
	 * Output: 500
	 * 
	 * Input: arr[] = {1, 3, 50, 10, 9, 7, 6} 
	 * Output: 50
	 * 
	 * Corner case (No decreasing part) Input: arr[] = {10, 20, 30, 40, 50}
	 * Output: 50
	 * 
	 * Corner case (No increasing part) Input: arr[] = {120, 100, 80, 20, 0}
	 * Output: 120 Method 1 (Linear Search)
	 * 
	 * We can traverse the array and keep track of maximum and element. And
	 * finally return the maximum element.
	 * 
	 * Method 2 (Binary Search) We can modify the standard Binary Search
	 * algorithm for the given type of arrays. 
	 * i) If the mid element is greater than both of its adjacent elements, 
	 *    then mid is the maximum. 
	 * ii) If mid element is greater than its next element and smaller than the 
	 *    previous element then maximum lies on left side of mid. 
	 *    Example array: {3, 50, 10, 9, 7, 6} 
	 * iii) If mid element is smaller than its next element and greater than 
	 *    the previous element then maximum lies on right side of mid. 
	 *    Example array: {2, 4, 6, 8, 10, 3, 1}
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 30, 40, 50, 60, 70, 23, 20 };
		System.out.printf("The maximum element is %d", findMaximum(arr));
		System.out.println();
		System.out.printf("The binary search maximum element is %d", findMaxBinarySearch(arr));
	}
	
	public static int findMaxBinarySearch(int a[]){
		int low = 0;
		int high = a.length -1;
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(a[mid] >= a[mid - 1] && a[mid] >= a[mid + 1]){
				return a[mid];
			}else if(a[mid] > a[mid + 1] && a[mid] < a[mid - 1]){
				high = mid - 1;
			}else if(a[mid] < a[mid + 1] && a[mid] > a[mid - 1]){
				low = mid + 1;
			}
		}
		return -1;
	}
	

	public static int findMaximum(int arr[]) {
		int low = 0;
		int high = arr.length - 1;
		int max = arr[low];
		int i;
		for (i = low; i <= high; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}
}
