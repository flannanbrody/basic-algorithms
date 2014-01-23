package general;

public class Pancake_Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   int arr[] = {23, 10, 20, 11, 12, 6, 7};
		
		    pancakeSort(arr, arr.length);
		 
		    System.out.println("Sorted Array ");
		    printArray(arr, arr.length);
	}
	
	/* Reverses arr[0..i] */
	public static void flip(int arr[], int i)
	{
	    int temp, start = 0;
	    while (start < i)
	    {
	        temp = arr[start];
	        arr[start] = arr[i];
	        arr[i] = temp;
	        start++;
	        i--;
	    }
	}
	 
	/* Returns index of the maximum element in arr[0..n-1] */
	public static int findMax(int arr[], int n)
	{
	   int mi, i;
	   for (mi = 0, i = 0; i < n; ++i)
	       if (arr[i] > arr[mi])
	              mi = i;
	   return mi;
	}
	 
	// The main function that sorts given array using flip operations
	public static void pancakeSort(int[] arr, int n)
	{
	    // Start from the complete array and one by one reduce current size by one
	    for (int curr_size = n; curr_size > 1; --curr_size)
	    {
	        // Find index of the maximum element in arr[0..curr_size-1]
	        int mi = findMax(arr, curr_size);
	 
	        // Move the maximum element to end of current array if it's not
	        // already at the end
	        if (mi != curr_size-1)
	        {
	            // To move at the end, first move maximum number to beginning 
	            flip(arr, mi);
	 
	            // Now move the maximum number to end by reversing current array
	            flip(arr, curr_size-1);
	        }
	    }
	}
	 
	/* A utility function to print an array of size n */
	public static void printArray(int arr[], int n)
	{
	    for (int i = 0; i < n; ++i)
	        System.out.printf("%d ", arr[i]);
	}

}
