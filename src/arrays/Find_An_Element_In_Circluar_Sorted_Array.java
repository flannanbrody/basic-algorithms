package arrays;

public class Find_An_Element_In_Circluar_Sorted_Array {

	/*
	 * We'll use binary search to give a O(nlogn) algorithms.
	 * 
	 * A simple solution is to traverse the complete array and find minimum. This solution requires \Theta(n) time. 
	 * 
	 * We can do it in O(Logn) using Binary Search. If we take a closer look at above examples, we can easily figure 
	 * out following pattern: 
	 * 
	 * The minimum element is the only element whose previous element is greater than it. If there is no such element, then there is no 
	 * rotation and first element is the minimum element. Therefore, we do binary search for an element which is smaller than the 
	 * previous element.
	 * 
	 */
	public static void main(String[] args) {
		int a[] = {12, 14, 18, 21, 3, 6, 8, 9};
		System.out.println("Output is : " + circularArraySearch(a, 18));
	}

	private static int circularArraySearch(int[] a, int key){
		int low = 0;
		int hi = a.length - 1;
		while(low <= hi){
			int mid = low + (hi - low)/2;
			if (key == a[mid]){
				return mid;
			}
			if(a[mid] <= a[hi]){ //Right half is sorted...
				if(key > a[mid] && key <= a[hi]){
					low = mid + 1;
				}else{
					hi = mid - 1;
				}
			}else{ //left half is sorted
				if(a[low] <= key && key < a[mid]){
					hi = mid - 1;
				}else{
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}
