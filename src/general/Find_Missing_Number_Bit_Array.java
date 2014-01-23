package general;

import java.util.ArrayList;

/*
 * An array A[1...n] contains all the integers from 0 to n except for one number which is
 * missing. In this problem, we cannot access an entire integer in A with a single operation.
 * The elements of A are represented in binary, and the only operation we can use
 * to access them is ???fetch the jth bit of A[i]???, which takes constant time. 
 * Write code to find the missing integer. Can you do it in O(n) time?
 */

/*
 *
 * An array A[1...n] contains all the integers from 0 to n except for 
 * one number which is missing.
 * ===================================================
 *  suppose we got numbers from 0 to n 
 * if n+1 is even(eg. n=3), the numbers in the least significant bit are: 1010
 * 			count(0)=count(1)
 * if n+1 is odd(eg. n=4), the numbers int the LSB are:01010 
 * 			count(0)=count(1)+1
 *====================================================
 * n+1=4 we delete a 0  count(0)<count(1)
 *     		we delete 1 count(0)>count(1)
 * n+1=5 delete 0 count(0)=count(1)
 * 		delete 1	count(0)>count(1)
 * so whether n is ever or odd, if we delete a 0 count(0)<=count(1)
 *  if we delete a 1 count(0)>count(1) 
 * 
 * 
 * we come back to the original problem, we miss a number 
 * let's consider only the Least significant bit 
 * if the number is odd, then it means we have delete a 1 so count(0)>count(1)
 * if the number is even, then we have delete a 0 so count(0)<=count(1)
 * 
 * that means we can count 1 and 0 of all numbers' LSB 
 * if count(0)>count(1) the number's last bit is 1 otherwise it is 0 
 * in this way, we have detetmined the last bit 
 * 
 * if it is odd what we need to do is to test the list of odds and vice versa.
 * the SLSB in the odds or evens also satisfy the theory of count(0)&count(1)
 * now we can move a bit left to test the second LSB
 * continue until 2^column>n
 */
public class Find_Missing_Number_Bit_Array {
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= 30; i++)
			list.add(i);
		list.remove(13);// remove the element in the index of 19, it is actually
						// 19
		System.out.println(findMissing(list, 0, 30));
	}

	public static boolean getBit(int n, int index) {
		return (n & (1 << index)) > 0;
	}

	// we try to find missing number from 1 - n;
	public static int findMissing(ArrayList<Integer> list, int column, int n) {
		if (Math.pow(2, column) > n) // ?????????????????????
			return 0;

		ArrayList<Integer> oddIndices = new ArrayList<Integer>();
		ArrayList<Integer> evenIndices = new ArrayList<Integer>();

		for (Integer i : list) {
			if (getBit(i, column))
				oddIndices.add(i);
			else
				evenIndices.add(i);
		}

		if (oddIndices.size() >= evenIndices.size()) // missing number has a 0
														// in the index of
														// column
			/*
			 * the last zero in the return statement is that we got in this
			 * method the rest we need to use recursion in each recursion we
			 * just add a 0 or 1 to the last bit the call to findMissing(evens,
			 * column+1) decide the rest
			 */
			return findMissing(evenIndices, column + 1, n) << 1 | 0;
		else
			return findMissing(oddIndices, column + 1, n) << 1 | 1;
	}
}
