package arrays;

public class Max_All_Subarrays_In_Array_Of_Size_k {

	/**
	 * Given an array and an integer k, find the maximum for each and every
	 * contiguous subarray of size k.
	 * 
	 * Below doesn't use either method....it uses 2 for loops...
	 * 
	 * Examples:
	 * 
	 * Input : arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6} k = 3 
	 * Output : 3 3 4 5 5 5 6
	 * 
	 * Input : arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13} k = 4 
	 * Output : 10 10 10 15 15 90 90
	 * 
	 * Method 2 (Use Self-Balancing BST) 
	 * 1) Pick first k elements and create a Self-Balancing Binary Search Tree (BST) of size k. 
	 * 2) Run a loop for i = 0 to n – k 
	 *    …..a) Get the maximum element from the BST, and print it.
	 *    …..b) Search for arr[i] in the BST and delete it from the BST. 
	 *    …..c)Insert arr[i+k] into the BST.
	 * 
	 * Time Complexity: Time Complexity of step 1 is O(kLogk). Time Complexity
	 * of steps 2(a), 2(b) and 2(c) is O(Logk). Since steps 2(a), 2(b) and 2(c)
	 * are in a loop that runs n-k+1 times, time complexity of the complete
	 * algorithm is O(kLogk + (n-k+1)*Logk) which can also be written as
	 * O(nLogk).
	 * 
	 * Method 3 (A O(n) method: use Dequeue) We create a Dequeue, Qi of capacity
	 * k, that stores only useful elements of current window of k elements. An
	 * element is useful if it is in current window and is greater than all
	 * other elements on left side of it in current window. We process all array
	 * elements one by one and maintain Qi to contain useful elements of current
	 * window and these useful elements are maintained in sorted order. The
	 * element at front of the Qi is the largest and element at rear of Qi is
	 * the smallest of current window.
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 3;
		printKMax(arr, k);
	}

	public static void printKMax(int arr[], int k) {
		int j, max;

		for (int i = 0; i <= arr.length - k; i++) {
			max = arr[i];

			for (j = 1; j < k; j++) {
				if (arr[i + j] > max)
					max = arr[i + j];
			}
			System.out.printf("%d ", max);
		}
	}

}
