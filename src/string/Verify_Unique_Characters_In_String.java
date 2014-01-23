package string;

//Using quicksort
public class Verify_Unique_Characters_In_String {
	
	public static void main(String[] args){
		String uniqueString = "qwertyuioplkjhgfdsazxcvbnm";
		String nonUniqueString = "jkhsdfhgss";
		System.out.println("test unique...." + test(uniqueString));
		System.out.println("test unique...." + test(nonUniqueString));
		
		System.out.println("test2 unique...." + test2(uniqueString));
		System.out.println("test2 unique...." + test2(nonUniqueString));
	}

	/* use a array to record the occurrence of different characters
	 * first method uses extra space
	 * NOTE: the spaces will cause duplicates too
	 * the time complexity is O(n), the space complexity is also O(n)
	 */
	public static boolean test(String input){
		boolean char_set[] = new boolean[255]; 
		
		for(int i = 0; i < input.length(); i++){
			int index = input.charAt(i);       // implicit conversion from char to int 
			if(char_set[index])
				return false;
			char_set[index] = true;
		}
		return true;
	}
	

	//CTCI
	public static boolean isUniqueChars2(String str) {
		if (str.length() > 256) {
			return false;
		}
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	 /* first use quicksort to sort the input O(nlogn)
	  * then iterate the sorted array to check if there are duplicates O(n)
	  * so the total running time is O(nlogn) + O(n) = O(nlogn);
	  */
	public static boolean test2(String input){
		char[] data = input.toCharArray();
		quickSort(data, 0, data.length-1);
		
		for(int i = 0; i < data.length -1; i++)
			if(data[i] == data[i+1])
				return false;
		return true;
	}
	
    // quicksort the subarray from a[lo] to a[hi]
    private static void quickSort(char[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }

    // partition the subarray a[lo .. hi] by returning an index j
    // so that a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
    private static int partition(char[] data, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        char v = data[lo];
        while (true) { 

            // find item on lo to swap
            while (less(data[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, data[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            exch(data, i, j);
        }

        // put v = a[j] into position
        exch(data, lo, j);

        // with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
	
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
    // exchange a[i] and a[j]
    private static void exch(char[] data, int i, int j) {
        char swap = data[i];
        data[i] = data[j];
        data[j] = swap;
    }

}
