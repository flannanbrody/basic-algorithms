package arrays;

public class Rank_Of_Array {

	public static void main(String[] args) {

		int[] a = new int[] { 16, 18, 7, 8, 9, 10, 13, 0, 1, 2, 0, 9, 13, 14 };
		int rank = 7;
		int pick = pickRank(a, 0, a.length - 1, rank);
		System.out.println("a1 rank " + rank + " : " + pick);
		System.out.println();
		System.out.println("Simpler appraoch :" + rank(a, rank));
	}

	public static int pickRank(int[] a, int left, int right, int rank) {
		int pivotIndex = partition(a, left, right);
		int leftSize = pivotIndex - left;
		if (leftSize == rank)
			return max(a, left, pivotIndex);
		else if (rank < leftSize) {
			return pickRank(a, left, pivotIndex - 1, rank);
		} else
			// (rank > leftSize)
			return pickRank(a, pivotIndex, right, rank - leftSize);
	}

	public static int max(int[] array, int left, int right) {
		int max = Integer.MIN_VALUE;
		for (int i = left; i <= right; i++) {
			max = Math.max(array[i], max);
		}
		return max;
	}

	public static int partition(int[] a, int left, int right) {
		int pivot = a[(left + right) / 2]; // a random pick
		while (left <= right) {
			while (a[right] > pivot)
				right--;
			while (a[left] < pivot)
				left++;

			if (left <= right) {
				int tmp = a[right];
				a[right] = a[left];
				a[left] = tmp;

				right--;
				left++;
			}

		}
		return left;
	}
	
	/*
	 * Trying a simpler approach
	 */
	public static int rank(int[] a, int key){
		int low = 0;
		int high = a.length -1;
		while(low <= high){
			int j = partition(a, low, high);
			if(j < key){
				low = j + 1;
			}else if(j > key){
				high = j -1;
			}else{
				return a[key];
			}
		}
		return a[key];
	}
	
    // partition the subarray a[lo .. hi] by returning an index j
    // so that a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) { 

            // find item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, a[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put v = a[j] into position
        exch(a, lo, j);

        // with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
