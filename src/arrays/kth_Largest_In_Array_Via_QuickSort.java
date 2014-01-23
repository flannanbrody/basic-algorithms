package arrays;

import java.util.Random;

public class kth_Largest_In_Array_Via_QuickSort {

	//let's create a test case
	public static void main(String[] args)
	{
		int[] nums = new int[20];
		int N = nums.length;
		Random myRandom = new Random();
		System.out.print("Numbers: ");
		for(int i=0; i < N;i++)
		{
			nums[i] = i + myRandom.nextInt(N - i);//each number is random from 0-99
			System.out.print(nums[i]+",");
		}
		System.out.println();
		System.out.println("10th largest value is "+FindKthLargest(nums, 10));
		int[] a = {3, 5, 2, 7, 6, 1};
		System.out.println("New version 10th largest value is "+select(nums, 10));
		System.out.print("After finding: ");
		for(int i=0; i<N;i++)
		{
			System.out.print(nums[i]+",");
		}
		System.out.println();
		//notice the whole array is not sorted after we identified kth largest value!
	}

	//define method header
	public static int FindKthLargest(int[] nums, int k)
	{
		//firstly make sure k is valid between (1, nums.length)
		if(k<1||k>nums.length)
			return -1;//let's assume -1 as the default bad signal though in reality we should improve this
		//otherwise, we are going to use quick sort to solve this problem
		//though compared to full quicksort we only need to take care of the kth value at position!
		//thus we need two support values to know the region of array we focus on
		return FindKthLargest(nums, 0, nums.length-1, k);
	}

	public static int FindKthLargest(int[] nums, int start, int end, int k)
	{
		//this is the key method, the basic idea is to borrow the quick sort algorithm
		//by picking a pivot and put in place and check if it is value we are looking for
		int pivot = start;//assume pivot position is 1st element
		int left = start;
		int right = end;//we keep start/end untouched and copy values for processing in method
		while(left<=right)
		{
			//so we scan from left to right until we find a value which is larger than pivot value
			while(left<=right && nums[left]<=nums[pivot])
				++left;//after this loop, the value at left is larger than pivot position thus need swapping
			while(left<=right && nums[right]>=nums[pivot])
				--right;//similar for right one
			//now we swap if valid
			if(left<right)
			{
				Swap(nums, left, right);
			}
		}
		//after the loop, the correct pivot position should rely on right's position
		Swap(nums, pivot, right);

		//now different from quick sort, we firstly check if we can return from here
		if(k==right+1)//notice k is nth, start from 1 while index starts from 0
			return nums[right];//we immediately return as right position value is set!
		else if(k>right+1)//that means we have divided values to 2 groups, and kth largest can only exist in right half
			return FindKthLargest(nums, right+1, end, k);
		else//we only need focus on the left half
			return FindKthLargest(nums, start, right-1, k);
	}

	//define a support method to swap
	private static void Swap(int[] nums, int a, int b)
	{
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) { 

            // find item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, a[--j]))
                if (j == 0) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put v = a[j] into position
        exch(a, lo, j);

        // with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

   /***********************************************************************
    *  Rearranges the elements in a so that a[k] is the kth smallest element,
    *  and a[0] through a[k-1] are less than or equal to a[k], and
    *  a[k+1] through a[n-1] are greater than or equal to a[k].
    ***********************************************************************/
    public static int select(int[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IndexOutOfBoundsException("Selected element out of bounds");
        }
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
    }



   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/
    
    // is v < w ?
    private static boolean less(Integer v, Integer w) {
        return (v.compareTo(w) < 0);
    }
        
    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
