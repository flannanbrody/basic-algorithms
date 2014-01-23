package arrays;

/*
 * 
 Q1.
 I have an array containing duplicates in the following format: 
 arr[]={ 2,9,1,5,1,4,9,7,2,1,4 } I want to sort the array in place such that all the duplicate elements are moved 
 towards the end and sorted in different sub arrays like following: arr[]={ 1,2,4,5,7,9, 1,2,4,9, 1 } 

 A1.
 The problem cant be done in less than nlgn because we need to use comparision sorting at one time or another 
 1.Sort inplace using quicksort taken nlgn time 
 2.set a pointer to last element of the array, now scan the array each time we get a duplicate, swap it with the pointer and 
   move the pointer backwards, stop the scan when the value of swapped variable is greater than next variable, save this location 
   as pivot this takes n time 
 3.quicksort 0, pivot-1 and pivot-1 size this will give final output, this takes nlgn time therefore total time is O(nlgn)

 */
public class Sort_Duplication_Into_Separate_Inplace_Array {
	public static void main(String args[]) {
		int array[] = { 2, 9, 1, 5, 1, 4, 9, 7, 2, 1, 4 };
		int size = array.length;
		quickSort(0, size - 1, array);           // a[] is sorted now [1, 1, 1, 2, 2, 4, 4, 5, 7, 9, 9]
		int pivot = moveDuplicates(array, size); // pivot is 6....a[] now looks like [9, 9, 1, 7, 2, 5, 4, 4, 2, 1, 1] 
		quickSort(0, pivot, array);				 // now a[] is [1, 2, 4, 5, 7, 9, 9, 4, 2, 1, 1]
		quickSort(pivot, size - 1, array);		 // [1, 2, 4, 5, 7, 9, 1, 1, 2, 4, 9]
		for (int i = 0; i < size; i++) {        
			System.out.print(array[i] + " ");

		}
		System.out.println();
	}
	
	public static int moveDuplicates(int array[], int size) {
		int right = size - 1;
		for (int i = 0; i < size - 1; i++) {
			if (right <= i) {
				return right;
			}
			if (array[i] == array[i + 1]) {
				exch(array, i, right);
				right--;
			}
		}
		return right;
	}
	
	public static void quickSort(int left, int right, int array[]) {
		if (left >= right) {
			return;
		}
		if (left == right - 1) {
			if (array[left] > array[right]) {
				exch(array, left, right);
			}
			return;
		}

		int pivot = partition(array, left, right);
		quickSort(left, pivot - 1, array);
		quickSort(pivot + 1, right, array);
	}
	
    private static int partition(int[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = array[lo];
        while (true) { 
            while (less(array[++i], v))
                if (i == hi) break;

            while (less(v, array[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            if (i >= j) break;

            exch(array, i, j);
        }
        // put v = a[j] into position
        exch(array, lo, j);
        // with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
    
    // is v < w ?
    private static boolean less(int v, int w) {
        return (Integer.valueOf(v).compareTo(Integer.valueOf(w)) < 0);
    }
        
    // exchange a[i] and a[j]
    private static void exch(int[] array, int i, int j) {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
}