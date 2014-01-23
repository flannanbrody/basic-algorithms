package bitwise;

/*
 * Problem

 Calculate x to the power y.
 Constraint

 Complexity should be less than O(n).
 Solution

 Suppose we are trying to calculate x to the power y and y is 4. Then we can do result=1; Then 4 times (result=result*x). In this way the complexity is O(n). In another way, we can do result=x*x; then we can do result =result *result; in this way the number of multiplication is 2 but y=4. So for power of 2s we can clearly see the number of multiplication is log(n) time. What happens for other numbers like when y=7. We can divide seven in 4+2+1. so x^(4+2+1)=(x^4) * (x^2) * (x^1).
 So we can see that all powers are now divided into power of some numbers which are powers of 2. For example x^y where y is 13, we can do 8+4+1. Clearly we can see when y is represented in binary, the set bits are indicative of how to calculate the result. So whenever the bit is set multiply the powers to the result. and then do power=power*power for the next bit.
 */
public class CalculatePower {
	public static void main(String[] args) {
		int x = 4;
		int y = 10;
		long power = x;
		long answer = 1;
		while (y != 0) {
			if ((y & 1) == 1) {
				answer *= power;
			}
			y >>= 1;
			power *= power;
		}
		System.out.println(answer);
	}
}
