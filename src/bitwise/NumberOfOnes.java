package bitwise;

/*
 * Given a number n find total number of ones in the binary representation of the numbers 1, 2, 3, 4, ..., n

 For example, if n=5

 1=1 (number of ones=1)
 2=10 (number of ones=1)
 3=11 (number of ones=2)
 4=100 (number of ones=1)
 5=101 (number of ones=2)

 output
 7 (1+1+2+1+2)

 Solution


 Initialize a count to 1 for odd numbers and 0 for even numbers. If the bth bit is set then add to a count 2^(b-1)*b+n%2^b+1;
 */
public class NumberOfOnes {

	/**
	 * given n find the total number of ones in the binary representation of
	 * numbers 1,2,3,...,n
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getNumberOfOnes(30));
	}

	public static int getNumberOfOnes(int num) {
		int p = 1, cnt = 0;

		if ((num & 1) != 0)
			cnt++;

		while (1 << (p - 1) < num) {
			if ((num & (1 << p)) != 0)
				cnt += (1 << (p - 1)) * (p) + num % (1 << p) + 1;
			p++;
		}
		return cnt;
	}

}
