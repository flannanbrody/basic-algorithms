package arrays;

/*
 * Key binary search.
 * 
 * Given a sorted array of n integers that has been rotated an unknown 
 * number of times, give an O(log n) algorithm that finds an element 
 * in the array. You may assume that the array was originally sorted in 
 * increasing order.
 * 
	 EXAMPLE:
	 Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14) 
	 Output: 8 (the index of 5 in the array)
 */

public class Rotate_Array_Find_Element {
	public static void main(String args[]) {
		int data[] = { 25, 27, 29, 31, 35, 36, 44, 55, 67, 1, 5, 9, 16, 20, 21, 22, 23, 24 };
		for (int i = 0; i < data.length; i++)
			System.out.println(find(data, data[i]));

		System.out.println("27 is located here : " + find(data, 27));
	}

	public static int find(int a[], int key) {
		return find(a, key, 0, a.length - 1);
	}

	public static int find(int a[], int key, int low, int high) {
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (a[mid] == key)
				return mid;
			else if (a[low] <= a[mid]) {  //Sorted 0...mid
				if (key > a[mid])         //Search right side
					low = mid + 1;
				else if (key >= a[low])   //Search left side cause a[low] < key < a[mid]
					high = mid - 1;
				else
					low = mid + 1;
			} else if (key < a[mid])
				high = mid - 1;
			else if (key <= a[high])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
}