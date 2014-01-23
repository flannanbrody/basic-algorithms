package arrays;

public class Find_Missing_Number {

	/**
	 * You are given a list of n-1 integers and these integers are in the range
	 * of 1 to n. There are no duplicates in list. One of the integers is
	 * missing in the list. Write an efficient code to find the missing integer.
	 * 
	 * Example: I/P [1, 2, 4, ,6, 3, 7, 8] O/P 5
	 * 
	 * 
	 * METHOD 1(Use sum formula) Algorithm:
	 * 
	 * 1. Get the sum of numbers total = n*(n+1)/2 
	 * 2  Subtract all the numbers from sum and you will get the missing number.
	 */
	public static void main(String[] args) {
		int a[] = { 1, 2, 4, 5, 6 };
		int miss = getMissingNo(a);
		System.out.printf("%d", miss);
	}

	public static int getMissingNo(int a[]) {
		int n = a.length;
		int i, total;
		total = (n + 1) * (n + 2) / 2; //gauss formula (6 + 1) * (6 + 2) / 2 = 21 or....n * (n + 1)  / 2
		for (i = 0; i < n; i++)
			total -= a[i];
		return total;
	}
}
