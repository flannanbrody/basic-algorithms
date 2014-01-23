package general;
/*
 * Write a function to determine the number of bits required to convert integer A 
 * to integer B.
 * Input: 31, 14
 * Output: 2
 */
 
public class Convert_One_Bit_To_Another {
	
	public static void main(String args[]){
		System.out.println(bitSwapRequired(31, 14));
		System.out.println(bitSwapRequired(16, 14));
	}
	
	public static int bitSwapRequired(int a, int b){
		int count = 0;
		for(int c = a ^ b; c > 0; c >>= 1)
			count += c & 1;
		return count;
	}
}