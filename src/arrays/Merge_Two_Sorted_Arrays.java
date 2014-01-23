package arrays;

import java.util.Arrays;

public class Merge_Two_Sorted_Arrays {

	/**
	 * 1. Three variables
	 *      -- new array hold result.... long[] answer = new long[N + M];
	 * 		-- 2 pointers too both arrays and another for indexing into new array
	 * 2. Determine which first element in both arrays is smaller...put in new array	
	 * 			tmp = a[i] < b[j] ? a[i++] : b[j++];
	 *			answer[k++] = tmp;
	 * 3. Copy new array back too old array
	 */
	public static void main(String[] args) {
		long[] a = {1, 3, 5, 7, 9};
		long[] b = {2, 4, 6, 8, 10, 12};
		System.out.println("Output is : ");
		long[] longArray = merge2SortedAndRemoveDublicates(a, b);
		for(long l: longArray){
			System.out.println(" " + l);
		}
	}

	public static long[] merge2SortedAndRemoveDublicates(long[] a, long[] b) {
		int N = a.length;
		int M = b.length;
		long[] answer = new long[N + M];
		int i = 0; 
		int	j = 0; 
		int k = 0;
		long tmp;
		while (i < N && j < M) {
			tmp = a[i] < b[j] ? a[i++] : b[j++];
			answer[k++] = tmp;
		}
		while (i < N) { //take from the first array only cause second is empty
			tmp = a[i++];
			answer[k++] = tmp;
		}
		while (j < M) { //take from the second array only cause first is empty
			tmp = b[j++];
			answer[k++] = tmp;
		}
		return Arrays.copyOf(answer, k);
	}

}
