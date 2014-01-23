package arrays;

import java.util.Arrays;

class Rotate_Array_In_Place {
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6};
		int k = 2;//so after rotation, we expect [3, 4, 5, 6, 1, 2]
		System.out.println("Original: " + Arrays.toString(nums));
		rotate(nums, k);
		System.out.println("After rotation: " + Arrays.toString(nums));
	}

	static void rotate(int[] nums, int k)
	{
		//as we discussed, we firstly reverse 0-k-1 index sub-array and k-length-1 sub-array and finally reverse whole array
		reverse(nums, 0, k-1);           // [1, 2, 3, 4, 5, 6] --> [2, 1, 3, 4, 5, 6]
		reverse(nums, k, nums.length-1); // [2, 1, 3, 4, 5, 6] --> [2, 1, 6, 5, 4, 3]
		reverse(nums, 0, nums.length-1); // [2, 1, 6, 5, 4, 3] --> [3, 4, 5, 6, 1, 2]
	}

	//we firstly define a swap method as this is the basic idea of not requiring extra memory
	static void swap(int[] nums, int a, int b)
	{
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

	static void reverse(int[] nums, int start, int end)
	{
		//the reverse is simple, reverse head and tail and get closer until meeting
		for(int i=start; i<=(start+end)/2; i++)//notice we stop at mid! otherwise it reverse and reverse
		{
			swap(nums, i, (start+end)-i);//the to be swapped index is "start+end-i"
		}
	}
}
