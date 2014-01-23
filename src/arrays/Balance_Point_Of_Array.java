package arrays;

/*
 * Use BalanceBest...its easy
 * 	1. leftSum = a[0](1) and rightSum is the some of a[1]....a[N-1](56)
 *  2. leftSum += a[i + 1]...just keep adding next value too leftsum while...subtracting a[i] from rightSum until there equal, 
 *  else return -1.
 * 
 * Improved Version
 * -- Create two arrays: Using additional memory
 * 	  1. One array to store sums from left to right
 * 	  2. The other array to store sums from right to left
 *    3. Compare sums and return the value where the sums equal
 */
public class Balance_Point_Of_Array {
	// now we create a test case
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 7, 6, 5, 9, 5, 6, 7, 5, 2, -1 };// expected 6th position
		
		System.out.println("(Naive) Balance point for a is index " + BalanceNaive(a));
		System.out.println("(Improve) Balance point for a is index " + BalanceImprove(a));
		System.out.println("(Best) Balance point for a is index "+ BalanceBest(a));

		System.out.println();
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
		System.out.printf("%d\n", equilibrium(arr));
	}

	public static int BalanceBest(int[] a) {
		int leftSum = a[0];
		int rightSum = 0;

		for (int i = 0; i < a.length; i++)
			// notice we start from 2nd as 1st value is set
			rightSum += a[i];// each sum is sum of previous sum plus current value

		for (int i = 0; i < a.length - 1; i++) {
			if (leftSum == rightSum)
				return i;
			leftSum += a[i + 1];
			rightSum -= a[i];
		}
		return -1;// otherwise we return -1 as not found
	}

	// now we implement the improved method, using extra memory to achieve o(n)
	// time performance
	public static int BalanceImprove(int[] a) {
		// as we discussed we need two extra arrays to store the sums from left
		// to right and from right to left
		int[] leftSums = new int[a.length];
		int[] rightSums = new int[a.length];
		// now we compute sums for leftSums, but as each sum is depending on
		// previous sum, we need assign the 1st sum to a[0]
		leftSums[0] = a[0];
		for (int i = 1; i < a.length; i++)
			// notice we start from 2nd as 1st value is set
			leftSums[i] = leftSums[i - 1] + a[i];// each sum is sum of previous
													// sum plus current value

		// similarly we set right sums
		rightSums[a.length - 1] = a[a.length - 1];// we proceed from right to
													// left for right sums
		for (int i = a.length - 2; i >= 0; i--)
			rightSums[i] = rightSums[i + 1] + a[i];

		// now compare each value in left and right sum arrays to find match
		for (int i = 0; i < leftSums.length; i++) {
			if (leftSums[i] == rightSums[i])
				return i;// return immediately when we find a match for balance
							// point
		}
		return -1;// otherwise we return -1 as not found
	}

	// firstly let's implement the naive method
	// we return the balance index if found or -1 if not found
	public static int BalanceNaive(int[] a) {
		for (int i = 0; i < a.length; i++) {
			// for each position, we compute left sum and right sum and compare,
			// return if found equal left/right sum
			int leftSum = 0;
			int rightSum = 0;
			for (int m = 0; m <= i; m++)
				leftSum += a[m];
			for (int m = i; m < a.length; m++)
				rightSum += a[m];
			if (leftSum == rightSum)
				return i;// index returned whenever equal left/right found
		}
		return -1;// if no return before that means no balance point found
	}

	/*
	 * Equilibrium index of an array is an index such that the sum of elements
	 * at lower indexes is equal to the sum of elements at higher indexes. For
	 * example, in an arrya A:
	 * 
	 * A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0
	 * 
	 * 3 is an equilibrium index, because: A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
	 * 
	 * 6 is also an equilibrium index, because sum of zero elements is zero,
	 * i.e., A[0] + A[1] + A[2] + A[3] + A[4] + A[5]=0
	 * 
	 * 7 is not an equilibrium index, because it is not a valid index of array A.
	 * 
	 * Write a function int equilibrium(int[] arr, int n); that given a sequence
	 * arr[] of size n, returns an equilibrium index (if any) or -1 if no
	 * equilibrium indexes exist.
	 * 
	 * Method 1 (Simple but inefficient) Use two loops. Outer loop iterates
	 * through all the element and inner loop finds out whether the current
	 * index picked by the outer loop is equilibrium index or not. Time
	 * complexity of this solution is O(n^2).
	 */
	public static int equilibrium(int arr[]) {
		int n = arr.length;
		int i, j;
		int leftsum, rightsum;

		/*
		 * Check for indexes one by one until an equilibrium index is found
		 */
		for (i = 0; i < n; ++i) {
			leftsum = 0; // initialize left sum for current index i
			rightsum = 0; // initialize right sum for current index i

			/* get left sum */
			for (j = 0; j < i; j++)
				leftsum += arr[j];

			/* get right sum */
			for (j = i + 1; j < n; j++)
				rightsum += arr[j];

			/* if leftsum and rightsum are same, then we are done */
			if (leftsum == rightsum)
				return i;
		}

		/* return -1 if no equilibrium index is found */
		return -1;
	}
}
