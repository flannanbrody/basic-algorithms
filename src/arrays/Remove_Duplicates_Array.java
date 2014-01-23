package arrays;

import java.util.Arrays;

public class Remove_Duplicates_Array {

	/**
	 * This method needs the array to be sort like 1, 1, 1, 2, 3, 3......if its like 1, 2, 3, 1, 2, 3....it won't work.
	 * remove dup of a sorted arr in place: [1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0]
	 * remove dup of a sorted arr in place: [1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0]
	 * remove dup of a sorted arr in place2: [-1, 1, 2, 3, 4, 5, 6, 7, 8, 0, 0, 0, 0, 0, 0]
	 * 
	 *  [1, 1, 1, 2, 2, 3, 4, 4, 5, 6, 6]
		[1, 2, 1, 2, 2, 3, 4, 4, 5, 6, 6]
		[1, 2, 3, 2, 2, 3, 4, 4, 5, 6, 6]
		[1, 2, 3, 4, 2, 3, 4, 4, 5, 6, 6]
		[1, 2, 3, 4, 5, 3, 4, 4, 5, 6, 6]
		[1, 2, 3, 4, 5, 6, 4, 4, 5, 6, 6]
		
		[1, 2, 3, 4, 5, 6, 0, 4, 5, 6, 6]
		[1, 2, 3, 4, 5, 6, 0, 0, 5, 6, 6]
		[1, 2, 3, 4, 5, 6, 0, 0, 0, 6, 6]
		[1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 6]
		[1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0]
	 */
	public static void main(String[] args) {
		int[] a = new int[]{1, 1, 1, 2, 2, 3, 4, 4, 5, 6, 6};
		removeDupInplace(a);
		System.out.println("remove dup of a sorted arr in place: " + Arrays.toString(a));
		
		int[] a1 = new int[]{1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6};
		removeDupInplace1(a1);
		System.out.println("remove dup of a sorted arr in place: " + Arrays.toString(a1));

        int[] a9 = new int[]{-1, -1, 1, 1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 7, 8};
        removeDupInplace(a9);
        System.out.println("remove dup of a sorted arr in place2: " + Arrays.toString(a9));
	}

	public static void removeDupInplace(int[] a) {
		if (a.length <= 1)
			return;

		int i = 0, j = 0;

		while (++i < a.length) {
			if (a[j] != a[i])
				a[++j] = a[i];
		}

		while (++j < a.length)
			a[j] = 0;

	}

	public static void removeDupInplace1(int[] a) {
		if (a.length <= 1)
			return;
		int i, j = 0;
		for (i = 1; i < a.length; ++i) {
			if (a[j] != a[i]) {
				a[j + 1] = a[i];
				j++;
			}
		}
		j++;
		while (j < a.length) {
			a[j] = 0;
			j++;
		}
	}
}
