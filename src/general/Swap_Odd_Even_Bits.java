package general;

/*
 * Write a program to swap odd and even bits in an integer with as few instructions 
 * as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc).
 */
public class Swap_Odd_Even_Bits {
	public static void main(String args[]){
		System.out.println(swapOddAndEven(6));
	}
	
	public static int swapOddAndEven(int n){
		int mask1 = 0xAAAAAAAA;   // 1010 1010 1010 ...
		int mask2 = 0x55555555;	  // 0101 0101 0101 ...
		
		return  ((n & mask1) >> 1) | ((n & mask2) << 1);
	}
}