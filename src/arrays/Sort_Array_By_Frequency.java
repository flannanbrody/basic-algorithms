package arrays;

import java.util.LinkedHashMap;

/**
 * Could use a Radix Sort
 * 
 * Given an array of integers, sort the array according to frequency of
 * elements. For example, if the input array is {2, 3, 2, 4, 5, 12, 2, 3, 3,
 * 3, 12}, then modify the array to {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}. 
 * 
 * Following is detailed algorithm. 
 * 1) Create a BST and while creating BST maintain the count i,e frequency of each coming element in same BST. This
 *    step may take O(nLogn) time if a self balancing BST is used. 
 * 2) Do Inorder traversal of BST and store every element and count of each element in an auxiliary array. Let us call 
 *    the auxiliary array as ‘count[]‘. Note that every element of this array is element and frequency pair. This step 
 *    takes O(n) time. 
 * 3) Sort ‘count[]‘ according to frequency of the elements. This step takes O(nLohn) time if a O(nLogn) sorting 
 *    algorithm is used. 
 * 4) Traverse through the sorted array ‘count[]‘. For each element x, print it ‘freq’ times where ‘freq’ is frequency of x.
 * 
 * This step takes O(n) time.
 * 
 * Overall time complexity of the algorithm can be minimum O(nLogn) if we
 * use a O(nLogn) sorting algorithm and use a self balancing BST with
 * O(Logn) insert operation.
 */

public class Sort_Array_By_Frequency {

	/*
	 * Given an array of integers, sort the array according to frequency of elements.
	 * For example, if the input array is {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}, then
	 * modify the array to {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}.
	 */
	
	public static void main(String[] args) {
		int[] unsortedArray = { 2, 12, 3, 2, 4, 2, 3, 3, 3, 12, 5 };

		LinkedHashMap<Integer, Integer> valueAndItsCount = new LinkedHashMap<Integer, Integer>();

		for (int x : unsortedArray) {
			if (valueAndItsCount.containsKey(x)) {
				int xCount = valueAndItsCount.get(x);
				xCount++;
				valueAndItsCount.put(x, xCount);
			} else {
				valueAndItsCount.put(x, 1);
			}
		}

		int maxCount = 0;
		int theKey = 0;
		while (!valueAndItsCount.isEmpty()) {

			for (int x : valueAndItsCount.keySet()) {
				if (valueAndItsCount.get(x) > maxCount) {
					maxCount = valueAndItsCount.get(x);
					theKey = x;
				}
			}

			for (int i = 0; i < maxCount; i++) {
				System.out.print(theKey + " ");
			}
			valueAndItsCount.remove(theKey);
			maxCount = 0;
		}

	} // end main
}
