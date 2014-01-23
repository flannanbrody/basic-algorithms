package arrays;

/*************************************************************************
 * 
 * Uses Merge sort too count inversions
 * 
 * Read in N integers and count number of inversions in N log N time.
 * 
 *************************************************************************/

public class Count_Inversions_In_Array {
	
	// generate N real numbers between 0 and 1, and mergesort them
	public static void main(String[] args) {
		Integer[] a = {new Integer(1), new Integer(20), new Integer(6), new Integer(4), new Integer(5)};

		System.out.println(Count_Inversions_In_Array.count(a));
		System.out.println(Count_Inversions_In_Array.brute(a));
	}
	
	// count number of inversions in the array a[] - do not overwrite a[]
	public static long count(Comparable<Integer>[] a) {
		Comparable<Integer>[] b = new Comparable[a.length];
		Comparable<Integer>[] aux = new Comparable[a.length];
		for (int i = 0; i < a.length; i++)
			b[i] = a[i];
		long inversions = count(a, b, aux, 0, a.length - 1);
		return inversions;
	}
	
	// return the number of inversions in the subarray b[lo..hi]
	// side effect b[lo..hi] is rearranged in ascending order
	private static long count(Comparable[] a, Comparable[] b, Comparable[] aux, int lo, int hi) {
		long inversions = 0;
		if (hi <= lo)
			return 0;
		int mid = lo + (hi - lo) / 2;
		inversions += count(a, b, aux, lo, mid);
		inversions += count(a, b, aux, mid + 1, hi);
		inversions += merge(b, aux, lo, mid, hi);
		assert inversions == brute(a, lo, hi);
		return inversions;
	}
	
	// count number of inversions in a[lo..hi] via brute force (for debugging
	// only)
	private static long brute(Comparable[] a, int lo, int hi) {
		long inversions = 0;
		for (int i = lo; i <= hi; i++)
			for (int j = i + 1; j <= hi; j++)
				if (less(a[j], a[i]))
					inversions++;
		return inversions;
	}

	// count number of inversions via brute force
	public static long brute(Comparable[] a) {
		return brute(a, 0, a.length - 1);
	}
	
	// merge and count
	private static long merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		long inversions = 0;

		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		// merge back to a[]
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
				inversions += (mid - i + 1);
			} else
				a[k] = aux[i++];
		}
		return inversions;
	}

	// is v < w ?
	private static boolean less(Comparable<Comparable> v, Comparable w) {
		return (v.compareTo(w) < 0);
	}
}
