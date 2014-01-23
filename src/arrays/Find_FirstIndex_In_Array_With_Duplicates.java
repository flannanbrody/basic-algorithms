package arrays;

public class Find_FirstIndex_In_Array_With_Duplicates {

	/*
	 * Binary search.....called recursively...either left or right
	 */
	public static void main(String[] args)
	{
		int[] nums = {1,2,2,3,3,3,3,3,3,3,3,4,5,6,7,8,9};
		System.out.println("First index of number 3 is "+GetFirstIndex(nums, 3, 0, nums.length-1));
	}

	//notice we define a same header as a normal binary search
	//nums are the sorted array, a is the number we are looking for
	//start and end are two index values to keep track of the current focus sub-array
	public static int GetFirstIndex(int[] nums, int key, int low, int high)
	{
		//firstly, check if sub-array is valid
		if(high<low) return -1;//if no element left for analyzing, return -1 as invalid,
		//now check the sub-array to see if possibly it contains a
		if(nums[low]>key) return -1;//because even the smallest element is larger than a, not possible!
		if(nums[high]<key) return -1; //similarly, if largest value is smaller than a, not possible to contain a

		//now is the key, before we go, we need check if first element is a
		if(nums[low]==key) return low; //this is the key, we need find the beginning position of all a's

		//now coming to the binary search part
		int mid = low + (high - low)/2;
		if(nums[mid]==key){
			//we have two choice, either mid position is candidate, or the index we find in the left half can be
			int leftIndex = GetFirstIndex(nums, key, low, mid-1);//recursive call
			return leftIndex==-1?mid:leftIndex; //only if leftIndex is valid (not equal to -1) will return leftIndex, otherwise, return mid!
		}
		else if(nums[mid]>key)//which means a can only appear in left half!
			return GetFirstIndex(nums, key, low, mid-1);
		else//only possible in right half
			return GetFirstIndex(nums, key, mid+1, high);
		
	}
}