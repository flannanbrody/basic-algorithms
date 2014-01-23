package arrays;

public class Next_Greatest_Element {

	/**
	 * Given an array, print the Next Greater Element (NGE) for every element.
	 * The Next greater Element for an element x is the first greater element on
	 * the right side of x in array. Elements for which no greater element
	 * exist, consider next greater element as -1.
	 * 
	 * Examples: 
	 * a) For any array, rightmost element always has next greater element as -1. 
	 * b) For an array which is sorted in decreasing order, all elements have next greater element as -1. 
	 * c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
	 * 
		Element       NGE
		   4      -->   5
		   5      -->   25
		   2      -->   25
		   25     -->   -1
		d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.
		
		  Element        NGE
		   13      -->    -1
		   7       -->     12
		   6       -->     12
		   12     -->     -1
	 * 
	 * IMPLEMENTED BELOW
	 * Method 1 (Simple) Use two loops: The outer loop picks all the elements one by one. The inner
	 * loop looks for the first greater element for the element picked by outer
	 * loop. If a greater element is found then that element is printed as next,
	 * otherwise -1 is printed.
	 * 
	 * Not used below
	 * Method 2 (Using Stack) 
	 *  1) Push the first element to stack. 
	 *  2) Pick rest of the elements one by one and follow following steps in loop. 
	 *     ....a) Mark the current element as next. 
	 *     ....b) If stack is not empty, then pop an element from stack and compare it with next. 
	 *     ....c) If next is greater than the popped element, then next is the next greater element for the popped element. 
	 *     ....d) Keep poppoing from the stack while the popped element is smaller than next. next becomes the next greater 
	 *            element for all such popped elements 
	 *     ....e) If next is smaller than the popped element, then push the popped element back. 
	 *  3) After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
 
		Time Complexity: O(n). The worst case occurs when all elements are sorted in decreasing order. If elements are sorted 
		in decreasing order, then every element is processed at most 4 times.
		a) Initialy pushed to the stack.
		b) Popped from the stack when next element is being processed.
		c) Pushed back to the stack because next element is smaller.
		d) Popped from the stack in step 3 of algo.
	 */
	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3 };
		printNGE(arr);

	}

	/*
	 * prints element and NGE pair for all elements of arr[] of size n
	 */
	public static void printNGE(int arr[]) {
		int n = arr.length;
		int next = -1;
		int i = 0;
		int j = 0;
		for (i = 0; i < n; i++) {
			next = -1;
			for (j = i + 1; j < n; j++) {
				if (arr[i] < arr[j]) {
					next = arr[j];
					break;
				}
			}
			System.out.printf("%d –> %d\n", arr[i], next);
		}
	}

}
