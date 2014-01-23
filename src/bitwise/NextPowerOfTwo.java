package bitwise;

/*
 * Problem

 Given a number find the lowest number which is power of 2 and greater than the given number.
 Solution

 We will keep on shifting the bits to right till the number becomes zero. So if the last set bit of the number is at k distance from the right side, we will have to shift the number k times to make it zero. During every right shift we will left shift a result which has initial value 1. Then the result will have (k+1)th bit set after the iteration and all other bits set to zero. Any number where exactly one bit is set is a power of two. And the result will be greater than the given number as the highest set bit is in the left side. The next smaller power of two would have it's kth bit set, which will be either equal or smaller than the previous number. So this result is the lowest number which is greater than the given number and a power of 2.
 */
public class NextPowerOfTwo {
	public static void main(String[] args) {
		long num = 128;
		long result = findNextPowerOfTwo(num);
		System.out.println(result);
	}

	private static long findNextPowerOfTwo(long num) {
		long result = 1;
		while (num != 0) {
			num >>= 1;
			result <<= 1;
		}
		return result;
	}
}
