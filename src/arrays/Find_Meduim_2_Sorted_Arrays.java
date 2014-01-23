package arrays;

public class Find_Meduim_2_Sorted_Arrays {


	/*
	 * O(log(min(m, n))).
	 * 
	 * m1 is meduim of arr1 / and m2 is meduim of arr2
	 * if (m1 < m2) ....arr1 --> .......5(m1).........
	 * 					arr2 --> .......23(m2).........
	 * 
	 * 										|--meduim lies here --|
	 * if we merge both arrays ........5(m1)xxxxxxxxxxxxxxxxxxxxxx23(m2).........
	 * 
	 * if (m1 < m2) ....arr1 --> ...........5(m1)xxxxxxxxxxx (meduim is after 5)
	 * 					arr2 --> xxxxxxxxxxx23(m2).........  (meduim is before 23)
	 * 
	 * So now repeat....consider the arr1 = everything after 5
	 * 								 arr2 = everything before 23
	 * 
	 * 
	 * if (m2 < m1) ....arr1 --> xxxxxxxxxxx5(m1)........... (meduim is before 5)
	 * 					arr2 --> ...........23(m2)xxxxxxxxxx (meduim is after 23)
	 * 
	 */
	public static void main(String[] args) {
		int[] arr1 = {1, 12, 15, 26, 38, 39};
		int[] arr2 = {2, 13, 17, 30, 45};

		int med = median(arr1, arr2);
		System.out.println("Median = " + med);

	}

	public static int median(int[] arr1, int[] arr2) {
		int N = arr1.length;
		int M = arr2.length;
		return median(arr1, 0, N - 1, arr2, 0, M - 1);
	}

	public static int median(int[] arr1, int l1, int h1, int[] arr2, int l2, int h2) {
		int mid1 = l1 + (h1 - l1) / 2;
		int mid2 = l2 + (h2 - l2) / 2;

		if (h1 - l1 == 1)
			return (Math.max(arr1[l1], arr2[l2]) + Math.min(arr1[h1], arr2[h2])) / 2;
		else if (arr1[mid1] > arr2[mid2])
			return median(arr1, l1, mid1, arr2, mid2, h2);
		else
			return median(arr1, mid1, h1, arr2, l2, mid2);
	}

}
