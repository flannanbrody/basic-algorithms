package arrays;

import java.util.Arrays;

public class Find_First_Last_Occurance_Of_Number {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        int[] a = {1, 3, 10, 10, 10, 10, 10, 23, 45, 67};
        Arrays.sort(a);
        System.out.println("Output is : " + binarySeach(a, 10));

	}
	
	/*
	 * First occurance of
	 * else if(low != mid){ //First index of....Equal but range is not fully scanned
	 *			hi = mid;   //Set upper bound to current number and rescan
	 *		}
	 *
	 * Last occurance of
	 *  else if(hi != mid){  //Last index of.....
	 * 			low = mid;        
	 *		}
	 *
	 */
	private static int binarySeach(int[] a, int key){
		int low = 0;
		int hi = a.length - 1;
		while(low <= hi){
			int mid = low + (hi - low)/2;
			if(key < a[mid]){
				hi = mid - 1;
			}else if(key > a[mid]){
				low = mid + 1;
			}else if(low != mid){ //First index of....Equal but range is not fully scanned
				hi = mid;         //Set upper bound to current number and rescan
			}else if(hi != mid){  //Last index of.....
				low = mid;        
			}else{                
				return mid;		  //Equal and full range is scanned
			}
		}
		return -1;
	}

}
