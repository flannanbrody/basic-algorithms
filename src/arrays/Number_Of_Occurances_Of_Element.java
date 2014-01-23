package arrays;

public class Number_Of_Occurances_Of_Element {


	/*
	 * Array is sorted
	 * If we just done a binary search....found element and then calculated count both left and right until
	 * you find a different value.....this will return the count of a element in array, but if array has only 
	 * this element....the algorithm will be O(n)...we can do better..
	 * 
	 * So use find first and last occurrences of elements in array...O (nlog n)
	 * difference between first and last.
	 */
	public static void main(String[] args) {
		int[] a = {1, 3, 10, 10, 10, 10, 10, 23, 45, 67};
		int firstOccurance = firstOccurance(a, 10);
		int lastOccurance = lastOccurance(a, 10) + 1;

		System.out.println("Output is : " + (lastOccurance - firstOccurance));

	}
	
	private static int firstOccurance(int[] a, int key){
		int low = 0;
		int hi = a.length - 1;
		while(low <= hi){
			int mid = low + (hi - low)/2;
			if(key < a[mid]){
				hi = mid - 1;
			}else if(key > a[mid]){
				low = mid + 1;
			}else if(low != mid){ //First index of....Equal but range is not fully scanned
				hi = mid;         //Set upper bound to current number and rescan
			}else{                
				return mid;		  //Equal and full range is scanned
			}
		}
		return -1;
	}
	
	private static int lastOccurance(int[] a, int key){
		int low = 0;
		int hi = a.length - 1;
		while(low <= hi){
			int mid = low + (hi - low)/2;
			if(key < a[mid]){
				hi = mid - 1;
			}else if(key > a[mid]){
				low = mid + 1;
			}else if(hi != mid){  //Last index of.....
				low = mid;        
			}else{                
				return mid;		  //Equal and full range is scanned
			}
		}
		return -1;
	}

}
