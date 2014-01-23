package arrays;

//Binary search...Problem asks for O(log(m) + log(n)) solution here. However I am giving here O(logK) 
public class Find_Kth_Smallest_Of_Two_Arrays {

	public static void main(String[] args) {

		int[] A = { 4, 5, 7, 45, 67, 77, 86, 94, 101 };
		int[] B = { 1, 3, 6, 8, 23, 24, 34, 44, 51 };
		int k = 6;

		getKthSmallestInTwoArrays(A, B, k);
		findKSmall(A, A.length, B, B.length, k);
	}

	private static void getKthSmallestInTwoArrays(int[] a, int[] b, int k) {

		int lowA = 0, lowB = 0, highA = k - 1, highB = k - 1;

		if (a.length < (k - 1)) {
			highA = a.length - 1;
		}

		if (b.length < (k - 1)) {
			highB = b.length - 1;
		}

		if ((highA + highB) < k) {
			// insufficient elements
			return;
		}

		int midA = 0, midB = 0;
		int result = 0;

		while (k >= 0) {
			midA = lowA + (highA - lowA) / 2;
			midB = lowB + (highB - lowB) / 2;
			if (a[midA] >= b[midB]) {
				// it means the first midA elements of A are all greater than
				// first midB elements of B

				// it means that the kth smallest lies in second half of B OR
				// first half of A

				k = k - (midB - lowB + 1);
				result = b[midB];
				highA = midA - 1;
				lowB = midB + 1;
			} else if (a[midA] < b[midB]) {
				// it means the first midB elements of B are all greater than
				// first midA elements of A

				// it means that the kth smallest lies in second half of A OR
				// first half of B
				k = k - (midA - lowA + 1);
				result = a[midA];
				highB = midB - 1;
				lowA = midA + 1;
			}

			if (k == 0)
				break;
		}
		System.out.println(result);
	}

	private static void findKSmall(int[] a, int m, int[] b, int n, int k){
		int i = 0;
		int j = 0;
		int elem = 0;
		while (k > 0){
			if (a[i] < b[j]) {
				if (i > m)
					continue;
				elem = a[i];
				i++;
			}else {
				if (j > n)
					continue;
				elem = b[j];
				j++;
			}
			k--;
		}
		System.out.println(elem);
	}
}
