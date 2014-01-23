package arrays;

public class Find_Pair_With_Difference_Equal_To_N {

	/**
	 * Given an unsorted array and a number n, find if there exists a pair of
	 * elements in the array whose difference is n.
	 * 
	 * Examples: Input: arr[] = {5, 20, 3, 2, 50, 80}, n = 78 
	 * Output: Pair Found: (2, 80)
	 * 
	 * Input: arr[] = {90, 70, 20, 80, 50}, n = 45 
	 * Output: No Such Pair Source: find pair
	 * 
	 * IMPLEMENTED BELOW
	 * Run a loop with two pointers...
	 * The second step of the above algorithm can be improved to O(n). The first
	 * step remain same. The idea for second step is take two index variables i
	 * and j, initialize them as 0 and 1 respectively. Now run a linear loop. If
	 * arr[j] – arr[i] is smaller than n, we need to look for greater arr[j], so
	 * increment j. If arr[j] – arr[i] is greater than n, we need to look for
	 * greater arr[i], so increment i.
	 * 
	 * The simplest method is to run two loops, the outer loop picks the first
	 * element (smaller element) and the inner loop looks for the element picked
	 * by outer loop plus n. Time complexity of this method is O(n^2).
	 * 
	 * We can use sorting and Binary Search to improve time complexity to
	 * O(nLogn). The first step is to sort the array in ascending order. Once
	 * the array is sorted, traverse the array from left to right, and for each
	 * element arr[i], binary search for arr[i] + n in arr[i+1..n-1]. If the
	 * element is found, return the pair. Both first and second steps take
	 * O(nLogn). So overall complexity is O(nLogn).
	 *  
	 * 
	 * Hashing can also be used to solve this problem. Create an empty hash table HT. 
	 * Traverse the array, use array elements as hash keys and enter them in HT. 
	 * Traverse the array again look for value n + arr[i] in HT.
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 8, 30, 40, 100 };
		int n = 60;
		findPair(arr, n);
	}

	// The function assumes that the array is sorted
	public static boolean findPair(int arr[], int n) {
		int size = arr.length;
		// Initialize positions of two elements
		int i = 0;
		int j = 1;

		// Search for a pair....arr[j] - arr[i] == n
		while (i < size && j < size) {
			if (i != j && arr[j] - arr[i] == n) {
				System.out.printf("Pair Found: (%d, %d)", arr[i], arr[j]);
				return true;
			} else if (arr[j] - arr[i] < n)
				j++;
			else
				i++;
		}

		System.out.printf("No such pair");
		return false;
	}
}
