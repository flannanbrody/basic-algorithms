package bitwise;

/*
 * Swap two integers without using a temp variable.
 Solution


 We will use some excellent property of XOR to solve this. If we xor two numbers then the result will give you back the original numbers when again xor ed with the other number. So if ANS=A XOR B
 then ANS XOR A = B and ANS XOR B = A.
 */
public class SwapWithoutTemp {
	public static void main(String[] args) {
		int a = 5;
		int b = 6;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a);
		System.out.println(b);
	}
}
