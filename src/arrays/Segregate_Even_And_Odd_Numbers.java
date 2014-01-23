package arrays;

public class Segregate_Even_And_Odd_Numbers {

	/**
	 * 
	 * Given an array A[], write a function that segregates even and odd
	 * numbers. The functions should put all even numbers first, and then odd
	 * numbers.
	 * 
	 * Example Input = {12, 34, 45, 9, 8, 90, 3} Output = {12, 34, 8, 90, 45, 9,
	 * 3}
	 * 
	 * In the output, order of numbers can be changed, i.e., in the above
	 * example 34 can come before 12 and 3 can come before 9.
	 * 
	 * The problem is very similar to our old post Segregate 0s and 1s in an
	 * array, and both of these problems are variation of famous Dutch national
	 * flag problem.
	 * 
	 * 
	 * Algorithm: segregateEvenOdd() 
	 * 1) Initialize two index variables left and right: left = 0, right = size -1 
	 * 2) Keep incrementing left index until we see an odd number. 
	 * 3) Keep decrementing right index until we see an even number. 
	 * 4) If left < right then swap arr[left] and arr[right]
	 */
	public static void main(String[] args) {
		int a[] = {12,34,45,9,8,90,3};
		
		int i=0, j=a.length-1;
		
		while(i<j)
		{
			while(a[i]%2==0)
				i++;
			while(a[j]%2!=0)
				j--;
			if(i<j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		for(i=0;i<a.length;i++)
			System.out.print(a[i]+", ");
	}

}
